package main;

import java.util.ArrayList;
import java.util.Scanner;

import dto.dto_3;

public class day_ArrayList4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<dto_3> arr = new ArrayList<>();
		
		System.out.print("�� ��? : ");
		int num = sc.nextInt();
		
		for (int i = 0; i < num; i++) {
			System.out.print("�̸�? : ");
			String name = sc.next();
			System.out.print("����? : ");
			int kor = sc.nextInt();
			System.out.print("����? : ");
			int eng = sc.nextInt();
			System.out.print("����? : ");
			int mat = sc.nextInt();
			arr.add(new dto_3(name, kor, eng, mat));
		}
		
		for (int i = 0; i < num; i++) {
			System.out.print(arr.get(i).getName() + "\t");
			System.out.print(arr.get(i).getKor() + "\t");
			System.out.print(arr.get(i).getEng() + "\t");
			System.out.print(arr.get(i).getMat() + "\t");
			arr.get(i).setTotal();
			System.out.print(arr.get(i).getTotal() + "\t");
			arr.get(i).setAva();
			System.out.print(arr.get(i).getAva() + "\n");
		}
	}

}
