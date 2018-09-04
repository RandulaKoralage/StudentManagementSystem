/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.sms.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.ijse.sms.db.DBConnection;
import com.ijse.sms.model.Registration;

/**
 *
 * @author Randula
 */
public class RegistrationController {

    public static boolean addRegistrationDetail(Registration registration) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Registration VALUES (?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, registration.getRegID());
        stm.setObject(2, registration.getStID());
        stm.setObject(3, registration.getCourseID());
        stm.setObject(4, registration.getRegFee());
        stm.setObject(5, registration.getRegDate());
        stm.setObject(6, registration.getClassDetail());

        int res = stm.executeUpdate();
        return (res > 0);
    }

    public static boolean deleteRegistrationDetail(String regID) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM Registration WHERE RegID='" + regID + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        int res = stm.executeUpdate(sql);
        return (res > 0);
    }

    public static boolean updateRegistrationDetail(Registration registration) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE Registration SET StID=?, CourseID=?,RegFee=?,RegDate=?,ClassDetail=? WHERE RegID=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, registration.getStID());
        stm.setObject(2, registration.getCourseID());
        stm.setObject(3, registration.getRegFee());
        stm.setObject(4, registration.getRegDate());
        stm.setObject(5, registration.getClassDetail());
        stm.setObject(6, registration.getRegID());

        int res = stm.executeUpdate();
        return (res > 0);
    }

    public static Registration searchRegistrationDetail(String regID) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Registration WHERE RegID='" + regID + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        Registration registration = null;
        if (rst.next()) {
            registration = new Registration(rst.getString("RegID"), rst.getString("StID"), rst.getString("CourseID"), rst.getDouble("RegFee"), rst.getString("RegDate"), rst.getString("ClassDetail"));
        }
        return registration;
    }

    public static ArrayList<Registration> viewAllRegistrationDetail() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Registration";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Registration> registrationDetailList = new ArrayList<Registration>();
        while (rst.next()) {
            Registration registration = new Registration(rst.getString("RegID"), rst.getString("StID"), rst.getString("CourseID"), rst.getDouble("RegFee"), rst.getString("RegDate"), rst.getString("ClassDetail"));
            registrationDetailList.add(registration);
        }
        return registrationDetailList;
    }

    public static ArrayList<Registration> viewAllRegistrationDetail(String stId) throws ClassNotFoundException, SQLException {
        String sql = "select regId,courseID,classDetail,regDate from registration where stID='" + stId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Registration> registrationDetailList = new ArrayList<Registration>();
        while (rst.next()) {
            Registration registration = new Registration(rst.getString("RegID"), rst.getString("CourseID"), rst.getString("ClassDetail"), rst.getString("RegDate"));
            registrationDetailList.add(registration);
        }
        return registrationDetailList;
    }

    public static int numOfRegistrations(String classDetail) throws ClassNotFoundException, SQLException {
        String sql = "select count(regId) from registration where classDetail='" + classDetail + "';";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        int count = 0;
        while (rst.next()) {
            count = rst.getInt("count(regId)");
        }
        return count;
    }

    public static ArrayList<Registration> viewAllCandidates(String eYear, String acYear, String eName) throws ClassNotFoundException, SQLException {
        String sql = "select * from registration where courseID in (select courseID from examination where examName='" + eName + "' and  year(ExamDate)='" + eYear + "' ) and year(regDate)='" + acYear + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Registration> candidates = new ArrayList<Registration>();
        while (rst.next()) {
            Registration registration = new Registration(rst.getString("RegID"), rst.getString("StID"), rst.getString("CourseID"), rst.getDouble("RegFee"), rst.getString("RegDate"), rst.getString("ClassDetail"));
            candidates.add(registration);
        }
        return candidates;
    }

    public static ArrayList<Registration> viewRepeateCandidates(String eYear, String acYear, String eName) throws ClassNotFoundException, SQLException {
        String sql = "select * from registration where stID in (select stID from resultTable where status='Repeate' and examId in(select examId from examination where examName='" + eName + "' and  year(ExamDate)='" + eYear + "'))and year(regDate)='" + acYear + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Registration> candidates = new ArrayList<Registration>();
        while (rst.next()) {
            Registration registration = new Registration(rst.getString("RegID"), rst.getString("StID"), rst.getString("CourseID"), rst.getDouble("RegFee"), rst.getString("RegDate"), rst.getString("ClassDetail"));
            candidates.add(registration);
        }
        return candidates;
    }

    public static ArrayList<Registration> countRegistrations() throws ClassNotFoundException, SQLException {
        String sql = "select count(regId),year(regDate) from Registration group by year(regDate)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Registration> list = new ArrayList<Registration>();
        while (rst.next()) {
            Registration registration = new Registration(rst.getString("count(regId)"), rst.getString("year(regDate)"));
            list.add(registration);
        }
        return list;
    }

    public static String[] viewClassNames(String stId) throws ClassNotFoundException, SQLException {
        String sql = "select classDetail from registration where stID='" + stId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        rst.beforeFirst();
        String array[] = new String[count];
        int i = 0;
        while (rst.next()) {
            array[i++] = rst.getString("classDetail");
        }
        return array;
    }
     public static ArrayList<Registration> totalRegFee() throws ClassNotFoundException, SQLException {
        String sql = "select sum(RegFee),year(regDate) from registration group by year(regDate)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Registration> list = new ArrayList<Registration>();
        while (rst.next()) {
            Registration registration = new Registration(rst.getString("sum(RegFee)"), rst.getString("year(regDate)"));
            list.add(registration);
        }
        return list;
    }
        public static ArrayList<Registration> studensOfCourses(String year) throws ClassNotFoundException, SQLException {
        String sql = " select count(regId), courseID from registration where year(RegDate)='"+year+"' group by courseID";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Registration> list = new ArrayList<Registration>();
        while (rst.next()) {
            Registration registration = new Registration(rst.getString("count(regId)"), rst.getString("courseID"));
            list.add(registration);
        }
        return list;
    }
     
}
