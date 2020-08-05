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
			System.out.println("selectDB() SQL query 오류" + query);
		}catch(Exception e){
			System.out.println("selectDB() 오류");
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
		System.out.println(" insertDB() query 오류~ " + query);
		
	}catch(Exception e) {
		System.out.println(" insertDB() 오류  ~ : ");
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
		System.out.println(" insertDB(dto) query 오류~ " + query);
		
	}catch(Exception e) {
		System.out.println(" insertDB(dto) 오류  ~ : ");
	}finally {
		common.close(connection, ps, rs);
	}
	return result;
	}
	
	//update
	public int updateDB(String no, String name, String area, int age, String whereno) {
		int result = 0;
		String query = "update t05_member set no = "+no+", name = '"+ name +"', area = '" + area+"' where no ="+whereno;;
	try {
		connection = common.getConnection();
		ps = connection.prepareStatement(query);
		result = ps.executeUpdate();
	}catch(SQLException se) {
		System.out.println(" updateDB() query 오류~ " + query);
		
	}catch(Exception e) {
		System.out.println(" updateDB() 오류  ~ : ");
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
		System.out.println(" deleteDB() query 오류~ " + query);
		
	}catch(Exception e) {
		System.out.println(" deleteDB() 오류  ~ : ");
	}finally {
		common.close(connection, ps, rs);
	}
	return result;
	}
	
	
}

