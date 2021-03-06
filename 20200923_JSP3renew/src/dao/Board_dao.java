package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.*;

public class Board_dao {

	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection 	  = null;
	PreparedStatement ps 	  = null;
	ResultSet rs 			  = null;
	
	
	
	String boardGubun = "";
	
	public void SetBoardGubun(String gubun) {
		if (gubun.equals("notice")) {
			boardGubun = "notice";
		}else if(gubun.equals("news")) {
			boardGubun = "news";
		}else if(gubun.equals("free")) {
			boardGubun = "free";
		}else if(gubun.equals("qna")) {
			boardGubun = "qna";
		}
	}
	
	
	
	/*
	 * 조회
	 * */
	public ArrayList<Board_dto> getBoardList(String select, String search, String sort){
		ArrayList<Board_dto> arr = new ArrayList<>();
		String query =" select no,title,content,attach,reg_name,to_char(reg_date,'YYYY-MM-DD'),hit \r\n" + 
					" from h05_"+boardGubun+" \r\n" + 
					" where "+select+" like '%"+search+"%'"+
					" order by "+sort+" desc";
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
				Board_dto dto = new Board_dto(no, title, content, attach, reg_name, reg_date,hit);
				arr.add(dto);
			}
		}catch(SQLException se) {
			System.out.println("getboardList() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getboardList() 오류");
		}finally {
			common.close(connection, ps, rs);
		}						
		
		return arr;
	}

	/*
	 * 저장 수정 삭제 통합 
	 */
	public int BoardCUD(String Setquery) {
		int result =0;
		String query = Setquery;
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
	
	/*
	 * 번호생성
	 */
	public String getBoardNo() {
		String maxNo="";
		String query=" select max(no) from h05_"+boardGubun+" ";
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
	 * 조회수 증가 
	 */
	
	public void hitCount(String no) {
		String query = "update h05_"+boardGubun+" set hit = hit + 1 where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps         = connection.prepareStatement(query);
			ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("hitCount() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("hitCount() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
	}
	
	/*
	 * dto로 조회
	 */
	public Board_dto getBoardView(String SearchNo) {
		Board_dto dto = null;
		String query = " select no,title,content,attach,reg_name,to_char(reg_date,'YYYY-MM-DD'),hit \r\n" + 
				" from h05_"+boardGubun+" \r\n" + 
				" where no = '"+SearchNo+"'";
		try {
			connection = common.getConnection();
			ps         = connection.prepareStatement(query);
			rs         = ps.executeQuery();
			if(rs.next()) {
				String no 		= rs.getString(1);
				String title 	= rs.getString(2);
				String content 	= rs.getString(3);
				String attach 	= rs.getString(4);
				String reg_name = rs.getString(5);
				String reg_date = rs.getString(6);
				int hit 		= rs.getInt(7);
				dto = new Board_dto(no, title, content, attach, reg_name, reg_date,hit);
				//System.out.println(query);
			}
			
		}catch(SQLException se) {
			System.out.println("getNoticeView() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNoticeView() 오류");
		}finally {
			common.close(connection, ps, rs);
		}					
		return dto;
	}

}
