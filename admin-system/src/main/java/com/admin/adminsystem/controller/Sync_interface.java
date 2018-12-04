package com.admin.adminsystem.controller;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by DC on 2018/8/22.
 */



@RestController
public class Sync_interface {


    public static String readXml(String path) {

        BufferedReader reader = null;
        String context = "";
        try {
            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + path);
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;

            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
                context += tempString;
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        return context;
    }

    @RequestMapping(value = "/sync/service-http", method = RequestMethod.GET, produces = {"application/xml;charset=UTF-8"})
    public String sync_service_http() {
        return this.readXml("xml/DDXP_DDXP_O_HTTPSERVICE_SYNCHRONIZE.xml");
    }

    @RequestMapping(value = "/sync/service-mq", method = RequestMethod.GET, produces = {"application/xml;charset=UTF-8"})
    public String sync_service_mq() {
        return this.readXml("xml/DDXP_DDXP_O_MQSERVICE_SYNCHRONIZE.xml");
    }

    @RequestMapping(value = "/sync/route-mq", method = RequestMethod.GET, produces = {"application/xml;charset=UTF-8"})
    public String sync_route_mq() {
        return this.readXml("xml/DDXP_DDXP_O_MQSUBSCRIBE_SYNCHRONIZE.xml");
    }

    @RequestMapping(value = "/sync/route-rest", method = RequestMethod.GET, produces = {"application/xml;charset=UTF-8"})
    public String sync_route_rest() {
        return this.readXml("xml/DDXP_DDXP_O_RESTSUBSCRIBE_SYNCHRONIZE.xml");
    }

    @RequestMapping(value = "/sync/route-ws", method = RequestMethod.GET, produces = {"application/xml;charset=UTF-8"})
    public String sync_route_ws() {
        return this.readXml("xml/DDXP_DDXP_O_WSSUBSCRIBE_SYNCHRONIZE.xml");
    }

    @RequestMapping(value = "/sync/system", method = RequestMethod.GET, produces = {"application/xml;charset=UTF-8"})
    public String sync_system() {
        return this.readXml("xml/DDXP_DDXP_SYSTEMUSER_SYNCHRONIZE.xml");
    }

}
