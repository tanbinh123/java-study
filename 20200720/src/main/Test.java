package main;

import java.text.DecimalFormat;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("00000");
		
//		String name = "JSL인재개발원";
//		String n1 = name.substring(3);
//		String n2 = name.substring(3, 5);
		
		String no = "S001";
		System.out.println(no);
		for (int i = 0; i < 52200; i++) {
			
			
			String subno = no.substring(1);
			int subnonum = Integer.parseInt(subno)+1;
			String result = df.format(subnonum);
			no = "S"+result;
			
			System.out.println(no);
		}
		
		// 
		
		
	}

}