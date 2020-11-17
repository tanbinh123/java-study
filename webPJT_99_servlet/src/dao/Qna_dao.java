package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Qna_dto;

public class Qna_dao {
	DBConnectionOracle common= new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps  = null;
	ResultSet         rs  = null;
	
	//삭제
	public int deleteQna(String no) {
		int result =0;
		String query =" delete from h05_Qna2 \r\n" + 
					  " where no ='"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("deleteQna() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("deleteQna() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	// 수정
	public int updateQna(Qna_dto dto) {
		int result =0;
		String query ="update h05_Qna2 \r\n" + 
				"set title ='"+dto.getTitle()+"', \r\n" + 
				"content ='"+dto.getContent()+"' \r\n" + 
				"where no ='"+dto.getNo()+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("updateQna() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("updateQna() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	
	// 조회수 증가
	public void setHitCount(String no) {
		String query=" update h05_Qna2 set hit = hit + 1\r\n" + 
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
	public Qna_dto getQnaView(String no){
		Qna_dto dto = null; 
		String query ="select no,title,groupno,depth,to_char(reg_date,'yyyy-MM-dd'),reg_name,hit,content,seg from h05_Qna2"+
						" where no ='"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String nn 		= rs.getString(1);
				String title 	= rs.getString(2);
				String groupno 	= rs.getString(3);
				int depth 		= rs.getInt(4);
				String reg_date = rs.getString(5);
				String reg_name = rs.getString(6);
				int hit 		= rs.getInt(7);
				String content	= rs.getString(8);
				int seg 		= rs.getInt(9);
				dto = new Qna_dto(nn, title, groupno, reg_date, reg_name, content, depth, seg, hit);
				
			}
		}catch(SQLException se) {
			System.out.println("getQnaView() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getQnaView() 오류");
		}finally {
			common.close(connection, ps, rs);
		}				
		return dto;
	}
	
	//목록조회
	public ArrayList<Qna_dto> getQnaList(String select,String search){
		ArrayList<Qna_dto> arr = new ArrayList<Qna_dto>();
		String query ="select no,title,groupno,depth,to_char(reg_date,'yyyy-MM-dd'),reg_name,hit,content,seg from h05_Qna2 where "+select+" like '%"+search+"%' order by groupno desc, depth asc";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			while(rs.next()) {
				String no 		= rs.getString(1);
				String title 	= rs.getString(2);
				String groupno 	= rs.getString(3);
				int depth 		= rs.getInt(4);
				String reg_date = rs.getString(5);
				String reg_name = rs.getString(6);
				int hit 		= rs.getInt(7);
				String content	= "";
				int seg 		= rs.getInt(9);
				Qna_dto dto = new Qna_dto(no, title, groupno, reg_date, reg_name, content, depth, seg, hit);
				arr.add(dto);
			}			
		}catch(SQLException se) {
			System.out.println("getQnaList() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getQnaList() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		
		return arr;
	}
	
	// 등록
	public int saveQna(Qna_dto dto) {
		int result =0;
		String query ="insert into h05_Qna2 \r\n" + 
				"(no,title,groupno,reg_date,reg_name,content,depth,seg,hit) \r\n" + 
				"values \r\n" + 
				"('"+dto.getNo()+"','"+dto.getTitle()+"','"+dto.getGroupno()+"','"+dto.getReg_date()+"','"+dto.getReg_name()+"','"+dto.getContent()+"','"+dto.getDepth()+"','"+dto.getSeg()+"','"+dto.getHit()+"')";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("saveQna() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("saveQna() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return result;
	}
	
	// depth번호생성
		public int getDepth() {
			int depth = 0;
			String query=" select max(depth) from h05_Qna2 ";
			try {
				connection = common.getConnection();
				ps  = connection.prepareStatement(query);
				rs  = ps.executeQuery();
				if(rs.next()) {
					depth = rs.getInt(1);
				}
				if(depth == 0) {
					depth = 1;
				} else {
					depth += 1;
				}
			}catch(SQLException se) {
				System.out.println("getQnaNo() query 오류: "+query);
			}catch(Exception ee) {
				System.out.println("getQnaNo() 오류");
			}finally {
				common.close(connection, ps, rs);
			}		
			return depth;
		}	
		
	
	// 번호생성
	public String getQnaNo() {
		String maxNo="";
		String query=" select max(no) from h05_Qna2 ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				maxNo = rs.getString(1);
			}
			if(maxNo == null) {
				maxNo ="Q001";
			} else {
				String n = maxNo.substring(1); 
				int i = Integer.parseInt(n); 
				i = i + 1;
				DecimalFormat df = new DecimalFormat("000");
				String newNo = df.format((double)i);
				maxNo = "Q"+newNo; // 
			}
		}catch(SQLException se) {
			System.out.println("getQnaNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getQnaNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return maxNo;
	}		
	
	// 그룹 번호생성
		public String getGroupNo() {
			String maxNo="";
			String query=" select max(groupno) from h05_Qna2 ";
			try {
				connection = common.getConnection();
				ps  = connection.prepareStatement(query);
				rs  = ps.executeQuery();
				if(rs.next()) {
					maxNo = rs.getString(1);
				}
				if(maxNo == null) {
					maxNo ="G001";
				} else {
					String n = maxNo.substring(1); 
					int i = Integer.parseInt(n); 
					i = i + 1;
					DecimalFormat df = new DecimalFormat("000");
					String newNo = df.format((double)i);
					maxNo = "G"+newNo; // 
				}
			}catch(SQLException se) {
				System.out.println("getGroupNo() query 오류: "+query);
			}catch(Exception ee) {
				System.out.println("getGroupNo() 오류");
			}finally {
				common.close(connection, ps, rs);
			}		
			return maxNo;
		}	
		
		
		
		// 수정
		public int getUpdateDepth(int depth) {
			int result =0;
			String query ="update h05_qna2 set depth = depth + 1 where depth >= "+depth;
			try {
				connection = common.getConnection();
				ps  = connection.prepareStatement(query);
				result  = ps.executeUpdate();			
			}catch(SQLException se) {
				System.out.println("updateQna() query 오류: "+query);
			}catch(Exception ee) {
				System.out.println("updateQna() 오류");
			}finally {
				common.close(connection, ps, rs);
			}		
			return result;
		}
}
