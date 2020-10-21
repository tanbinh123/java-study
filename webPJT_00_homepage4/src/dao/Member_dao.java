package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Notice_dto;

public class Member_dao {
	DBConnectionOracle common= new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps  = null;
	ResultSet         rs  = null;
	// 삭제
	public int deleteNotice(String no) {
		int result =0;
		String query =" delete from h00_notice \r\n" + 
					  " where no ='"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("deleteNotice() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("deleteNotice() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	

	
	//상세조회
	public String getLoginName(String id, String pw){
		String name = null; 
		String query =" select name \r\n" + 
						" from h00_member\r\n" + 
						" where id ='"+id+"' and pw ='"+pw+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				name	= rs.getString(1);
				
			}
		}catch(SQLException se) {
			System.out.println("getLoginName() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getLoginName() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		return name;
	}
	

}







