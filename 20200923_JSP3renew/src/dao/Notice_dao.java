package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.*;

public class Notice_dao {

	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection 	  = null;
	PreparedStatement ps 	  = null;
	ResultSet rs 			  = null;
	
	
	
	
	/*
	 * 조회
	 * */
	public ArrayList<Notice_dto> getNoticeList(String select, String search){
		ArrayList<Notice_dto> arr = new ArrayList<>();
		String query =" select no,title,content,attach,reg_name,to_char(reg_date,'YYYY-MM-DD'),hit \r\n" + 
					" from h05_notice \r\n" + 
					" where "+select+" like '%"+search+"%'"+
					" order by no desc";
		try {
			connection = common.getConnection();
			ps         = connection.prepareStatement(query);
			rs         = ps.executeQuery();
			while(rs.next()) {
				String no 		= rs.getString(1);
				String title 	= rs.getString(2);
				String content 	= rs.getString(3);
				String attach 	= rs.getString(4);
				String reg_name = rs.getString(5);
				String reg_date = rs.getString(6);
				int hit 		= rs.getInt(7);
				Notice_dto dto = new Notice_dto(no, title, content, attach, reg_name, reg_date,hit);
				arr.add(dto);
				System.out.print(query);
			}
		}catch(SQLException se) {
			System.out.println("getNoticeList() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNoticeList() 오류");
		}finally {
			common.close(connection, ps, rs);
		}						
		
		return arr;
	}
	
	
	/*
	 * 번호생성
	 */
	public String getNoticeNo() {
		String maxNo="";
		String query=" select max(no) from h05_notice ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				maxNo = rs.getString(1);
			}
			if(maxNo == null) {
				maxNo ="N001";
			} else {
				String n = maxNo.substring(1); 
				int i = Integer.parseInt(n); 
				i = i + 1;
				DecimalFormat df = new DecimalFormat("000");
				String newNo = df.format((double)i);
				maxNo = "N"+newNo; // 
			}
		}catch(SQLException se) {
			System.out.println("getEventNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getEventNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return maxNo;
	}
	
	/*
	 * 저장
	 */
	public int noticeSave(Notice_dto dto) {
		int result =0;
		String query ="insert into h05_notice \r\n" + 
				"(no,title,content,attach,reg_name,reg_date,hit) \r\n" + 
				"values \r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getAttach()+"','"+dto.getReg_name()+"','"+dto.getReg_date()+"','"+dto.getHit()+"')";
		try {
			connection = common.getConnection();
			ps         = connection.prepareStatement(query);
			result     = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("eventSave() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("eventSave() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		return result;
	}
}
