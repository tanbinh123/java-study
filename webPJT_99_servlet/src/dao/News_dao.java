package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.News_dto;

public class News_dao {
	DBConnectionOracle common= new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps  = null;
	ResultSet         rs  = null;
	// 삭제
	public int deleteNews(String no) {
		int result =0;
		String query =" delete from h05_News \r\n" + 
					  " where no ='"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("deleteNews() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("deleteNews() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	// 수정
	public int updateNews(News_dto dto) {
		int result =0;
		String query ="update h05_News \r\n" + 
				"set title='"+dto.getTitle()+"', \r\n" + 
				"    content='"+dto.getContent()+"', \r\n" + 
				"    reg_name ='"+dto.getReg_name()+"', \r\n" + 
				"    reg_date ='"+dto.getReg_date()+"' \r\n" + 
				"where no ='"+dto.getNo()+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("updateNews() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("updateNews() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	
	// 조회수 증가
	public void setHitCount(String no) {
		String query=" update h05_News set hit = hit + 1\r\n" + 
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
	public News_dto getNewsView(String no){
		News_dto dto = null; 
		String query =" select no, title, content , reg_name, to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
						" from h05_News\r\n" + 
						" where no ='"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String nn 		= rs.getString(1);
				String title 	= rs.getString(2);
				String content 	= rs.getString(3);
				String reg_name = rs.getString(4);
				String reg_date = rs.getString(5);
				int hit 		= rs.getInt(6);
				dto = new News_dto(nn,title,content,
												reg_name,reg_date,hit);
			}
		}catch(SQLException se) {
			System.out.println("getNewsView() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNewsView() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		return dto;
	}
	
	//목록조회
	public ArrayList<News_dto> getNewsList(String select,String search){
		ArrayList<News_dto> arr = new ArrayList<News_dto>();
		String query =" select no, title, reg_name, to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
					  " from h05_News\r\n" + 
				      " where "+select+" like '%"+search+"%' "+
					  " order by no desc";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			while(rs.next()) {
				String no 		= rs.getString(1);
				String title 	= rs.getString(2);
				String reg_name = rs.getString(3);
				String reg_date = rs.getString(4);
				int hit 		= rs.getInt(5);
				News_dto dto = new News_dto(no,title,"",
												reg_name,reg_date,hit);
				arr.add(dto);
			}			
		}catch(SQLException se) {
			System.out.println("getNewsList() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNewsList() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		
		return arr;
	}
	
	// 등록
	public int saveNews(News_dto dto) {
		int result =0;
		String query ="insert into h05_News \r\n" + 
				"(no,title,content,reg_name,reg_date,hit) \r\n" + 
				"values \r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getReg_name()+"','"+dto.getReg_date()+"','"+dto.getHit()+"')";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("saveNews() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("saveNews() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	
	// 번호생성
	public String getNewsNo() {
		String maxNo="";
		String query=" select max(no) from h05_News ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				maxNo = rs.getString(1);
			}
			if(maxNo == null) {
				maxNo ="Z001";
			} else {
				String n = maxNo.substring(1); 
				int i = Integer.parseInt(n); 
				i = i + 1;
				DecimalFormat df = new DecimalFormat("000");
				String newNo = df.format((double)i);
				maxNo = "Z"+newNo; // 
			}
		}catch(SQLException se) {
			System.out.println("getNewsNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNewsNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return maxNo;
	}		
}







