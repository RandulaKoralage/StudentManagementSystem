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
public class Refund {
    private String refID;
    private String regID;
    private double paidAmount;
    private double deduction;
    private double refAmount;
    private String refDate;
    private String note;

    public Refund() {
    }

    public Refund(String refID, String regID, double paidAmount, double deduction, double refAmount, String refDate, String note) {
        this.refID = refID;
        this.regID = regID;
        this.paidAmount = paidAmount;
        this.deduction = deduction;
        this.refAmount = refAmount;
        this.refDate = refDate;
        this.note = note;
    }

    /**
     * @return the refID
     */
    public String getRefID() {
        return refID;
    }

    /**
     * @param refID the refID to set
     */
    public void setRefID(String refID) {
        this.refID = refID;
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
     * @return the paidAmount
     */
    public double getPaidAmount() {
        return paidAmount;
    }

    /**
     * @param paidAmount the paidAmount to set
     */
    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    /**
     * @return the deduction
     */
    public double getDeduction() {
        return deduction;
    }

    /**
     * @param deduction the deduction to set
     */
    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    /**
     * @return the refAmount
     */
    public double getRefAmount() {
        return refAmount;
    }

    /**
     * @param refAmount the refAmount to set
     */
    public void setRefAmount(double refAmount) {
        this.refAmount = refAmount;
    }

    /**
     * @return the refDate
     */
    public String getRefDate() {
        return refDate;
    }

    /**
     * @param refDate the refDate to set
     */
    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }
    
    
}
