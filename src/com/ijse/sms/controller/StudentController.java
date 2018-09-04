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
import com.ijse.sms.model.Student;

/**
 *
 * @author Randula
 */
public class StudentController {

    public static boolean addStudent(Student student) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Student VALUES (?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, student.getStID());
        stm.setObject(2, student.getStName());
        stm.setObject(3, student.getStAddress());
        stm.setObject(4, student.getStTelephone());
        stm.setObject(5, student.getdOB());
        stm.setObject(6, student.getGender());
        stm.setObject(7, student.getGuardName());
        stm.setObject(8, student.getGuardOccupation());
        stm.setObject(9, student.getGuardRelationship());
        stm.setObject(10, student.getGuardTelephone());

        int res = stm.executeUpdate();
        return (res > 0);
    }

    public static boolean deleteStudent(String stID) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM Student WHERE StID='" + stID + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        int res = stm.executeUpdate(sql);
        return (res > 0);
    }

    public static boolean updateStudent(Student student) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE Student SET StName=?, StAddress=?,StTelephone=?,DOB=?,Gender=?,GuardName=?,GuardOccupation=?,GuardRelationship=?,GuardTelephone=? WHERE StID=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, student.getStName());
        stm.setObject(2, student.getStAddress());
        stm.setObject(3, student.getStTelephone());
        stm.setObject(4, student.getdOB());
        stm.setObject(5, student.getGender());
        stm.setObject(6, student.getGuardName());
        stm.setObject(7, student.getGuardOccupation());
        stm.setObject(8, student.getGuardRelationship());
        stm.setObject(9, student.getGuardTelephone());
        stm.setObject(10, student.getStID());

        int res = stm.executeUpdate();
        return (res > 0);
    }

    public static Student searchStudent(String stID) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Student WHERE StID='" + stID + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        Student student = null;
        if (rst.next()) {
            student = new Student(rst.getString("StID"), rst.getString("StName"), rst.getString("StAddress"), rst.getString("StTelephone"), rst.getString("DOB"), rst.getString("Gender"), rst.getString("GuardName"), rst.getString("GuardOccupation"), rst.getString("GuardRelationship"), rst.getString("GuardTelephone"));
        }
        return student;
    }

    public static ArrayList<Student> viewAllStudent() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Student";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Student> studentList = new ArrayList<Student>();
        while (rst.next()) {
            Student student = new Student(rst.getString("StID"), rst.getString("StName"), rst.getString("StAddress"), rst.getString("StTelephone"), rst.getString("DOB"), rst.getString("Gender"), rst.getString("GuardName"), rst.getString("GuardOccupation"), rst.getString("GuardRelationship"), rst.getString("GuardTelephone"));
            studentList.add(student);
        }
        return studentList;
    }

    public static String getStId() throws ClassNotFoundException, SQLException {
        String sql = "SELECT StID FROM Student ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        Student student = null;
        rst.last();
        String id = rst.getString("stID");
        return id;
    }

    public static String[] studentNames(String year, String className) throws ClassNotFoundException, SQLException {
        String sql = "select StName from student where stID IN(select stID from Registration where courseID  IN(select courseID from SelectClass where ClassName='" + className + "' and year(FirstDate)='" + year + "') and ClassDetail='" + className + "')";
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
            array[i++] = rst.getString("stName");
        }
        return array;
    }

    public static String getStIdFromName(String name) throws ClassNotFoundException, SQLException {
        String sql = "SELECT StID FROM Student WHERE StName='" + name + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        Student student = null;
        rst.last();
        String id = rst.getString("stID");
        return id;
    }

    public static String getStNameFromId(String id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT StName FROM Student WHERE StID='" + id + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        Student student = null;
        rst.last();
        String name = rst.getString("StName");
        return name;
    }

    public static String[] studentForExams(String examId) throws ClassNotFoundException, SQLException {
        String sql = "select StID,StName from student where StID in (select StID from ResultTable where examId='" + examId + "')";
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
            array[i++] = rst.getString("stName");
        }
        return array;
    }

    public static String getAddress(String id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT StAddress FROM Student WHERE StID='" + id + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        Student student = null;
        rst.last();
        String name = rst.getString("StAddress");
        return name;
    }

    public static ArrayList<Student> viewAllStudent(String StName) throws ClassNotFoundException, SQLException {
        String sql = "select * from student where  stName like '%"+StName+"%'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Student> studentList = new ArrayList<>();
        while (rst.next()) {
            Student student = new Student(rst.getString("StID"), rst.getString("StName"), rst.getString("StAddress"), rst.getString("StTelephone"), rst.getString("DOB"), rst.getString("Gender"), rst.getString("GuardName"), rst.getString("GuardOccupation"), rst.getString("GuardRelationship"), rst.getString("GuardTelephone"));
            studentList.add(student);
        }
        return studentList;
    }
}
