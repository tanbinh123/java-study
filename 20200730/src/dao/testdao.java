package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.testDB_dto;

public class testdao {
	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String query;
	public ArrayList<testDB_dto> selectTestDB(){
		
	ArrayList<testDB_dto> arr = new ArrayList<>();
	String query = "select empno, ename, job from test";
	try{
		connection = common.getConnection();
		ps = connection.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			int empno = rs.getInt(1);//name
			String ename = rs.getString(2);//3
			String job = rs.getString(3);//4
			
			testDB_dto dto = new testDB_dto(empno, ename, job);
			arr.add(dto);
			
		}
	}catch(SQLException se){
		System.out.println("getListAll() SQL query 오류" + query);
	}catch(Exception e){
		System.out.println("getListAll() 오류");
	}finally {
		common.close(connection, ps, rs);
	}
	
	return arr;
}
	
	
	public ArrayList<testDB_dto> insertTestDB(int setEmpno, String setEname, String setJob){
	
	ArrayList<testDB_dto> arr = new ArrayList<>();
	String query = "insert into TEST VALUES ("+setEmpno+",'"+ setEname +"','" + setJob+"')";
	try{
		connection = common.getConnection();
		ps = connection.prepareStatement(query);
		rs = ps.executeQuery();
//		
//		while(rs.next()) {
//			int empno = rs.getInt(1);//name
//			String ename = rs.getString(2);//3
//			String job = rs.getString(3);//4
//			
//			testDB_dto dto = new testDB_dto(empno, ename, job);
//			arr.add(dto);
//			
//		}
	}catch(SQLException se){
		System.out.println("getListAll() SQL query 오류" + query);
	}catch(Exception e){
		System.out.println("getListAll() 오류");
	}finally {
		common.close(connection, ps, rs);
	}
	
	return arr;
}
}
