package com.admin.adminsystem.controller;

import com.admin.adminsystem.dao.ServiceDao;
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
public class SyncService {


    @Resource
    ServiceDao serviceDao;

//    private static final String HTTPSERVICE_SYNCHRONIZE_API = "http://localhost:8080/sync/service-http";
    private static final String HTTPSERVICE_SYNCHRONIZE_API = "http://10.232.83.21:9998/ws/synchronize/httpservices";

//    private static final String MQSERVICE_SYNCHRONIZE_API = "http://localhost:8080/sync/service-mq";
    private static final String MQSERVICE_SYNCHRONIZE_API = "http://10.232.83.21:9998/ws/synchronize/mqservices";

    public String getHttpService() {
        return getData(HTTPSERVICE_SYNCHRONIZE_API);
    }

    public String getMqService() {

        return getData(MQSERVICE_SYNCHRONIZE_API);
    }

    public static String getData(String url) {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder().url(url).get().build();
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

    public boolean backup() {
        serviceDao.backup();
        return true;
    }

    public boolean drop() {
        serviceDao.delete();
        return true;
    }

    @RequestMapping(value = "/sync-service", method = RequestMethod.GET)
    public JSONObject syncService() throws Exception{
        JSONObject response = new JSONObject();
        if(backup()) {
            drop();
        }
        String httpXmlData = this.getHttpService();
        String mqXmlData = this.getMqService();

        List<HashMap<String, String>> httpSourceData = this.getSourceData(httpXmlData);
        List<HashMap<String, String>> httpDefineData = new ArrayList<>();
        for (HashMap<String, String> pair1 : httpSourceData) {
            HashMap<String, String> hdata = new HashMap<>();
            hdata = this.defineData("http", pair1);
            httpDefineData.add(hdata);
            serviceDao.insert(hdata);
        }

        List<HashMap<String, String>> mqSourceData = this.getSourceData(mqXmlData);
        List<HashMap<String, String>> mqDefineData = new ArrayList<>();
        for (HashMap<String, String> pair2 : mqSourceData) {
            HashMap<String, String> mdata = new HashMap<>();
            mdata = this.defineData("mq", pair2);
            mqDefineData.add(mdata);
            serviceDao.insert(mdata);
        }
        int count = httpDefineData.size() + mqDefineData.size();
        response.put("count", count);
        return response;
    }


    public HashMap<String, String> defineData(String type, HashMap<String, String> d) {
        HashMap<String, String> data = new HashMap<>();
        data.put("PK_SERVICE", UUID.randomUUID().toString().replace("-","").toLowerCase());
        data.put("SERVICE_CODE", d.get("Svc_ServiceCode"));
        data.put("SERVICE_VERSION", d.get("Svc_Version"));
        data.put("OWNER_ORG", d.get("Svc_Provider_Org"));
        data.put("OWNER", d.get("Svc_Provider"));
        data.put("ENABLED_FLAG", "1");
        if (type == "http") {
            String catlog = d.get("Svc_Catalog");
            if (catlog.equals("WS")) {
                data.put("TYPE", "W");
            } else if (catlog.equals("REST")) {
                data.put("TYPE", "R");
            } else {
                data.put("TYPE", "");
            }
        } else{
            data.put("TYPE", "M");
        }

        data.put("REMARK", d.containsKey("Svc_Desc") ? d.get("Svc_Desc") : "");
        data.put("CREATOR", "Admin");
        data.put("MODIFIER", "Admin");
        data.put("SVC_TYPE", d.containsKey("Svc_Desc") ? d.get("Svc_Desc") : "");
        if (type == "http"){
            data.put("SVC_PROXYURL", d.get("Svc_ProxyUrl"));
            data.put("SVC_REALURL", d.get("Svc_RealUrl"));
        } else {
            data.put("SVC_PROXYURL", "");
            data.put("SVC_REALURL", "");
        }
        data.put("SVC_EXAMPLE", d.containsKey("SVC_EXAMPLE") ? d.get("Svc_Example") : "");

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

            List<Element> father = doc.selectNodes("//"+ root + "/Body/Services");
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
}
