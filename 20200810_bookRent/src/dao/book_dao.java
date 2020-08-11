package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.book_dto;

public class book_dao {

	public String getNo(String no) {
		DecimalFormat df = new DecimalFormat("0000");
		String cutno = no.substring(1);
		int pulsNo = Integer.parseInt(cutno)+1;
		String result = "K"+df.format(pulsNo);
		return result;
	}
	


	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String query = "";
	public ArrayList<book_dto> selectDB(int showGubun, String serchId, String serchName) {
		ArrayList<book_dto> arr = new ArrayList<>();
		if(showGubun == 1)query = "select * from b05_book ORDER BY no asc";
		else if(showGubun == 2)query = "select * from b05_book where id like '%"+serchId+"%' ORDER BY no asc";
		else if(showGubun == 3)query = "select * from b05_book where name like '%"+serchName+" ORDER BY no asc%'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getNString(1);
				String name = rs.getNString(2);
				String publisher = rs.getNString(3);
				String writer = rs.getNString(4);
				String reg_date = rs.getNString(5);
				String rent_gubun = rs.getNString(6);
			
				book_dto dto = new book_dto(no, name, publisher, writer, reg_date, rent_gubun);
				arr.add(dto);
				
			}
		}catch(SQLException se){
			System.out.println(" selectDB() query error~ " + query);
		}catch(Exception e) {
			System.out.println(" selectDB() error  ~ : ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
	
	public String insertDBNo() {
		String a = "";
		query = "select max(id) from b05_bookmember";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getNString(1);
				a = id;
				
			}
		}catch(SQLException se){
			System.out.println(" selectDB() query error~ " + query);
		}catch(Exception e) {
			System.out.println(" selectDB() error  ~ : ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return a;
	}
	
	public int insertDB(String id, String name, String address , String tel, int age) {
		int result = 0;
		String query = "insert into b05_bookmember (id, name, address, tel, age, reg_date) values ('"+id+"','"+name+"','"+address+"','"+tel+"',"+age+",sysdate)";
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
	
	public int updateDB(String id, String name, String address , String tel, int age) {
		int result = 0;
		String query = "update b05_bookmember set name = '"+name+"', address = '"+address+"', tel = '"+tel+"', age = "+age+" where id = '"+id+"'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se){
			System.out.println(" updateDB() query error~ " + query);
		}catch(Exception e) {
			System.out.println(" updateDB() error  ~ : ");
		}finally {
			common.close(connection, ps, rs);
		}
		return result;
		}
	
	public int deleteDB(String id) {
		int result = 0;
		String query = "delete from b05_bookmember where id = '"+id+"'";
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
