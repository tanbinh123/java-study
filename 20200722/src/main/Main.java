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
		
			for (int i = 0; i < 1000; i++) {
				dao.getRinfo(arr);
			}
		
		do {
			System.out.print("검색:1 등록:2 수정:3 삭제:4 종료:0 : ");
			gubun = sc.nextInt();
			if(gubun == 1) {
				int search = 0;
				do {
					System.out.print("전체 검색 : 0 \n사번으로 검색 : 1 \n이름으로 검색 : 2 \n지역으로 검색 : 3 \n나이로 검색 : 4\n검색 종료 : 9 \n=================== \n");
					search = sc.nextInt();
					if(search == 0){
						for (int i = 0; i < arr.size(); i++) {
								System.out.print(arr.get(i).getNo()+"\t");
								System.out.print(arr.get(i).getName()+"\t");
								System.out.print(arr.get(i).getArea()+"\t");
								System.out.print(arr.get(i).getAge()+"\n");
						}
					}
					else if(search == 1) {
						System.out.print("검색할 사번 입력 : ");
						String searchNo = sc.next();
						for (int i = 0; i < arr.size(); i++) {
							if(searchNo.equals(arr.get(i).getNo())){
								System.out.print(arr.get(i).getNo()+"\t");
								System.out.print(arr.get(i).getName()+"\t");
								System.out.print(arr.get(i).getArea()+"\t");
								System.out.print(arr.get(i).getAge()+"\n");
							}
						}
					}else if(search ==2) {
						System.out.print("검색할 이름 입력 : ");
						String searchName = sc.next();
						for (int i = 0; i < arr.size(); i++) {
							if(arr.get(i).getName().indexOf(searchName) != -1){
								System.out.print(arr.get(i).getNo()+"\t");
								System.out.print(arr.get(i).getName()+"\t");
								System.out.print(arr.get(i).getArea()+"\t");
								System.out.print(arr.get(i).getAge()+"\n");
							}
						}
					
					}else if(search ==3) {
						System.out.print("검색할 지역 입력 : ");
						String searchArea = sc.next();
						for (int i = 0; i < arr.size(); i++) {
							if(arr.get(i).getArea().indexOf(searchArea) != -1){
								System.out.print(arr.get(i).getNo()+"\t");
								System.out.print(arr.get(i).getName()+"\t");
								System.out.print(arr.get(i).getArea()+"\t");
								System.out.print(arr.get(i).getAge()+"\n");
							}
						}
					
					}else if(search ==4) {
						System.out.print("검색 시작 나이 입력 : ");
						int searchAge1 = sc.nextInt();
						System.out.print("검색 끝 나이 입력 : ");
						int searchAge2 = sc.nextInt();
						for (int i = 0; i < arr.size(); i++) {
							if(arr.get(i).getAge()>searchAge1 && arr.get(i).getAge()<searchAge2){
								System.out.print(arr.get(i).getNo()+"\t");
								System.out.print(arr.get(i).getName()+"\t");
								System.out.print(arr.get(i).getArea()+"\t");
								System.out.print(arr.get(i).getAge()+"\n");
							}
						}
					
					}}while(search != 9);
				
			}
				else if(gubun == 2) {
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
				String remove = sc.next();
				for (int i = 0; i < arr.size(); i++) {
					if(remove.equals(arr.get(i).getNo())){
						arr.remove(i);
						System.out.println("사원 번호 >" + remove + "< 삭제되었습니다.");
					}
				}
				for (int i = 0; i < arr.size(); i++) {
					System.out.print(arr.get(i).getNo()+"\t");
					System.out.print(arr.get(i).getName()+"\t");
					System.out.print(arr.get(i).getArea()+"\t");
					System.out.print(arr.get(i).getAge()+"\n");
				}
			}
			else if(gubun == 0) {
				System.out.println("종료 되었습니다.");
			}
			else {
				System.out.println("다시 선택해주세요.");
			}
		}while(gubun != 0);
	}
}
