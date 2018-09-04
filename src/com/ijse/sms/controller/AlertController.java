/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.sms.controller;

import com.ijse.sms.db.DBConnection;
import com.ijse.sms.model.ClassAlert;
import com.ijse.sms.model.PaymentAlert;
import com.ijse.sms.model.Registration;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Randula
 */
public class AlertController {

    public static ArrayList<PaymentAlert> paymentAlerts() throws ClassNotFoundException, SQLException {
        String sql = "select r.stID,r.regId,RegFee,sum(Payment)as tot,CourseFee,CourseName  from Payment p,registration r,course c where r.regId=p.regId and r.CourseID=c.CourseID and datediff(curdate(),r.regDate)>180 and p.PaymentCategory='Course' group by r.regId having(RegFee+tot)<c.CourseFee";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<PaymentAlert> alertList = new ArrayList<PaymentAlert>();
        while (rst.next()) {
            PaymentAlert paymentAlert = new PaymentAlert(rst.getString("StID"), rst.getString("RegID"), rst.getDouble("RegFee"), rst.getString("CourseName"), rst.getDouble("courseFee"), rst.getDouble("tot"));
            alertList.add(paymentAlert);
        }
        return alertList;
    }

    public static ArrayList<ClassAlert> registrations(String acYear) throws ClassNotFoundException, SQLException {
        String sql = "	select count(regId),classDetail from registration where year(regDate)='" + acYear + "' group by classDetail ;";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<ClassAlert> list = new ArrayList<ClassAlert>();
        while (rst.next()) {
            ClassAlert classAlert = new ClassAlert(rst.getString("count(regId)"), rst.getString("ClassDetail"));
            list.add(classAlert);
        }
        return list;
    }

    public static ArrayList<ClassAlert> allClasses(String year) throws ClassNotFoundException, SQLException {
        String sql = "select count(regId),courseID from registration where year(regDate)='" + year + "' group by courseID";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<ClassAlert> list = new ArrayList<ClassAlert>();
        while (rst.next()) {
            ClassAlert classAlert = new ClassAlert(rst.getInt("count(regId)"), rst.getString("courseID"));
            list.add(classAlert);
        }
        return list;
    }
}
