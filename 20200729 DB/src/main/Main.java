package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.dao;
import dto.dto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Scanner sc = new Scanner(System.in);
		dao dao = new dao();
		int gubun = 1;
		
		do {
		System.out.println("검색 전체조회 :1, 이름 :2, 지역 :3, 나이 :4 종료:0");
		gubun = sc.nextInt();
		
		ArrayList<dto> arr = null;
		if(gubun == 1) {
//			arr = dao.getListAll();
			arr = dao.getMemberList(gubun,"",0,0);
		}else if(gubun ==2) {
			System.out.print("검색할 이름 : ");
			String searchName = sc.next();
//			arr = dao.getListName(searchName);
			arr = dao.getMemberList(gubun,searchName,0,0);
		}else if(gubun ==3) {
			System.out.print("검색할 지역 : ");
			String searchArea = sc.next();
//			arr = dao.getListArea(searchArea);
			arr = dao.getMemberList(gubun,searchArea,0,0);
		}else if(gubun ==4) {
			System.out.print("몇살부터? : ");
			int startAge = sc.nextInt();
			System.out.print("몇살까지? : ");
			int endAge = sc.nextInt();
//			arr = dao.getListAge(age1, age2);
			arr = dao.getMemberList(gubun,"",startAge, endAge);
		}else {
			
		}
		System.out.println("ID\tNAME\tAREA\tAGE");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i).getId()+"\t");
			System.out.print(arr.get(i).getName()+"\t");
			System.out.print(arr.get(i).getArea()+"\t");
			System.out.print(arr.get(i).getAge()+"\n");
		}
		}while(gubun != 0);
	}

}
