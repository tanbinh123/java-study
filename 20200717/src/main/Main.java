package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.mainDao;
import dto.mainDto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<mainDto> arr = new ArrayList<>();
		
		System.out.print("�� ��? :");
		int howmany = sc.nextInt();
		
		for (int i = 0; i < howmany; i++) {
			System.out.print("��� ��ȣ : ");
			String no = sc.next();
			
			System.out.print("���� �Է� : ");
			String name = sc.next();
			
			System.out.println("�μ� �Է�");
			System.out.println("�ѹ� : 1");
			System.out.println("���� : 2");
			System.out.println("�λ� : 3");
			System.out.println("���� : 4");
			System.out.println("=======");
			System.out.print("�Է� : ");
			String departNum = sc.next();
			
			System.out.println("���� �Է�");
			System.out.println("��� : 1");
			System.out.println("�븮 : 2");
			System.out.println("���� : 3");
			System.out.println("���� : 4");
			System.out.println("=======");
			System.out.print("�Է� : ");
			String positionNum = sc.next();
			
			mainDao dao = new mainDao();
			String depart = dao.getDepart(departNum);
			String position = dao.getPosition(positionNum);
			int money = dao.getMoney(positionNum);
			mainDto dto = new mainDto(no, name, depart, position, money);
			arr.add(dto);
			arr.get(i).getPositionMoney();
		}
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i).getNo()+"\t"+arr.get(i).getName()+"\t"+arr.get(i).getDepart()+"\t"+arr.get(i).getPosition()+"\t"+arr.get(i).getMoney()+"\t"+arr.get(i).getPositionMoney()+"\n");
		}
	}

}
