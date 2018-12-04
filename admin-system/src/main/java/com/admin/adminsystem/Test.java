package com.admin.adminsystem;

import com.admin.adminsystem.controller.Sync;
import com.alibaba.fastjson.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DC on 2018/8/28.
 */
public class Test {
    public static void main(String[] args) {

        JSONObject response = new JSONObject();
//        backupSystemuser();
        String xmlData = Sync.callAPI("http://localhost:8080/sync/system");
        //System.out.println(xmlData);
        Document doc;
        List<Map<String, String>> lists = null;
        try {
            doc = DocumentHelper.parseText(xmlData);
            Element et = doc.getRootElement();
            String root = et.getName();
            List<Element> father = doc.selectNodes("//"+ root + "/Body/SystemUsers");
            //System.out.println(father.toString());
            if (father!=null && !father.isEmpty() && father.size()==1) {
                List<Element> systemUsers = father.get(0).elements();
                if (systemUsers != null) {
                    lists = new ArrayList<Map<String, String>>();
                    for (Element e : systemUsers) {
                        List<Element> li = e.elements();
                        HashMap<String, String> item = new HashMap<String, String>();
                        for (Element element2 : li) {
                            String key = element2.getName();
                            String value = element2.getText();
                            item.put(key, value);
                        }
                        lists.add(item);
                    }
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
            //数据源xml格式有问题
        }

        //System.out.println(lists);
//        return lists.toString();
    }
}
