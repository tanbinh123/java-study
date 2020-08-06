package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionOracle;

public class score_dao {

	public int getTotal(int kor, int eng, int mat) {
		int total = kor + eng + mat;
		return total;
	}
	
	public int getAva(int total, int su) {
		int ava = total/su;
		return ava;
	}
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public int insertDB(String no, String name, int kor, int eng, int mat) {
		int result = 0;
		String query = "insert into t05_score values ('"+no+"','"+name+"',"+kor+","+eng+","+mat+","+getTotal(kor, eng , mat)+","+getAva(getTotal(kor,eng,mat),3)+")";
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
