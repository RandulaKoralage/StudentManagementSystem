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
import com.ijse.sms.model.Payment;

/**
 *
 * @author Randula
 */
public class PaymentController {
    public static boolean addPayment(Payment payment)throws ClassNotFoundException,SQLException{
		String sql="INSERT INTO  Payment VALUES (?,?,?,?,?,?)";
		Connection conn=DBConnection.getDBConnection().getConnection();
		PreparedStatement stm=conn.prepareStatement(sql);
		
		stm.setObject(1,payment.getPayID());
		stm.setObject(2,payment.getRegID());
		stm.setObject(3,payment.getPayment());
		stm.setObject(4,payment.getDiscount());
		stm.setObject(5,payment.getPayDate());
		stm.setObject(6,payment.getPaymentCategory());
                
		int res=stm.executeUpdate();
		return(res>0);
	}

	public static boolean deletePayment(String payID)throws ClassNotFoundException,SQLException{
		String sql="DELETE FROM Payment WHERE PayID='"+payID+"'";
		Connection conn=DBConnection.getDBConnection().getConnection();
		Statement stm=conn.createStatement();
		
		int res=stm.executeUpdate(sql);
		return(res>0);
	}

	public static boolean updatePayment(Payment payment)throws ClassNotFoundException,SQLException{
		String sql="UPDATE Payment SET RegID=?, Payment=?,Discount=?,PayDate=?,PaymentCategory=? WHERE PayID=?";
		Connection conn=DBConnection.getDBConnection().getConnection();
		PreparedStatement stm=conn.prepareStatement(sql);
		
		stm.setObject(1,payment.getRegID());
		stm.setObject(2,payment.getPayment());
		stm.setObject(3,payment.getDiscount());
		stm.setObject(4,payment.getPayDate());
		stm.setObject(5,payment.getPaymentCategory());
                stm.setObject(6,payment.getPayID());
		
		int res=stm.executeUpdate();
		return(res>0);
	}
	
	public static Payment searchPayment(String payId)throws ClassNotFoundException,SQLException{
		String sql="SELECT * FROM Payment WHERE PayId='"+payId+"'";
		Connection conn=DBConnection.getDBConnection().getConnection();
		Statement stm=conn.createStatement();
		
		ResultSet rst=stm.executeQuery(sql);
		Payment payment=null;
		if(rst.next()){
			payment=new Payment(rst.getString("PayID"),rst.getString("RegID"),rst.getDouble("Payment"),rst.getDouble("Discount"),rst.getString("PayDate"),rst.getString("PaymentCategory"));
		}
		return payment;
	}
	
	public static ArrayList<Payment>viewAllPayment()throws ClassNotFoundException,SQLException{
		String sql="SELECT * FROM Payment";
		Connection conn=DBConnection.getDBConnection().getConnection();
		Statement stm=conn.createStatement();
		
		ResultSet rst=stm.executeQuery(sql);
		ArrayList<Payment>paymentList=new ArrayList<Payment>();
		while(rst.next()){
			Payment payment=new Payment(rst.getString("PayID"),rst.getString("RegID"),rst.getDouble("Payment"),rst.getDouble("Discount"),rst.getString("PayDate"),rst.getString("PaymentCategory"));
			paymentList.add(payment);
		}
		return paymentList;
	}
       
        public static ArrayList<Payment>setPaidAmount(String regId)throws ClassNotFoundException,SQLException{
		String sql="SELECT * FROM Payment WHERE RegId='"+regId+"'AND PaymentCategory='course'";
		Connection conn=DBConnection.getDBConnection().getConnection();
		Statement stm=conn.createStatement();
		
		ResultSet rst=stm.executeQuery(sql);
		ArrayList<Payment>list=new ArrayList<Payment>();
		while(rst.next()){
			Payment payment=new Payment(rst.getString("PayID"),rst.getString("RegID"),rst.getDouble("Payment"),rst.getDouble("Discount"),rst.getString("PayDate"),rst.getString("PaymentCategory"));
			list.add(payment);
		}
		return list;
	}
      /*  public static ArrayList<Payment>totalPayments(String year)throws ClassNotFoundException,SQLException{
		String sql="select sum(Payment),year(PayDate) from payment where year(payDate)='"+year+"' group by year(PayDate)";
		Connection conn=DBConnection.getDBConnection().getConnection();
		Statement stm=conn.createStatement();
		
		ResultSet rst=stm.executeQuery(sql);
		ArrayList<Payment>paymentList=new ArrayList<Payment>();
		while(rst.next()){
			Payment payment=new Payment(rst.getString("PayID"),rst.getString("RegID"));
			paymentList.add(payment);
		}
		return paymentList;
}*/
                
  public static int totalPayments(String year) throws ClassNotFoundException, SQLException {
        String sql="select sum(Payment),year(PayDate) from payment where year(payDate)='"+year+"' group by year(PayDate)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        int count = 0;
        while (rst.next()) {
            count = rst.getInt("sum(Payment)");
        }
        return count;
    }

	
}
