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
public class Student {
    private String stID;
    private String stName;
    private String stAddress;
    private String stTelephone;
    private String dOB;
    private String gender;
    private String guardName;
    private String guardOccupation;
    private String guardRelationship;
    private String guardTelephone;

    public Student() {
    }

    public Student(String stID, String stName, String stAddress, String stTelephone, String dOB, String gender, String guardName, String guardOccupation, String guardRelationship, String guardTelephone) {
        this.stID = stID;
        this.stName = stName;
        this.stAddress = stAddress;
        this.stTelephone = stTelephone;
        this.dOB = dOB;
        this.gender = gender;
        this.guardName = guardName;
        this.guardOccupation = guardOccupation;
        this.guardRelationship = guardRelationship;
        this.guardTelephone = guardTelephone;
    }
 
    /**
     * @return the stID
     */
    public String getStID() {
        return stID;
    }

    /**
     * @param stID the stID to set
     */
    public void setStID(String stID) {
        this.stID = stID;
    }

    /**
     * @return the stName
     */
    public String getStName() {
        return stName;
    }

    /**
     * @param stName the stName to set
     */
    public void setStName(String stName) {
        this.stName = stName;
    }

    /**
     * @return the stAddress
     */
    public String getStAddress() {
        return stAddress;
    }

    /**
     * @param stAddress the stAddress to set
     */
    public void setStAddress(String stAddress) {
        this.stAddress = stAddress;
    }

    /**
     * @return the stTelephone
     */
    public String getStTelephone() {
        return stTelephone;
    }

    /**
     * @param stTelephone the stTelephone to set
     */
    public void setStTelephone(String stTelephone) {
        this.stTelephone = stTelephone;
    }

    /**
     * @return the dOB
     */
    public String getdOB() {
        return dOB;
    }

    /**
     * @param dOB the dOB to set
     */
    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the guardName
     */
    public String getGuardName() {
        return guardName;
    }

    /**
     * @param guardName the guardName to set
     */
    public void setGuardName(String guardName) {
        this.guardName = guardName;
    }

    /**
     * @return the guardOccupation
     */
    public String getGuardOccupation() {
        return guardOccupation;
    }

    /**
     * @param guardOccupation the guardOccupation to set
     */
    public void setGuardOccupation(String guardOccupation) {
        this.guardOccupation = guardOccupation;
    }

    /**
     * @return the guardRelationship
     */
    public String getGuardRelationship() {
        return guardRelationship;
    }

    /**
     * @param guardRelationship the guardRelationship to set
     */
    public void setGuardRelationship(String guardRelationship) {
        this.guardRelationship = guardRelationship;
    }

    /**
     * @return the guardTelephone
     */
    public String getGuardTelephone() {
        return guardTelephone;
    }

    /**
     * @param guardTelephone the guardTelephone to set
     */
    public void setGuardTelephone(String guardTelephone) {
        this.guardTelephone = guardTelephone;
    }
}
