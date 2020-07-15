package dao;

import java.text.DecimalFormat;

public class dao2 extends dto.dto2{
	
	public dao2(String name, int kor, int eng, int mat) {
		super(name, kor, eng, mat);
		// TODO Auto-generated constructor stub
	}
	public int getTotal() {
		total = kor + eng + mat;
		return total;
	}
	public double getAva(int count) {
		DecimalFormat df = new DecimalFormat(".#");
		ava = total / (double)count;
		String ava = df.format(super.ava);
		return Double.parseDouble(ava);
	}
	public String getResult() {
		if(ava >= 90)result = "��";
		else if(ava >= 80)result = "��";
		else if(ava >= 70)result = "��";
		else if(ava >= 60)result = "��";
		else result = "��";
		return result;
	}
}
