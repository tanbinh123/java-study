package dao;

import java.text.DecimalFormat;

public class mainDao {

	

	public String getNo(String no) {
		DecimalFormat df = new DecimalFormat("000");
				String subno = no.substring(1);
				int subnonum = Integer.parseInt(subno)+1;
				String result = df.format(subnonum);
				no = "S"+result;
		return no;
	}
	String depart = "";
	public String getDepart(String depart) {
		int a = Integer.parseInt(depart);
		if (a == 1) depart = "총무";
		else if(a == 2) depart = "영업";
		else if(a == 3) depart = "인사";
		else if(a == 4) depart = "관리";
		return depart;
	}
	String position = "";
	public String getPosition(String position) {
		int a = Integer.parseInt(position);
		if (a == 1) position = "사원";
		else if(a == 2) position = "대리";
		else if(a == 3) position = "과장";
		else if(a == 4) position = "부장";
		return position;
	}
	
	int salaryMon = 0;
	public int getSalaryMon(String position) {
		int a = Integer.parseInt(position);
		if (a == 1) salaryMon = 1100000;
		else if(a == 2) salaryMon = 1200000;
		else if(a == 3) salaryMon = 1300000;
		else if(a == 4) salaryMon = 1400000;
		return salaryMon;
	}
	int PositionMoney;
	double pm;
	public int getPositionMoney(String position) {
		DecimalFormat df = new DecimalFormat("#");
		int a = Integer.parseInt(position);
		if (a == 1) pm = 1100000 * 0.1;
		else if(a == 2) pm = 1200000 * 0.1;
		else if(a == 3) pm = 1300000 * 0.1;
		else if(a == 4) pm = 1400000 * 0.1;
		String c = df.format(pm);
		PositionMoney = Integer.parseInt(c);
		return PositionMoney;
	}
	int bonus;
	double result;
	public int getBonus(int mon, int posmoney) {
		DecimalFormat df = new DecimalFormat("#");
		result = (mon*12) * 0.5;
		String a = df.format(result);
		bonus = Integer.parseInt(a);
		return bonus;
	}
	public int getSalaryYear(int mon, int posmoney, int bo) {
		int salaryYear = ((mon+posmoney) * 12) + bo;
		return salaryYear;
	}
}
