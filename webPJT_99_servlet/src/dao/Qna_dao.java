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
		String query =" delete from h05_Qna \r\n" + 
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
	/*
	// 수정
	public int updateQna(Qna_dto dto) {
		int result =0;
		String query ="update h05_Qna \r\n" + 
				"set question='"+dto.getQuestion()+"', \r\n" + 
				"    answer='"+dto.getAnswer()+"', \r\n" + 
				"    reg_id ='"+dto.getReg_id()+"', \r\n" + 
				"    reg_date ='"+dto.getReg_date()+"', \r\n" + 
				"    sort ='"+dto.getSort()+"' \r\n" + 
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
		String query=" update h05_Qna set hit = hit + 1\r\n" + 
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
		String query =" select no,question,answer,reg_id,to_char(reg_date,'yyyy-MM-dd'),sort, hit\r\n" + 
						" from h05_Qna\r\n" + 
						" where no ='"+no+"'";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				String nn 		= rs.getString(1);
				String question = rs.getString(2);
				String answer 	= rs.getString(3);
				String reg_id 	= rs.getString(4);
				String reg_date = rs.getString(5);
				String sort = rs.getString(6);
				int hit 		= rs.getInt(7);
				dto = new Qna_dto(nn,question,answer,reg_id,
						reg_date,sort,hit);
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
	*/
	//목록조회
	public ArrayList<Qna_dto> getQnaList(String select,String search){
		ArrayList<Qna_dto> arr = new ArrayList<Qna_dto>();
		String query =" select no,title,reg_name,groupno,to_char(reg_date,'yyyy-MM-dd'),depth,seg, hit\r\n" + 
					  " from h05_Qna2\r\n" +
				      " where "+select+" like '%"+search+"%' "+
					  " order by sort asc,no desc ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();	
			while(rs.next()) {
				String no 		= rs.getString("no");
				String title 	= rs.getString("title");
				String reg_name = rs.getString("reg_name");
				String reg_date = rs.getString("reg_date");
				int hit 		= rs.getInt("hit");
				String groupno 	= rs.getString("groupno");
				int depth 		= rs.getInt("depth");
				int seg 		= rs.getInt("seg");
				Qna_dto dto = new Qna_dto(no, title, groupno, reg_date, reg_name, "", depth, seg, hit);
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
				"('"+dto.getNo()+"','"+dto.getQuestion()+"','"+dto.getAnswer()+"','"+dto.getReg_id()+"','"+dto.getReg_date()+"','"+dto.getSort()+"','"+dto.getHit()+"')";
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
	
	
	// 번호생성
	public String getQnaNo() {
		String maxNo="";
		String query=" select max(no) from h05_Qna ";
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
}
