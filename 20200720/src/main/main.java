package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.mainDao;
import dto.mainDto;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<mainDto> arr = new ArrayList<>();
		String no = "S001";
		
		System.out.println("how many ? :");
		int num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
			mainDao dao = new mainDao();
//			System.out.print("input your number : ");
//			String no = sc.next();
			
			if (i  == 0) no = "S001";
			else no = dao.getNo(no);
			
			System.out.println("input your name : ");
			String name = sc.next();
			System.out.print("choose your depart \n 총무:1 \n 영업:2 \n 인사:3 \n 관리:4 \n");
			String departN = sc.next();
			System.out.print("choose your position \n 사원:1 \n 대리:2 \n 과장:3 \n 부장:4 \n");
			String positionN = sc.next();
			
			
			String depart = dao.getDepart(departN);
			String position = dao.getPosition(positionN);
			int salaryMon = dao.getSalaryMon(positionN);
			int positionMoney = dao.getPositionMoney(positionN);
			int bonus = dao.getBonus(salaryMon, positionMoney);
			int salaryYear = dao.getSalaryYear(salaryMon, positionMoney, bonus);
			arr.add(new mainDto(no, name, depart, position, salaryMon, positionMoney, bonus, salaryYear));
			
		}
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i).getNo() + "\t");
			System.out.print(arr.get(i).getName() + "\t");
			System.out.print(arr.get(i).getDepart() + "\t");
			System.out.print(arr.get(i).getPosition()+ "\t");
			System.out.print(arr.get(i).getSalaryMon() + "\t");
			System.out.print(arr.get(i).getPositionMoney() + "\t");
			System.out.print(arr.get(i).getBonus() + "\t");
			System.out.print(arr.get(i).getSalaryYear() + "\n");
		}

	}

}
