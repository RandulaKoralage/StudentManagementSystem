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
import com.ijse.sms.model.Course;

/**
 *
 * @author Randula
 */
public class CourseController {

    public static boolean addCourse(Course course) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Course VALUES (?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, course.getCourseID());
        stm.setObject(2, course.getCourseName());
        stm.setObject(3, course.getCourseFee());
        stm.setObject(4, course.getCourseDuration());
        stm.setObject(5, course.getDescription());

        int res = stm.executeUpdate();
        return (res > 0);
    }

    public static boolean deleteCourse(String courseID) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM Course WHERE CourseID='" + courseID + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        int res = stm.executeUpdate(sql);
        return (res > 0);
    }

    public static boolean updateCourse(Course course) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE Course SET CourseName=?, CourseFee=?,CourseDuration=?,Description=? WHERE CourseID=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, course.getCourseName());
        stm.setObject(2, course.getCourseFee());
        stm.setObject(3, course.getCourseDuration());
        stm.setObject(4, course.getDescription());
        stm.setObject(5, course.getCourseID());

        int res = stm.executeUpdate();
        return (res > 0);
    }

    public static Course searchCourse(String courseID) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Course WHERE CourseID='" + courseID + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        Course course = null;
        if (rst.next()) {
            course = new Course(rst.getString("CourseID"), rst.getString("CourseName"), rst.getDouble("CourseFee"), rst.getString("CourseDuration"), rst.getString("Description"));
        }
        return course;
    }

    public static ArrayList<Course> viewAllcourse() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Course";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Course> courseList = new ArrayList<Course>();
        while (rst.next()) {
            Course course = new Course(rst.getString("CourseID"), rst.getString("CourseName"), rst.getDouble("CourseFee"), rst.getString("CourseDuration"), rst.getString("Description"));
            courseList.add(course);
        }
        return courseList;
    }

    public static String[] viewCourses() throws ClassNotFoundException, SQLException {
        String sql = "SELECT CourseName FROM Course";
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
            array[i++] = rst.getString("CourseName");
        }
        return array;
    }

    public static String[] viewCourseId() throws ClassNotFoundException, SQLException {
        String sql = "SELECT CourseID FROM Course";
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
            array[i++] = rst.getString("CourseID");
        }
        return array;
    }

    public static String matchId(String courseName) throws ClassNotFoundException, SQLException {
        String sql = "SELECT CourseID FROM  Course WHERE CourseName='" + courseName + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        String cId = null;
        while (rst.next()) {
            cId = rst.getString("CourseID");
        }
        return cId;
    }

    public static int totalCourses() throws ClassNotFoundException, SQLException {
        String sql = "SELECT count(CourseID) FROM  Course";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        int total = 0;
        while (rst.next()) {
            total = rst.getInt("count(CourseID)");
        }
        return total;
    }

    public static String matchName(String courseId) throws ClassNotFoundException, SQLException {
        String sql = "SELECT CourseName FROM  Course WHERE CourseId='" + courseId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        String cName = null;
        while (rst.next()) {
            cName = rst.getString("CourseName");
        }
        return cName;
    }

    public static String[] giveRegCourses(String stId) throws ClassNotFoundException, SQLException {
        String sql = " select courseName from Course where CourseID in (select  CourseID from Registration where stID='" + stId + "')";
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
            array[i++] = rst.getString("courseName");
        }
        return array;
    }
    
    public static double courseFee(String courseName) throws ClassNotFoundException, SQLException {
        String sql = "SELECT CourseFee FROM  Course WHERE CourseName='" + courseName + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        double fee = 0;
        while (rst.next()) {
            fee= rst.getDouble("CourseFee");
        }
        return fee;
    }
     public static String viewCourseName(String regId) throws ClassNotFoundException, SQLException {
        String sql = " select courseName from Course where CourseID in (select  CourseID from Registration where regID='" + regId + "')";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

         ResultSet rst = stm.executeQuery(sql);
        String cName = null;
        while (rst.next()) {
            cName = rst.getString("CourseName");
        }
        return cName;
    }
      public static String matchCourseForExams(String examName) throws ClassNotFoundException, SQLException {
        String sql = "	select courseName from course where courseID in(select courseID from examination where examId in(select examId from examination where examName='"+examName+"'))";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        String cName = null;
        while (rst.next()) {
            cName = rst.getString("CourseName");
        }
        return cName;
    }
}
