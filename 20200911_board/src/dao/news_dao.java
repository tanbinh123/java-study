package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.news_dto;

public class news_dao {
	
	//번호 추가 메소드
		public String getNo(String no) {
			DecimalFormat df = new DecimalFormat("000");
			String cutno = no.substring(1);
			int pulsNo = Integer.parseInt(cutno)+1;
			String result = "N"+df.format(pulsNo);
			return result;
		}
		
		
		
		//DB연결
		DBConnectionOracle common = new DBConnectionOracle();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		public String getNewsNo() {
			String maxNo="";
			String query=" select max(no) from h00_news ";
			try {
				connection = common.getConnection();
				ps  = connection.prepareStatement(query);
				rs  = ps.executeQuery();
				if(rs.next()) {
					maxNo = rs.getString(1);
				}
				
				if(maxNo == null) {
					maxNo ="N001";
				}else {
					String n = maxNo.substring(1); 
					int i = Integer.parseInt(n); 
					i = i + 1;
					DecimalFormat df = new DecimalFormat("000");
					String newNo = df.format((double)i);
					maxNo = "N"+newNo; // maxNO ="R0005"
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
		
		//no에서 가장 큰 번호만 조회
		public String selectDBNo() {
			String result = "";
			String query = "select max(no) from h05_news";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String no = rs.getNString(1);
					result = no;
					
				}
			}catch(SQLException se){
				System.out.println(" insertDBNo() query error~ " + query);
			}catch(Exception e) {
				System.out.println(" insertDBNo() error  ~ : ");
			}finally {
				common.close(connection, ps, rs);
			}
			
			return result;
		}
	
	
	
	public int saveNews(String no, String title, String content, String reg_name, String reg_date) {
		int result = 0;
		String query="insert into h05_news (no, title, content, reg_name, reg_date) values ('"+no+"','"+title+"','"+content+"','"+reg_name+"','"+reg_date+"')";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se){
			System.out.println(" saveNews() query error~ " + query);
		}catch(Exception e) {
			System.out.println(" saveNews() error  ~ : ");
		}finally {
			common.close(connection, ps, rs);
		}
		return result;
	}
	
	//getNewsList
	public ArrayList<news_dto> getNewsList(String gubun, String search) {
		String query = "";
		ArrayList<news_dto> arr = new ArrayList<>();
		if(gubun.equals("all"))query = "select no, title, content, reg_name, to_char(reg_date, 'yyyy-MM-dd'), hit from h05_news ORDER BY no desc";
		else if(gubun.equals("title") || gubun.equals("content")){
			query = "select no, title, content, reg_name, to_char(reg_date, 'yyyy-MM-dd'), hit from h05_news where "+gubun+" like '%"+search+"%' ORDER BY no desc";
		}else if(gubun.equals("view")){
			query = "select no, title, content, reg_name, to_char(reg_date, 'yyyy-MM-dd'), hit from h05_news where no = '"+search+"' ORDER BY no desc";
		}try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getNString(1);
				String title = rs.getNString(2);
				String content = rs.getNString(3);
				String reg_name = rs.getNString(4);
				String reg_date = rs.getNString(5);
				int hit = rs.getInt(6);
			
				news_dto dto = new news_dto(no, title, content, reg_name, reg_date, hit);
				arr.add(dto);
				
			}
		}catch(SQLException se){
			System.out.println(" getNewsList() query error~ " + query);
		}catch(Exception e) {
			System.out.println(" getNewsList() error  ~ : ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
	
	public news_dto getNewsView(String no) {
		news_dto dto = null;
		String query =" select no, title, content, reg_name, \r\n" + 
					  "        to_char(reg_date,'yyyy-MM-dd'), hit \r\n" + 
					  " from h05_news \r\n" + 
					  " where no ='"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			if(rs.next()) {
				String nn 		= rs.getString(1);
				String title 	= rs.getString(2);
				String content  = rs.getString(3);
				String reg_name = rs.getString(4);
				String reg_date = rs.getString(5);
				int hit 		= rs.getInt(6);
				dto = new news_dto(no,title,content,reg_name,reg_date,hit);
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

	//숫자
	public int hitAdd(String search) {
		int result = 0;
		String query="update h05_news\r\n" + 
				"set hit = hit + 1\r\n" + 
				"where no = '"+search+"'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se){
			System.out.println(" saveNews() query error~ " + query);
		}catch(Exception e) {
			System.out.println(" saveNews() error  ~ : ");
		}finally {
			common.close(connection, ps, rs);
		}
		return result;
	}
	
	//수정
	public int updateNews(String no, String title, String content, String reg_name, String reg_date) {
		int result = 0;
		String query="UPDATE h05_news \r\n" + 
				"SET title = '"+title+"',\r\n" + 
				"    content = '"+content+"',\r\n" + 
				"    reg_name = '"+reg_name+"',\r\n" + 
				"    reg_date = '"+reg_date+"'\r\n" + 
				"where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se){
			System.out.println(" saveNews() query error~ " + query);
		}catch(Exception e) {
			System.out.println(" saveNews() error  ~ : ");
		}finally {
			common.close(connection, ps, rs);
		}
		return result;
	}
}
