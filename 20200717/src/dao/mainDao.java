package dao;


public class mainDao {

	String result;
	public String getDepart(String departNum) {
		int a = Integer.parseInt(departNum);
		if (a == 1) result = "�ѹ�";
		else if (a == 2) result = "����";
		else if (a == 3) result = "�λ�";
		else if (a == 4) result = "����";
		else result = "�μ� ����";
		return result;
	}
	String result2;
	public String getPosition(String positionNum) {
		int a = Integer.parseInt(positionNum);
		if (a == 1) result2 = "���";
		else if (a == 2) result2 = "�븮";
		else if (a == 3) result2 = "����";
		else if (a == 4) result2 = "����";
		else result2 = "���� ����";
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
