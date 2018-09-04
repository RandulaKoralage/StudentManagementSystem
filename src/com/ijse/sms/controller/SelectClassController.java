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
import com.ijse.sms.model.SelectClass;

/**
 *
 * @author Randula
 */
public class SelectClassController {

    public static boolean addClass(SelectClass selectClass) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO SelectClass VALUES (?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, selectClass.getClassID());
        stm.setObject(2, selectClass.getCourseID());
        stm.setObject(3, selectClass.getClassName());
        stm.setObject(4, selectClass.getClassDay());
        stm.setObject(5, selectClass.getNoOfStudents());
        stm.setObject(6, selectClass.getStartTime());
        stm.setObject(7, selectClass.getEndTime());
        stm.setObject(8, selectClass.getFirstDate());

        int res = stm.executeUpdate();
        return (res > 0);
    }

    public static boolean deleteClass(String classID) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM SelectClass WHERE ClassID='" + classID + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        int res = stm.executeUpdate(sql);
        return (res > 0);
    }

    public static boolean updateClass(SelectClass selectClass) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE SelectClass SET CourseID=?, ClassName=?,ClassDay=?,NoOfStudents=?,StartTime=?,EndTime=?,FirstDate=? WHERE ClassID=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, selectClass.getCourseID());
        stm.setObject(2, selectClass.getClassName());
        stm.setObject(3, selectClass.getClassDay());
        stm.setObject(4, selectClass.getNoOfStudents());
        stm.setObject(5, selectClass.getStartTime());
        stm.setObject(6, selectClass.getEndTime());
        stm.setObject(7, selectClass.getFirstDate());
        stm.setObject(8, selectClass.getClassID());

        int res = stm.executeUpdate();
        return (res > 0);
    }

    public static SelectClass searchClass(String classID) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM SelectClass WHERE ClassID='" + classID + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        SelectClass selectClass = null;
        if (rst.next()) {
            selectClass = new SelectClass(rst.getString("ClassID"), rst.getString("CourseID"), rst.getString("ClassName"), rst.getString("ClassDay"), rst.getInt("NoOfStudents"), rst.getDouble("StartTime"), rst.getDouble("EndTime"), rst.getString("FirstDate"));
        }
        return selectClass;
    }

    public static ArrayList<SelectClass> viewAllClass() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM SelectClass";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<SelectClass> classDetailList = new ArrayList<SelectClass>();
        while (rst.next()) {
            SelectClass selectClass = new SelectClass(rst.getString("ClassID"), rst.getString("CourseID"), rst.getString("ClassName"), rst.getString("ClassDay"), rst.getInt("NoOfStudents"), rst.getDouble("StartTime"), rst.getDouble("EndTime"), rst.getString("FirstDate"));
            classDetailList.add(selectClass);
        }
        return classDetailList;
    }

    public static String[] viewClasses() throws ClassNotFoundException, SQLException {
        String sql = "SELECT ClassName FROM SelectClass";
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
            array[i++] = rst.getString("ClassName");
        }
        return array;
    }

    public static ArrayList<SelectClass> searchClassByYear(String year) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM SelectClass WHERE YEAR(FirstDate) ='" + year + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<SelectClass> classDetailList = new ArrayList<SelectClass>();
        while (rst.next()) {
            SelectClass selectClass = new SelectClass(rst.getString("ClassID"), rst.getString("CourseID"), rst.getString("ClassName"), rst.getString("ClassDay"), rst.getInt("NoOfStudents"), rst.getDouble("StartTime"), rst.getDouble("EndTime"), rst.getString("FirstDate"));
            classDetailList.add(selectClass);
        }
        return classDetailList;
    }

    public static ArrayList<SelectClass> teachersInchargeOfClass(String lectId, String year) throws ClassNotFoundException, SQLException {
        String sql = "select * from SelectClass where year(FirstDate)='" + year + "' and classID IN(select ClassID from Timetable where lectId='" + lectId + "' )";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<SelectClass> list = new ArrayList<SelectClass>();
        while (rst.next()) {
            SelectClass selectClass = new SelectClass(rst.getString("ClassID"), rst.getString("CourseID"), rst.getString("ClassName"), rst.getString("ClassDay"), rst.getInt("NoOfStudents"), rst.getDouble("StartTime"), rst.getDouble("EndTime"), rst.getString("FirstDate"));
            list.add(selectClass);
        }
        return list;
    }

    public static String year(String classId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT year(FirstDate) FROM SelectClass  WHERE ClassID='" + classId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        rst.last();
        String year = rst.getString("year(FirstDate)");
        return year;
    }

    public static String[] classNamesOfAYear(String year) throws ClassNotFoundException, SQLException {
        String sql = "select ClassName from SelectClass where year(FirstDate)='" + year + "'";
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
            array[i++] = rst.getString("ClassName");
        }
        return array;
    }

    public static String[] classIdOfAYear(String year) throws ClassNotFoundException, SQLException {
        String sql = "select ClassID from SelectClass where year(FirstDate)='" + year + "'";
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
            array[i++] = rst.getString("ClassID");
        }
        return array;
    }

    public static String[] classNamesOfAYearToCourse(String year, String courseId) throws ClassNotFoundException, SQLException {
        String sql = "select ClassName from SelectClass where year(FirstDate)='" + year + "' and CourseID='" + courseId + "'";
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
            array[i++] = rst.getString("ClassName");
        }
        return array;
    }

    public static String matchName(String classId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT ClassName FROM  SelectClass WHERE ClassId='" + classId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        String name = null;
        while (rst.next()) {
            name = rst.getString("ClassName");
        }
        return name;
    }

    public static String matchNameWithDay(String classId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT ClassDay FROM  SelectClass WHERE ClassId='" + classId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        String name = null;
        while (rst.next()) {
            name = rst.getString("ClassDay");
        }
        return name;
    }

    public static String matchId(String className, String year) throws ClassNotFoundException, SQLException {
        String sql = "SELECT ClassId FROM  SelectClass WHERE ClassName='" + className + "' AND year(FirstDate)='" + year + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        String name = null;
        while (rst.next()) {
            name = rst.getString("ClassId");
        }
        return name;
    }

    public static int numOfStudents(String className, String year) throws ClassNotFoundException, SQLException {
        String sql = "select  NoOfStudents from SelectClass where className='"+className+"' and year(FirstDate)='"+year+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        int count = 0;
        while (rst.next()) {
            count = rst.getInt("NoOfStudents");
        }
        return count;
    }
    public static String firstDate(String eName, String year) throws ClassNotFoundException, SQLException {
        String sql = "	select FirstDate from selectClass where courseID in (select courseID from examination where examId in(select examId from examination where examName='"+eName+"' and year(ExamDate)='"+year+"'))order by firstdate desc limit 1;";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        String day = null;
        while (rst.next()) {
            day = rst.getString("FirstDate");
        }
        return day;
    }
     public static String[] classNamesOfGivenExam(String eYear, String eName) throws ClassNotFoundException, SQLException {
        String sql = "select className from selectClass where courseID in(select courseID from examination where examName='"+eName+"' and year(ExamDate)='"+eYear+"')";
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
            array[i++] = rst.getString("ClassName");
        }
        return array;
    }
     
    public static ArrayList<SelectClass> allClasses(String year) throws ClassNotFoundException, SQLException {
        String sql = "select className,NoOfStudents from selectClass where  year(FirstDate)='"+year+"';";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<SelectClass> list = new ArrayList<SelectClass>();
        while (rst.next()) {
            SelectClass selectClass = new SelectClass(rst.getString("ClassName"),rst.getInt("NoOfStudents"));
            list.add(selectClass);
        }
        return list;
    }
  public static ArrayList<SelectClass> classesOfACourse(String cId, String year) throws ClassNotFoundException, SQLException {
        String sql = "select * from selectclass where courseID='"+cId+"' and  year(firstdate)='"+year+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<SelectClass> list = new ArrayList<SelectClass>();
        while (rst.next()) {
            SelectClass selectClass = new SelectClass(rst.getString("ClassID"), rst.getString("CourseID"), rst.getString("ClassName"), rst.getString("ClassDay"), rst.getInt("NoOfStudents"), rst.getDouble("StartTime"), rst.getDouble("EndTime"), rst.getString("FirstDate"));
            list.add(selectClass);
        }
        return list;
    }
}
