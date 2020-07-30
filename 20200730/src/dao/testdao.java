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
	
	/*
	//select문
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
	
	//update문
	public ArrayList<testDB_dto> updateTestDB(int setEmpno, String setEname, String setJob, int where){
	
	ArrayList<testDB_dto> arr = new ArrayList<>();
	String query = "update test set empno = "+setEmpno+", ename = '"+ setEname +"', job = '" + setJob+"' where empno ="+where;
	try{
		connection = common.getConnection();
		ps = connection.prepareStatement(query);
		rs = ps.executeQuery();

	}catch(SQLException se){
		System.out.println("getListAll() SQL query 오류" + query);
	}catch(Exception e){
		System.out.println("getListAll() 오류");
	}finally {
		common.close(connection, ps, rs);
	}
	
	return arr;
}
	//insert문
	public ArrayList<testDB_dto> insertTestDB(int setEmpno, String setEname, String setJob){
	
	ArrayList<testDB_dto> arr = new ArrayList<>();
	String query = "insert into TEST VALUES ("+setEmpno+",'"+ setEname +"','" + setJob+"')";
	try{
		connection = common.getConnection();
		ps = connection.prepareStatement(query);
		rs = ps.executeQuery();

	}catch(SQLException se){
		System.out.println("getListAll() SQL query 오류" + query);
	}catch(Exception e){
		System.out.println("getListAll() 오류");
	}finally {
		common.close(connection, ps, rs);
	}
	
	return arr;
}
	//delete문
	public ArrayList<testDB_dto> deleteTestDB(int setEmpno){
	
	ArrayList<testDB_dto> arr = new ArrayList<>();
	String query = "delete from test where empno = " + setEmpno;
	try{
		connection = common.getConnection();
		ps = connection.prepareStatement(query);
		rs = ps.executeQuery();

	}catch(SQLException se){
		System.out.println("getListAll() SQL query 오류" + query);
	}catch(Exception e){
		System.out.println("getListAll() 오류");
	}finally {
		common.close(connection, ps, rs);
	}
	
	return arr;
}
	*/
	
	
	
	
	//select, insert, update, delete 통합
	String query = "";
	public ArrayList<testDB_dto> allControlTestDB(int gubun,int setEmpno, String setEname, String setJob, int where){
	ArrayList<testDB_dto> arr = new ArrayList<>();
	if (gubun == 1)query = "select empno, ename, job from test";
	else if (gubun == 2)query = "insert into TEST VALUES ("+setEmpno+",'"+ setEname +"','" + setJob+"')";
	else if (gubun == 3)query = "update test set empno = "+setEmpno+", ename = '"+ setEname +"', job = '" + setJob+"' where empno ="+where;
	else if (gubun == 4)query = "delete from test where empno = " + setEmpno;
	try{
		connection = common.getConnection();
		ps = connection.prepareStatement(query);
		rs = ps.executeQuery();

		if(gubun == 1) {
			while(rs.next()) {
				int empno = rs.getInt(1);//name
				String ename = rs.getString(2);//3
				String job = rs.getString(3);//4
				
				testDB_dto dto = new testDB_dto(empno, ename, job);
				arr.add(dto);
			}
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
}
