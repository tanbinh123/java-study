package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.CarInfo_dto;

public class CarInfo_dao {

	//번호 추가 메소드
	public String getNo(String no) {
		DecimalFormat df = new DecimalFormat("000");
		String cutno = no.substring(1);
		int pulsNo = Integer.parseInt(cutno)+1;
		String result = "C"+df.format(pulsNo);
		return result;
	}
	
	//DB연결
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//select
	String query = "";
	public ArrayList<CarInfo_dto> selectDB(int showGubun, String search) {
		ArrayList<CarInfo_dto> arr = new ArrayList<>();
		if(showGubun == 1)query = "select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, case a.auto_yn when 'y' then '자동' else '수동' end, case a.option_yn when 'y' then '유' else '무' end, case a.accident_yn when 'y' then '유' else '무' end, b.fuel_name, to_char(a.import_date, 'yyyy-MM-dd'), case a.rent_gubun when 'y' then '가능' else '불가능' end\r\n" + 
									"from c05_car a, car_common_fuel b, car_common_made c\r\n" + 
									"where a.fuel_type = b.fuel_type\r\n" + 
									"and a.car_made = c.made_code\r\n" + 
									"ORDER BY no asc";
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
									"and a.no = '"+search+"' ORDER BY no asc";
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getNString(1);
				String model_name = rs.getNString(2);
				String car_number = rs.getNString(3);
				String car_made = rs.getNString(4);
				String car_made_ym = rs.getNString(5);
				String auto_yn = rs.getNString(6);
				String option_yn = rs.getNString(7);
				String accident_yn = rs.getNString(8);
				String fuel_type = rs.getNString(9);
				String import_date = rs.getNString(10);
				String rent_gubun = rs.getNString(11);
			
				CarInfo_dto dto = new CarInfo_dto(no, model_name, car_number, car_made, car_made_ym, auto_yn, option_yn, accident_yn, fuel_type, import_date, rent_gubun);
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
		query = "select max(no) from c05_car";
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
	public int insertDB(String no, String model_name, String car_number, String car_made, String car_made_ym,
			String auto_yn, String option_yn, String accident_yn, String fuel_type, String import_date,
			String rent_gubun) {
		int result = 0;
		String query = "insert into c05_car (no, model_name, car_number, car_made, car_made_ym, auto_yn, option_yn, accident_yn, fuel_type, import_date, rent_gubun) values ('"+no+"','"+model_name+"','"+car_number+"','"+car_made+"','"+car_made_ym+"','"+auto_yn+"','"+option_yn+"','"+accident_yn+"','"+fuel_type+"','"+import_date+"','"+rent_gubun+"')";
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
		public int updateDB(String no, String model_name, String car_number, String car_made, String car_made_ym,
				String auto_yn, String option_yn, String accident_yn, String fuel_type, String import_date
				) {
			int result = 0;
			String query = "update c05_car set model_name ='"+model_name+"', car_number = '"+car_number+"', car_made = '"+car_made+"', car_made_ym = '"+car_made_ym+"', auto_yn = '"+auto_yn+"', option_yn = '"+option_yn+"', accident_yn = '"+accident_yn+"', fuel_type = '"+fuel_type+"', import_date = '"+import_date+"'where no = '"+no+"'";
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
	
	//deletDB
	public int deleteDB(String no) {
		int result = 0;
		String query = "delete from c05_car where no = '"+no+"'";
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

	
