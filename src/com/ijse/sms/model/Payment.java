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
public class Payment {
    private String payID;
    private String regID;
    private double payment;
    private double discount;
    private String payDate;
    private String paymentCategory;  

    public Payment() {
    }

    public Payment(String payID, String regID, double payment, double discount, String payDate, String paymentCategory) {
        this.payID = payID;
        this.regID = regID;
        this.payment = payment;
        this.discount = discount;
        this.payDate = payDate;
        this.paymentCategory = paymentCategory;
    }
     public Payment(String payID, String regID) {
        this.payID = payID;
        this.regID = regID;
    }

    /**
     * @return the payID
     */
    public String getPayID() {
        return payID;
    }

    /**
     * @param payID the payID to set
     */
    public void setPayID(String payID) {
        this.payID = payID;
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
     * @return the payment
     */
    public double getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(double payment) {
        this.payment = payment;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the payDate
     */
    public String getPayDate() {
        return payDate;
    }

    /**
     * @param payDate the payDate to set
     */
    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    /**
     * @return the paymentCategory
     */
    public String getPaymentCategory() {
        return paymentCategory;
    }

    /**
     * @param paymentCategory the paymentCategory to set
     */
    public void setPaymentCategory(String paymentCategory) {
        this.paymentCategory = paymentCategory;
    }
    
}
