package dao;

import main.todayMain2;

public class todayDao2 {

	String result;
	public String getDepart(int a) {
		if(a == 1) result = "총무";
		else if (a ==2) result = "영업";
		else if (a ==3) result = "인사";
		else if (a ==4) result = "관리";
		else result = "부서 없음";
		return result;
	}
	
	String result2;
	public String getPosition(int a) {
		
		if(a == 1) result2 = "사원";
		else if (a ==2) result2 = "대리";
		else if (a ==3) result2 = "과장";
		else if (a ==4) result2 = "부장";
		else result2 = "직급 없음";
		return result2;
	}
	
}
