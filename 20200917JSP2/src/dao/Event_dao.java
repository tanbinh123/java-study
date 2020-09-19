package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Event_dto;

public class Event_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection 	  = null;
	PreparedStatement ps 	  = null;
	ResultSet rs 			  = null;

	public ArrayList<Event_dto> getEventList(String select, String search){
		ArrayList<Event_dto> arr = new ArrayList<>();
		String query =" select no,title,to_char(s_date,'YYYY-MM-DD'),to_char(e_date,'YYYY-MM-DD'),reg_name,to_char(reg_date,'YYYY-MM-DD'),hit \r\n" + 
					" from h05_event \r\n" + 
					" where "+select+" like '%"+search+"%'"+
					" order by no desc";
		try {
			connection = common.getConnection();
			ps         = connection.prepareStatement(query);
			rs         = ps.executeQuery();
			while(rs.next()) {
				String no 		= rs.getString(1);
				String title 	= rs.getString(2);
				String s_date 	= rs.getString(3);
				String e_date 	= rs.getString(4);
				String reg_name = rs.getString(5);
				String reg_date = rs.getString(6);
				int hit 		= rs.getInt(7);
				Event_dto dto = new Event_dto(no,title,"",s_date,e_date,reg_name,reg_date,hit);
				arr.add(dto);
			}
		}catch(SQLException se) {
			System.out.println("getEventList() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getEventList() 오류");
		}finally {
			common.close(connection, ps, rs);
		}						
		
		return arr;
	}
	
	public int eventSave(Event_dto dto) {
		int result =0;
		String query ="insert into h05_event \r\n" + 
				"(no,title,content,s_date,e_date,reg_name,reg_date) \r\n" + 
				"values \r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getS_date()+"','"+dto.getE_date()+"','"+dto.getReg_name()+"','"+dto.getReg_date()+"')";
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
	
	
	public String getEventNo() {
		String maxNo="";
		String query=" select max(no) from h05_event ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				maxNo = rs.getString(1);
			}
			if(maxNo == null) {
				maxNo ="E0001";
			} else {
				String n = maxNo.substring(1); 
				int i = Integer.parseInt(n); 
				i = i + 1;
				DecimalFormat df = new DecimalFormat("0000");
				String newNo = df.format((double)i);
				maxNo = "E"+newNo; // 
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
	
	public Event_dto getEventView(String no) {
		Event_dto dto = null;
		String query = "SELECT title, content, to_char(s_date, 'YYYY-MM-DD'),to_char(e_date, 'YYYY-MM-DD'),reg_name,to_char(reg_date, 'YYYY-MM-DD'), hit\r\n" + 
				"FROM h05_event\r\n" + 
				"where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps         = connection.prepareStatement(query);
			rs         = ps.executeQuery();
			if(rs.next()) {
				String title 	= rs.getString(1);
				String content 	= rs.getString(2);
				String s_date	= rs.getString(3);
				String e_date = rs.getString(4);
				String reg_name = rs.getString(5);
				String reg_date = rs.getString(6);
				int hit 		= rs.getInt(7);
				dto = new Event_dto(no,title,content,s_date,e_date,reg_name,reg_date,hit);
			}
		}catch(SQLException se) {
			System.out.println("getEventView() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getEventView() 오류");
		}finally {
			common.close(connection, ps, rs);
		}					
		return dto;
	}
	
	public void hitCount(String no) {
		String query = "update h05_event set hit = hit + 1 where no = '"+no+"'";
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
	
	public int eventUpdate(Event_dto dto) {
		int result =0;
		String query ="update h05_event set title = '"+dto.getTitle()+"',content = '"+dto.getContent()+"',s_date = '"+dto.getS_date()+"' ,e_date = '"+dto.getE_date()+"',reg_name = '"+dto.getReg_name()+"',reg_date = '"+dto.getReg_date()+"' where no = '"+dto.getNo()+"'";
		try {
			connection = common.getConnection();
			ps         = connection.prepareStatement(query);
			result     = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("eventUpdate() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("eventUpdate() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		return result;
	}
	
	public int deleteEvent(String no) {
		int result =0;
		String query ="DELETE FROM h05_event WHERE no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps         = connection.prepareStatement(query);
			result     = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("deleteEvent() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("deleteEvent() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		return result;
	}

}
