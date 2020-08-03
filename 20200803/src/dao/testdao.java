package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.testDB_dto;

public class testdao {
	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//select, insert, update, delete 통합
	String query = "";
	public ArrayList<testDB_dto> selectlDB(int gubun,int selectgubun, int setEmpno, String setEname, String setJob,String setSal,String setDname, int whereno){
		ArrayList<testDB_dto> arr = new ArrayList<>();
			if (selectgubun == 1)query = "select a.empno, a.ename, a.job, a.sal, b.dname from emp a, dept b where a.deptno=b.deptno";
			else if(selectgubun == 2)query = "select a.empno, a.ename, a.job, a.sal, b.dname from emp a, dept b where a.deptno=b.deptno and a.empno = '"+whereno+"'";
			else if(selectgubun == 3)query = "select a.empno, a.ename, a.job, a.sal, b.dname from emp a, dept b where a.deptno=b.deptno and a.ename like '%"+setEname+"%'";
			else if(selectgubun == 4)query = "select a.empno, a.ename, a.job, a.sal, b.dname from emp a, dept b where a.deptno=b.deptno and b.dname like '%"+setDname+"%'";
		try{
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
	
				while(rs.next()) {
					String empno = rs.getString("empno");//name
					String ename = rs.getString("ename");//3
					String job = rs.getString("job");//4
					int sal = rs.getInt("sal");//4
					String dname = rs.getString("dname");//4
					
					testDB_dto dto = new testDB_dto(sal, empno, ename, job, dname);
					arr.add(dto);
			}	
		}catch(SQLException se){
			System.out.println("getListAll() SQL query 오류" + query);
		}catch(Exception e){
			System.out.println("getListAll() 오류");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}
/*
	//select, insert, update, delete 통합
	String query = "";
	public ArrayList<testDB_dto> allControlDB(int gubun,int selectgubun, int setEmpno, String setEname, String setJob,String setSal,String setDname, int whereno){
		ArrayList<testDB_dto> arr = new ArrayList<>();
		if (gubun == 1) {
			if (selectgubun == 1)query = "select a.empno, a.ename, a.job, a.sal, b.dname from emp a, dept b where a.deptno=b.deptno";
			else if(selectgubun == 2)query = "select a.empno, a.ename, a.job, a.sal, b.dname from emp a, dept b where a.deptno=b.deptno and a.empno = '"+whereno+"'";
			else if(selectgubun == 3)query = "select a.empno, a.ename, a.job, a.sal, b.dname from emp a, dept b where a.deptno=b.deptno and a.ename like '%"+setEname+"%'";
			else if(selectgubun == 4)query = "select a.empno, a.ename, a.job, a.sal, b.dname from emp a, dept b where a.deptno=b.deptno and b.dname like '%"+setDname+"%'";
		}
		else if (gubun == 2)query = "insert into emp VALUES ("+setEmpno+",'"+ setEname +"','" + setJob+"','" + setSal+"','" + setDname+"')";
		else if (gubun == 3)query = "update emp set empno = "+setEmpno+", ename = '"+ setEname +"', job = '" + setJob+"' where empno ="+whereno;
		else if (gubun == 4)query = "delete from emp where empno = " + setEmpno;
		try{
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
	
			if(gubun == 1) {
				while(rs.next()) {
					String empno = rs.getString("empno");//name
					String ename = rs.getString("ename");//3
					String job = rs.getString("job");//4
					int sal = rs.getInt("sal");//4
					String dname = rs.getString("dname");//4
					
					testDB_dto dto = new testDB_dto(sal, empno, ename, job, dname);
					arr.add(dto);
				}
			}	
		}catch(SQLException se){
			System.out.println("getListAll() SQL query 오류" + query);
		}catch(Exception e){
			System.out.println("getListAll() 오류");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr;
	}*/
}
