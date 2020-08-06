package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import common.DBConnectionOracle;
import dto.testDB_dto;

public class testdao {
	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	

	//select
	String query = "";
	public ArrayList<testDB_dto> selectDB(int selectgubun, String no, String name, String area,int age){
		ArrayList<testDB_dto> arr = new ArrayList<>();
		query = "select a.no, a.name, b.area_name, a.age from t05_member a, a_area_info b where a.area = b.area_code";
			if (selectgubun == 1) query = query;
			else if(selectgubun == 2)query = query + " and a.no like '%"+no+"%'";
			else if(selectgubun == 3)query = query + " and a.name like '%"+name+"%'";
			else if(selectgubun == 4)query = query + "and b.area_name like '%"+area+"%'";
		try{
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
	
				while(rs.next()) {
					String s_no = rs.getString("no");//name
					String s_name = rs.getString("name");//3
					String s_area = rs.getString("area_name");//4
					int s_age = rs.getInt("age");//4
					
					testDB_dto dto = new testDB_dto(s_no, s_name, s_area, s_age);
					arr.add(dto);
				}
		}catch(SQLException se){
			System.out.println("selectDB() SQL query error" + query);
		}catch(Exception e){
			System.out.println("selectDB() error");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
	
	//insert
	public int insertDB(String no, String name, String area, int age) {
		int result = 0;
		String query = "insert into t05_member VALUES ("+no+",'"+ name +"','" + area+"','" + age+"')";
	try {
		connection = common.getConnection();
		ps = connection.prepareStatement(query);
		result = ps.executeUpdate();
	}catch(SQLException se) {
		System.out.println(" insertDB() query error~ " + query);
		
	}catch(Exception e) {
		System.out.println(" insertDB() error  ~ : ");
	}finally {
		common.close(connection, ps, rs);
	}
	return result;
	}
	
	//insert use dto
	public int insertDB(testDB_dto dto) {
		int result = 0;
		String query = "insert into t05_member VALUES ("+dto.getNo()+",'"+ dto.getName() +"','" + dto.getArea()+"','" + dto.getAge()+"')";
	try {
		connection = common.getConnection();
		ps = connection.prepareStatement(query);
		result = ps.executeUpdate();
	}catch(SQLException se) {
		System.out.println(" insertDB(dto) query error~ " + query);
	}catch(Exception e) {
		System.out.println(" insertDB(dto) error  ~ : ");
	}finally {
		common.close(connection, ps, rs);
	}
	return result;
	}
	
	//update 사전 조회
	public testDB_dto updateDB(String no) {
		testDB_dto dto = null;
		String query = "select a.no, a.name, b.area_name, a.age from t05_member a, a_area_info b where a.area = b.area_code and no = '"+no+"'";
	try {
		connection = common.getConnection();
		ps = connection.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			String s_no = rs.getString("no");//name
			String s_name = rs.getString("name");//3
			String s_area = rs.getString("area_name");//4
			int s_age = rs.getInt("age");//4
			
			dto = new testDB_dto(s_no, s_name, s_area, s_age);
		}
	}catch(SQLException se) {
		System.out.println(" updateDB() query error~ " + query);
		
	}catch(Exception e) {
		System.out.println(" updateDB() error  ~ : ");
	}finally {
		common.close(connection, ps, rs);
	}
	return dto;
	}
	
	//update
	public int updateDB(String name, String area, int age, String whereno) {
		int result = 0;
		String query = "update t05_member set name = '"+ name +"', area = '" + area+"', age = '" + age+"' where no ="+whereno;;
	try {
		connection = common.getConnection();
		ps = connection.prepareStatement(query);
		result = ps.executeUpdate();
		
	}catch(SQLException se) {
		System.out.println(" updateDB() query error~ " + query);
		
	}catch(Exception e) {
		System.out.println(" updateDB() error  ~ : ");
	}finally {
		common.close(connection, ps, rs);
	}
	return result;
	}
	
	
	//delete
	public int deleteDB(String no, String name, String area, int age) {
		int result = 0;
		String query = "delete from t05_member where no = " + no;
	try {
		connection = common.getConnection();
		ps = connection.prepareStatement(query);
		result = ps.executeUpdate();
	}catch(SQLException se) {
		System.out.println(" deleteDB() query error~ " + query);
		
	}catch(Exception e) {
		System.out.println(" deleteDB() error  ~ : ");
	}finally {
		common.close(connection, ps, rs);
	}
	return result;
	}
	
}

