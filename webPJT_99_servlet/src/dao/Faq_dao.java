package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Faq_dto;

public class Faq_dao {
	DBConnectionOracle common= new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps  = null;
	ResultSet         rs  = null;
	
	//삭제
	public int deleteFaq(String no) {
		int result =0;
		String query =" delete from h05_Faq \r\n" + 
					  " where no ='"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("deleteFaq() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("deleteFaq() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	// 수정
	public int updateFaq(Faq_dto dto) {
		int result =0;
		String query ="update h05_Faq \r\n" + 
				"set question='"+dto.getQuestion()+"', \r\n" + 
				"    answer='"+dto.getAnswer()+"', \r\n" + 
				"    reg_id ='"+dto.getReg_id()+"', \r\n" + 
				"    reg_date ='"+dto.getReg_date()+"', \r\n" + 
				"    sort ='"+dto.getSort()+"' \r\n" + 
				"where no ='"+dto.getNo()+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("updateFaq() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("updateFaq() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	
	// 조회수 증가
	public void setHitCount(String no) {
		String query=" update h05_Faq set hit = hit + 1\r\n" + 
					 " where no='"+no+"' ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			ps.executeUpdate();		
		}catch(SQLException se) {
			System.out.println("setHitCount() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("setHitCount() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
	}	
	
	//상세조회
	public Faq_dto getFaqView(String no){
		Faq_dto dto = null; 
		String query =" select no,question,answer,reg_id,to_char(reg_date,'yyyy-MM-dd'),sort, hit\r\n" + 
						" from h05_Faq\r\n" + 
						" where no ='"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String nn 		= rs.getString(1);
				String question = rs.getString(2);
				String answer 	= rs.getString(3);
				String reg_id 	= rs.getString(4);
				String reg_date = rs.getString(5);
				String sort = rs.getString(6);
				int hit 		= rs.getInt(7);
				dto = new Faq_dto(nn,question,answer,reg_id,
						reg_date,sort,hit);
			}
		}catch(SQLException se) {
			System.out.println("getFaqView() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getFaqView() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		return dto;
	}
	
	//목록조회
	public ArrayList<Faq_dto> getFaqList(String select,String search){
		ArrayList<Faq_dto> arr = new ArrayList<Faq_dto>();
		String query =" select no,question,answer,reg_id,to_char(reg_date,'yyyy-MM-dd'),sort, hit\r\n" + 
					  " from h05_Faq\r\n" + 
				      " where "+select+" like '%"+search+"%' "+
					  " order by no desc";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			while(rs.next()) {
				String no 		= rs.getString(1);
				String question 	= rs.getString(2);
				String answer 	= rs.getString(3);
				String reg_id = rs.getString(4);
				String reg_date = rs.getString(5);
				String sort = rs.getString(6);
				int hit 		= rs.getInt(7);
				Faq_dto dto = new Faq_dto(no, question, answer, reg_id, reg_date, sort, hit);
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
	
	// 등록
	public int saveFaq(Faq_dto dto) {
		int result =0;
		String query ="insert into h05_Faq \r\n" + 
				"(no,question,answer,reg_id,reg_date,sort,hit) \r\n" + 
				"values \r\n" + 
				"('"+dto.getNo()+"','"+dto.getQuestion()+"','"+dto.getAnswer()+"','"+dto.getReg_id()+"','"+dto.getReg_date()+"','"+dto.getSort()+"','"+dto.getHit()+"')";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("saveFaq() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("saveFaq() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	
	// 번호생성
	public String getFaqNo() {
		String maxNo="";
		String query=" select max(no) from h05_Faq ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				maxNo = rs.getString(1);
			}
			if(maxNo == null) {
				maxNo ="F001";
			} else {
				String n = maxNo.substring(1); 
				int i = Integer.parseInt(n); 
				i = i + 1;
				DecimalFormat df = new DecimalFormat("000");
				String newNo = df.format((double)i);
				maxNo = "F"+newNo; // 
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
}
