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

    public static String s_h = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<Msg>\n" +
            "<Head>\n" +
            "<Svc_ServiceCode>DDXP_DDXP_O_HTTPSERVICE_SYNCHRONIZE</Svc_ServiceCode>\n" +
            "<Svc_Version>1.0</Svc_Version>\n" +
            "<Svc_Sender_Org>DDXP</Svc_Sender_Org>\n" +
            "<Svc_Sender>DDXP</Svc_Sender>\n" +
            "<Svc_Receiver_Org></Svc_Receiver_Org>\n" +
            "<Svc_Receiver></Svc_Receiver>\n" +
            "<Svc_SerialNumber></Svc_SerialNumber>\n" +
            "<Svc_SessionId>20171228140658867</Svc_SessionId>\n" +
            "<Svc_SendTimeStamp>20171228140658867</Svc_SendTimeStamp>\n" +
            "</Head>\n" +
            "<Body>\n" +
            "\t<Services>\n" +
            "\t\t<Service>\n" +
            "\t\t\t<Svc_ServiceCode>MDXP_HR_O_POST_MODIFY</Svc_ServiceCode>\n" +
            "\t\t\t<Svc_Version>1.0</Svc_Version>\n" +
            "\t\t\t<Svc_Provider_Org>MDXP</Svc_Provider_Org>\n" +
            "\t\t\t<Svc_Provider>HR</Svc_Provider>\n" +
            "\t\t\t<Svc_Type>请求</Svc_Type>\n" +
            "\t\t\t<Svc_Catalog>WS</Svc_Catalog>\n" +
            "\t\t\t<Svc_Desc>岗位更新接口</Svc_Desc>\n" +
            "\t\t\t<Svc_ProxyUrl>http://proxyURL.qdjc.com/aa.do</Svc_ProxyUrl>\n" +
            "\t\t\t<Svc_RealUrl>http://mdxp.qdjc.com/aa.do</Svc_RealUrl>\n" +
            "\t\t\t<Svc_Example>Example</Svc_Example>\n" +
            "\t\t\t<OperationTime>20180313180303203</OperationTime> \n" +
            "\t\t</Service>\n" +
            "\t\t<Service>\n" +
            "\t\t\t<Svc_ServiceCode>MDXP_HR_O_POST_IFRQ</Svc_ServiceCode>\n" +
            "\t\t\t<Svc_Version>1.0</Svc_Version>\n" +
            "\t\t\t<Svc_Provider_Org>MDXP</Svc_Provider_Org>\n" +
            "\t\t\t<Svc_Provider>HR</Svc_Provider>\n" +
            "\t\t\t<Svc_Type>发送</Svc_Type>\n" +
            "\t\t\t<Svc_Catalog>REST</Svc_Catalog>\n" +
            "\t\t\t<Svc_Desc>岗位券表请求接口</Svc_Desc>\n" +
            "\t\t\t<Svc_ProxyUrl>http://proxyURL.qdjc.com/aa.do</Svc_ProxyUrl>\n" +
            "\t\t\t<Svc_RealUrl>http://mdxp.qdjc.com/aa.do</Svc_RealUrl>\n" +
            "\t\t\t<Svc_Example>Example</Svc_Example>\n" +
            "\t\t\t<OperationTime>20180313180303203</OperationTime> \n" +
            "\t\t</Service>\n" +
            "\t</Services>\n" +
            "</Body>\n" +
            "</Msg>\n";

    public static String s_m = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<Msg>\n" +
            "<Head>\n" +
            "<Svc_ServiceCode>DDXP_DDXP_O_MQSERVICE_SYNCHRONIZE</Svc_ServiceCode>\n" +
            "<Svc_Version>1.0</Svc_Version>\n" +
            "<Svc_Sender_Org>DDXP</Svc_Sender_Org>\n" +
            "<Svc_Sender>DDXP</Svc_Sender>\n" +
            "<Svc_Receiver_Org></Svc_Receiver_Org>\n" +
            "<Svc_Receiver></Svc_Receiver>\n" +
            "<Svc_SerialNumber></Svc_SerialNumber>\n" +
            "<Svc_SessionId>20171228140658867</Svc_SessionId>\n" +
            "<Svc_SendTimeStamp>20171228140658867</Svc_SendTimeStamp>\n" +
            "</Head>\n" +
            "<Body>\n" +
            "\t<Services>\n" +
            "\t\t<Service>\n" +
            "\t\t\t<Svc_ServiceCode>MDXP_HR_O_POST_MODIFY1</Svc_ServiceCode>\n" +
            "\t\t\t<Svc_Version>1.0</Svc_Version>\n" +
            "\t\t\t<Svc_Provider_Org>MDXP</Svc_Provider_Org>\n" +
            "\t\t\t<Svc_Provider>HR</Svc_Provider>\n" +
            "\t\t\t<Svc_Type>请求</Svc_Type>\n" +
            "\t\t\t<Svc_Catalog>WS</Svc_Catalog>\n" +
            "\t\t\t<Svc_Desc>岗位更新接口</Svc_Desc>\n" +
            "\t\t\t<Svc_Example>Example</Svc_Example>\n" +
            "\t\t\t<OperationTime>20180313180303203</OperationTime> \n" +
            "\t\t</Service>\n" +
            "\t\t<Service>\n" +
            "\t\t\t<Svc_ServiceCode>MDXP_HR_O_POST_IFRQ1</Svc_ServiceCode>\n" +
            "\t\t\t<Svc_Version>1.0</Svc_Version>\n" +
            "\t\t\t<Svc_Provider_Org>MDXP</Svc_Provider_Org>\n" +
            "\t\t\t<Svc_Provider>HR</Svc_Provider>\n" +
            "\t\t\t<Svc_Type>发送</Svc_Type>\n" +
            "\t\t\t<Svc_Catalog>REST</Svc_Catalog>\n" +
            "\t\t\t<Svc_Desc>岗位券表请求接口</Svc_Desc>\n" +
            "\t\t\t<Svc_Example>Example</Svc_Example>\n" +
            "\t\t\t<OperationTime>20180313180303203</OperationTime> \n" +
            "\t\t</Service>\n" +
            "\t</Services>\n" +
            "</Body>\n" +
            "</Msg>\n";

    public static String r_m = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<Msg>\n" +
            "<Head>\n" +
            "<Svc_ServiceCode>DDXP_DDXP_O_MQSUBSCRIBE_SYNCHRONIZE</Svc_ServiceCode>\n" +
            "<Svc_Version>1.0</Svc_Version>\n" +
            "<Svc_Sender_Org>DDXP</Svc_Sender_Org>\n" +
            "<Svc_Sender>DDXP</Svc_Sender>\n" +
            "<Svc_Receiver_Org></Svc_Receiver_Org>\n" +
            "<Svc_Receiver></Svc_Receiver>\n" +
            "<Svc_SerialNumber></Svc_SerialNumber>\n" +
            "<Svc_SessionId>20171228140658867</Svc_SessionId>\n" +
            "<Svc_SendTimeStamp>20171228140658867</Svc_SendTimeStamp>\n" +
            "</Head>\n" +
            "<Body>\n" +
            "\t<SubScribes>\n" +
            "\t\t<SubScribe>\n" +
            "\t\t\t<Svc_ServiceCode>MDXP_HR_O_POST_MODIFY</Svc_ServiceCode>\n" +
            "\t\t   <Svc_Type>推送</Svc_Type>\n" +
            "\t\t   <Svc_Sender>NAOMS</Svc_Sender>\n" +
            "\t\t   <Svc_Receiver>FIDS,PA</Svc_Receiver>\n" +
            "\t\t   <OperationTime>20180313180303203</OperationTime> \n" +
            "\t\t</SubScribe>\n" +
            "\t\t<SubScribe>\n" +
            "\t\t\t<Svc_ServiceCode>MDXP_HR_O_POST_ADD</Svc_ServiceCode>\n" +
            "\t\t   <Svc_Type>请求</Svc_Type>\n" +
            "\t\t   <Svc_Sender>FIDS,PA</Svc_Sender>\n" +
            "\t\t   <Svc_Receiver>NAOMS</Svc_Receiver>\n" +
            "\t\t   <OperationTime>20180313180303203</OperationTime> \n" +
            "\t\t</SubScribe>\n" +
            "\t\t\n" +
            "\t</SubScribes>\n" +
            "</Body>\n" +
            "</Msg>\n";

    public static String r_r = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<Msg>\n" +
            "<Head>\n" +
            "<Svc_ServiceCode>DDXP_DDXP_O_MQSUBSCRIBE_SYNCHRONIZE</Svc_ServiceCode>\n" +
            "<Svc_Version>1.0</Svc_Version>\n" +
            "<Svc_Sender_Org>DDXP</Svc_Sender_Org>\n" +
            "<Svc_Sender>DDXP</Svc_Sender>\n" +
            "<Svc_Receiver_Org></Svc_Receiver_Org>\n" +
            "<Svc_Receiver></Svc_Receiver>\n" +
            "<Svc_SerialNumber></Svc_SerialNumber>\n" +
            "<Svc_SessionId>20171228140658867</Svc_SessionId>\n" +
            "<Svc_SendTimeStamp>20171228140658867</Svc_SendTimeStamp>\n" +
            "</Head>\n" +
            "<Body>\n" +
            "\t<SubScribes>\n" +
            "\t\t<SubScribe>\n" +
            "\t\t\t<Svc_ServiceCode>MDXP_HR_O_POST_MODIFY1</Svc_ServiceCode>\n" +
            "\t\t   <Svc_Type>推送</Svc_Type>\n" +
            "\t\t   <Svc_Sender>NAOMS</Svc_Sender>\n" +
            "\t\t   <Svc_Receiver>FIDS,PA</Svc_Receiver>\n" +
            "\t\t   <OperationTime>20180313180303203</OperationTime> \n" +
            "\t\t</SubScribe>\n" +
            "\t\t<SubScribe>\n" +
            "\t\t\t<Svc_ServiceCode>MDXP_HR_O_POST_ADD1</Svc_ServiceCode>\n" +
            "\t\t   <Svc_Type>请求</Svc_Type>\n" +
            "\t\t   <Svc_Sender>FIDS,PA</Svc_Sender>\n" +
            "\t\t   <Svc_Receiver>NAOMS</Svc_Receiver>\n" +
            "\t\t   <OperationTime>20180313180303203</OperationTime> \n" +
            "\t\t</SubScribe>\n" +
            "\t\t\n" +
            "\t</SubScribes>\n" +
            "</Body>\n" +
            "</Msg>\n";

    public static String r_w = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<Msg>\n" +
            "<Head>\n" +
            "<Svc_ServiceCode>DDXP_DDXP_O_MQSUBSCRIBE_SYNCHRONIZE</Svc_ServiceCode>\n" +
            "<Svc_Version>1.0</Svc_Version>\n" +
            "<Svc_Sender_Org>DDXP</Svc_Sender_Org>\n" +
            "<Svc_Sender>DDXP</Svc_Sender>\n" +
            "<Svc_Receiver_Org></Svc_Receiver_Org>\n" +
            "<Svc_Receiver></Svc_Receiver>\n" +
            "<Svc_SerialNumber></Svc_SerialNumber>\n" +
            "<Svc_SessionId>20171228140658867</Svc_SessionId>\n" +
            "<Svc_SendTimeStamp>20171228140658867</Svc_SendTimeStamp>\n" +
            "</Head>\n" +
            "<Body>\n" +
            "\t<SubScribes>\n" +
            "\t\t<SubScribe>\n" +
            "\t\t\t<Svc_ServiceCode>MDXP_HR_O_POST_MODIFY2</Svc_ServiceCode>\n" +
            "\t\t   <Svc_Type>推送</Svc_Type>\n" +
            "\t\t   <Svc_Sender>NAOMS</Svc_Sender>\n" +
            "\t\t   <Svc_Receiver>FIDS,PA</Svc_Receiver>\n" +
            "\t\t   <Svc_Method>MethodA,MethodB</Svc_Method>\n" +
            "\t\t   <OperationTime>20180313180303203</OperationTime>\n" +
            "\t\t</SubScribe>\n" +
            "\t\t<SubScribe>\n" +
            "\t\t\t<Svc_ServiceCode>MDXP_HR_O_POST_ADD2</Svc_ServiceCode>\n" +
            "\t\t   <Svc_Type>请求</Svc_Type>\n" +
            "\t\t   <Svc_Sender>FIDS,PA</Svc_Sender>\n" +
            "\t\t   <Svc_Receiver>NAOMS</Svc_Receiver>\n" +
            "\t\t   <Svc_Method>MethodA,MethodB</Svc_Method>\n" +
            "\t\t   <OperationTime>20180313180303203</OperationTime> \n" +
            "\t\t</SubScribe>\n" +
            "\t\t\n" +
            "\t</SubScribes>\n" +
            "</Body>\n" +
            "</Msg>\n";

    public static String sys = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<Msg>\n" +
            "<Head>\n" +
            "<Svc_ServiceCode>DDXP_DDXP_SYSTEMUSER_SYNCHRONIZE</Svc_ServiceCode>\n" +
            "<Svc_Version>1.0</Svc_Version>\n" +
            "<Svc_Sender_Org>DDXP</Svc_Sender_Org>\n" +
            "<Svc_Sender>DDXP</Svc_Sender>\n" +
            "<Svc_Receiver_Org></Svc_Receiver_Org>\n" +
            "<Svc_Receiver></Svc_Receiver>\n" +
            "<Svc_SerialNumber></Svc_SerialNumber>\n" +
            "<Svc_SessionId>20171228140658867</Svc_SessionId>\n" +
            "<Svc_SendTimeStamp>20171228140658867</Svc_SendTimeStamp>\n" +
            "</Head>\n" +
            "<Body>\n" +
            "\t<SystemUsers>\n" +
            "\t\t<SystemUser>\n" +
            "\t\t\t<PK_SYSTEMUSER>6d780cda-a7ef-4ef1-9762-fbd449f2a9aa</PK_SYSTEMUSER>\n" +
            "\t\t   <SYSTEMUSER_ORG>ADXP</SYSTEMUSER_ORG>\n" +
            "\t\t   <SYSTEMUSER_CODE>HR</SYSTEMUSER_CODE>\n" +
            "\t\t   <SYSTEMUSER_DESC>HR系统</SYSTEMUSER_DESC>\n" +
            "\t\t</SystemUser>\n" +
            "\t\t<SystemUser>\n" +
            "\t\t\t<PK_SYSTEMUSER>6d780cda-a7ef-4ef1-9762-fbd449f2a9bb</PK_SYSTEMUSER>\n" +
            "\t\t   <SYSTEMUSER_ORG>ADXP</SYSTEMUSER_ORG>\n" +
            "\t\t   <SYSTEMUSER_CODE>SMS</SYSTEMUSER_CODE>\n" +
            "\t\t   <SYSTEMUSER_DESC>SMS系统</SYSTEMUSER_DESC>\n" +
            "\t\t</SystemUser>\n" +
            "\t</SystemUsers>\n" +
            "</Body>\n" +
            "</Msg>\n";

    @RequestMapping(value = "/sync/service-http", method = RequestMethod.GET, produces = {"application/xml;charset=UTF-8"})
    public String sync_service_http() {
        return s_h;
    }

    @RequestMapping(value = "/sync/service-mq", method = RequestMethod.GET, produces = {"application/xml;charset=UTF-8"})
    public String sync_service_mq() {
        return s_m;
    }

    @RequestMapping(value = "/sync/route-mq", method = RequestMethod.GET, produces = {"application/xml;charset=UTF-8"})
    public String sync_route_mq() {
        return r_m;
    }

    @RequestMapping(value = "/sync/route-rest", method = RequestMethod.GET, produces = {"application/xml;charset=UTF-8"})
    public String sync_route_rest() {
        return r_r;
    }

    @RequestMapping(value = "/sync/route-ws", method = RequestMethod.GET, produces = {"application/xml;charset=UTF-8"})
    public String sync_route_ws() {
        return r_w;
    }

    @RequestMapping(value = "/sync/system", method = RequestMethod.GET, produces = {"application/xml;charset=UTF-8"})
    public String sync_system() {
        return sys;
    }

}
