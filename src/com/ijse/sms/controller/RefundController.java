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
import com.ijse.sms.model.Refund;

/**
 *
 * @author Randula
 */
public class RefundController {
     public static boolean addRefund(Refund refund)throws ClassNotFoundException,SQLException{
	String sql="INSERT INTO  Refund VALUES (?,?,?,?,?,?,?)";
	Connection conn=DBConnection.getDBConnection().getConnection();
	PreparedStatement stm=conn.prepareStatement(sql);
		
	stm.setObject(1,refund.getRefID());
	stm.setObject(2,refund.getRegID());
	stm.setObject(3,refund.getPaidAmount());
	stm.setObject(4,refund.getDeduction());
	stm.setObject(5,refund. getRefAmount());
	stm.setObject(6,refund.getRefDate());
        stm.setObject(7,refund.getNote());
                
	int res=stm.executeUpdate();
	return(res>0);
	}

    public static boolean deleteRefund(String refID)throws ClassNotFoundException,SQLException{
	String sql="DELETE FROM Refund WHERE RefID='"+refID+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	int res=stm.executeUpdate(sql);
	return(res>0);
	}

    public static boolean updateRefund(Refund refund)throws ClassNotFoundException,SQLException{
	String sql="UPDATE Refund SET RegID=?, PaidAmount=?,Deduction=?,RefAmount=?,RefDate=?,Note=? WHERE RefID=?";
	Connection conn=DBConnection.getDBConnection().getConnection();
	PreparedStatement stm=conn.prepareStatement(sql);
		
	stm.setObject(1,refund.getRegID());
	stm.setObject(2,refund.getPaidAmount());
	stm.setObject(3,refund.getDeduction());
	stm.setObject(4,refund. getRefAmount());
	stm.setObject(5,refund.getRefDate());
        stm.setObject(6,refund.getNote());
        stm.setObject(7,refund.getRefID());
                
        int res=stm.executeUpdate();
        return(res>0);
    }
	
    public static Refund searchRefund(String refID)throws ClassNotFoundException,SQLException{
        String sql="SELECT * FROM Refund WHERE RefID='"+refID+"'";
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm=conn.createStatement();
		
        ResultSet rst=stm.executeQuery(sql);
        Refund refund=null;
            if(rst.next()){
		refund=new Refund(rst.getString("RefID"),rst.getString("RegID"),rst.getDouble("PaidAmount"),rst.getDouble("Deduction"),rst.getDouble("RefAmount"),rst.getString("RefDate"),rst.getString("Note"));
            }
        return refund;
    }
	
    public static ArrayList<Refund> viewAllRefund()throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM Refund";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<Refund>refundList=new ArrayList<Refund>();
            while(rst.next()){
		Refund refund=new Refund(rst.getString("RefID"),rst.getString("RegID"),rst.getDouble("PaidAmount"),rst.getDouble("Deduction"),rst.getDouble("RefAmount"),rst.getString("RefDate"),rst.getString("Note"));
		refundList.add(refund);
            }
            return refundList;
    }
}
