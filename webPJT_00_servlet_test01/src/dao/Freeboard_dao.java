package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Freeboard_dto;


public class Freeboard_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//news_list파일 전체 목록 보여주기
	public ArrayList<Freeboard_dto> savefreeList(String select, String search){
		ArrayList<Freeboard_dto> arr = new ArrayList<>();
		String query = "select a.no, a.title, b.name, to_char(a.reg_date, 'yyyy-MM-dd'), a.hit \r\n" + 
					   "from h00_freeboard a, h00_member b\r\n" + 
					   "where a."+select+" like '%"+search+"%' \r\n" + 
					   "and a.reg_id = b.id\r\n" + 
					   "order by no desc";
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			rs 			= ps.executeQuery();
			while(rs.next()) {
				String no		 = rs.getString(1);
				String title	 = rs.getString(2);
				String reg_id  	 = rs.getString(3);
				String reg_date  = rs.getString(4);
				int hit 		 = rs.getInt(5);
				Freeboard_dto dto = new Freeboard_dto(no, title, "", reg_id, reg_date, hit);
				arr.add(dto);
			}
		}catch(SQLException se) {
			System.out.println("savefreeList() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("savefreeList() 오류");
		}finally {
			common.close(connection, ps, rs);
		}
		return arr;
	}
	
	//news_view파일 hit카운트 하기
	public void getfreehit(String no) {
		String query = "UPDATE h00_freeboard\r\n" + 
					   "SET hit = hit +1\r\n" + 
					   "where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			ps.executeUpdate(); 
			//int result = ps.executeUpdate(); /*위에 것과 동일 어차피 리턴 안해도 되니까*/
		}catch(SQLException se) {
			System.out.println("getfreehit() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getfreehit() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
		
	}
	
	//news_view파일 목록 보여주기
	public Freeboard_dto freeView(String no) {
		Freeboard_dto dto = null;
		String query = "select a.no, a.title, a.content, b.name, to_char(a.reg_date, 'yyyy-MM-dd'), a.hit \r\n" + 
					   "from h00_freeboard a, h00_member b\r\n" + 
					   "where no = '"+no+"'\r\n" + 
					   "and a.reg_id = b.id";
		System.out.println(query);
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			rs 			= ps.executeQuery();
			while(rs.next()) {
				String nn		 = rs.getString(1);
				String title	 = rs.getString(2);
				String content	 = rs.getString(3);
				String reg_id  = rs.getString(4);
				String reg_date  = rs.getString(5);
				int hit 		 = rs.getInt(6);
				dto = new Freeboard_dto(no, title, content, reg_id, reg_date, hit);
			}
		}catch(SQLException se) {
			System.out.println("freeView() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("freeView() 오류");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return dto;
	}
	
	//db_save파일 No를 만들기
	public String getfreeNo() {
		String maxNo="";
		String query="select max(no) from h00_freeboard";
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
			System.out.println("getfreeNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getfreeNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return maxNo;
	}
	
	//db_save파일 sql파일에 행 삽입
	public int getfreeSave(Freeboard_dto dto) {
		int result = 0;
		String query = " insert into h00_freeboard(no, title, content, reg_id, reg_date)\r\n" + 
					   " values('"+dto.getNo()+"','"+dto.getTitle()+"', '"+dto.getContent()+"', '"+dto.getReg_id()+"', '"+dto.getReg_date()+"')";
		//System.out.println(query);
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result = ps.executeUpdate(); 
			//int result = ps.executeUpdate(); /*위에 것과 동일 어차피 리턴 안해도 되니까*/
		}catch(SQLException se) {
			System.out.println("getfreeSave() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getfreeSave() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
		return result;		
	}
	
	//db_save파일 sql파일에 행 수정
	public int getfreeUpdate(Freeboard_dto dto) {
		int result = 0;
		String query = " update h00_freeboard\r\n" + 
					   " set title = '"+dto.getTitle()+"',\r\n" + 
					   "     content = '"+dto.getContent()+"',\r\n" + 
					   "     reg_id = '"+dto.getReg_id()+"',\r\n" + 
					   "     reg_date = '"+dto.getReg_date()+"'\r\n" + 
					   " where no = '"+dto.getNo()+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result = ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("getfreeUpdate() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getfreeUpdate() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
		return result;		
	}
	
	
	//db_save파일 sql파일에 행 삭제
	public int getfreeDelete(String no) {
		int result = 0;
		String query = " delete h00_freeboard\r\n" + 
					   " where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result = ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("getfreeDelete() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getfreeDelete() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
		return result;		
	}
	
	//조회수 증가
	public void setHitCount(String no) {
		String query = " update h00_freeboard\r\n" + 
					   " set hit = hit + 1\r\n" + 
					   " where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			ps.executeUpdate(); 
			//int result = ps.executeUpdate(); /*위에 것과 동일 어차피 리턴 안해도 되니까*/
		}catch(SQLException se) {
			System.out.println("sethitCount() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("sethitCount() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
	}
}
