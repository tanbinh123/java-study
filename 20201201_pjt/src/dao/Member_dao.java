package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionOracle;
import dto.Member_dto;

public class Member_dao {
	DBConnectionOracle common= new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps  = null;
	ResultSet         rs  = null;

	// 회원 비밀번호 찾기
	public String idMemberCheck(String id, String tel_1,String tel_2,String tel_3){
		String pw ="";
		String query =" select pw from h00_member \r\n" + 
					  " where id ='"+id+"' \r\n" + 
					  "    and tel_1='"+tel_1+"' \r\n" + 
					  "    and tel_2='"+tel_2+"' \r\n" + 
					  "    and tel_3='"+tel_3+"'  ";
		
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			
			if(rs.next()) pw = rs.getString(1);
			
		}catch(SQLException se) {
			System.out.println("idMemberCheck() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("idMemberCheck() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		return pw;
	}
	
	// id 중복검사
	public int idCheckCount(String id){
		int count = 0;
		String query=" select count(*) from h00_member \r\n" + 
					 " where id ='"+id+"' ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			if(rs.next()) count = rs.getInt(1);
		}catch(SQLException se) {
			System.out.println("idCheckCount() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("idCheckCount() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		return count;
	}
	
	
	
	// 로그인
	public String getLoginName(String id, String pw){
		String name= null;
		String query=" select name from h00_member \r\n" + 
					 " where id ='"+id+"' \r\n" + 
					 " and pw='"+pw+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			if(rs.next()) {
				name = rs.getString(1);
			}
			
		}catch(SQLException se) {
			System.out.println("getLoginName() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getLoginName() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		
		return name;
	}
	
	
	// 회원가입
	public int saveMember(Member_dto dto) {
		int result =0;
		String query =" insert into h00_member \r\n" + 
				" (id,name,pw,area,address,tel_1,tel_2,tel_3,mf, \r\n" + 
				" hobby_t,hobby_r,hobby_s,reg_date) \r\n" + 
				"values \r\n" + 
				"('"+dto.getId()+"','"+dto.getName()+"','"+dto.getPw()+"','"+dto.getArea()+"','"+dto.getAddress()+"','"+dto.getTel_1()+"','"+dto.getTel_2()+"','"+dto.getTel_3()+"',\r\n" + 
				"'"+dto.getMf()+"','"+dto.getHobby_t()+"','"+dto.getHobby_r()+"','"+dto.getHobby_s()+"','"+dto.getReg_date()+"') ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("saveMember() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("saveMember() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}	
}








