package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.book_dto;
import dto.score_dto;

public class book_dao {

	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String query = "";
	public ArrayList<book_dto> selectDB(int showGubun, String serchId, String serchName) {
		ArrayList<book_dto> arr = new ArrayList<>();
		if(showGubun == 1)query = "select * from b05_bookmember";
		else if(showGubun == 2)query = "select * from b05_bookmember where id like '%"+serchId+"%'";
		else if(showGubun == 3)query = "select * from b05_bookmember where name like '%"+serchName+"%'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getNString(1);
				String name = rs.getNString(2);
				String address = rs.getNString(3);
				String tel = rs.getNString(4);
				int age = rs.getInt(5);
				String reg_date = rs.getNString(6);
			
				book_dto dto = new book_dto(id,name,address,tel,age,reg_date);
				arr.add(dto);
				
			}
		}catch(SQLException se){
			System.out.println(" insertDB() query error~ " + query);
		}catch(Exception e) {
			System.out.println(" insertDB() error  ~ : ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
	
	public int insertDB(String id, String name, String address , String tel, int age, String reg_date) {
		int result = 0;
		String query = "insert into b05_bookmember (id, name, address, tel, age, reg_date) values ('"+id+"','"+name+"','"+address+"','"+tel+"',"+age+",'"+reg_date+"')";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se){
			System.out.println(" insertDB() query error~ " + query);
		}catch(Exception e) {
			System.out.println(" insertDB() error  ~ : ");
		}finally {
			common.close(connection, ps, rs);
		}
		return result;
		}
}
