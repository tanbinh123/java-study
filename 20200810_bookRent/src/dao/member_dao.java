package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.member_dto;

public class member_dao {
	
	public String getNo(String no) {
		DecimalFormat df = new DecimalFormat("0000");
		String cutno = no.substring(1);
		int pulsNo = Integer.parseInt(cutno)+1;
		String result = "B"+df.format(pulsNo);
		return result;
	}
	
	public static String phone(String src) {
	    if (src == null) {
	      return "";
	    }
	    if (src.length() == 8) {
	      return src.replaceFirst("^([0-9]{4})([0-9]{4})$", "$1-$2");
	    } else if (src.length() == 12) {
	      return src.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
	    }
	    return src.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
	  }

	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String query = "";
	public ArrayList<member_dto> selectDB(int showGubun, String serchId, String serchName) {
		ArrayList<member_dto> arr = new ArrayList<>();
		if(showGubun == 1)query = "select id, name, address, tel, age, to_char(reg_date, 'yyyy-MM-dd') from b05_bookmember ORDER BY id asc";
		else if(showGubun == 2)query = "select id, name, address, tel, age, to_char(reg_date, 'yyyy-MM-dd') from b05_bookmember where id like '%"+serchId+"%' ORDER BY id asc";
		else if(showGubun == 3)query = "select id, name, address, tel, age, to_char(reg_date, 'yyyy-MM-dd') from b05_bookmember where name like '%"+serchName+" ORDER BY id asc%'";
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
			
				member_dto dto = new member_dto(id,name,address,tel,age,reg_date);
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
