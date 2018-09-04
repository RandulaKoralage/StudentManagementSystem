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
import com.ijse.sms.model.ResultTable;


/**
 *
 * @author Randula
 */
public class ResultTableController {
      public static boolean addOrderDetail(ArrayList<ResultTable> list) throws ClassNotFoundException, SQLException{
		int res=0;
	
			String sql="INSERT INTO ResultTable VALUES(?,?,?,?,?,?,?)";
			Connection conn=DBConnection.getDBConnection().getConnection();
			PreparedStatement stm=conn.prepareStatement(sql);
		for(ResultTable resultTable:list){
			stm.setObject(1,resultTable.getResultID());
			stm.setObject(2,resultTable.getExamID());
			stm.setObject(3,resultTable.getStID());
			stm.setObject(4,resultTable.getPracticalMark());
                        stm.setObject(5,resultTable.getTheoryMark());
			stm.setObject(6,resultTable.getGrade());
			stm.setObject(7,resultTable.getStatus());
                        
			res=stm.executeUpdate();
				
		}
			return(res>0);	
			
	}

    public static boolean deleteResultTable(String resultID)throws ClassNotFoundException,SQLException{
	String sql="DELETE FROM ResultTable WHERE ResultID='"+resultID+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	int res=stm.executeUpdate(sql);
	return(res>0);
    }

    public static boolean updateResultTable(ResultTable resultTable)throws ClassNotFoundException,SQLException{
	String sql="UPDATE ResultTable SET ExamID=?, StID=?,PracticalMark=?,TheoryMark=?,Grade=?,Status=? WHERE ResultID=?";
	Connection conn=DBConnection.getDBConnection().getConnection();
	PreparedStatement stm=conn.prepareStatement(sql);

	stm.setObject(1,resultTable.getExamID());
	stm.setObject(2,resultTable.getStID());
	stm.setObject(3,resultTable. getPracticalMark());
	stm.setObject(4,resultTable.getTheoryMark());
	stm.setObject(5,resultTable.getGrade());
	stm.setObject(6,resultTable. getStatus());
        stm.setObject(7,resultTable.getResultID());
                
	int res=stm.executeUpdate();
	return(res>0);
    }
	
    public static ResultTable searchResultTable(String resultID)throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM ResultTable WHERE ResultID='"+resultID+"'";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ResultTable resultTable=null;
            if(rst.next()){
		resultTable=new ResultTable(rst.getString("ResultID"),rst.getString("ExamID"),rst.getString("StID"),rst.getDouble("PracticalMark"),rst.getDouble("TheoryMark"),rst.getString("Grade"),rst.getString("Status"));
            }
	return resultTable;
    }
	
    public static ArrayList<ResultTable> viewAllResults()throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM ResultTable";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<ResultTable>resultList=new ArrayList<ResultTable>();
	while(rst.next()){
            ResultTable resultTable=new ResultTable(rst.getString("ResultID"),rst.getString("ExamID"),rst.getString("StID"),rst.getDouble("PracticalMark"),rst.getDouble("TheoryMark"),rst.getString("Grade"),rst.getString("Status"));
            resultList.add(resultTable);
	}
	return resultList;
    }
      public static ResultTable searchResultByIds(String examID,String stId)throws ClassNotFoundException,SQLException{
	String sql="SELECT * FROM ResultTable WHERE ExamID='"+examID+"' AND StID='"+stId+"'" ;
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ResultTable resultTable=null;
            if(rst.next()){
		resultTable=new ResultTable(rst.getString("ResultID"),rst.getString("ExamID"),rst.getString("StID"),rst.getDouble("PracticalMark"),rst.getDouble("TheoryMark"),rst.getString("Grade"),rst.getString("Status"));
            }
	return resultTable;
    }
        public static String[] getResultId(String examId) throws ClassNotFoundException, SQLException {
        String sql = "select ResultId from ResultTable where examId='"+examId+"' and status='Pass'";
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
            array[i++] = rst.getString("ResultId");
        }
        return array;
    }
         public static ArrayList<ResultTable> viewAllResultsOfAnExam(String examName,String year)throws ClassNotFoundException,SQLException{
	String sql="select * from resultTable where examId in(select examId from examination where examName='"+examName+"' and year(ExamDate)='" + year + "')";
	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<ResultTable>resultList=new ArrayList<ResultTable>();
	while(rst.next()){
            ResultTable resultTable=new ResultTable(rst.getString("ResultID"),rst.getString("ExamID"),rst.getString("StID"),rst.getDouble("PracticalMark"),rst.getDouble("TheoryMark"),rst.getString("Grade"),rst.getString("Status"));
            resultList.add(resultTable);
	}
	return resultList;
    }
          public static ArrayList<ResultTable> viewResultToPrint(String examName,String year)throws ClassNotFoundException,SQLException{
	String sql="select * from ResultTable where examId in (select examId from examination where examName='"+examName+"' and year(ExamDate)='"+year+"') and status='Pass'";

	Connection conn=DBConnection.getDBConnection().getConnection();
	Statement stm=conn.createStatement();
		
	ResultSet rst=stm.executeQuery(sql);
	ArrayList<ResultTable>resultList=new ArrayList<ResultTable>();
	while(rst.next()){
            ResultTable resultTable=new ResultTable(rst.getString("ResultID"),rst.getString("ExamID"),rst.getString("StID"),rst.getDouble("PracticalMark"),rst.getDouble("TheoryMark"),rst.getString("Grade"),rst.getString("Status"));
            resultList.add(resultTable);
	}
	return resultList;
    }
      
}
