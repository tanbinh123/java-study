package main;

import java.util.ArrayList;

public class day_ArrayList {
	public static void main(String[] arg) {
		ArrayList<String> arr = new ArrayList<>(); //생성
		
		arr.add("AAA"); //리스트 순서대로 삽입
		arr.add("BBB");
		arr.add("CCC");
		for (int i = 0; i < arr.size(); i++) { //length가 아닌 size()
			System.out.print("=for= : " + arr.get(i)+"\n");
		}
		System.out.println();
		
		
		
		
		arr.remove(1);	//배열의 1번째 항목 삭제 2번째 배열이 1번째가 된다.
		for (int i = 0; i < arr.size(); i++) {
			System.out.print("=remove= : " + arr.get(i)+"\n");
		}
		System.out.println();
		
		
		
		arr.add(1, "DDD"); //배열 1번째자리에 삽입 , 기존 1번째 항목은 2번으로 밀려난다.
		for (int i = 0; i < arr.size(); i++) {
			System.out.print("=add(1,DDD\")= : " + arr.get(i)+"\n");
		}
		System.out.println();
		
		
		
		arr.clear(); //배열에 있는 항목 전체 삭제
			System.out.print("=clear= : " + arr.size()+"\n");
			
		arr.add("A");
		arr.add("B");
		for (int i = 0; i < arr.size(); i++) { 
			System.out.print("=for= : " + arr.get(i)+"\n");
		}
		System.out.println();
		
		arr.set(1, "CCC");
		for (int i = 0; i < arr.size(); i++) { //set을 쓰면 바로 치환
			System.out.print("=set= : " + arr.get(i)+"\n");
		}
		System.out.println();
	}
}
