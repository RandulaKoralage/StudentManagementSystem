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
import com.ijse.sms.model.Certificate;


/**
 *
 * @author Randula
 */
public class CertificateController {
      public static boolean addCertificate(Certificate certificate)throws ClassNotFoundException,SQLException{
	String sql="INSERT INTO Certificate VALUES (?,?,?,?)";
	Connection conn=DBConnection.getDBConnection().getConnection();
	PreparedStatement stm=conn.prepareStatement(sql);
	
        stm.setObject(1,certificate.getCertificateID());
	stm.setObject(2,certificate.getResultID());
	stm.setObject(3,certificate.getIssueDate());
	stm.setObject(4,certificate.getStatus());
		
	int res=stm.executeUpdate();
	return(res>0);
    }

    public static boolean deleteCertificate(String certificateID)throws ClassNotFoundException,SQLException{
	String sql="DELETE FROM Certificate WHERE CertificateID='"+certificateID+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	int res=stm.executeUpdate(sql);
	return(res>0);
    }

    public static boolean updateCertificate(Certificate certificate)throws ClassNotFoundException,SQLException{
	String sql="UPDATE Certificate SET ResultID=?, IssueDate=?,Status=? WHERE CertificateID=?";
	Connection conn=DBConnection.getDBConnection().getConnection();
	PreparedStatement stm=conn.prepareStatement(sql);

	stm.setObject(1,certificate.getResultID());
	stm.setObject(2,certificate.getIssueDate());
	stm.setObject(3,certificate.getStatus());
        stm.setObject(4,certificate.getCertificateID());
                
	int res=stm.executeUpdate();
	return(res>0);
    }
	
    public static Certificate searchCertificate(String certificateID)throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM Certificate WHERE CertificateID='"+certificateID+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	Certificate certificate=null;
            if(rst.next()){
		certificate=new Certificate(rst.getString("CertificateID"),rst.getString("ResultID"),rst.getString("IssueDate"),rst.getString("Status"));
            }
	return certificate;
    }
	
    public static ArrayList<Certificate> viewAllCertificate()throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM Certificate";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<Certificate>certificateList=new ArrayList<Certificate>();
	while(rst.next()){
            Certificate certificate=new Certificate(rst.getString("CertificateID"),rst.getString("ResultID"),rst.getString("IssueDate"),rst.getString("Status"));
            certificateList.add(certificate);
	}
	return certificateList;
    }
    
     public static String[] viewCertificateId()throws ClassNotFoundException,SQLException{
	String sql="SELECT CertificateID FROM Certificate";
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
              array[i++]=rst.getString("CertificateID");        
        }        
	return array;
    }
   public static String[] viewCertificateIdListOfExam(String examId )throws ClassNotFoundException,SQLException{
	String sql="select CertificateID from certificate where resultId in(select resultId from resultTable where ExamId='"+examId+"')";
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
              array[i++]=rst.getString("CertificateID");        
        }        
	return array;
    }
  public static Certificate searchCertificate(String examId,String stId)throws ClassNotFoundException,SQLException{
	String sql="select * from certificate where resultId in(select resultId from resultTable where examId='"+examId+"' and stID='"+stId+"')";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	Certificate certificate=null;
            if(rst.next()){
		certificate=new Certificate(rst.getString("CertificateID"),rst.getString("ResultID"),rst.getString("IssueDate"),rst.getString("Status"));
            }
	return certificate;
    }
      public static String getCertId(String resId) throws ClassNotFoundException, SQLException {
        String sql = "select CertificateID from certificate where ResultID='"+resId+"' ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        String id = null;
        while (rst.next()) {
            id = rst.getString("CertificateID");
        }
        return id;
    }
        public static String getCertDate(String resId) throws ClassNotFoundException, SQLException {
        String sql = "select IssueDate from certificate where ResultID='"+resId+"' ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();

        ResultSet rst = stm.executeQuery(sql);
        String date = null;
        while (rst.next()) {
            date = rst.getString("IssueDate");
        }
        return date;
    }
}
