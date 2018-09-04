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
import com.ijse.sms.model.Timetable;


/**
 *
 * @author Randula
 */
public class TimetableController {
    public static boolean addTimetable(Timetable timetable)throws ClassNotFoundException,SQLException{
	String sql="INSERT INTO Timetable VALUES (?,?,?)";
	Connection conn=DBConnection.getDBConnection().getConnection();
	PreparedStatement stm=conn.prepareStatement(sql);
	
        stm.setObject(1,timetable.getScheduleID());
	stm.setObject(2,timetable.getLectID());
	stm.setObject(3,timetable.getClassID());
	

		
	int res=stm.executeUpdate();
	return(res>0);
    }

    public static boolean deleteTimetable(String scheduleID)throws ClassNotFoundException,SQLException{
	String sql="DELETE FROM Timetable WHERE ScheduleID='"+scheduleID+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	int res=stm.executeUpdate(sql);
	return(res>0);
    }

    public static boolean updateTimetable(Timetable timetable)throws ClassNotFoundException,SQLException{
	String sql="UPDATE Timetable SET LectID=?, ClassID=? WHERE ScheduleID=?";
	Connection conn=DBConnection.getDBConnection().getConnection();
	PreparedStatement stm=conn.prepareStatement(sql);

	stm.setObject(1,timetable.getLectID());
	stm.setObject(2,timetable.getClassID());
	stm.setObject(3,timetable.getScheduleID());

                
	int res=stm.executeUpdate();
	return(res>0);
    }
	
    public static Timetable searchTimetable(String scheduleID)throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM Timetable WHERE ScheduleID='"+scheduleID+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	Timetable timetable=null;
            if(rst.next()){
		timetable=new Timetable(rst.getString("ScheduleID"),rst.getString("LectID"),rst.getString("ClassID"));
            }
	return timetable;
    }
	
    public static ArrayList<Timetable> viewSchedual()throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM Timetable";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<Timetable>schedualList=new ArrayList<Timetable>();
	while(rst.next()){
            Timetable timetable=new Timetable(rst.getString("ScheduleID"),rst.getString("LectID"),rst.getString("ClassID"));
            schedualList.add(timetable);
	}
	return schedualList;
    }
     public static ArrayList<Timetable> viewSchedualsByLecturers(String lectId)throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM Timetable WHERE LectID='"+lectId+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<Timetable>schedualList=new ArrayList<Timetable>();
	while(rst.next()){
            Timetable timetable=new Timetable(rst.getString("ScheduleID"),rst.getString("LectID"),rst.getString("ClassID"));
            schedualList.add(timetable);
	}
	return schedualList;
    }
           public static String[] viewScheduleId()throws ClassNotFoundException,SQLException{
	String sql="SELECT ScheduleID FROM Timetable";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	int count=0;
	while(rst.next()){
            count++;
	}
        rst.beforeFirst();
        String array[]=new String[count];
        int i=0;
         while(rst.next()){       
              array[i++]=rst.getString("ScheduleID");        
        }        
	return array;
    }
        public static String giveScheduleId(String classId,String lectId)throws ClassNotFoundException,SQLException{
	String sql="SELECT ScheduleID FROM Timetable  WHERE ClassID='"+classId+"' AND LectID='"+lectId+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
        
           rst.last();
           String id=rst.getString("ScheduleID");
	return id;
    }
        
        public static String giveScheduleIdToClassName(String className)throws ClassNotFoundException,SQLException{
	String sql=" select scheduleID from Timetable where ClassID in (select  ClassID from SelectClass where ClassName='"+className+"')";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
        String id=null;
        if(rst.next()){
	id=rst.getString("ScheduleID");
        }
	return id;
    }
        public static ArrayList<Timetable> timetableView(String courseId,String year)throws ClassNotFoundException,SQLException{
	String sql="select * from timetable where classID in(select classID from selectclass where courseID='"+courseId+"' and year(firstdate)='"+year+"')order by ClassID";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<Timetable>schedualList=new ArrayList<Timetable>();
	while(rst.next()){
            Timetable timetable=new Timetable(rst.getString("ScheduleID"),rst.getString("LectID"),rst.getString("ClassID"));
            schedualList.add(timetable);
	}
	return schedualList;
    }
        public static ArrayList<Timetable> teachersInvolvement(String year)throws ClassNotFoundException,SQLException{
	String sql="select lectId, count(classID) from timetable where classID in (select classID from selectClass where year(firstdate)='"+year+"') group by lectId";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<Timetable>list=new ArrayList<Timetable>();
	while(rst.next()){
            Timetable timetable=new Timetable(rst.getString("count(classID)"),rst.getString("LectID"));
            list.add(timetable);
	}
	return list;
    }
}
