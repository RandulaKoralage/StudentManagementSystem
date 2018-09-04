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

public class PaymentAlert {
private String stId;
private String regId;
private double regFee;
private String courseName;
private double courseFee;
private double tot;
    public PaymentAlert() {
    }

    public PaymentAlert(String stId, String regId, double regFee, String courseName, double courseFee, double tot) {
        this.stId = stId;
        this.regId = regId;
        this.regFee = regFee;
        this.courseName = courseName;
        this.courseFee = courseFee;
        this.tot = tot;
    }

  

    /**
     * @return the stId
     */
    public String getStId() {
        return stId;
    }

    /**
     * @param stId the stId to set
     */
    public void setStId(String stId) {
        this.stId = stId;
    }

    /**
     * @return the regId
     */
    public String getRegId() {
        return regId;
    }

    /**
     * @param regId the regId to set
     */
    public void setRegId(String regId) {
        this.regId = regId;
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
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the courseFee
     */
    public double getCourseFee() {
        return courseFee;
    }

    /**
     * @param courseFee the courseFee to set
     */
    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    /**
     * @return the tot
     */
    public double getTot() {
        return tot;
    }

    /**
     * @param tot the tot to set
     */
    public void setTot(double tot) {
        this.tot = tot;
    }


}
