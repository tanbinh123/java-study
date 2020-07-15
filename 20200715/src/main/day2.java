package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.dao3;
import dto.dto3;

public class day2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<dto3> arr = new ArrayList<>();
		
		System.out.print("몇 명? : ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.print("이름? : ");
			String name = sc.next();
			System.out.print("국어? : ");
			int kor = sc.nextInt();
			System.out.print("영어? : ");
			int eng = sc.nextInt();
			System.out.print("수학? : ");
			int mat = sc.nextInt();
			dao3 dao = new dao3();
			int total = dao.getTotal(kor, eng, mat);
			double ava = dao.getAva(total, 3);
			String result = dao.getResult(ava);
			dto3 dto = new dto3(name, result, kor, eng, mat, total, ava);
			arr.add(dto);
		}
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
		for (int i = 0; i < arr.size(); i++) {
	
			System.out.print(arr.get(i).getName() + "\t");
			System.out.print(arr.get(i).getKor() + "\t");
			System.out.print(arr.get(i).getEng() + "\t");
			System.out.print(arr.get(i).getMat() +"\t");
			System.out.print(arr.get(i).getTotal() + "\t");
			System.out.print(arr.get(i).getAva() + "\t");
			System.out.print(arr.get(i).getReult() + "\n");
		}
		sc.close();
	}

}
