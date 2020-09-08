package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.CarRent_dto;
import dto.rentList_dto;

public class CarRent_dao {

	//번호 추가 메소드
		public String getNo(String no) {
			DecimalFormat df = new DecimalFormat("000");
			String cutno = no.substring(1);
			int pulsNo = Integer.parseInt(cutno)+1;
			String result = "R"+df.format(pulsNo);
			return result;
		}
		
	//DB연결
		DBConnectionOracle common = new DBConnectionOracle();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//select
		String query = "";
		public ArrayList<CarRent_dto> selectDB(int showGubun, String search) {
			ArrayList<CarRent_dto> arr = new ArrayList<>();
			if(showGubun == 1)query = "select a.rent_no,a.member_no,a.car_no,to_char(a.rent_date, 'yyyy-MM-dd'),return_day,to_char(a.return_date, 'yyyy-MM-dd'),to_char(a.expect_date, 'yyyy-MM-dd')\r\n" + 
										"from c05_carrent a, c05_car b\r\n" + 
										"where a.car_no = b.no ORDER BY no asc";
			else if(showGubun ==2)query = "select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, case a.auto_yn when 'y' then '자동' else '수동' end, case a.option_yn when 'y' then '유' else '무' end, case a.accident_yn when 'y' then '유' else '무' end, b.fuel_name, to_char(a.import_date, 'yyyy-MM-dd'), case a.rent_gubun when 'y' then '가능' else '불가능' end \r\n" + 
									"from c05_car a, car_common_fuel b, car_common_made c\r\n" + 
									"where a.fuel_type = b.fuel_type\r\n" + 
									"and a.car_made = c.made_code\r\n" + 
									"and no = '"+search+"' ORDER BY no asc";
		
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String rent_no = rs.getNString(1);
					String member_no = rs.getNString(2);
					String car_no = rs.getNString(3);
					String rent_day = rs.getNString(4);
					String return_day = rs.getNString(5);
					String return_date = rs.getNString(6);
					String returnExpectDate = rs.getNString(7);
				
					CarRent_dto dto = new CarRent_dto(rent_no, member_no, car_no, rent_day, return_day, return_date,returnExpectDate);
					arr.add(dto);
					
				}
			}catch(SQLException se){
				System.out.println(" selectDB() query error~ " + query);
			}catch(Exception e) {
				System.out.println(" selectDB() error  ~ : ");
			}finally {
				common.close(connection, ps, rs);
			}
			
			return arr;
		}
		
		
		//no에서 가장 큰 번호만 조회
		public String selectDBNo() {
			String result = "";
			query = "select max(rent_no) from c05_carrent";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String no = rs.getNString(1);
					result = no;
					
				}
			}catch(SQLException se){
				System.out.println(" insertDBNo() query error~ " + query);
			}catch(Exception e) {
				System.out.println(" insertDBNo() error  ~ : ");
			}finally {
				common.close(connection, ps, rs);
			}
			
			return result;
		}
		
		//select count (car테이블에서 차량 유무 검증)
				public int selectCountDB(String carNo) {
					int result = 0;
					String query = "select count(*) from c05_car where no = '"+carNo+"'";
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
		//select count (member테이블에서 차량 유무 검증)
		public int selectCountMemberDB(String carNo) {
			int result = 0;
			String query = "select count(*) from b05_bookmember where id = '"+carNo+"'";
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
				
		//select count (carrent테이블에서 차량 유무 검증)
		public int selectCountDB2(String carNo) {
			int result = 0;
			String query = "select count(*) from c05_carrent where rent_date = (select max(rent_date) from c05_carrent where car_no = '"+carNo+"')";
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
				
				
		//insert 대여
		public int insertDB(String rent_no, String member_no, String car_no, String rent_date, String returnExpectDate) {
			int result = 0;
			String query = "insert into c05_carrent (rent_no, member_no, car_no, rent_date, Expect_Date) values ('"+rent_no+"','"+member_no+"','"+car_no+"','"+rent_date+"','"+returnExpectDate+"')";
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
		
		//update 반납
		public int updateReturnDB(String returnNo, String returnDate) {
			int result = 0;
			String query = "update c05_carrent set return_date = '"+returnDate+"' where rent_date = (select max(rent_date) \r\n" + 
					"                    from c05_carrent \r\n" + 
					"                    where car_no = '"+returnNo+"')";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				result = ps.executeUpdate();
			}catch(SQLException se){
				System.out.println(" updateDB() query error~ " + query);
			}catch(Exception e) {
				System.out.println(" updateDB() error  ~ : ");
			}finally {
				common.close(connection, ps, rs);
			}
				return result;
			}
		
		//update 반납일수 구하기
		public int updateGetReturnDay(String returnNo) {
			int result = 0;
			String query = "update c05_carrent set return_day = (select TO_DATE(TO_char(return_date, 'YYYYMMDD')) - TO_DATE(TO_char(rent_date, 'YYYYMMDD'))\r\n" + 
					"                    from c05_carrent\r\n" + 
					"                    where rent_date = (select max(rent_date) \r\n" + 
					"                    from c05_carrent \r\n" + 
					"                    where car_no = '"+returnNo+"'))\r\n" + 
					"                    where rent_date = (select max(rent_date) \r\n" + 
					"                    from c05_carrent \r\n" + 
					"                    where car_no = '"+returnNo+"')";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				result = ps.executeUpdate();
			}catch(SQLException se){
				System.out.println(" updateDB() query error~ " + query);
			}catch(Exception e) {
				System.out.println(" updateDB() error  ~ : ");
			}finally {
				common.close(connection, ps, rs);
			}
				return result;
			}
				
		//update rent_gubun
		public int updateDB(String car_no, int gubun) {
			String query = "";
			int result = 0;
			if(gubun == 1)query = "update c05_car set rent_gubun = 'n' where no = '"+car_no+"'";
			if(gubun == 2)query = "update c05_car set rent_gubun = 'y' where no = '"+car_no+"'";
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				result = ps.executeUpdate();
			}catch(SQLException se){
				System.out.println(" updateDB() query error~ " + query);
			}catch(Exception e) {
				System.out.println(" updateDB() error  ~ : ");
			}finally {
				common.close(connection, ps, rs);
			}
				return result;
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//select 대여내역
				public ArrayList<rentList_dto> selectRentList(int showGubun, String search) {
					ArrayList<rentList_dto> arr = new ArrayList<>();
					if(showGubun == 1)query = "select m.id, m.name, c.no, c.model_name, to_char(r.rent_date, 'yyyy-MM-dd'),to_char(r.return_date, 'yyyy-MM-dd'),r.return_day\r\n" + 
												"from b05_bookmember m, c05_car c, c05_carrent r\r\n" + 
												"where m.id = r.member_no\r\n" + 
												"and c.no = r.car_no\r\n" + 
												"and m.id = '"+search+"' ORDER BY r.rent_date desc";
					else if(showGubun ==2)query = "select m.id, m.name, c.no, c.model_name, to_char(r.rent_date, 'yyyy-MM-dd'),to_char(r.return_date, 'yyyy-MM-dd'),r.return_day\r\n" + 
												"from b05_bookmember m, c05_car c, c05_carrent r\r\n" + 
												"where m.id = r.member_no\r\n" + 
												"and c.no = r.car_no\r\n" + 
												"and c.no = '"+search+"' ORDER BY r.rent_date desc";
					else if(showGubun ==9)query = "select m.id, m.name, c.no, c.model_name, to_char(r.rent_date, 'yyyy-MM-dd'),to_char(r.return_date, 'yyyy-MM-dd'),r.return_day\r\n" + 
													"from b05_bookmember m, c05_car c, c05_carrent r\r\n" + 
													"where m.id = r.member_no\r\n" + 
													"and c.no = r.car_no";
				
					try {
						connection = common.getConnection();
						ps = connection.prepareStatement(query);
						rs = ps.executeQuery();
						
						while(rs.next()) {
							String memberid = rs.getNString(1);
							String memberName = rs.getNString(2);
							String carId = rs.getNString(3);
							String carName = rs.getNString(4);
							String rentDate = rs.getNString(5);
							String returnDate = rs.getNString(6);
							String returnDay = rs.getNString(7);
						
							rentList_dto dto = new rentList_dto(memberid, memberName, carId, carName, rentDate, returnDate, returnDay);
							arr.add(dto);
							
						}
					}catch(SQLException se){
						System.out.println(" selectDB() query error~ " + query);
					}catch(Exception e) {
						System.out.println(" selectDB() error  ~ : ");
					}finally {
						common.close(connection, ps, rs);
					}
					
					return arr;
				}
}


