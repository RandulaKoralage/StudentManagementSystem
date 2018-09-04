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
public class Registration {

    private String regID;
    private String stID;
    private String courseID;
    private double regFee;
    private String regDate;
    private String classDetail;

    public Registration() {
    }

    public Registration(String regID, String stID, String courseID, double regFee, String regDate, String classDetail) {
        this.regID = regID;
        this.stID = stID;
        this.courseID = courseID;
        this.regFee = regFee;
        this.regDate = regDate;
        this.classDetail = classDetail;
    }

    public Registration(String regID, String courseID, String classDetail, String regDate) {
        this.regID = regID;
        this.courseID = courseID;
        this.classDetail = classDetail;
        this.regDate = regDate;
    }

    public Registration(String regID, String classDetail) {
        this.regID = regID;
        this.classDetail = classDetail;
    }

    /**
     * @return the regID
     */
    public String getRegID() {
        return regID;
    }

    /**
     * @param regID the regID to set
     */
    public void setRegID(String regID) {
        this.regID = regID;
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
     * @return the courseID
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * @param courseID the courseID to set
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    /**
     * @return the regFee
     */
    public double getRegFee() {
        return regFee;
    }

    /**
     * @param regFee the regFee to set
     */
    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    /**
     * @return the regDate
     */
    public String getRegDate() {
        return regDate;
    }

    /**
     * @param regDate the regDate to set
     */
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    /**
     * @return the classDetail
     */
    public String getClassDetail() {
        return classDetail;
    }

    /**
     * @param classDetail the classDetail to set
     */
    public void setClassDetail(String classDetail) {
        this.classDetail = classDetail;
    }

}
