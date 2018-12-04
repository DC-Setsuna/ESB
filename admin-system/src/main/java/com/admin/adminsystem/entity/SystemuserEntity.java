package com.admin.adminsystem.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by DC on 2018/8/24.
 */



@Entity
@Table(name = "SYSTEMUSER")
public class SystemuserEntity {

    @Id
    @GeneratedValue(generator = "xxx")
    @GenericGenerator(name = "xxx", strategy = "uuid")
    private String PK_SYSTEMUSER;


    @Column(name = "SYSTEMUSER_ORG")
    private String SYSTEMUSER_ORG;

    public String getPK_SYSTEMUSER() {
        return PK_SYSTEMUSER;
    }

    public void setPK_SYSTEMUSER(String PK_SYSTEMUSER) {
        this.PK_SYSTEMUSER = PK_SYSTEMUSER;
    }

    public String getSYSTEMUSER_ORG() {
        return SYSTEMUSER_ORG;
    }

    public void setSYSTEMUSER_ORG(String SYSTEMUSER_ORG) {
        this.SYSTEMUSER_ORG = SYSTEMUSER_ORG;
    }

    public String getSYSTEMUSER_CODE() {
        return SYSTEMUSER_CODE;
    }

    public void setSYSTEMUSER_CODE(String SYSTEMUSER_CODE) {
        this.SYSTEMUSER_CODE = SYSTEMUSER_CODE;
    }

    public String getSYSTEMUSER_DESC() {
        return SYSTEMUSER_DESC;
    }

    public void setSYSTEMUSER_DESC(String SYSTEMUSER_DESC) {
        this.SYSTEMUSER_DESC = SYSTEMUSER_DESC;
    }

    public String getINSERT_TIMESTAMP() {
        return INSERT_TIMESTAMP;
    }

    public void setINSERT_TIMESTAMP(String INSERT_TIMESTAMP) {
        this.INSERT_TIMESTAMP = INSERT_TIMESTAMP;
    }

    public String getLAST_UPDATE_TIMESTAMP() {
        return LAST_UPDATE_TIMESTAMP;
    }

    public void setLAST_UPDATE_TIMESTAMP(String LAST_UPDATE_TIMESTAMP) {
        this.LAST_UPDATE_TIMESTAMP = LAST_UPDATE_TIMESTAMP;
    }

    public String getCREATOR() {
        return CREATOR;
    }

    public void setCREATOR(String CREATOR) {
        this.CREATOR = CREATOR;
    }

    public String getMODIFIER() {
        return MODIFIER;
    }

    public void setMODIFIER(String MODIFIER) {
        this.MODIFIER = MODIFIER;
    }

    @Column(name = "SYSTEMUSER_CODE")
    private String SYSTEMUSER_CODE;

    @Column(name = "SYSTEMUSER_DESC")
    private String SYSTEMUSER_DESC;

    @Column(name = "INSERT_TIMESTAMP")
    private String INSERT_TIMESTAMP;

    @Column(name = "LAST_UPDATE_TIMESTAMP")
    private String LAST_UPDATE_TIMESTAMP;

    @Column(name = "CREATOR")
    private String CREATOR;

    @Column(name = "MODIFIER")
    private String MODIFIER;
}
