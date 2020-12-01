package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Faq_dto;
import dto.Notice_dto;

public class Faq_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	//No생성
	public String getFaqNo() {
		String maxNo="";
		String query=" select max(no) from h17_faq ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery(); //select는  executeQuery이고 리턴 타입은 result set이다
			if(rs.next()) {
				maxNo = rs.getString(1);
			}
			if(maxNo == null) {
				maxNo ="F001";
			}else {
				String n = maxNo.substring(1); 
				int i = Integer.parseInt(n); 
				i = i + 1; 
				DecimalFormat df = new DecimalFormat("000");
				String newNo = df.format((double)i);
				maxNo = "F"+newNo; 
			}
		}catch(SQLException se) {
			System.out.println("getFaqNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getFaqNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return maxNo;
	}
	
	//sql에 입력시키기
	public int saveFaq(Faq_dto dto) {
		int result = 0;
		String query=" INSERT INTO h17_faq\r\n" + 
					 " (no, question, answer, reg_id, reg_date, sort)\r\n" + 
					 " VALUES ('"+dto.getNo()+"', '"+dto.getQuestion()+"', '"+dto.getAnswer()+"', '"+dto.getReg_id()+"', '"+dto.getReg_date()+"', '"+dto.getSort()+"')";
		
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			result  	= ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("saveFaq() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("saveFaq() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		
		return result;
	}

	//notice_list파일 목록조회
	public ArrayList<Faq_dto> getFaqList(String select, String search){
		ArrayList<Faq_dto> arr = new ArrayList<Faq_dto>();
		String query = " SELECT a.no, a.question, a.answer, b.name, to_char(a.reg_date, 'yyyy-MM-dd'), a.hit, a.sort\r\n" + 
					   " from h17_faq a , h17_member b\r\n" + 
					   " WHERE a.reg_id = b.id\r\n" + 
					   " and "+select+" like '%"+search+"%'\r\n" + 
					   " order by a.sort desc, a.reg_date desc";
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			rs 			= ps.executeQuery();
			while(rs.next()) {
				String no		 = rs.getString(1);
				String question	 = rs.getString(2);
				String answer	 = rs.getString(3);
				String id		 = rs.getString(4);
				String reg_date  = rs.getString(5);
				int hit 		 = rs.getInt(6);
				String sort		 = rs.getString(7);
				Faq_dto dto = new Faq_dto(no, question, answer, id, reg_date, sort, hit);
				arr.add(dto);
			}
		}catch(SQLException se) {
			System.out.println("getFaqList() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getFaqList() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		return arr;
	}
	
	//상세조회
	public Faq_dto FaqView(String no) {
		Faq_dto dto = null;
		String query = " SELECT a.no, a.question, a.answer, b.id, to_char(a.reg_date, 'yyyy-MM-dd'), a.hit, a.sort\r\n" + 
					   " from h17_faq a , h17_member b\r\n" + 
					   " WHERE a.reg_id = b.id\r\n" + 
					   " and a.no = '"+no+"'";
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			rs 			= ps.executeQuery();
			if(rs.next()) {
				String nn		 = rs.getString(1);
				String qustion	 = rs.getString(2);
				String answer	 = rs.getString(3);
				String id	   	 = rs.getString(4);
				String reg_date  = rs.getString(5);
				int hit 		 = rs.getInt(6);
				String sort  = rs.getString(7);
				dto = new Faq_dto(nn, qustion, answer, id, reg_date, sort, hit);
			}
		}catch(SQLException se) {
			System.out.println("FaqView() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("FaqView() 오류");
		}finally {
			common.close(connection, ps, rs);
		}						
		return dto;
	}
	
	//수정
	public int updateFaq(Faq_dto dto) {
		int result = 0;
		String query = " UPDATE h17_faq \r\n" + 
					   " SET question = '"+dto.getQuestion()+"',\r\n" + 
					   "     answer = '"+dto.getAnswer()+"',\r\n" + 
					   "     reg_id = '"+dto.getReg_id()+"',\r\n" + 
					   "     reg_date = '"+dto.getReg_date()+"',\r\n" + 
					   "     sort = '"+dto.getSort()+"'\r\n" + 
					   " where no = '"+dto.getNo()+"'";
		
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			result  	= ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("updateFaq() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("updateFaq() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		
		return result;
	}
	
	//삭제
	public int deleteFaq(String no) {
		int result = 0;
		String query=" delete from h17_faq " + 
					 " where no = '"+no+"'";
		
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			result  	= ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("deleteFaq() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("deleteFaq() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		
		return result;
	}
	
	//조회수 증가
	public void setHitCount(String no) {
		String query = " update h17_faq\r\n" + 
					   " set hit = hit + 1\r\n" + 
					   " where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("sethitCount() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("sethitCount() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
	}
	
}
