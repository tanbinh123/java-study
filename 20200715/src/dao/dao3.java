package dao;

import java.text.DecimalFormat;

public class dao3{
	
	
	public int getTotal(int kor, int eng, int mat) {
		int total = kor + eng + mat;
		return total;
	}
	public double getAva(int total, int count) {
		DecimalFormat df = new DecimalFormat(".#");
		double result = total / (double)count;
		String ava = df.format(result);
		return Double.parseDouble(ava);
	}
	String result = "";
	public String getResult(double ava) {
		if(ava >= 90)result = "수";
		else if(ava >= 80)result = "우";
		else if(ava >= 70)result = "미";
		else if(ava >= 60)result = "양";
		else result = "가";
		return result;
	}
}
