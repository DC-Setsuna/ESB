package com.admin.adminsystem.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The type Route entity.
 */
@Entity
@Table(name = "ROUTE_CONFIG")
public class RouteEntity implements Serializable{
    @Id
    @GeneratedValue(generator = "xxx")
    @GenericGenerator(name = "xxx", strategy = "uuid")
    private String PK_ROUTE;

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

    @Column(name = "ENABLED_FLAG")
    private Long ENABLED_FLAG;

    @Column(name = "REMARK")
    @JsonProperty(index = 5)
    private String REMARK;

    @Column(name = "INSERT_TIMESTAMP")
    private Date INSERT_TIMESTAMP;

    @Column(name = "LAST_UPDATE_TIMESTAMP")
    private Date LAST_UPDATE_TIMESTAMP;

    @Column(name = "CREATOR")
    private String CREATOR;

    @Column(name = "MODIFIER")
    private String MODIFIER;

    /**
     * Gets pk route.
     *
     * @return the pk route
     */
    public String getPK_ROUTE() {
        return PK_ROUTE;
    }

    /**
     * Sets pk route.
     *
     * @param PK_ROUTE the pk route
     */
    public void setPK_ROUTE(String PK_ROUTE) {
        this.PK_ROUTE = PK_ROUTE;
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
     * Gets enabled flag.
     *
     * @return the enabled flag
     */
    public Long getENABLED_FLAG() {
        return ENABLED_FLAG;
    }

    /**
     * Sets enabled flag.
     *
     * @param ENABLED_FLAG the enabled flag
     */
    public void setENABLED_FLAG(Long ENABLED_FLAG) {
        this.ENABLED_FLAG = ENABLED_FLAG;
    }

    /**
     * Gets remark.
     *
     * @return the remark
     */
    public String getREMARK() { return REMARK; }

    /**
     * Sets remark.
     *
     * @param REMARK the remark
     */
    public void setREMARK(String REMARK) { this.REMARK = REMARK; }

    /**
     * Gets insert timestamp.
     *
     * @return the insert timestamp
     */
    public Date getINSERT_TIMESTAMP() {
        return INSERT_TIMESTAMP;
    }

    /**
     * Sets insert timestamp.
     *
     * @param INSERT_TIMESTAMP the insert timestamp
     */
    public void setINSERT_TIMESTAMP(Date INSERT_TIMESTAMP) {
        this.INSERT_TIMESTAMP = INSERT_TIMESTAMP;
    }

    /**
     * Gets last update timestamp.
     *
     * @return the last update timestamp
     */
    public Date getLAST_UPDATE_TIMESTAMP() {
        return LAST_UPDATE_TIMESTAMP;
    }

    /**
     * Sets last update timestamp.
     *
     * @param LAST_UPDATE_TIMESTAMP the last update timestamp
     */
    public void setLAST_UPDATE_TIMESTAMP(Date LAST_UPDATE_TIMESTAMP) {
        this.LAST_UPDATE_TIMESTAMP = LAST_UPDATE_TIMESTAMP;
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

    /**
     * Gets modifier.
     *
     * @return the modifier
     */
    public String getMODIFIER() {
        return MODIFIER;
    }

    /**
     * Sets modifier.
     *
     * @param MODIFIER the modifier
     */
    public void setMODIFIER(String MODIFIER) {
        this.MODIFIER = MODIFIER;
    }
}
