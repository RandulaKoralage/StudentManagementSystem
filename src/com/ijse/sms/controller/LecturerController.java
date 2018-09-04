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
import com.ijse.sms.model.Lecturer;


/**
 *
 * @author Randula
 */
public class LecturerController {
     public static boolean addLecturer(Lecturer lecturer)throws ClassNotFoundException,SQLException{
	String sql="INSERT INTO Lecturer VALUES (?,?,?,?,?)";
	Connection conn=DBConnection.getDBConnection().getConnection();
	PreparedStatement stm=conn.prepareStatement(sql);
        
	stm.setObject(1,lecturer.getLectID());	
	stm.setObject(2,lecturer.getLectName());
	stm.setObject(3,lecturer.getLectAddress());
	stm.setObject(4,lecturer.getLectTelephone());
	stm.setObject(5,lecturer. getLectDOB());
   
        
	int res=stm.executeUpdate();
	return(res>0);
    }

    public static boolean deleteLecturer(String lectID)throws ClassNotFoundException,SQLException{
	String sql="DELETE FROM Lecturer WHERE LectID='"+lectID+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	int res=stm.executeUpdate(sql);
	return(res>0);
    }

    public static boolean updateLecturer(Lecturer lecturer)throws ClassNotFoundException,SQLException{
	String sql="UPDATE Lecturer SET LectName=?, LectAddress=?,LectTelephone=?,LectDOB=? WHERE LectID=?";
	Connection conn=DBConnection.getDBConnection().getConnection();
	PreparedStatement stm=conn.prepareStatement(sql);
		
	stm.setObject(1,lecturer.getLectName());
	stm.setObject(2,lecturer.getLectAddress());
	stm.setObject(3,lecturer.getLectTelephone());
	stm.setObject(4,lecturer. getLectDOB());
        stm.setObject(5,lecturer.getLectID());
        
	int res=stm.executeUpdate();
	return(res>0);
    }
	
    public static Lecturer searchLecturer(String lectID)throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM Lecturer WHERE LectID='"+lectID+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	Lecturer lecturer=null;
            if(rst.next()){
		lecturer=new Lecturer(rst.getString("LectID"),rst.getString("LectName"),rst.getString("LectAddress"),rst.getString("LectTelephone"),rst.getString("LectDOB"));
            }
	return lecturer;
    }
	
    public static ArrayList<Lecturer> viewAllLecturer()throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM Lecturer";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<Lecturer>lecturerList=new ArrayList<Lecturer>();
	while(rst.next()){
            Lecturer lecturer=new Lecturer(rst.getString("LectID"),rst.getString("LectName"),rst.getString("LectAddress"),rst.getString("LectTelephone"),rst.getString("LectDOB"));
            lecturerList.add(lecturer);
	}
	return lecturerList;
    }
    public static int totalLecturers()throws ClassNotFoundException,SQLException{
	String sql="SELECT count(LectID) FROM  Lecturer";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
        int total=0;
        while(rst.next()){       
              total=rst.getInt("count(LectID)");        
        }        
	return total;
    }
    
     public static String[] viewLectId()throws ClassNotFoundException,SQLException{
	String sql="SELECT LectID FROM Lecturer";
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
              array[i++]=rst.getString("LectID");        
        }        
	return array;
    }
      public static String matchName(String lecId)throws ClassNotFoundException,SQLException{
	String sql="SELECT LectName FROM  Lecturer WHERE LectID='"+lecId+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
        String name=null;
        while(rst.next()){       
              name=rst.getString("LectName");        
        }        
	return name;
    }
}
