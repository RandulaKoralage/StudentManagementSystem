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
public class Examination {
    private String examID;
    private String courseID;
    private String examName;
    private double examFee;
    private double examTime;
    private String examDate;
    private String place;
    private String examType;
    
    public Examination() {
    }

    public Examination(String examID, String courseID, String examName, double examFee, double examTime, String examDate, String place,String examType) {
        this.examID = examID;
        this.courseID = courseID;
        this.examName = examName;
        this.examFee = examFee;
        this.examTime = examTime;
        this.examDate = examDate;
        this.place = place;
        this.examType = examType;
    }

    /**
     * @return the examID
     */
    public String getExamID() {
        return examID;
    }

    /**
     * @param examID the examID to set
     */
    public void setExamID(String examID) {
        this.examID = examID;
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
     * @return the examName
     */
    public String getExamName() {
        return examName;
    }

    /**
     * @param examName the examName to set
     */
    public void setExamName(String examName) {
        this.examName = examName;
    }

    /**
     * @return the examFee
     */
    public double getExamFee() {
        return examFee;
    }

    /**
     * @param examFee the examFee to set
     */
    public void setExamFee(double examFee) {
        this.examFee = examFee;
    }

    /**
     * @return the examTime
     */
    public double getExamTime() {
        return examTime;
    }

    /**
     * @param examTime the examTime to set
     */
    public void setExamTime(double examTime) {
        this.examTime = examTime;
    }

    /**
     * @return the examDate
     */
    public String getExamDate() {
        return examDate;
    }

    /**
     * @param examDate the examDate to set
     */
    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    /**
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return the examType
     */
    public String getExamType() {
        return examType;
    }

    /**
     * @param examType the examType to set
     */
    public void setExamType(String examType) {
        this.examType = examType;
    }
    
    
}
