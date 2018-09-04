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
public class Timetable {
    private String lectID;
    private String classID;
    private String scheduleID;

    public Timetable() {
    }

    public Timetable(String scheduleID, String lectID, String classID ) {
        this.lectID = lectID;
        this.classID = classID;
        this.scheduleID = scheduleID;
    }

    public Timetable(String scheduleID, String lectID) {
        this.lectID = lectID;
        this.scheduleID = scheduleID;
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
     * @return the sheduleID
     */
    public String getScheduleID() {
        return scheduleID;
    }

    /**
     * @param sheduleID the sheduleID to set
     */
    public void setScheduleID(String sheduleID) {
        this.scheduleID = scheduleID;
    }
}
