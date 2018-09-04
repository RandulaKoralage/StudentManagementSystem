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
import com.ijse.sms.model.Examination;

/**
 *
 * @author Randula
 */
public class ExaminationController {

    public static boolean addExamination(Examination examination) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Examination VALUES (?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, examination.getExamID());
        stm.setObject(2, examination.getCourseID());
        stm.setObject(3, examination.getExamName());
        stm.setObject(4, examination.getExamFee());
        stm.setObject(5, examination.getExamTime());
        stm.setObject(6, examination.getExamDate());
        stm.setObject(7, examination.getPlace());
         stm.setObject(8, examination.getExamType());
        int res = stm.executeUpdate();
        return (res > 0);
    }

    public static boolean deleteExamination(String examID) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM Examination WHERE ExamID='" + examID + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        int res = stm.executeUpdate(sql);
        return (res > 0);
    }

    public static boolean updateExamination(Examination examination) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE Examination SET CourseID=?, ExamName=?,ExamFee=?,ExamTime=?,ExamDate=?,Place=? ExamType=? WHERE ExamID=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, examination.getCourseID());
        stm.setObject(2, examination.getExamName());
        stm.setObject(3, examination.getExamFee());
        stm.setObject(4, examination.getExamTime());
        stm.setObject(5, examination.getExamDate());
        stm.setObject(6, examination.getPlace());
        stm.setObject(7, examination.getExamType());
        stm.setObject(8, examination.getExamID());

        int res = stm.executeUpdate();
        return (res > 0);
    }

    public static Examination searchExamination(String examID) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Examination WHERE ExamID='" + examID + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        Examination examination = null;
        if (rst.next()) {
            examination = new Examination(rst.getString("ExamID"), rst.getString("CourseID"), rst.getString("ExamName"), rst.getDouble("ExamFee"), rst.getDouble("ExamTime"), rst.getString("ExamDate"), rst.getString("Place"),rst.getString("ExamType"));
        }
        return examination;
    }

    public static ArrayList<Examination> viewAllExamination() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Examination";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Examination> examinationList = new ArrayList<Examination>();
        while (rst.next()) {
            Examination examination = new Examination(rst.getString("ExamID"), rst.getString("CourseID"), rst.getString("examName"), rst.getDouble("ExamFee"), rst.getDouble("ExamTime"), rst.getString("ExamDate"), rst.getString("Place"),rst.getString("ExamType"));
            examinationList.add(examination);
        }
        return examinationList;
    }

    public static String[] examIdOfAYear(String year) throws ClassNotFoundException, SQLException {
        String sql = "select ExamID from Examination where year(ExamDate)='" + year + "'";
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
            array[i++] = rst.getString("ExamID");
        }
        return array;
    }

    public static String[] examNameOfAYear(String year) throws ClassNotFoundException, SQLException {
        String sql = "select ExamName from Examination where year(ExamDate)='" + year + "'";
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
            array[i++] = rst.getString("ExamName");
        }
        return array;
    }

    public static ArrayList<Examination> viewAllExamination(String year) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Examination where year(ExamDate)='" + year + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Examination> examinationList = new ArrayList<Examination>();
        while (rst.next()) {
            Examination examination = new Examination(rst.getString("ExamID"), rst.getString("CourseID"), rst.getString("examName"), rst.getDouble("ExamFee"), rst.getDouble("ExamTime"), rst.getString("ExamDate"), rst.getString("Place"),rst.getString("ExamType"));
            examinationList.add(examination);
        }
        return examinationList;
    }

    public static String[] examNameOfAStudent(String regId) throws ClassNotFoundException, SQLException {
        String sql = "select examName from examination where courseID in(select courseID from registration where regId='" + regId + "')";
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
            array[i++] = rst.getString("ExamName");
        }
        return array;
    }

    public static String matchId(String examName) throws ClassNotFoundException, SQLException {
        String sql = "SELECT examId FROM  examination WHERE examName='" + examName + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        String id = null;
        while (rst.next()) {
            id = rst.getString("examId");
        }
        return id;
    }

    public static String matchName(String examId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT examName FROM  examination WHERE examId='" + examId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        String name = null;
        while (rst.next()) {
            name = rst.getString("examName");
        }
        return name;
    }
      public static String courseName(String examName) throws ClassNotFoundException, SQLException {
        String sql = "SELECT courseName FROM  examination WHERE examName='" + examName + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        String name = null;
        while (rst.next()) {
            name = rst.getString("courseName");
        }
        return name;
    }
      public static String getDate(String eName,String eYear) throws ClassNotFoundException, SQLException {
        String sql = "SELECT ExamDate FROM  examination WHERE examName='" + eName + "' and  year(ExamDate)='" + eYear + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        String name = null;
        while (rst.next()) {
            name = rst.getString("ExamDate");
        }
        return name;
    }
      
         public static String[] finalExamNameOfAYear(String year) throws ClassNotFoundException, SQLException {
        String sql = "select ExamName from Examination where year(ExamDate)='" + year + "' and ExamType='Final'";
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
            array[i++] = rst.getString("ExamName");
        }
        return array;
    }
          public static String[] repeateExamNameOfAYear(String year) throws ClassNotFoundException, SQLException {
        String sql = "select ExamName from Examination where year(ExamDate)='" + year + "' and ExamType='Repeate'";
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
            array[i++] = rst.getString("ExamName");
        }
        return array;
    }
        public static int numOfPass(String eName,String eYear) throws ClassNotFoundException, SQLException {
        String sql = "select count(stId) from resultTable where status='pass' and examId in (select examId from examination where examName='"+eName+"' and year(ExamDate)='"+eYear+"')";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        int count = 0;
        while (rst.next()) {
            count = rst.getInt("count(stId)");
        }
        return count;
    }
         public static int numOfCandidates(String eName,String eYear) throws ClassNotFoundException, SQLException {
        String sql = "select count(stID) from resultTable where  examId in (select examId from examination where examName='"+eName+"' and year(ExamDate)='"+eYear+"')";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        int count = 0;
        while (rst.next()) {
            count = rst.getInt("count(stId)");
        }
        return count;
    }
}
