package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.dao;
import dto.dto;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dao dao = new dao();
		ArrayList<dto> arr = new ArrayList<>();
		int gubun = 0;
		String no = "";
		do {
			System.out.print("검색:1 등록:2 수정:3 삭제:4 종료:0 : ");
			gubun = sc.nextInt();
			if(gubun == 1) {
				System.out.print("찾을 사번 입력 : ");
				String search = sc.next();
				for (int i = 0; i < arr.size(); i++) {
					if(search.equals(arr.get(i).getNo())){
						System.out.print(arr.get(i).getNo()+"\t");
						System.out.print(arr.get(i).getName()+"\t");
						System.out.print(arr.get(i).getArea()+"\t");
						System.out.print(arr.get(i).getAge()+"\n");
					}
				}
				
			}else if(gubun == 2) {
				if(arr.size()==0){
					no = "S0001";
				}else {
					no = arr.get(arr.size()-1).getNo();
					no = dao.getNo(no);
				}
				System.out.print("이름? :");
				String name = sc.next();
				System.out.print("지역? :");
				String area = sc.next();
				System.out.print("나이? :");
				int age = sc.nextInt();
				arr.add(new dto(no, name, area, age));
				for (int i = 0; i < arr.size(); i++) {
					System.out.print(arr.get(i).getNo()+"\t");
					System.out.print(arr.get(i).getName()+"\t");
					System.out.print(arr.get(i).getArea()+"\t");
					System.out.print(arr.get(i).getAge()+"\n");
				}
			}else if(gubun == 3) {
				System.out.print("수정할 사번 입력 : ");
				String edit = sc.next();
				for (int i = 0; i < arr.size(); i++) {
					if(edit.equals(arr.get(i).getNo())){
						no = arr.get(i).getNo();
						System.out.print("수정 이름? :");
						String name = sc.next();
						System.out.print("수정 지역? :");
						String area = sc.next();
						System.out.print("수정 나이? :");
						int age = sc.nextInt();
						arr.set(i, new dto(no, name, area, age));
						
						System.out.print(arr.get(i).getNo()+"\t");
						System.out.print(arr.get(i).getName()+"\t");
						System.out.print(arr.get(i).getArea()+"\t");
						System.out.print(arr.get(i).getAge()+"\n");
					}
					
				}
				
			}else if(gubun == 4) {
				System.out.print("삭제할 사번 입력 : ");
				String edit = sc.next();
				for (int i = 0; i < arr.size(); i++) {
					if(edit.equals(arr.get(i).getNo())){
						arr.remove(i);
					}
				}
			}else {
				System.out.println("다시 선택해주세요.");
			}
		}while(gubun != 0);
	}
}
