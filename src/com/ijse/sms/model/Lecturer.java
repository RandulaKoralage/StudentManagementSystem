/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.sms.model;

/**
 *
 * @author Randula
 */
public class Lecturer {
    private String lectID;
    private String lectName;
    private String lectAddress;
    private String lectTelephone;
    private String lectDOB; 

    public Lecturer() {
    }

    public Lecturer(String lectID, String lectName, String lectAddress, String lectTelephone, String lectDOB) {
        this.lectID = lectID;
        this.lectName = lectName;
        this.lectAddress = lectAddress;
        this.lectTelephone = lectTelephone;
        this.lectDOB = lectDOB;
    }

    /**
     * @return the lectID
     */
    public String getLectID() {
        return lectID;
    }

    /**
     * @param lectID the lectID to set
     */
    public void setLectID(String lectID) {
        this.lectID = lectID;
    }

    /**
     * @return the lectName
     */
    public String getLectName() {
        return lectName;
    }

    /**
     * @param lectName the lectName to set
     */
    public void setLectName(String lectName) {
        this.lectName = lectName;
    }

    /**
     * @return the lectAddress
     */
    public String getLectAddress() {
        return lectAddress;
    }

    /**
     * @param lectAddress the lectAddress to set
     */
    public void setLectAddress(String lectAddress) {
        this.lectAddress = lectAddress;
    }

    /**
     * @return the lectTelephone
     */
    public String getLectTelephone() {
        return lectTelephone;
    }

    /**
     * @param lectTelephone the lectTelephone to set
     */
    public void setLectTelephone(String lectTelephone) {
        this.lectTelephone = lectTelephone;
    }

    /**
     * @return the lectDOB
     */
    public String getLectDOB() {
        return lectDOB;
    }

    /**
     * @param lectDOB the lectDOB to set
     */
    public void setLectDOB(String lectDOB) {
        this.lectDOB = lectDOB;
    }
    
    

}
