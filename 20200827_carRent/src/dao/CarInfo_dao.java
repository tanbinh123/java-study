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

	
	public String getNo(String no) {
		DecimalFormat df = new DecimalFormat("000");
		String cutno = no.substring(1);
		int pulsNo = Integer.parseInt(cutno)+1;
		String result = "C"+df.format(pulsNo);
		return result;
	}
	
	
	public String getYNResult(String a) {
		String result = "";
		if(a.equals("y") || a.equals("Y") || a.equals("ㅛ") || a.equals("n") || a.equals("N") || a.equals("ㅜ")) {
			if(a.equals("y") || a.equals("Y") || a.equals("ㅛ")) {
				result = "y";
			}
			else if(a.equals("n") || a.equals("N") || a.equals("ㅜ")) {
				result = "n";
			}
		}else {
			System.out.println("y 나 n 으로 입력해주세요");
			a = "";
		}
		return result;
	}
	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String query = "";
	public ArrayList<CarInfo_dto> selectDB(int showGubun, String searchMade, String searchModelName, String searchCarNumber) {
		ArrayList<CarInfo_dto> arr = new ArrayList<>();
		if(showGubun == 1)query = "select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, a.auto_yn, a.option_yn, a.accident_yn, b.fuel_name, to_char(a.import_date, 'yyyy-MM-dd'), a.rent_gubun \r\n" + 
									"from c05_car a, car_common_fuel b, car_common_made c\r\n" + 
									"where a.fuel_type = b.fuel_type\r\n" + 
									"and a.car_made = c.made_code\r\n" + 
									"ORDER BY no asc";
		else if(showGubun == 2)query = "select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, a.auto_yn, a.option_yn, a.accident_yn, b.fuel_name, to_char(a.import_date, 'yyyy-MM-dd'), a.rent_gubun \r\n" + 
									"from c05_car a, car_common_fuel b, car_common_made c\r\n" + 
									"where a.fuel_type = b.fuel_type\r\n" + 
									"and a.car_made = c.made_code\r\n" + 
									"and car_made like '%"+searchMade+"%' ORDER BY no asc";
		else if(showGubun == 3)query = "select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, a.auto_yn, a.option_yn, a.accident_yn, b.fuel_name, to_char(a.import_date, 'yyyy-MM-dd'), a.rent_gubun \r\n" + 
									"from c05_car a, car_common_fuel b, car_common_made c\r\n" + 
									"where a.fuel_type = b.fuel_type\r\n" + 
									"and a.car_made = c.made_code\r\n" + 
									"and model_name like '%"+searchModelName+"%' ORDER BY no asc";
		else if(showGubun == 4)query = "select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, a.auto_yn, a.option_yn, a.accident_yn, b.fuel_name, to_char(a.import_date, 'yyyy-MM-dd'), a.rent_gubun \r\n" + 
									"from c05_car a, car_common_fuel b, car_common_made c\r\n" + 
									"where a.fuel_type = b.fuel_type\r\n" + 
									"and a.car_made = c.made_code\r\n" + 
									"and car_number like '%"+searchCarNumber+"%' ORDER BY no asc";
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
}
