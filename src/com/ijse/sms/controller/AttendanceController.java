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
import com.ijse.sms.model.Attendance;

/**
 *
 * @author Randula
 */
public class AttendanceController {
    public static boolean addAttendance(ArrayList<Attendance>register)throws ClassNotFoundException,SQLException{
	String sql="INSERT INTO Attendance VALUES (?,?,?,?,?)";
	Connection conn=DBConnection.getDBConnection().getConnection();
	PreparedStatement stm=conn.prepareStatement(sql);
	int res=0;
        for(Attendance attendance:register){	
            stm.setObject(1,attendance.getAttendID());
            stm.setObject(2,attendance.getStID());
            stm.setObject(3,attendance.getScheduleID());
            stm.setObject(4,attendance.getCurrentDate());
            stm.setObject(5,attendance.getStatus());
            res=stm.executeUpdate();
        }	
	return(res>0);
    }

    public static boolean deleteAttendance(String attendID)throws ClassNotFoundException,SQLException{
	String sql="DELETE FROM Attendance WHERE AttendID='"+attendID+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	int res=stm.executeUpdate(sql);
	return(res>0);
    }

    public static boolean updateAttendance(Attendance attendance)throws ClassNotFoundException,SQLException{
	String sql="UPDATE Attendance SET StID=?, ScheduleID=?,CurrentDate=?,Status=? WHERE AttendID=?";
	Connection conn=DBConnection.getDBConnection().getConnection();
	PreparedStatement stm=conn.prepareStatement(sql);


	stm.setObject(2,attendance.getStID());
	stm.setObject(3,attendance.getScheduleID());
	stm.setObject(4,attendance.getCurrentDate());
	stm.setObject(5,attendance.getStatus());
        stm.setObject(1,attendance.getAttendID());
                
	int res=stm.executeUpdate();
	return(res>0);
    }
	
    public static Attendance searchAttendance(String attendID)throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM Attendance WHERE AttendID='"+attendID+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	Attendance attendance=null;
            if(rst.next()){
		attendance=new Attendance(rst.getInt("AttendID"),rst.getString("StID"),rst.getString("ScheduleID"),rst.getString("CurrentDate"),rst.getString("Status"));
            }
	return attendance;
    }
	
    public static ArrayList<Attendance> viewAllAttendance()throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM Attendance";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<Attendance>attendanceList=new ArrayList<Attendance>();
	while(rst.next()){
            Attendance attendance=new Attendance(rst.getInt("AttendID"),rst.getString("StID"),rst.getString("ScheduleID"),rst.getString("CurrentDate"),rst.getString("Status"));
            attendanceList.add(attendance);
	}
	return attendanceList;
    }    
      public static String[] viewAttendanceDates(String className) throws ClassNotFoundException, SQLException {
        String sql = "select distinct CurrentDate from Attendance where (ScheduleID) in(select ScheduleID from Timetable where ClassID in (select ClassID from SelectClass where ClassName='"+className+"'))";
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
            array[i++] = rst.getString("CurrentDate");
        }
        return array;
    }
     public static ArrayList<Attendance> viewSelectedAttendance(String year,String givenDate,String className)throws ClassNotFoundException,SQLException{
	String sql="select * from Attendance where scheduleID in(select scheduleID from Timetable where classID in(select classID from SelectClass where year(firstDate)='"+year+"' and ClassName='"+className+"'))and currentDate='"+givenDate+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<Attendance>attendanceList=new ArrayList<Attendance>();
	while(rst.next()){
            Attendance attendance=new Attendance(rst.getInt("AttendID"),rst.getString("StID"),rst.getString("ScheduleID"),rst.getString("CurrentDate"),rst.getString("Status"));
            attendanceList.add(attendance);
	}
	return attendanceList;
    }    
     
      public static ArrayList<Attendance> viewStudentAttendanceAllClass(String firstDate,String secondDate,String id)throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM Attendance  WHERE currentDate BETWEEN '"+firstDate+"' AND '"+secondDate+"' and stId='"+id+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<Attendance>attendanceList=new ArrayList<Attendance>();
	while(rst.next()){
            Attendance attendance=new Attendance(rst.getInt("AttendID"),rst.getString("StID"),rst.getString("ScheduleID"),rst.getString("CurrentDate"),rst.getString("Status"));
            attendanceList.add(attendance);
	}
	return attendanceList;
    }    
      public static ArrayList<Attendance> viewStudentAttendanceGivenClass(String firstDate,String secondDate,String stId,String classId)throws ClassNotFoundException,SQLException{
	String sql=" SELECT * FROM Attendance  WHERE currentDate BETWEEN '"+firstDate+"' AND '"+secondDate+"' AND stId='"+stId+"' AND scheduleID IN (SELECT scheduleID from TimeTable WHERE classID='"+classId+"')";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<Attendance>attendanceList=new ArrayList<Attendance>();
	while(rst.next()){
            Attendance attendance=new Attendance(rst.getInt("AttendID"),rst.getString("StID"),rst.getString("ScheduleID"),rst.getString("CurrentDate"),rst.getString("Status"));
            attendanceList.add(attendance);
	}
	return attendanceList;
      }
         public static ArrayList<Attendance> viewAllStudentAttendanceGivenClass(String firstDate,String secondDate,String classId)throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM Attendance  WHERE currentDate BETWEEN '"+firstDate+"' AND '"+secondDate+"' AND scheduleID IN (SELECT scheduleID from TimeTable WHERE classID='"+classId+"')";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<Attendance>attendanceList=new ArrayList<Attendance>();
	while(rst.next()){
            Attendance attendance=new Attendance(rst.getInt("AttendID"),rst.getString("StID"),rst.getString("ScheduleID"),rst.getString("CurrentDate"),rst.getString("Status"));
            attendanceList.add(attendance);
	}
	return attendanceList;
    }    
         public static String totalDays(String classId)throws ClassNotFoundException,SQLException{
	String sql="select distinct count(distinct CurrentDate) from Attendance where (ScheduleID) in(select ScheduleID from Timetable where ClassId ='"+classId+"')";
	Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
        String cId=null;
        while(rst.next()){       
              cId=rst.getString("count(distinct CurrentDate)");        
        }        
	return cId;
    }
           public static String presentDays(String classId,String stId)throws ClassNotFoundException,SQLException{
	String sql="select count(stId) from attendance where status='PR' and stID='"+stId+"' and scheduleID in(SELECT scheduleID from TimeTable WHERE classID='"+classId+"')";
	Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
        String cId=null;
        while(rst.next()){       
              cId=rst.getString("count(stId)");        
        }        
	return cId;
    }
        public static ArrayList<Attendance> attendanceVariation(String stId,String classId)throws ClassNotFoundException,SQLException{
	String sql="select stID,count(AttendID), monthname(currentDate) from attendance where status='PR' and stId='"+stId+"' and scheduleID in(select scheduleID from timetable where classID='"+classId+"') group by monthname(currentDate)";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<Attendance>attendanceList=new ArrayList<Attendance>();
	while(rst.next()){
            Attendance attendance=new Attendance(rst.getString("StID"),rst.getString("count(AttendID)"),rst.getString("monthname(currentDate)"));
            attendanceList.add(attendance);
	}
	return attendanceList;
    }    
}
