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
public class ClassAlert {
    private String tot;
    private String courseDetail;
    private int courseRegs;
    private String courseId;
    
    public ClassAlert() {
    }

    
    public ClassAlert(String tot, String courseDetail) {
        this.tot = tot;
        this.courseDetail = courseDetail;
    }

    public ClassAlert(int courseRegs, String courseId) {
        this.courseRegs = courseRegs;
        this.courseId = courseId;
    }
    /**
     * @return the tot
     */
    public String getTot() {
        return tot;
    }

    /**
     * @param tot the tot to set
     */
    public void setTot(String tot) {
        this.tot = tot;
    }

    /**
     * @return the courseDetail
     */
    public String getCourseDetail() {
        return courseDetail;
    }

    /**
     * @param courseDetail the courseDetail to set
     */
    public void setCourseDetail(String courseDetail) {
        this.courseDetail = courseDetail;
    }

    /**
     * @return the courseRegs
     */
    public int getCourseRegs() {
        return courseRegs;
    }

    /**
     * @param courseRegs the courseRegs to set
     */
    public void setCourseRegs(int courseRegs) {
        this.courseRegs = courseRegs;
    }

    /**
     * @return the courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    
}
