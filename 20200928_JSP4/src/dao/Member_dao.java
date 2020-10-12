package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionOracle;

public class Member_dao {

	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection 	  = null;
	PreparedStatement ps 	  = null;
	ResultSet rs 			  = null;
	
	
	public int MemberReg(String id, String name, String pw, String area, String address, String tel_1, String tel_2,
			String tel_3, String mf, String hobby_t, String hobby_r, String hobby_s, String reg_date) {
		int result =0;
		String query = "INSERT INTO h05_member (id,name,pw,area,address,tel_1,tel_2,tel_3,mf,hobby_t,hobby_r,hobby_s,reg_date) VALUES ('"+id+"','"+name+"','"+pw+"','"+area+"','"+address+"','"+tel_1+"','"+tel_2+"','"+tel_3+"','"+mf+"','"+hobby_t+"','"+hobby_r+"','"+hobby_s+"','"+reg_date+"')";
		try {
			connection = common.getConnection();
			ps         = connection.prepareStatement(query);
			result     = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("BoardSUD() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("BoardSUD() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		return result;
	}
}
