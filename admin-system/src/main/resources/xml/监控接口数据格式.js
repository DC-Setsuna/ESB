
https://10.232.90.68:9443/ibmmq/console/internal/ibmmq/qmgr [GET]

[{"name":"MDXPQMGR","platform":"","commandlevel":"","description":"","status":"RUNNING","hastatus":"","sanstatus":"","drport":"","draddress":"","host":"","port":"","channel":""}]


https://10.232.90.68:9443/ibmmq/console/internal/ibmmq/qmgr/MDXPQMGR/queue?type=all&hideSystem=true

[{"name":"DDXPQMGR","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_ADXP_TO_MDXP_S","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_ADXP_TO_MDXP_S_BACKOUT","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_DDXP_TO_MDXP_R","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_DDXP_TO_MDXP_R_BACKOUT","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_DDXP_TO_MDXP_T","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_FDXP_TO_MDXP_S","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_FDXP_TO_MDXP_S_BACKOUT","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_MDXP_TO_SUBSYS_R","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_MDXP_TO_SUBSYS_R_BACKOUT","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_MDXP_TO_SUBSYS_S","type":"qlocal","description":"","currentdepth":3244},{"name":"LQ_MDXP_TO_SUBSYS_S_BACKOUT","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_SODB_TO_MDXP_S","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_SODB_TO_MDXP_S_BACKOUT","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_SUBSYS_TO_MDXP_R","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_SUBSYS_TO_MDXP_R_BACKOUT","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_SUBSYS_TO_MDXP_S","type":"qlocal","description":"","currentdepth":0},{"name":"LQ_SUBSYS_TO_MDXP_S_BACKOUT","type":"qlocal","description":"","currentdepth":0},{"name":"MDXP.DEFAULT.DEADLETTER.QUEUE","type":"qlocal","description":"IBM MQ Default Dead Letter Queue","currentdepth":0},{"name":"MDXP.INNER.REQUEST.BACKOUT.QUEUE","type":"qlocal","description":"","currentdepth":0},{"name":"MDXP.INNER.REQUEST.INPUT.QUEUE","type":"qlocal","description":"","currentdepth":0},{"name":"MDXP.INNER.RESPONSE.BACKOUT.QUEUE","type":"qlocal","description":"","currentdepth":0},{"name":"MDXP.INNER.RESPONSE.INPUT.QUEUE","type":"qlocal","description":"","currentdepth":0},{"name":"MDXP.OUTTER.REQUEST.BACKOUT.QUEUE","type":"qlocal","description":"","currentdepth":0},{"name":"MDXP.OUTTER.REQUEST.INPUT.QUEUE","type":"qlocal","description":"","currentdepth":0},{"name":"MDXP.OUTTER.REQUEST.REMOTE.QUEUE","type":"qremote","description":"","remoteqmgr":"DDXPQMGR","remotequeue":"DDXP.OUTTER.REQUEST.INPUT.QUEUE","transmissionqueue":"DDXPQMGR"},{"name":"MDXP.OUTTER.RESPONSE.BACKOUT.QUEUE","type":"qlocal","description":"","currentdepth":0},{"name":"MDXP.OUTTER.RESPONSE.INPUT.QUEUE","type":"qlocal","description":"","currentdepth":0},{"name":"MDXP.OUTTER.RESPONSE.REMOTE.QUEUE","type":"qremote","description":"","remoteqmgr":"DDXPQMGR","remotequeue":"DDXP.OUTTER.RESPONSE.INPUT.QUEUE","transmissionqueue":"DDXPQMGR"},{"name":"RQ_MDXP_TO_DDXP_R","type":"qremote","description":"","remoteqmgr":"DDXP_QM","remotequeue":"LQ_MDXP_TO_DDXP_R","transmissionqueue":"TQ_MDXP_TO_DDXP_R"},{"name":"RQ_MDXP_TO_DDXP_S","type":"qremote","description":"","remoteqmgr":"DDXP_QM","remotequeue":"LQ_MDXP_TO_DDXP_S","transmissionqueue":"TQ_MDXP_TO_DDXP_S"},{"name":"TQ_MDXP_TO_DDXP_R","type":"qlocal","description":"","currentdepth":0},{"name":"TQ_MDXP_TO_DDXP_S","type":"qlocal","description":"","currentdepth":0}]



https://10.232.90.68:9443/ibmmq/console/internal/ibmmq/qmgr/MDXPQMGR/channel?type=all&showStatusAs=MQIACH_CHANNEL_STATUS&hideSystem=true

[{"name":"C_ADXP_TO_MDXP_S","type":"rcvr","description":"Receiver Channel from ADXP","status":"MQCHS_INACTIVE"},{"name":"C_DDXP_TO_MDXP_R","type":"rcvr","description":"Receiver Channel from DDXP","status":"MQCHS_INACTIVE"},{"name":"C_DDXP_TO_MDXP_T","type":"rcvr","description":"","status":"MQCHS_INACTIVE"},{"name":"C_FDXP_TO_MDXP_S","type":"rcvr","description":"Receiver Channel from FDXP","status":"MQCHS_INACTIVE"},{"name":"C_MDXP_TO_DDXP_R","type":"sdr","description":"Sender Channel to DDXP","connectionname":"10.232.83.29(1414)","transmissionqueue":"TQ_MDXP_TO_DDXP_R","status":"MQCHS_INACTIVE"},{"name":"C_MDXP_TO_DDXP_S","type":"sdr","description":"Sender Channel to DDXP","connectionname":"10.232.83.29(1414)","transmissionqueue":"TQ_MDXP_TO_DDXP_S","status":"MQCHS_INACTIVE"},{"name":"C_SODB_TO_MDXP_S","type":"rcvr","description":"Receiver Channel from SODB","status":"MQCHS_INACTIVE"},{"name":"DDXPQMGR.TO.MDXPQMGR","type":"rcvr","description":"","status":"MQCHS_INACTIVE"},{"name":"MDXPQMGR.TO.DDXPQMGR","type":"sdr","description":"","connectionname":"localhost(1415)","transmissionqueue":"DDXPQMGR","status":"MQCHS_RETRYING"},{"name":"MDXP_ADMIN_CHANNEL","type":"svrconn","description":"","status":"MQCHS_RUNNING"}]


https://10.232.90.68:9443/ibmmq/console/internal/ibmmq/qmgr/MDXPQMGR/listener?showStatusAs=MQIACH_LISTENER_STATUS&hideSystem=true

[{"name":"LISTENER.TCP","type":"tcp","description":"","control":0,"port":"1414","status":"MQSVC_STATUS_RUNNING"}]

