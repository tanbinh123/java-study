package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import common.DBConnectionOracle;

public class news_dao {
	
	//번호 추가 메소드
		public String getNo(String no) {
			DecimalFormat df = new DecimalFormat("0000");
			String cutno = no.substring(1);
			int pulsNo = Integer.parseInt(cutno)+1;
			String result = "N"+df.format(pulsNo);
			return result;
		}
		
	
	//DB연결
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public int saveNews(String no, String title, String content, String reg_name, String reg_date) {
		int result = 0;
		String query="insert into h05_news (no, title, content, reg_name, reg_date) values ('"+no+"','"+title+"','"+content+"','"+reg_name+"','"+reg_date+"')";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(SQLException se){
			System.out.println(" saveNews() query error~ " + query);
		}catch(Exception e) {
			System.out.println(" saveNews() error  ~ : ");
		}finally {
			common.close(connection, ps, rs);
		}
		return result;
	}
}
