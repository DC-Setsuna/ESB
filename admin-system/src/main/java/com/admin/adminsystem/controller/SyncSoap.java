package com.admin.adminsystem.controller;

import okhttp3.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by DC on 2019/1/18.
 */
public class SyncSoap {

    public SyncSoap() {}

    public String getXMLdata(String url) {
        try {
            String soapData = getSoapData(url);

            try {
                String xmlData = parseXML(soapData);
                return xmlData;
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        } catch (IOException  e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getSoapData(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("text/xml");
        RequestBody body = RequestBody.create(mediaType, "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.caacitc.com\">\r\n   <soapenv:Header/>\r\n   <soapenv:Body>\r\n      <ws:synchronize/>\r\n   </soapenv:Body>\r\n</soapenv:Envelope>");
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "text/xml")
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    private String parseXML(String xml) throws DocumentException {
        Document doc = DocumentHelper.parseText(xml);
        Element root = doc.getRootElement();
        Element e2 = (Element) root.elements().get(0);
        Element e3 = (Element) e2.elements().get(0);
        Element _return = e3.element("return");

        return _return.getText();
    }

    public static void main(String[] args) {
        HashMap<String, String> a = new HashMap<>();
        System.out.print(a.get("a"));
    }
}
