package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.CarRent_dto;

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
			if(showGubun == 1)query = "select a.rent_no,a.member_no,a.car_no,to_char(a.rent_date, 'yyyy-MM-dd'),to_char(a.return_day, 'yyyy-MM-dd'),to_char(a.return_date, 'yyyy-MM-dd')\r\n" + 
										"from c05_carrent a, c05_car b\r\n" + 
										"where a.car_no = b.no ORDER BY no asc";
			else if(showGubun == 2)query = "select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, case a.auto_yn when 'y' then '자동' else '수동' end, case a.option_yn when 'y' then '유' else '무' end, case a.accident_yn when 'y' then '유' else '무' end, b.fuel_name, to_char(a.import_date, 'yyyy-MM-dd'), case a.rent_gubun when 'y' then '가능' else '불가능' end\r\n" + 
										"from c05_car a, car_common_fuel b, car_common_made c\r\n" + 
										"where a.fuel_type = b.fuel_type\r\n" + 
										"and a.car_made = c.made_code\r\n" + 
										"and car_made like '%"+search+"%' ORDER BY no asc";
			else if(showGubun == 3)query = "select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, case a.auto_yn when 'y' then '자동' else '수동' end, case a.option_yn when 'y' then '유' else '무' end, case a.accident_yn when 'y' then '유' else '무' end, b.fuel_name, to_char(a.import_date, 'yyyy-MM-dd'), case a.rent_gubun when 'y' then '가능' else '불가능' end \r\n" + 
										"from c05_car a, car_common_fuel b, car_common_made c\r\n" + 
										"where a.fuel_type = b.fuel_type\r\n" + 
										"and a.car_made = c.made_code\r\n" + 
										"and model_name like '%"+search+"%' ORDER BY no asc";
			else if(showGubun == 4)query = "select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, case a.auto_yn when 'y' then '자동' else '수동' end, case a.option_yn when 'y' then '유' else '무' end, case a.accident_yn when 'y' then '유' else '무' end, b.fuel_name, to_char(a.import_date, 'yyyy-MM-dd'), case a.rent_gubun when 'y' then '가능' else '불가능' end \r\n" + 
										"from c05_car a, car_common_fuel b, car_common_made c\r\n" + 
										"where a.fuel_type = b.fuel_type\r\n" + 
										"and a.car_made = c.made_code\r\n" + 
										"and car_number like '%"+search+"%' ORDER BY no asc";
			else if(showGubun == 5)query = "select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, case a.auto_yn when 'y' then '자동' else '수동' end, case a.option_yn when 'y' then '유' else '무' end, case a.accident_yn when 'y' then '유' else '무' end, b.fuel_name, to_char(a.import_date, 'yyyy-MM-dd'), case a.rent_gubun when 'y' then '가능' else '불가능' end \r\n" + 
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

				
					CarRent_dto dto = new CarRent_dto(rent_no, member_no, car_no, rent_day, return_day, return_date);
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
		public String insertDBNo() {
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
		
		//insert
		public int insertDB(String rent_no, String member_no, String car_no, String rent_date) {
			int result = 0;
			String query = "insert into c05_carrent (rent_no, member_no, car_no, rent_date) values ('"+rent_no+"','"+member_no+"','"+car_no+"','"+rent_date+"')";
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
		
		//update
				public int updateDB(String car_no) {
					int result = 0;
					String query = "update c05_car set rent_gubun = 'n' where no = '"+car_no+"'";
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
}
