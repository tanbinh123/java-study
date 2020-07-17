package dao;


public class mainDao {

	String result;
	public String getDepart(String departNum) {
		int a = Integer.parseInt(departNum);
		if (a == 1) result = "총무";
		else if (a == 2) result = "영업";
		else if (a == 3) result = "인사";
		else if (a == 4) result = "관리";
		else result = "부서 없음";
		return result;
	}
	String result2;
	public String getPosition(String positionNum) {
		int a = Integer.parseInt(positionNum);
		if (a == 1) result2 = "사원";
		else if (a == 2) result2 = "대리";
		else if (a == 3) result2 = "과장";
		else if (a == 4) result2 = "부장";
		else result2 = "직급 없음";
		return result2;
	}
	
	int money;
	public int getMoney(String positionNum) {
		int a = Integer.parseInt(positionNum);
		if (a == 1) money = 1200000;
		else if (a == 2) money = 1400000;
		else if (a == 3) money = 1600000;
		else if (a == 4) money = 1800000;
		else money = 0;
		return money;
	}
}
