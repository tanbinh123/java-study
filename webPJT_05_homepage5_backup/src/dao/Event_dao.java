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
	DBConnectionOracle common= new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps  = null;
	ResultSet         rs  = null;
	// ����
	public int deleteEvent(String no) {
		int result =0;
		String query =" delete from h05_Event \r\n" + 
					  " where no ='"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("deleteEvent() query ?���?: "+query);
		}catch(Exception ee) {
			System.out.println("deleteEvent() ?���?");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	// ����
	public int updateEvent(Event_dto dto) {
		int result =0;
		String query ="update h05_Event \r\n" + 
				"set title='"+dto.getTitle()+"', \r\n" + 
				"    content='"+dto.getContent()+"', \r\n" + 
				"    s_date ='"+dto.getS_date()+"', \r\n" + 
				"    e_date ='"+dto.getE_date()+"', \r\n" + 
				"    reg_name ='"+dto.getReg_name()+"', \r\n" + 
				"    reg_date ='"+dto.getReg_date()+"' \r\n" + 
				"where no ='"+dto.getNo()+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("updateEvent() query ?���?: "+query);
		}catch(Exception ee) {
			System.out.println("updateEvent() ?���?");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	
	// ��ȸ�� ����
	public void setHitCount(String no) {
		String query=" update h05_Event set hit = hit + 1\r\n" + 
					 " where no='"+no+"' ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			ps.executeUpdate();		
		}catch(SQLException se) {
			System.out.println("setHitCount() query ?���?: "+query);
		}catch(Exception ee) {
			System.out.println("setHitCount() ?���?");
		}finally {
			common.close(connection, ps, rs);
		}				
	}	
	
	//��ȸ
	public Event_dto getEventView(String no){
		Event_dto dto = null; 
		String query =" select no, title, content, to_char(s_date,'yyyy-MM-dd'),to_char(e_date,'yyyy-MM-dd') , reg_name, to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
						" from h05_Event\r\n" + 
						" where no ='"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String nn 		= rs.getString(1);
				String title 	= rs.getString(2);
				String content 	= rs.getString(3);
				String s_date 	= rs.getString(4);
				String e_date 	= rs.getString(5);
				String reg_name = rs.getString(6);
				String reg_date = rs.getString(7);
				int hit 		= rs.getInt(8);
				dto = new Event_dto(nn,title,content,s_date,e_date,reg_name,reg_date,hit);
			}
		}catch(SQLException se) {
			System.out.println("getEventView() query ����: "+query);
		}catch(Exception ee) {
			System.out.println("getEventView() ����");
		}finally {
			common.close(connection, ps, rs);
		}				
		return dto;
	}
	
	//����Ʈ ��ȸ
	public ArrayList<Event_dto> getEventList(String select,String search){
		ArrayList<Event_dto> arr = new ArrayList<Event_dto>();
		String query =" select no, title, content,to_char(s_date,'yyyy-MM-dd'),to_char(e_date,'yyyy-MM-dd') , reg_name, to_char(reg_date,'yyyy-MM-dd'), hit\r\n" + 
					  " from h05_Event\r\n" + 
				      " where "+select+" like '%"+search+"%' "+
					  " order by no desc";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			while(rs.next()) {
				String no 		= rs.getString(1);
				String title 	= rs.getString(2);
				String content 	= rs.getString(3);
				String s_date 	= rs.getString(4);
				String e_date 	= rs.getString(5);
				String reg_name = rs.getString(6);
				String reg_date = rs.getString(7);
				int hit 		= rs.getInt(8);
				Event_dto dto = new Event_dto(no,title,"",s_date,e_date,
												reg_name,reg_date,hit);
				arr.add(dto);
			}			
		}catch(SQLException se) {
			System.out.println("getEventList() query ����: "+query);
		}catch(Exception ee) {
			System.out.println("getEventList() ����");
		}finally {
			common.close(connection, ps, rs);
		}		
		
		return arr;
	}
	
	// ?���?
	public int saveEvent(Event_dto dto) {
		int result =0;
		String query ="insert into h05_Event \r\n" + 
				"(no,title,content,s_date,e_date,reg_name,reg_date) \r\n" + 
				"values \r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getContent()+"','"+dto.getS_date()+"','"+dto.getE_date()+"','"+dto.getReg_name()+"','"+dto.getReg_date()+"')";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("saveEvent() query ?���?: "+query);
		}catch(Exception ee) {
			System.out.println("saveEvent() ?���?");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	
	// 번호?��?��
	public String getEventNo() {
		String maxNo="";
		String query=" select max(no) from h05_Event ";
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
				maxNo = "E"+newNo; // 
			}
		}catch(SQLException se) {
			System.out.println("getEventNo() query ?���?: "+query);
		}catch(Exception ee) {
			System.out.println("getEventNo() ?���?");
		}finally {
			common.close(connection, ps, rs);
		}		
		return maxNo;
	}		
}







