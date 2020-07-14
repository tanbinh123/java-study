package main;

import java.util.*;

import dto.dto_2;

public class day_ArrayList3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 명? :");
		int num = sc.nextInt();
		
		ArrayList<dto_2> arr = new ArrayList<>();
		
		for (int i = 0; i < num; i++) {
			System.out.print("이름? : ");
			String name = sc.next();
			System.out.print("지역? : ");
			String area = sc.next();
			System.out.print("나이? : ");
			int age = sc.nextInt();
			arr.add(new dto_2(name, area, age));
		}
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).getName()+"\t"+arr.get(i).getArea()+"\t"+arr.get(i).getAge());
		}
	}

}
