package dao;

import main.todayMain2;

public class todayDao2 {

	String result;
	public String getDepart(int a) {
		if(a == 1) result = "�ѹ�";
		else if (a ==2) result = "����";
		else if (a ==3) result = "�λ�";
		else if (a ==4) result = "����";
		else result = "�μ� ����";
		return result;
	}
	
	String result2;
	public String getPosition(int a) {
		
		if(a == 1) result2 = "���";
		else if (a ==2) result2 = "�븮";
		else if (a ==3) result2 = "����";
		else if (a ==4) result2 = "����";
		else result2 = "���� ����";
		return result2;
	}
	
}
