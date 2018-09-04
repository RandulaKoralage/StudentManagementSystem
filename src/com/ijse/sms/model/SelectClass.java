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
public class SelectClass {
    private String classID;
    private String courseID;
    private String className;
    private String classDay;
    private int noOfStudents;
    private double startTime;
    private double endTime;
    private String firstDate; 

    public SelectClass() {
    }

    public SelectClass(String classID, String courseID, String className, String classDay, int noOfStudents, double startTime, double endTime, String firstDate) {
        this.classID = classID;
        this.courseID = courseID;
        this.className = className;
        this.classDay = classDay;
        this.noOfStudents = noOfStudents;
        this.startTime = startTime;
        this.endTime = endTime;
        this.firstDate = firstDate;
    }
 public SelectClass( String className,int noOfStudents) {
       
        this.className = className;       
        this.noOfStudents = noOfStudents;
        
    }
    /**
     * @return the classID
     */
    public String getClassID() {
        return classID;
    }

    /**
     * @param classID the classID to set
     */
    public void setClassID(String classID) {
        this.classID = classID;
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
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return the classDay
     */
    public String getClassDay() {
        return classDay;
    }

    /**
     * @param classDay the classDay to set
     */
    public void setClassDay(String classDay) {
        this.classDay = classDay;
    }

    /**
     * @return the noOfStudents
     */
    public int getNoOfStudents() {
        return noOfStudents;
    }

    /**
     * @param noOfStudents the noOfStudents to set
     */
    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    /**
     * @return the startTime
     */
    public double getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public double getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the firstDate
     */
    public String getFirstDate() {
        return firstDate;
    }

    /**
     * @param firstDate the firstDate to set
     */
    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }
    
}
