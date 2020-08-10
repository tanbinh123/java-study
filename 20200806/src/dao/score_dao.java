package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.score_dto;

public class score_dao {

	public int getTotal(int kor, int eng, int mat) {
		int total = kor + eng + mat;
		return total;
	}
	
	public int getAva(int total, int su) {
		int ava = total/su;
		return ava;
	}
	
	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String query = "";
	public ArrayList<score_dto> selectDB(String serchNo, String serchName) {
		ArrayList<score_dto> arr = new ArrayList<>();
		if(serchNo.equals("") && serchName.equals(""))query = "select * from t05_score";
		else if(serchNo.equals(serchNo) && serchName.equals(""))query = "select * from t05_score where no like '%"+serchNo+"%'";
		else if(serchNo.equals("") && serchName.equals(serchName))query = "select * from t05_score where name like '%"+serchName+"%'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getNString(1);
				String name = rs.getNString(2);
				int kor = rs.getInt(3);
				int eng = rs.getInt(4);
				int mat = rs.getInt(5);
				int total = rs.getInt(6);
				int ava = rs.getInt(7);
			
				score_dto dto = new score_dto(no,name,kor,eng,mat,total,ava);
				arr.add(dto);
				
			}
		}catch(SQLException se){
			System.out.println(" insertDB() query error~ " + query);
		}catch(Exception e) {
			System.out.println(" insertDB() error  ~ : ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
	
	
	public int insertDB(String no, String name, int kor, int eng, int mat) {
		int result = 0;
		String query = "insert into t05_score values ('"+no+"','"+name+"',"+kor+","+eng+","+mat+","+getTotal(kor, eng , mat)+","+getAva(getTotal(kor,eng,mat),3)+")";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se){
			System.out.println(" insertDB() query error~ " + query);
		}catch(Exception e) {
			System.out.println(" insertDB() error  ~ : ");
		}finally {
			common.close(connection, ps, rs);
		}
		return result;
		}
		
	public int updateDB(String no, String name, int kor, int eng, int mat) {
		int result = 0;
		String query = "update t05_score set name = '"+name+"', kor = "+kor+", eng = "+eng+", mat = "+mat+",total = "+getTotal(kor, eng , mat)+",ava = "+getAva(getTotal(kor,eng,mat),3)+"where no = '"+no+"'";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se){
			System.out.println(" insertDB() query error~ " + query);
		}catch(Exception e) {
			System.out.println(" insertDB() error  ~ : ");
		}finally {
			common.close(connection, ps, rs);
		}
		return result;
		}
		
		public int deleteDB(String no) {
			int result = 0;
			String query = "delete from t05_score where no = '"+no+"'";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				result = ps.executeUpdate();
			}catch(SQLException se){
				System.out.println(" insertDB() query error~ " + query);
			}catch(Exception e) {
				System.out.println(" insertDB() error  ~ : ");
			}finally {
				common.close(connection, ps, rs);
			}
		
		
		
		return result;
	}
	
	

}
