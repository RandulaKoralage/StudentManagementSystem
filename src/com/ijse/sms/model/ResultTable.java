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
public class ResultTable {
    private String resultID;
    private String examID;
    private String stID;
    private double practicalMark;
    private double theoryMark;
    private String grade;
    private String status;

    public ResultTable() {
    }

    public ResultTable(String resultID, String examID, String stID, double practicalMark, double theoryMark, String grade, String status) {
        this.resultID = resultID;
        this.examID = examID;
        this.stID = stID;
        this.practicalMark = practicalMark;
        this.theoryMark = theoryMark;
        this.grade = grade;
        this.status = status;
    }

    /**
     * @return the resultID
     */
    public String getResultID() {
        return resultID;
    }

    /**
     * @param resultID the resultID to set
     */
    public void setResultID(String resultID) {
        this.resultID = resultID;
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
     * @return the practicalMark
     */
    public double getPracticalMark() {
        return practicalMark;
    }

    /**
     * @param practicalMark the practicalMark to set
     */
    public void setPracticalMark(double practicalMark) {
        this.practicalMark = practicalMark;
    }

    /**
     * @return the theoryMark
     */
    public double getTheoryMark() {
        return theoryMark;
    }

    /**
     * @param theoryMark the theoryMark to set
     */
    public void setTheoryMark(double theoryMark) {
        this.theoryMark = theoryMark;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
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
