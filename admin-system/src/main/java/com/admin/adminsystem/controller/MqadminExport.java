package com.admin.adminsystem.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class MqadminExport {

    public  String QMGR;// = "[{\"name\":\"MDXPQMGR\",\"platform\":\"\",\"commandlevel\":\"\",\"description\":\"\",\"status\":\"RUNNING\",\"hastatus\":\"\",\"sanstatus\":\"\",\"drport\":\"\",\"draddress\":\"\",\"host\":\"\",\"port\":\"\",\"channel\":\"\"}]";

    public  String QUEUE;// = "[{\"name\":\"DDXPQMGR\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_ADXP_TO_MDXP_S\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_ADXP_TO_MDXP_S_BACKOUT\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_DDXP_TO_MDXP_R\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_DDXP_TO_MDXP_R_BACKOUT\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_DDXP_TO_MDXP_T\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_FDXP_TO_MDXP_S\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_FDXP_TO_MDXP_S_BACKOUT\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_MDXP_TO_SUBSYS_R\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_MDXP_TO_SUBSYS_R_BACKOUT\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_MDXP_TO_SUBSYS_S\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":3244},{\"name\":\"LQ_MDXP_TO_SUBSYS_S_BACKOUT\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_SODB_TO_MDXP_S\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_SODB_TO_MDXP_S_BACKOUT\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_SUBSYS_TO_MDXP_R\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_SUBSYS_TO_MDXP_R_BACKOUT\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_SUBSYS_TO_MDXP_S\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"LQ_SUBSYS_TO_MDXP_S_BACKOUT\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"MDXP.DEFAULT.DEADLETTER.QUEUE\",\"type\":\"qlocal\",\"description\":\"IBM MQ Default Dead Letter Queue\",\"currentdepth\":0},{\"name\":\"MDXP.INNER.REQUEST.BACKOUT.QUEUE\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"MDXP.INNER.REQUEST.INPUT.QUEUE\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"MDXP.INNER.RESPONSE.BACKOUT.QUEUE\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"MDXP.INNER.RESPONSE.INPUT.QUEUE\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"MDXP.OUTTER.REQUEST.BACKOUT.QUEUE\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"MDXP.OUTTER.REQUEST.INPUT.QUEUE\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"MDXP.OUTTER.REQUEST.REMOTE.QUEUE\",\"type\":\"qremote\",\"description\":\"\",\"remoteqmgr\":\"DDXPQMGR\",\"remotequeue\":\"DDXP.OUTTER.REQUEST.INPUT.QUEUE\",\"transmissionqueue\":\"DDXPQMGR\"},{\"name\":\"MDXP.OUTTER.RESPONSE.BACKOUT.QUEUE\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"MDXP.OUTTER.RESPONSE.INPUT.QUEUE\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"MDXP.OUTTER.RESPONSE.REMOTE.QUEUE\",\"type\":\"qremote\",\"description\":\"\",\"remoteqmgr\":\"DDXPQMGR\",\"remotequeue\":\"DDXP.OUTTER.RESPONSE.INPUT.QUEUE\",\"transmissionqueue\":\"DDXPQMGR\"},{\"name\":\"RQ_MDXP_TO_DDXP_R\",\"type\":\"qremote\",\"description\":\"\",\"remoteqmgr\":\"DDXP_QM\",\"remotequeue\":\"LQ_MDXP_TO_DDXP_R\",\"transmissionqueue\":\"TQ_MDXP_TO_DDXP_R\"},{\"name\":\"RQ_MDXP_TO_DDXP_S\",\"type\":\"qremote\",\"description\":\"\",\"remoteqmgr\":\"DDXP_QM\",\"remotequeue\":\"LQ_MDXP_TO_DDXP_S\",\"transmissionqueue\":\"TQ_MDXP_TO_DDXP_S\"},{\"name\":\"TQ_MDXP_TO_DDXP_R\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0},{\"name\":\"TQ_MDXP_TO_DDXP_S\",\"type\":\"qlocal\",\"description\":\"\",\"currentdepth\":0}]";

    public  String CHANNEL;// = "[{\"name\":\"C_ADXP_TO_MDXP_S\",\"type\":\"rcvr\",\"description\":\"Receiver Channel from ADXP\",\"status\":\"MQCHS_INACTIVE\"},{\"name\":\"C_DDXP_TO_MDXP_R\",\"type\":\"rcvr\",\"description\":\"Receiver Channel from DDXP\",\"status\":\"MQCHS_INACTIVE\"},{\"name\":\"C_DDXP_TO_MDXP_T\",\"type\":\"rcvr\",\"description\":\"\",\"status\":\"MQCHS_INACTIVE\"},{\"name\":\"C_FDXP_TO_MDXP_S\",\"type\":\"rcvr\",\"description\":\"Receiver Channel from FDXP\",\"status\":\"MQCHS_INACTIVE\"},{\"name\":\"C_MDXP_TO_DDXP_R\",\"type\":\"sdr\",\"description\":\"Sender Channel to DDXP\",\"connectionname\":\"10.232.83.29(1414)\",\"transmissionqueue\":\"TQ_MDXP_TO_DDXP_R\",\"status\":\"MQCHS_INACTIVE\"},{\"name\":\"C_MDXP_TO_DDXP_S\",\"type\":\"sdr\",\"description\":\"Sender Channel to DDXP\",\"connectionname\":\"10.232.83.29(1414)\",\"transmissionqueue\":\"TQ_MDXP_TO_DDXP_S\",\"status\":\"MQCHS_INACTIVE\"},{\"name\":\"C_SODB_TO_MDXP_S\",\"type\":\"rcvr\",\"description\":\"Receiver Channel from SODB\",\"status\":\"MQCHS_INACTIVE\"},{\"name\":\"DDXPQMGR.TO.MDXPQMGR\",\"type\":\"rcvr\",\"description\":\"\",\"status\":\"MQCHS_INACTIVE\"},{\"name\":\"MDXPQMGR.TO.DDXPQMGR\",\"type\":\"sdr\",\"description\":\"\",\"connectionname\":\"localhost(1415)\",\"transmissionqueue\":\"DDXPQMGR\",\"status\":\"MQCHS_RETRYING\"},{\"name\":\"MDXP_ADMIN_CHANNEL\",\"type\":\"svrconn\",\"description\":\"\",\"status\":\"MQCHS_RUNNING\"}]";

    public  String LISTENER;// = "[{\"name\":\"LISTENER.TCP\",\"type\":\"tcp\",\"description\":\"\",\"control\":0,\"port\":\"1414\",\"status\":\"MQSVC_STATUS_RUNNING\"}]";

    public MqadminExport(String QMGR, String QUEUE, String CHANNEL, String LISTENER) {
        this.QMGR = QMGR;
        this.QUEUE = QUEUE;
        this.CHANNEL = CHANNEL;
        this.LISTENER = LISTENER;
    }

    public JSONArray getQueues() {

        JSONArray sourceQueues = JSONArray.parseArray(QUEUE);
        JSONArray queues = new JSONArray();
        for (Object pair1 : sourceQueues) {
//            System.out.println(pair1);
            JSONObject pair2 = (JSONObject) pair1;

            String queueName = pair2.getString("name");
            String queueType = pair2.getString("type");

            String currentdepth = "0";
            if (queueType.equals("qlocal")) {
                currentdepth = String.valueOf(pair2.getInteger("currentdepth"));
            }

            JSONObject targetObject = new JSONObject();
            targetObject.put("queueName", queueName);
            targetObject.put("queueType", queueType);

            if (queueType.equals("qlocal")) {
                targetObject.put("queueMaxDepth", "");
                targetObject.put("queueCurrentDepth", currentdepth);
                targetObject.put("queuePersistentce", "");
            }

            queues.add(targetObject);
        }
        return queues;
    }

    public JSONArray getChannels() {
        JSONArray sourceChannels = JSONArray.parseArray(CHANNEL);
        JSONArray channels = new JSONArray();
        for (Object pair3 : sourceChannels) {
//            System.out.println(pair3);
            JSONObject pair4 = (JSONObject) pair3;
            String channelName = pair4.getString("name");
            String channelType = pair4.getString("type");
            String channelRunningState = pair4.getString("status");

            JSONObject targetObject = new JSONObject();
            targetObject.put("channelName", channelName);
            targetObject.put("channelType", channelType);
            targetObject.put("channelRunningState", channelRunningState);

            channels.add(targetObject);
        }

        return channels;
    }

    public JSONObject generatJson() {
        JSONObject exportData = new JSONObject();
        exportData.put("qmrOrg", "MDXP");
        JSONArray qmrs = new JSONArray();

        JSONObject qmr = new JSONObject();
        JSONArray sourceQmgr = JSONArray.parseArray(QMGR);
        JSONObject MDXPQMGR = (JSONObject) sourceQmgr.get(0);

        qmr.put("qmrName", MDXPQMGR.getString("name"));
        qmr.put("qmrIp", "10.232.90.68");

        JSONArray sourceListener = JSONArray.parseArray(LISTENER);
        JSONObject oneListener = (JSONObject) sourceListener.get(0);

        qmr.put("listenerPort", oneListener.getString("port"));
        qmr.put("listenerRunningState", oneListener.getString("status"));

        JSONArray queue = getQueues();
        qmr.put("queues", queue);
        JSONArray channel = getChannels();
        qmr.put("channels", channel);

        qmrs.add(qmr);
        exportData.put("qmrs", qmrs);
        return exportData;
    }

//    public static void main(String[] args) {
//        MqadminExport mqadminExport = new MqadminExport();
//        System.out.println(mqadminExport.generatJson().toString());
//        JSONArray a = mqadminExport.getChannels();
//        System.out.println(a.toString());
//        JSONArray b = mqadminExport.getQueues();
//        System.out.println(b.toString());
//    }
}
