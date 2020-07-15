package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.dao2;
import dto.dto2;

public class day1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<dao2> arr = new ArrayList<>();
		
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
			dao2 dto = new dao2(name, kor, eng, mat);
			arr.add(dto);
		}
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
		for (int i = 0; i < arr.size(); i++) {
			
			String name = arr.get(i).getName();
			int kor = arr.get(i).getKor();
			int eng = arr.get(i).getEng();
			int mat = arr.get(i).getMat();
			int total = arr.get(i).getTotal();
			double ava = arr.get(i).getAva(3);
			String result = arr.get(i).getResult();
			
			System.out.print(name + "\t");
			System.out.print(kor + "\t");
			System.out.print(eng + "\t");
			System.out.print(mat +"\t");
			System.out.print(total + "\t");
			System.out.print(ava + "\t");
			System.out.print(result + "\n");
		}
		sc.close();
	}

}
