package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Notice_dto;

public class Notice_dao {
	DBConnectionOracle common= new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps  = null;
	ResultSet         rs  = null;
	
	//목록조회 index 용
	public ArrayList<Notice_dto> getIndexNotice(){
		ArrayList<Notice_dto> arr = new ArrayList<Notice_dto>();
		String query =" select rownum, no, title, reg_date \r\n" + 
				" from( \r\n" + 
				"    select no, title, to_char(reg_date,'yy-MM-dd') as reg_date \r\n" + 
				"    from h00_notice \r\n" + 
				"    order by no desc) \r\n" + 
				" where rownum <= 7  ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			while(rs.next()) {
				String rownum	= rs.getString(1);
				String no 		= rs.getString(2);
				String title 	= rs.getString(3);
				String reg_date = rs.getString(4);
				
				Notice_dto dto = new Notice_dto(no,title,reg_date,rownum);
				arr.add(dto);
			}			
		}catch(SQLException se) {
			System.out.println("getIndexNotice() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getIndexNotice() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		
		return arr;
	}
	
	
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
	
	// 수정
	public int updateNotice(Notice_dto dto) {
		int result =0;
		String query ="update h00_notice \r\n" + 
				"set title='"+dto.getTitle()+"', \r\n" + 
				"    content='"+dto.getContent()+"', \r\n" + 
				"    attach ='"+dto.getAttach()+"', \r\n" + 
				"    reg_name ='"+dto.getReg_name()+"', \r\n" + 
				"    reg_date ='"+dto.getReg_date()+"' \r\n" + 
				"where no ='"+dto.getNo()+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("updateNotice() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("updateNotice() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	
	// 조회수 증가
	public void setHitCount(String no) {
		String query=" update h00_notice set hit = hit + 1\r\n" + 
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
	public Notice_dto getNoticeView(String no){
		Notice_dto dto = null; 
		String query =" select no, title, content, attach , reg_name, to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
						" from h00_notice\r\n" + 
						" where no ='"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String nn 		= rs.getString(1);
				String title 	= rs.getString(2);
				String content 	= rs.getString(3);
				String attach 	= rs.getString(4);
				String reg_name = rs.getString(5);
				String reg_date = rs.getString(6);
				int hit 		= rs.getInt(7);
				dto = new Notice_dto(nn,title,content,attach,
												reg_name,reg_date,hit);
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
	
	//목록조회
	public ArrayList<Notice_dto> getNoticeList(String select,String search){
		ArrayList<Notice_dto> arr = new ArrayList<Notice_dto>();
		String query =" select no, title, attach, reg_name, to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
					  " from h00_notice\r\n" + 
				      " where "+select+" like '%"+search+"%' "+
					  " order by no desc";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			while(rs.next()) {
				String no 		= rs.getString(1);
				String title 	= rs.getString(2);
				String attach 	= rs.getString(3);
				String reg_name = rs.getString(4);
				String reg_date = rs.getString(5);
				int hit 		= rs.getInt(6);
				Notice_dto dto = new Notice_dto(no,title,"",attach,
												reg_name,reg_date,hit);
				arr.add(dto);
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
	
	// 등록
	public int saveNotice(Notice_dto dto) {
		int result =0;
		String query ="insert into h00_notice \r\n" + 
				"(no,title,content,attach,reg_name,reg_date) \r\n" + 
				"values \r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getAttach()+"','"+dto.getReg_name()+"','"+dto.getReg_date()+"')";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("saveNotice() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("saveNotice() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	
	// 번호생성
	public String getNoticeNo() {
		String maxNo="";
		String query=" select max(no) from h00_notice ";
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
			System.out.println("getNoticeNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNoticeNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return maxNo;
	}		
}







