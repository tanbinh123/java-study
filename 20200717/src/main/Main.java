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
		
		System.out.print("몇 명? :");
		int howmany = sc.nextInt();
		
		for (int i = 0; i < howmany; i++) {
			System.out.print("사원 번호 : ");
			String no = sc.next();
			
			System.out.print("성명 입력 : ");
			String name = sc.next();
			
			System.out.println("부서 입력");
			System.out.println("총무 : 1");
			System.out.println("영업 : 2");
			System.out.println("인사 : 3");
			System.out.println("관리 : 4");
			System.out.println("=======");
			System.out.print("입력 : ");
			String departNum = sc.next();
			
			System.out.println("직급 입력");
			System.out.println("사원 : 1");
			System.out.println("대리 : 2");
			System.out.println("과장 : 3");
			System.out.println("부장 : 4");
			System.out.println("=======");
			System.out.print("입력 : ");
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
