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
import com.ijse.sms.model.UserAccounts;

/**
 *
 * @author Randula
 */
public class UserAccountController {
        public static boolean addUser( UserAccounts userAccounts)throws ClassNotFoundException,SQLException{
	String sql="INSERT INTO  UserAccounts VALUES (?,?,?,?)";
	Connection conn=DBConnection.getDBConnection().getConnection();
	PreparedStatement stm=conn.prepareStatement(sql);
        
	stm.setObject(1,userAccounts.getId());	
	stm.setObject(2,userAccounts.getUsername());
	stm.setObject(3,userAccounts.getPassword());
	stm.setObject(4,userAccounts.getUserType());

   
        
	int res=stm.executeUpdate();
	return(res>0);
    }

    public static boolean deleteUser(int id)throws ClassNotFoundException,SQLException{
	String sql="DELETE FROM  UserAccounts WHERE Id='"+id+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	int res=stm.executeUpdate(sql);
	return(res>0);
    }

    public static boolean updateUser(UserAccounts userAccounts)throws ClassNotFoundException,SQLException{
	String sql="UPDATE  UserAccounts SET Username=?, Password=?,UserType=? WHERE Id=?";
	Connection conn=DBConnection.getDBConnection().getConnection();
	PreparedStatement stm=conn.prepareStatement(sql);
		
	stm.setObject(1,userAccounts.getUsername());
	stm.setObject(2,userAccounts.getPassword());
	stm.setObject(3,userAccounts.getUserType());
        stm.setObject(4,userAccounts.getId());	
        
	int res=stm.executeUpdate();
	return(res>0);
    }
	
    public static  UserAccounts searchUser(int id)throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM  UserAccounts WHERE Id='"+id+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	 UserAccounts userAccounts=null;
            if(rst.next()){
		userAccounts=new  UserAccounts(rst.getInt("Id"),rst.getString("Username"),rst.getString("Password"),rst.getString("UserType"));
            }
	return userAccounts;
    }
    
    
	public static ArrayList<UserAccounts>viewAllUsers()throws ClassNotFoundException,SQLException{
		String sql="SELECT * FROM UserAccounts";
		Connection conn=DBConnection.getDBConnection().getConnection();
		Statement stm=conn.createStatement();
		
		ResultSet rst=stm.executeQuery(sql);
		ArrayList<UserAccounts>userList=new ArrayList<UserAccounts>();
		while(rst.next()){
			UserAccounts userAccounts=new  UserAccounts(rst.getInt("Id"),rst.getString("Username"),rst.getString("Password"),rst.getString("UserType"));
			userList.add(userAccounts);
		}
		return userList;
	}
	
    public static String[] viewUser()throws ClassNotFoundException,SQLException{
	String sql="SELECT userName FROM UserAccounts";
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
              array[i++]=rst.getString("userName");        
        }        
	return array;
    }
    
     public static String viewPassword(String id)throws ClassNotFoundException,SQLException{
	String sql="SELECT password FROM  UserAccounts WHERE Id='"+id+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
        String pass=null;
        while(rst.next()){       
              pass=rst.getString("password");        
        }        
	return pass;
    }
    
     public static String matchPassword(String userName)throws ClassNotFoundException,SQLException{
	String sql="SELECT password FROM  UserAccounts WHERE UserName='"+userName+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
        String pass=null;
        while(rst.next()){       
              pass=rst.getString("password");        
        }        
	return pass;
    }
     public static String selectType(String userName)throws ClassNotFoundException,SQLException{
	String sql="SELECT UserType FROM  UserAccounts WHERE UserName='"+userName+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
        String type=null;
        while(rst.next()){       
              type=rst.getString("UserType");        
        }        
	return type;
    }
}
