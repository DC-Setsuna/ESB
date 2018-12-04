package com.admin.adminsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The type Service 2 entity.
 */
@Entity
@Table(name = "Service")
public class Service2Entity implements Serializable {
    @Id
    @GeneratedValue(generator = "xxx")
    @GenericGenerator(name = "xxx", strategy = "uuid")
    private String PK_SERVICE;

    @Column(name = "SERVICE_CODE")
    private String SERVICE_CODE;

    @Column(name = "SERVICE_VERSION")
    private String SERVICE_VERSION;

    @Column(name = "OWNER_ORG")
    private String OWNER_ORG;

    @Column(name = "OWNER")
    private String OWNER;

    @Column(name = "ENABLED_FLAG")
    private String ENABLED_FLAG;

    @Column(name = "TYPE")
    private String TYPE;

    @Column(name = "REMARK")
    @JsonProperty(index = 5)
    private String REMARK;

    @Column(name = "INSERT_TIMESTAMP")
    private String INSERT_TIMESTAMP;

    @Column(name = "LAST_UPDATE_TIMESTAMP")
    private String LAST_UPDATE_TIMESTAMP;

    @Column(name = "CREATOR")
    private String CREATOR;

    @Column(name = "MODIFIER")
    private String MODIFIER;

    /**
     * Gets pk service.
     *
     * @return the pk service
     */
    public String getPK_SERVICE() {
        return PK_SERVICE;
    }

    /**
     * Sets pk service.
     *
     * @param PK_SERVICE the pk service
     */
    public void setPK_SERVICE(String PK_SERVICE) {
        this.PK_SERVICE = PK_SERVICE;
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
    public String getSERVICE_VERSION() { return SERVICE_VERSION; }

    /**
     * Sets service version.
     *
     * @param SERVICE_VERSION the service version
     */
    public void setSERVICE_VERSION(String SERVICE_VERSION) {
        this.SERVICE_VERSION = SERVICE_VERSION;
    }

    /**
     * Gets owner org.
     *
     * @return the owner org
     */
    public String getOWNER_ORG() {
        return OWNER_ORG;
    }

    /**
     * Sets owner org.
     *
     * @param OWNER_ORG the owner org
     */
    public void setOWNER_ORG(String OWNER_ORG) {
        this.OWNER_ORG = OWNER_ORG;
    }

    /**
     * Gets owner.
     *
     * @return the owner
     */
    public String getOWNER() {
        return OWNER;
    }

    /**
     * Sets owner.
     *
     * @param OWNER the owner
     */
    public void setOWNER(String OWNER) {
        this.OWNER = OWNER;
    }

    /**
     * Gets enabled flag.
     *
     * @return the enabled flag
     */
    public String getENABLED_FLAG() {
        return ENABLED_FLAG;
    }

    /**
     * Sets enabled flag.
     *
     * @param ENABLED_FLAG the enabled flag
     */
    public void setENABLED_FLAG(String ENABLED_FLAG) {
        this.ENABLED_FLAG = ENABLED_FLAG;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getTYPE() {
        return TYPE;
    }

    /**
     * Sets type.
     *
     * @param TYPE the type
     */
    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    /**
     * Gets remark.
     *
     * @return the remark
     */
    public String getREMARK() {
        return REMARK;
    }

    /**
     * Sets remark.
     *
     * @param REMARK the remark
     */
    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    /**
     * Gets insert timestamp.
     *
     * @return the insert timestamp
     */
    public String getINSERT_TIMESTAMP() {
        return INSERT_TIMESTAMP;
    }

    /**
     * Sets insert timestamp.
     *
     * @param INSERT_TIMESTAMP the insert timestamp
     */
    public void setINSERT_TIMESTAMP(String INSERT_TIMESTAMP) {
        this.INSERT_TIMESTAMP = INSERT_TIMESTAMP;
    }

    /**
     * Gets last update timestamp.
     *
     * @return the last update timestamp
     */
    public String getLAST_UPDATE_TIMESTAMP() {
        return LAST_UPDATE_TIMESTAMP;
    }

    /**
     * Sets last update timestamp.
     *
     * @param LAST_UPDATE_TIMESTAMP the last update timestamp
     */
    public void setLAST_UPDATE_TIMESTAMP(String LAST_UPDATE_TIMESTAMP) {
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
