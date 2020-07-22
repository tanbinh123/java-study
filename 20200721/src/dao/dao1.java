package dao;

import java.text.DecimalFormat;

public class dao1 {

	public String getNo(String no){
		DecimalFormat df = new DecimalFormat("000");
		String cutno = no.substring(1);
		int cutnoint = Integer.parseInt(cutno)+1;
		String result = "N"+df.format(cutnoint);
		return result;
	}
}
