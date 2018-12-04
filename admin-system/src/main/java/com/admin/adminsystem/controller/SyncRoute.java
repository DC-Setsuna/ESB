package com.admin.adminsystem.controller;

import com.admin.adminsystem.dao.RouteDao;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
public class SyncRoute {

    @Resource
    RouteDao routeDao;

    private static final String MQSUBSCRIBE_SYNCHRONIZE_API = "http://localhost:8080/sync/route-mq";

    private static final String RESTSUBSCRIBE_SYNCHRONIZE_API = "http://localhost:8080/sync/route-rest";

    private static final String WSSUBSCRIBE_SYNCHRONIZE_API = "http://localhost:8080/sync/route-ws";

    public String getMqsubscribe() {
        return getData(MQSUBSCRIBE_SYNCHRONIZE_API);
    }

    public String getRestsubscribe() {
        return getData(RESTSUBSCRIBE_SYNCHRONIZE_API);
    }

    public String getWssubscribe() {
        return getData(WSSUBSCRIBE_SYNCHRONIZE_API);
    }

    public static String getData(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).get().build();

        Response response = null;
        String data = "";
        try {
            response = client.newCall(request).execute();
            data = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean backup() {
        routeDao.backup();
        return true;
    }

    public boolean drop() {
        routeDao.delete();
        return true;
    }

    @RequestMapping(value = "/sync-route", method = RequestMethod.GET)
    public JSONObject syncRoute() throws Exception {
        JSONObject response = new JSONObject();
        if(backup()) {
            drop();
        }

        String mqXmlData = this.getMqsubscribe();
        String restXmlData = this.getRestsubscribe();
        String wsXmlData = this.getWssubscribe();

        List<HashMap<String, String>> mqSourceData = this.getSourceData(mqXmlData);
        List<HashMap<String, String>> mqDefineData = new ArrayList<>();
        for (HashMap<String, String> pair1 : mqSourceData)  {
            HashMap<String, String> mdata = new HashMap<>();
            mdata = this.defineData("mq", pair1);
            mqDefineData.add(mdata);
            routeDao.insert(mdata);
        }

        List<HashMap<String, String>> restSourceData = this.getSourceData(restXmlData);
        List<HashMap<String, String>> restDefineData = new ArrayList<>();
        for (HashMap<String, String> pair2 : restSourceData)  {
            HashMap<String, String> rdata = new HashMap<>();
            rdata = this.defineData("rest", pair2);
            restDefineData.add(rdata);
            routeDao.insert(rdata);
        }

        List<HashMap<String, String>> wsSourceData = this.getSourceData(wsXmlData);
        List<HashMap<String, String>> wsDefineData = new ArrayList<>();
        for (HashMap<String, String> pair3 : wsSourceData)  {
            HashMap<String, String> wdata = new HashMap<>();
            wdata = this.defineData("ws", pair3);
            wsDefineData.add(wdata);
            routeDao.insert(wdata);
        }

        int count = mqDefineData.size() + restDefineData.size() + wsDefineData.size();
        response.put("count", count);

        return response;
    }

    public HashMap<String, String> defineData(String type, HashMap<String, String> d) {
        HashMap<String, String> data = new HashMap<>();
        data.put("PK_ROUTE", UUID.randomUUID().toString().replace("-","").toLowerCase());
        data.put("SERVICE_CODE", d.get("Svc_ServiceCode"));
        data.put("SERVICE_VERSION", d.get("Svc_Version"));
        data.put("SENDER_ORG", d.get("Svc_Sender_Org"));
        data.put("SENDER", d.get("Svc_Sender"));
        data.put("RECEIVER_ORG", d.get("Svc_Receiver_Org"));
        data.put("RECEIVER", d.get("Svc_Receiver"));
        data.put("ENABLED_FLAG", "1");
        data.put("REMARK", "");
        data.put("CREATOR", "Admin");
        data.put("MODIFIER", "Admin");
        data.put("SVC_TYPE", d.get("Svc_Type"));
        if (type == "ws") {
            data.put("SVC_METHOD", d.get("Svc_Method"));
        } else {
            data.put("SVC_METHOD", "");
        }

        return data;

    }

    public List<HashMap<String, String>> getSourceData(String xmlData) {
        Document doc;
        List<HashMap<String, String>> list = null;
        try {
            doc = DocumentHelper.parseText(xmlData);
            Element et = doc.getRootElement();
            String root = et.getName();

            HashMap<String, String> headMap = new HashMap<>();
            List<Element> head = doc.selectNodes("//"+root+"/Head");
            if (head!=null && !head.isEmpty() && head.size()==1) {
                List<Element> heads = head.get(0).elements();
                if (heads != null) {
                    for (Element e : heads) {
                        headMap.put(e.getName(), e.getText());
                    }
                }
            }

            List<Element> father = doc.selectNodes("//"+ root + "/Body/SubScribes");
            if (father!=null && !father.isEmpty() && father.size()==1) {
                List<Element> systemUsers = father.get(0).elements();
                if (systemUsers != null) {
                    list = new ArrayList<HashMap<String, String>>();
                    for (Element e : systemUsers) {
                        List<Element> li = e.elements();
                        HashMap<String, String> item = (HashMap<String, String>) headMap.clone();
                        for (Element element2 : li) {
                            String key = element2.getName();
                            String value = element2.getText();
                            item.put(key, value);
                        }
                        list.add(item);
                    }
                }
            }

            return list;

        } catch (DocumentException e) {
            e.printStackTrace();
            //数据源xml格式有问题
        }
        return list;
    }

//    public static void main(String[] args) throws Exception {
//        SyncRoute syncRoute = new SyncRoute();
//        syncRoute.syncRoute();
//    }
}
