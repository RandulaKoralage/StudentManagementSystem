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
public class Attendance {
    private int attendID;
    private String stID;
    private String scheduleID;
    private String currentDate;
    private String status; 

    public Attendance() {
    }

    public Attendance(int attendID, String stID, String scheduleID, String currentDate, String status) {
        this.attendID = attendID;
        this.stID = stID;
        this.scheduleID = scheduleID;
        this.currentDate = currentDate;
        this.status = status;
    }
 public Attendance(String stID, String currentDate, String status) {      
        this.stID = stID;
        this.currentDate = currentDate;
        this.status = status;
    }
    /**
     * @return the attendID
     */
    public int getAttendID() {
        return attendID;
    }

    /**
     * @param attendID the attendID to set
     */
    public void setAttendID(int attendID) {
        this.attendID = attendID;
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
     * @return the sheduleID
     */
    public String getScheduleID() {
        return scheduleID;
    }

    /**
     * @param scheduleID the sheduleID to set
     */
    public void setSheduleID(String sheduleID) {
        this.scheduleID = sheduleID;
    }

    /**
     * @return the currentDate
     */
    public String getCurrentDate() {
        return currentDate;
    }

    /**
     * @param currentDate the currentDate to set
     */
    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
