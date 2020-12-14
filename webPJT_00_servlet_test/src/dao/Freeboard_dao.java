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
		
	//Freeboard_list파일 전체 목록 보여주기
	public ArrayList<Freeboard_dto> getFreeboardList(String select, String search){
		ArrayList<Freeboard_dto> arr = new ArrayList<>();
		String query = "select b.no, b.title, b.reg_id, to_char(b.reg_date, 'yyyy-MM-dd'), b.hit, a.name\r\n" + 
				"from h05_member a, h05_freeboard b\r\n" + 
				"where a.id = b.reg_id\r\n" +  
				"and "+select+" like '%"+search+"%' order by no desc;";
		try {
			connection 	= common.getConnection();
			ps 			= connection.prepareStatement(query);
			rs 			= ps.executeQuery();
			while(rs.next()) {
				String no		 = rs.getString(1);
				String title	 = rs.getString(2);
				String reg_id  = rs.getString(3);
				String reg_date  = rs.getString(4);
				int hit 		 = rs.getInt(5);
				String reg_name = rs.getString(6);
				Freeboard_dto dto = new Freeboard_dto(no, title, "", reg_name, reg_date,reg_id, hit);
				arr.add(dto);
			}
		}catch(SQLException se) {
			System.out.println("getFreeboardList() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getFreeboardList() 오류");
		}finally {
			common.close(connection, ps, rs);
		}
		return arr;
	}
	
	//Freeboard_view파일 hit카운트 하기
	public void getFreeboardhit(String no) {
		String query = "UPDATE h05_freeboard\r\n" + 
					   "SET hit = hit +1\r\n" + 
					   "where no = '"+no+"'";
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
	
	//Freeboard_view파일 목록 보여주기
	public Freeboard_dto FreeboardView(String no) {
		Freeboard_dto dto = null;
		String query = " select b.no, b.title, b.content, b.reg_id, to_char(b.reg_date, 'yyyy-MM-dd'), b.hit, a.name \r\n" + 
					   " from h05_member a, h05_freeboard b\r\n" + 
					   " where a.id = b.reg_id"
					   + "and b.reg_id = a.id"
					   + "no = '"+no+"'";
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
				String reg_name = rs.getString(7);
				dto = new Freeboard_dto(no, title, content, reg_name, reg_date,reg_id, hit);
			}
		}catch(SQLException se) {
			System.out.println("FreeboardView() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("FreeboardView() 오류");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return dto;
	}
	
	//db_save파일 No를 만들기
	public String getFreeboardNo() {
		String maxNo="";
		String query=" select max(no) from h05_freeboard ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery(); //select는  executeQuery이고 리턴 타입은 result set이다
			if(rs.next()) {
				maxNo = rs.getString(1);
			}
			if(maxNo == null) {
				maxNo ="W001";
			}else {
				String n = maxNo.substring(1); 
				int i = Integer.parseInt(n); 
				i = i + 1; 
				DecimalFormat df = new DecimalFormat("000");
				String newNo = df.format((double)i);
				maxNo = "W"+newNo; 
			}
		}catch(SQLException se) {
			System.out.println("getFreeboardNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getFreeboardNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return maxNo;
	}
	
	//db_save파일 sql파일에 행 삽입
	public int getFreeboardSave(Freeboard_dto dto) {
		int result = 0;
		String query = " insert into h05_freeboard(no, title, content, reg_name, reg_date)\r\n" + 
					   " values('"+dto.getNo()+"','"+dto.getTitle()+"', '"+dto.getContent()+"', '"+dto.getReg_name()+"', '"+dto.getReg_date()+"')";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result = ps.executeUpdate(); 
			//int result = ps.executeUpdate(); /*위에 것과 동일 어차피 리턴 안해도 되니까*/
		}catch(SQLException se) {
			System.out.println("getFreeboardSave() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getFreeboardSave() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
		return result;		
	}
	
	//db_save파일 sql파일에 행 수정
	public int getFreeboardUpdate(Freeboard_dto dto) {
		int result = 0;
		String query = " update h05_freeboard\r\n" + 
					   " set title = '"+dto.getTitle()+"',\r\n" + 
					   "     content = '"+dto.getContent()+"',\r\n" + 
					   "     reg_name = '"+dto.getReg_name()+"',\r\n" + 
					   "     reg_date = '"+dto.getReg_date()+"'\r\n" + 
					   " where no = '"+dto.getNo()+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result = ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("getFreeboardUpdate() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getFreeboardUpdate() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
		return result;		
	}
	
	
	//db_save파일 sql파일에 행 삭제
	public int getFreeboardDelete(String no) {
		int result = 0;
		String query = " delete h05_freeboard\r\n" + 
					   " where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result = ps.executeUpdate(); 
		}catch(SQLException se) {
			System.out.println("getFreeboardDelete() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getFreeboardDelete() 오류");
		}finally {
			common.close(connection, ps, rs);
		}	
		return result;		
	}
	
	//조회수 증가
	public void setHitCount(String no) {
		String query = " update h17_qna\r\n" + 
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
