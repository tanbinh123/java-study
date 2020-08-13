package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.info_dto;

public class info_dao {

	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//memberId, memberName, bookName, bookWriter, bookPublisher, rentDay;
	
	String query = "";
	String serch = "";
	public ArrayList<info_dto> selectDB(int gubun, String id) {
		ArrayList<info_dto> arr = new ArrayList<>();
		if(gubun == 1) serch = "m.id";
		else if(gubun == 2) serch = "b.no";
		query = "select m.id, m.name, b.name, b.writer, b.publisher, TO_DATE(TO_CHAR(r.return_date, 'YYYYMMDD')) - TO_DATE(TO_CHAR(r.rent_date, 'YYYYMMDD'))\r\n" + 
				" from b05_bookmember m, b05_book b, b05_rent r \r\n" + 
				" where m.id = r.member_id\r\n" + 
				" and b.no = r.book_no\r\n" + 	
				" and "+serch+" = '"+id+"'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String memberId = rs.getNString(1);
				String memberName = rs.getNString(2);
				String bookName = rs.getNString(3);
				String bookWriter = rs.getNString(4);
				String bookPublisher = rs.getNString(5);
				String rentDay = rs.getNString(6);
			
				info_dto dto = new info_dto(memberId, memberName, bookName, bookWriter, bookPublisher, rentDay);
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
}
