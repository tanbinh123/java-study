package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.book_dto;
import dto.rent_dto;

public class rent_dao {

		public String getNo(String no) {
			DecimalFormat df = new DecimalFormat("0000");
			String cutno = no.substring(1);
			int pulsNo = Integer.parseInt(cutno)+1;
			String result = "R"+df.format(pulsNo);
			return result;
		}
		


		DBConnectionOracle common = new DBConnectionOracle();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "";
		public ArrayList<rent_dto> selectDB(int showGubun, String memberId, String bookNo) {
			ArrayList<rent_dto> arr = new ArrayList<>();
			if(showGubun == 1)query = "select no, member_id, book_no,to_char(rent_date, 'yyyy-MM-dd'), to_char(return_date, 'yyyy-MM-dd') from b05_rent ORDER BY no asc";
			//else if(showGubun == 2)query = "select no, name, publisher, writer, to_char(reg_date, 'yyyy-MM-dd'), rent_gubun from b05_book where name like '%"+serchName+"%' ORDER BY no asc";
			//else if(showGubun == 3)query = "select no, name, publisher, writer, to_char(reg_date, 'yyyy-MM-dd'), rent_gubun from b05_book where writer like '%"+serchWriter+"%' ORDER BY no asc";
			//else if(showGubun == 4)query = "select no, name, publisher, writer, to_char(reg_date, 'yyyy-MM-dd'), rent_gubun from b05_book where no = '"+serchNo+"' ORDER BY no asc";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String no = rs.getNString(1);
					String member_id = rs.getNString(2);
					String book_no = rs.getNString(3);
					String rent_date = rs.getNString(4);
					String return_date = rs.getNString(5);
				
					rent_dto dto = new rent_dto(no, member_id, book_no,rent_date, return_date);
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
			query = "select max(no) from b05_rent";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String id = rs.getNString(1);
					a = id;
					
				}
			}catch(SQLException se){
				System.out.println(" insertDBNo() query error~ " + query);
			}catch(Exception e) {
				System.out.println(" insertDBNo() error  ~ : ");
			}finally {
				common.close(connection, ps, rs);
			}
			
			return a;
		}
		
		public int insertDB(String no, String member_id, String book_no) {
			int result = 0;
			String query = "insert into b05_rent (no, member_id, book_no, rent_date) values ('"+no+"','"+member_id+"','"+book_no+"',sysdate)";
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
		
		public int updateDB(String book_no) {
			int result = 0;
			String query = "update b05_book set rent_gubun = 'n' where no = '"+book_no+"'";
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
		
//		public int deleteDB(String id) {
//			int result = 0;
//			String query = "delete from b05_book where no = '"+id+"'";
//			try {
//				connection = common.getConnection();
//				ps = connection.prepareStatement(query);
//				result = ps.executeUpdate();
//			}catch(SQLException se){
//				System.out.println(" deleteDB() query error~ " + query);
//			}catch(Exception e) {
//				System.out.println(" deleteDB() error  ~ : ");
//			}finally {
//				common.close(connection, ps, rs);
//			}
//			return result;
//		}
}
