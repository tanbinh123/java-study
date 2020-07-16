package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.todayDao2;
import dto.todayDto2;


public class todayMain2 {
	
	public static void clearConsole() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<todayDto2> arr = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 명? : ");
		int num = sc.nextInt();
		clearConsole();
		
		
		for (int i = 0; i < num; i++) {
			todayDao2 dao = new todayDao2();
			System.out.print("사번 입력\n======\n입력 : ");
			String no = sc.next();
			clearConsole();
			System.out.print("이름 입력\n======\n입력 : ");
			String name = sc.next();
			clearConsole();
			System.out.print("부서 선택 : \n총무 : 1\n영업 : 2\n인사 : 3\n관리 : 4\n=======\n입력 : ");
			int departNumber = sc.nextInt();
			clearConsole();
			System.out.print("직급 선택 :  \n사원 : 1\n대리 : 2\n과장 : 3\n부장 : 4\n=======\n입력 : ");
			int positionNumber = sc.nextInt();
			clearConsole();
			
			String depart = dao.getDepart(departNumber);
			String position = dao.getPosition(positionNumber);
			
			arr.add(new todayDto2(no,name,depart,position));
		}
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i).getNo()+"\t"+arr.get(i).getName()+"\t"+arr.get(i).getDepart()+"\t"+arr.get(i).getPosition()+"\n");
		}

		sc.close();
	}

}
