package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.todayDao;
import dto.todayDto;

public class todayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<todayDto> arr = new ArrayList<>();
		todayDao dao = new todayDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 명?:");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.print("이름 ? : ");
			String name = sc.next();
			System.out.print("국어 ? : ");
			int kor = sc.nextInt();
			System.out.print("영어 ? : ");
			int eng = sc.nextInt();
			
			int total = dao.getTotal(kor, eng);
			String ava = dao.getAva(total, 2);
			String result = dao.getResult(ava);
			arr.add(new todayDto(name,ava,result,kor,eng,total));
		}

		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i).getName()+"\t");
			System.out.print(arr.get(i).getKor()+"\t");
			System.out.print(arr.get(i).getEng()+"\t");
			System.out.print(arr.get(i).getTotal()+"\t");
			System.out.print(arr.get(i).getAva()+"\t");
			System.out.print(arr.get(i).getResult()+"\n");
		}
	}

}
