package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionOracle;

public class return_dao {

	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public int updateDB(String book_no) {
		int result = 0;
		String query = "update b05_book set rent_gubun = 'y' where no = '"+book_no+"'";
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
	
	public int updateReturnDate(String book_no) {
		int result = 0;
		String query = "UPDATE b05_rent SET return_date = sysdate where rent_date = (select max(rent_date) from b05_rent where book_no = '"+book_no+"')";
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
}
