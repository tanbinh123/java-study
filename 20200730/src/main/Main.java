package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.testdao;
import dto.testDB_dto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Scanner sc = new Scanner(System.in);
		testdao dao = new testdao();	
		
		ArrayList<testDB_dto> arr = null;
		int gubun = 0;
		System.out.print("조회:1 입력:2  수정:3 삭제:4 종료:0 ");
		gubun = sc.nextInt();
		
		do {
			if(gubun == 1) {
				dao.selectTestDB();
			}else if(gubun == 2) {
				System.out.print("번호 입력 : ");
				int no = sc.nextInt();
				System.out.print("이름 입력 : ");
				String name = sc.next();
				System.out.print("직업 입력 : ");
				String job = sc.next();
				arr = dao.insertTestDB(no, name, job);
				System.err.println("입력 완료");
			}else if(gubun == 3) {
				
			}else if(gubun == 4) {
				
			}else if(gubun == 0) {
				System.out.println("-----종료되었습니다-----");
			}
		}while(gubun != 0);


}
}
