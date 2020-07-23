package dao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import dto.dto;

public class dao {
	public String getNo(String no) {
		DecimalFormat df = new DecimalFormat("0000");
		String cutno = no.substring(1);
		int pulsNo = Integer.parseInt(cutno)+1;
		String result = "S"+df.format(pulsNo);
		return result;
	}
	
	

Random rnd = new Random();
String result = "";
public String getRstr() {
	result = "";
	for (int i = 0; i < 3; i++) {
		String randomStr = String.valueOf((char) ((int) (rnd.nextInt(26)) + 65));
		 result += randomStr;
	}
	return result;
}

String resultArea = "";
public String getRstr2() {
	resultArea = "";
	for (int i = 0; i < 3; i++) {
		String randomStr = String.valueOf((char) ((int) (rnd.nextInt(26)) + 97));
		resultArea += randomStr;
	}
	return resultArea;
}

String resultInt ="";
public int getRint() {
	resultInt ="";
	DecimalFormat df = new DecimalFormat("00");
	for (int i = 0; i <2; i++) {
		String randomStr = String.valueOf(rnd.nextInt(10));
		resultInt += randomStr;
	}
	int newresultInt = Integer.parseInt(df.format(Double.parseDouble(resultInt)));
	return newresultInt;
}

String no ="";
public void getRinfo(ArrayList<dto> arr) {
	if(arr.size()==0){
		no = "S0001";
	}else {
		no = arr.get(arr.size()-1).getNo();
		no = getNo(no);
	}

	arr.add(new dto(no,getRstr(),getRstr2(),getRint()));
}
}