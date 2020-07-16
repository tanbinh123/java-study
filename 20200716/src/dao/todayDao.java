package dao;

import java.text.DecimalFormat;

public class todayDao {

	public int getTotal(int kor, int eng) {
		int total = kor + eng;
		return total;
	}
	public String getAva(int total, int count) {
		DecimalFormat df = new DecimalFormat(".00");
		double ava = total/(double)count;
		String avg = df.format(ava);
		return avg;
	}
	String result;
	public String getResult(String ava) {
		double a = Double.parseDouble(ava);
		if(a >= 90) result = "수";
		else if(a >= 80) result = "우";
		else if(a >= 70) result = "미";
		else if(a >= 60) result = "양";
		else result = "가";
		return result;
	}
}
