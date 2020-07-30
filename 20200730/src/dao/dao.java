package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.dto;
import dto.testDB_dto;

public class dao {

	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String query;
	public ArrayList<dto> getMemberList(int gubun, String seachvalue, int startAge, int endAge){
		ArrayList<dto> arr = new ArrayList<>();
		
		if(gubun == 1) {
			query = "select id, name, area, age from member";
		}else if(gubun == 2) {
			query = "select id, name, area, age from member where name like '%" +seachvalue+ "%'";
		}else if(gubun == 3) {
			query = "select id, name, area, age from member where area like '%" +seachvalue+ "%'";
		}else if(gubun == 4) {
			query = "select id, name, area, age from member where age >= "+startAge+" and age <= "+endAge;
		}
		
		
		try{
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);//id
				String name = rs.getString(2);//name
				String area = rs.getString("area");//3
				int age = rs.getInt("age");//4
				dto dto = new dto(id, name, area, age);
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
	
	
	//전체조회
	//조회할땐 리턴타입 지정하고 쿼리문 만듬
	public ArrayList<dto> getListAll(){
		ArrayList<dto> arr = new ArrayList<>();
		String query = "select id, name, area, age from member";
		try{
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);//id
				String name = rs.getString(2);//name
				String area = rs.getString("area");//3
				int age = rs.getInt("age");//4
				dto dto = new dto(id, name, area, age);
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
	//이름조회
	public ArrayList<dto> getListName(String seachname){
		ArrayList<dto> arr = new ArrayList<>();
		String query = "select id, name, area, age from member where name like '%"+seachname+"%'";
		try{
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);//id
				String name = rs.getString(2);//name
				String area = rs.getString("area");//3
				int age = rs.getInt("age");//4
				
				dto dto = new dto(id, name, area, age);
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
	//지역조회
	public ArrayList<dto> getListArea(String seachArea){
		ArrayList<dto> arr = new ArrayList<>();
		String query = "select id, name, area, age from member where area like '%"+seachArea+"%'";
		try{
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);//id
				String name = rs.getString(2);//name
				String area = rs.getString("area");//3
				int age = rs.getInt("age");//4
				
				dto dto = new dto(id, name, area, age);
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
	//나이조회
	public ArrayList<dto> getListAge(int age1, int age2){
		
		ArrayList<dto> arr = new ArrayList<>();
		String query = "select id, name, area, age from member where age >= "+age1+" and age <= "+age2;
		try{
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);//id
				String name = rs.getString(2);//name
				String area = rs.getString("area");//3
				int age = rs.getInt("age");//4
				
				dto dto = new dto(id, name, area, age);
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

}
