package com.admin.adminsystem.controller;

import com.admin.adminsystem.dao.SystemUserDao;
import com.admin.adminsystem.jpa.SystemuserJPA;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by DC on 2018/8/24.
 */

@RestController
public class Sync {

    @Autowired
    private SystemuserJPA systemuserJPA;
    @Resource
    SystemUserDao dao;

    private static final HashMap<String, String> mapping = new HashMap<>();
    static {
        mapping.put("SystemUserOrg", "SYSTEMUSER_ORG");
        mapping.put("SystemUserCode", "SYSTEMUSER_CODE");
        mapping.put("SystemUserDesc", "SYSTEMUSER_DESC");
    }

    public static String callAPI(String url) {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url(url)
//                .get()
//                .addHeader("Cache-Control", "no-cache")
//                .build();
//
//        Response response = null;
//        String data = "";
//        try {
//            response = client.newCall(request).execute();
//            data = response.body().string();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        SyncSoap syncSoap = new SyncSoap();
        String data = syncSoap.getXMLdata(url);
        return data;
    }

//    @RequestMapping(value = "/backup-systemuser", method = RequestMethod.GET)
    public boolean backupSystemuser() {
//        String response = this.callAPI("http://localhost:8080/sync/service-mq");
        HashMap<String,Object> map = new HashMap<String,Object>();
        dao.asd();
        return true;
    }

//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public boolean dropSystem() {
        dao.deleteSystem();
        return  true;
    }

    @RequestMapping(value = "/sync-system", method = RequestMethod.GET)
    public JSONObject syncSystemuser() throws Exception{
        JSONObject response = new JSONObject();
        if(this.backupSystemuser()) {
            this.dropSystem();
        }
        String xmlData = this.callAPI("http://10.232.83.21:9998/ws/synchronize/systemusers");
        Document doc;
        List<HashMap<String, String>> lists = null;
        try {
            doc = DocumentHelper.parseText(xmlData);
            Element et = doc.getRootElement();
            String root = et.getName();
            List<Element> father = doc.selectNodes("//"+ root + "/Body/SystemUsers");
            if (father!=null && !father.isEmpty() && father.size()==1) {
                List<Element> systemUsers = father.get(0).elements();
                if (systemUsers != null) {
                    lists = new ArrayList<HashMap<String, String>>();
                    for (Element e : systemUsers) {
                        List<Element> li = e.elements();
                        HashMap<String, String> item = new HashMap<String, String>();
                        for (Element element2 : li) {
                            String key = element2.getName();
                            String value = null;
                            if (mapping.containsKey(key)) {
                                value = mapping.get(key);
                            } else {
                                value = element2.getText();
                            }

                            item.put(key, value);
//                            if (key.equals("PK_SYSTEMUSER")) {
//                                item.put("PK_SYSTEMUSER", UUID.randomUUID().toString().replace("-","").toLowerCase());
//                            } else {
//                                item.put(key, value);
//                            }
                        }
                        item.put("PK_SYSTEMUSER", UUID.randomUUID().toString().replace("-","").toLowerCase());
                        lists.add(item);
                    }
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
            //数据源xml格式有问题
        }

        for (HashMap<String, String> item : lists) {
//            System.out.println("::::::::::::::" + item.get("PK_SYSTEMUSER"));
            dao.insertSystemuser(item);
//            System.out.println("::::::::::::::" + item.toString());
        }

        response.put("count",lists.size());
        return response;
    }
}
