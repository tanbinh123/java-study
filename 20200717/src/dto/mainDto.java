package dto;

import java.text.DecimalFormat;

public class mainDto {
	String no, name, depart, position;
	int money;
	int positionMoney;
	
	DecimalFormat df = new DecimalFormat(",###");
	
	public mainDto(String no, String name, String depart, String position, int money) {
		super();
		this.no = no;
		this.name = name;
		this.depart = depart;
		this.position = position;
		this.money = money;
	}
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getDepart() {
		return depart;
	}
	public String getPosition() {
		return position;
	}
	String result;
	public String getMoney() {
		result = df.format(money);
		return result;
	}
	String result2;
	double pm;
	public String getPositionMoney() {
		if(position.equals("사원")||position.equals("대리")||position.equals("과장")||position.equals("부장")) pm = money * 0.1;
		positionMoney = (int)pm;
		result2 = df.format(positionMoney);
		return result2;
	}
	
}
