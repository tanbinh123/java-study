package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBConnectionOracle;

public class DB_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnectionOracle dbc = new DBConnectionOracle();
		
		Connection con = dbc.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "select id, name, area, age from  member";
		try {
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id  = rs.getString(1);
				String name = rs.getString(2);
				String area = rs.getString(3);
				int age = rs.getInt(4);
				
				System.out.println("돌자 : " +id + name + area + age);
			}
		}catch(Exception e){
			System.out.print(" db 오류 1 ~~");
		}
		
	}

}
