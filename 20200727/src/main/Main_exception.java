package main;

import java.io.IOException;
import java.util.Scanner;

public class Main_exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String a = "ȫ";
//		int i =0;
//		try {
//			i = Integer.parseInt(a);
//		}catch(Exception e) {
//			System.out.println("����~");
//			i = -1;
//		}
//		
//		System.out.println(" i : " + i);
//		
		
		try {
			System.in.read();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		day2 ex = new day2();
		
		System.out.print("ù ��° ����? :");
		String a = sc.next();
		
		System.out.print("�� ��° ����? :");
		String b = sc.next();
		
//		String a = "50";
//		String b = "a";
		int total = 0;
		try {
			total = ex.getTotal(a, b);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("total : " + total);
	}

}
