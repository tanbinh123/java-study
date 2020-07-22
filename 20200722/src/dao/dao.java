package dao;

import java.text.DecimalFormat;

public class dao {
	public String getNo(String no) {
		DecimalFormat df = new DecimalFormat("0000");
		String cutno = no.substring(1);
		int pulsNo = Integer.parseInt(cutno)+1;
		String result = "S"+df.format(pulsNo);
		return result;
	}
}
