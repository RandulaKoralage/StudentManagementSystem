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
public class Certificate {
    private String certificateID;
    private String resultID;
    private String issueDate;
    private String status;

    public Certificate() {
    }

    public Certificate(String certificateID, String resultID, String issueDate, String status) {
        this.certificateID = certificateID;
        this.resultID = resultID;
        this.issueDate = issueDate;
        this.status = status;
    }

    /**
     * @return the certificateID
     */
    public String getCertificateID() {
        return certificateID;
    }

    /**
     * @param certificateID the certificateID to set
     */
    public void setCertificateID(String certificateID) {
        this.certificateID = certificateID;
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
     * @return the issueDate
     */
    public String getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate the issueDate to set
     */
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
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
