package com.admin.adminsystem.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;
import java.sql.Timestamp;
import java.util.Comparator;

/**
 * The type Msgflow log entity.
 */
@Entity
@Table(name = "MSGFLOW_LOG")
public class Msgflow_LogEntity implements Serializable, Comparator<Msgflow_LogEntity> {

    @Id
    @GeneratedValue(generator = "xxx")
    @GenericGenerator(name = "xxx", strategy = "uuid")
    private String PK_LOG;

    @Column(name = "SERVICE_CODE")
    private String SERVICE_CODE;

    @Column(name = "SERVICE_VERSION")
    private String SERVICE_VERSION;

    @Column(name = "SENDER_ORG")
    private String SENDER_ORG;

    @Column(name = "SENDER")
    private String SENDER;

    @Column(name = "RECEIVER_ORG")
    private String RECEIVER_ORG;

    @Column(name = "RECEIVER")
    private String RECEIVER;

    @Column(name = "SERIAL_NUMBER")
    private String SERIAL_NUMBER;

    @Column(name = "MSG")
    private String MSG;

    @Column(name = "MSG_TYPE")
    private long MSG_TYPE;

    @Column(name = "ERROR_MSG")
    private String ERROR_MSG;

    @Column(name = "LOG_TIMESTAMP")
    private String LOGTIMESTAMP;


    @Column(name = "CREATOR")
    private String CREATOR;

    /**
     * Gets pk log.
     *
     * @return the pk log
     */
    public String getPK_LOG() {
        return PK_LOG;
    }

    /**
     * Sets pk log.
     *
     * @param PK_LOG the pk log
     */
    public void setPK_LOG(String PK_LOG) {
        this.PK_LOG = PK_LOG;
    }

    /**
     * Gets service code.
     *
     * @return the service code
     */
    public String getSERVICE_CODE() {
        return SERVICE_CODE;
    }

    /**
     * Sets service code.
     *
     * @param SERVICE_CODE the service code
     */
    public void setSERVICE_CODE(String SERVICE_CODE) {
        this.SERVICE_CODE = SERVICE_CODE;
    }

    /**
     * Gets service version.
     *
     * @return the service version
     */
    public String getSERVICE_VERSION() {
        return SERVICE_VERSION;
    }

    /**
     * Sets service version.
     *
     * @param SERVICE_VERSION the service version
     */
    public void setSERVICE_VERSION(String SERVICE_VERSION) {
        this.SERVICE_VERSION = SERVICE_VERSION;
    }

    /**
     * Gets sender org.
     *
     * @return the sender org
     */
    public String getSENDER_ORG() {
        return SENDER_ORG;
    }

    /**
     * Sets sender org.
     *
     * @param SENDER_ORG the sender org
     */
    public void setSENDER_ORG(String SENDER_ORG) {
        this.SENDER_ORG = SENDER_ORG;
    }

    /**
     * Gets sender.
     *
     * @return the sender
     */
    public String getSENDER() {
        return SENDER;
    }

    /**
     * Sets sender.
     *
     * @param SENDER the sender
     */
    public void setSENDER(String SENDER) {
        this.SENDER = SENDER;
    }

    /**
     * Gets receiver org.
     *
     * @return the receiver org
     */
    public String getRECEIVER_ORG() {
        return RECEIVER_ORG;
    }

    /**
     * Sets receiver org.
     *
     * @param RECEIVER_ORG the receiver org
     */
    public void setRECEIVER_ORG(String RECEIVER_ORG) {
        this.RECEIVER_ORG = RECEIVER_ORG;
    }

    /**
     * Gets receiver.
     *
     * @return the receiver
     */
    public String getRECEIVER() {
        return RECEIVER;
    }

    /**
     * Sets receiver.
     *
     * @param RECEIVER the receiver
     */
    public void setRECEIVER(String RECEIVER) {
        this.RECEIVER = RECEIVER;
    }

    /**
     * Gets serial number.
     *
     * @return the serial number
     */
    public String getSERIAL_NUMBER() {
        return SERIAL_NUMBER;
    }

    /**
     * Sets serial number.
     *
     * @param SERIAL_NUMBER the serial number
     */
    public void setSERIAL_NUMBER(String SERIAL_NUMBER) {
        this.SERIAL_NUMBER = SERIAL_NUMBER;
    }

    /**
     * Gets msg.
     *
     * @return the msg
     */
    public String getMSG() {
        return MSG;
    }

    /**
     * Sets msg.
     *
     * @param MSG the msg
     */
    public void setMSG(String MSG) {
        this.MSG = MSG;
    }

    /**
     * Gets msg type.
     *
     * @return the msg type
     */
    public long getMSG_TYPE() {
        return MSG_TYPE;
    }

    /**
     * Sets msg type.
     *
     * @param MSG_TYPE the msg type
     */
    public void setMSG_TYPE(long MSG_TYPE) {
        this.MSG_TYPE = MSG_TYPE;
    }

    /**
     * Gets error msg.
     *
     * @return the error msg
     */
    public String getERROR_MSG() {
        return ERROR_MSG;
    }

    /**
     * Sets error msg.
     *
     * @param ERROR_MSG the error msg
     */
    public void setERROR_MSG(String ERROR_MSG) {
        this.ERROR_MSG = ERROR_MSG;
    }

    /**
     * Gets log timestamp.
     *
     * @return the log timestamp
     */
    public String getLOG_TIMESTAMP() {
        return LOGTIMESTAMP;
    }

    /**
     * Sets log timestamp.
     *
     * @param LOG_TIMESTAMP the log timestamp
     */
    public void setLOG_TIMESTAMP(String LOG_TIMESTAMP) {
        this.LOGTIMESTAMP = LOGTIMESTAMP;
    }

    /**
     * Gets creator.
     *
     * @return the creator
     */
    public String getCREATOR() {
        return CREATOR;
    }

    /**
     * Sets creator.
     *
     * @param CREATOR the creator
     */
    public void setCREATOR(String CREATOR) {
        this.CREATOR = CREATOR;
    }

    @Override
    public int compare(Msgflow_LogEntity o1, Msgflow_LogEntity o2) {
        if(Timestamp.valueOf(o1.getLOG_TIMESTAMP()).before(Timestamp.valueOf(o2.getLOG_TIMESTAMP()))){
            return 1;
        }else{
            return -1;
        }
    }
}
