package com.admin.adminsystem.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Reference entity.
 */
@Entity
@Table(name = "REFERENCE")
public class ReferenceEntity {
    @Id
    @GeneratedValue(generator = "xxx")
    @GenericGenerator(name = "xxx", strategy = "uuid")
    private String PK_REF;

    @Column(name = "TYPE")
    private String TYPE;

    @Column(name = "VALUE")
    private String VALUE;

    @Column(name = "SEQUENCE")
    private long SEQUENCE;

    @Column(name = "DESCRIPTION")
    private String DESCRIPTION;

    @Column(name = "PARENT")
    private String PARENT;

    @Column(name = "INSERT_TIMESTAMP")
    private Date INSERT_TIMESTAMP;

    @Column(name = "LAST_UPDATE_TIMESTAMP")
    private Date LAST_UPDATE_TIMESTAMP;

    @Column(name = "CREATOR")
    private String CREATOR;

    @Column(name = "MODIFIER")
    private String MODIFIER;

    /**
     * Gets pk ref.
     *
     * @return the pk ref
     */
    public String getPK_REF() {
        return PK_REF;
    }

    /**
     * Sets pk ref.
     *
     * @param PK_REF the pk ref
     */
    public void setPK_REF(String PK_REF) {
        this.PK_REF = PK_REF;
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
     * Gets value.
     *
     * @return the value
     */
    public String getVALUE() {
        return VALUE;
    }

    /**
     * Sets value.
     *
     * @param VALUE the value
     */
    public void setVALUE(String VALUE) {
        this.VALUE = VALUE;
    }

    /**
     * Gets sequence.
     *
     * @return the sequence
     */
    public long getSEQUENCE() {
        return SEQUENCE;
    }

    /**
     * Sets sequence.
     *
     * @param SEQUENCE the sequence
     */
    public void setSEQUENCE(long SEQUENCE) {
        this.SEQUENCE = SEQUENCE;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    /**
     * Sets description.
     *
     * @param DESCRIPTION the description
     */
    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

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

    /**
     * Gets parent.
     *
     * @return the parent
     */
    public String getPARENT() {
        return PARENT;
    }

    /**
     * Sets parent.
     *
     * @param PARENT the parent
     */
    public void setPARENT(String PARENT) {
        this.PARENT = PARENT;
    }
}
