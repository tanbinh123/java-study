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
		System.out.print("�� ��? : ");
		int num = sc.nextInt();
		clearConsole();
		
		
		for (int i = 0; i < num; i++) {
			todayDao2 dao = new todayDao2();
			System.out.print("��� �Է�\n======\n�Է� : ");
			String no = sc.next();
			clearConsole();
			System.out.print("�̸� �Է�\n======\n�Է� : ");
			String name = sc.next();
			clearConsole();
			System.out.print("�μ� ���� : \n�ѹ� : 1\n���� : 2\n�λ� : 3\n���� : 4\n=======\n�Է� : ");
			int departNumber = sc.nextInt();
			clearConsole();
			System.out.print("���� ���� :  \n��� : 1\n�븮 : 2\n���� : 3\n���� : 4\n=======\n�Է� : ");
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
