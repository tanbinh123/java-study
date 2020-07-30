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
		
		String query = "select empno, ename, job from emp";
		try {
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int empno  = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				
				System.out.println(empno +"\t"+ ename +"\t"+ job
						);
			}
		}catch(Exception e){
			System.out.print(" db 오류 1 ~~");
		}
		
	}

}