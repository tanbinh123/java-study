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
		String blankString = "";
		int blankValue = 0;
		
		do {
			try {
			System.out.println("조회:1 입력:2  수정:3 삭제:4 종료:0 ");
			gubun = sc.nextInt();
			//조회
			if(gubun == 1) {
				System.out.print("전체조회:1 \n사번으로조회:2 \n이름으로조회:3 \n부서명으로 조회:4 \n종료:0 \n");
				int selectgubun = sc.nextInt();
				if(selectgubun == 1) {
					arr = dao.selectlDB(gubun, selectgubun, blankValue, blankString, blankString, blankString, blankString, blankValue);
				}
				else if (selectgubun == 2) {
					System.out.print("사번으로 검색 : ");
					int no = sc.nextInt();
					arr = dao.selectlDB(gubun, selectgubun, blankValue, blankString, blankString, blankString, blankString, no);
				}
				else if (selectgubun == 3) {
					System.out.print("이름으로 검색 : ");
					String name = sc.next();
					name= name.toUpperCase();
					arr = dao.selectlDB(gubun, selectgubun, blankValue, name, blankString, blankString, blankString, blankValue);
				}
				else if (selectgubun == 4) {
					System.out.print("부서명으로 검색 : ");
					String dname = sc.next();
					dname= dname.toUpperCase();
					arr = dao.selectlDB(gubun, selectgubun, blankValue, blankString, blankString, blankString, dname, blankValue);
				}
				else if (selectgubun == 0) {
					gubun = 0;
				}
				System.out.println("Empno\tEname\tJob\tSal\tDnamer");
				for (int i = 0; i < arr.size(); i++) {
					System.out.print(arr.get(i).getEmpno()+"\t");
					System.out.print(arr.get(i).getEname()+"\t");
					System.out.print(arr.get(i).getJob()+"\t");
					System.out.print(arr.get(i).getSal()+"\t");
					System.out.print(arr.get(i).getDname()+"\n");
				}
				System.out.println("-----조회 완료-----");
				gubun = -1;
				/*
			//입력	
			}else if(gubun == 2) {
				System.out.print("번호 입력 : ");
				int no = sc.nextInt();
				System.out.print("이름 입력 : ");
				String name = sc.next();
				System.out.print("직업 입력 : ");
				String job = sc.next();
				System.out.print("연봉 입력 : ");
				String sal = sc.next();
				System.out.print("부서명 입력 : ");
				String dname = sc.next();
				arr = dao.allControlDB(gubun, blankValue, no, name, job, sal, dname, blankValue);
				System.out.println("-----입력 완료-----");
			
			//수정	
			}else if(gubun == 3) {
				System.out.print("수정할 번호 입력 : ");
				int where = sc.nextInt();
				System.out.print("번호 입력 : ");
				int no = sc.nextInt();
				System.out.print("이름 입력 : ");
				String name = sc.next();
				System.out.print("직업 입력 : ");
				String job = sc.next();
				arr = dao.allControlDB(gubun, blankValue, no, name, job, blankString,blankString,where);
				System.out.println("-----수정 완료-----");
			
			//삭제	
			}else if(gubun == 4) {
				System.out.print("삭제할 번호 입력 : ");
				int no = sc.nextInt();
				arr = dao.allControlDB(gubun, blankValue, no, blankString, blankString, blankString,blankString,blankValue);
				System.out.println("empno:"+no + " 삭제 완료");
			*/}else if(gubun == 0) {
				System.out.println("-----종료되었습니다-----");
			}
			}catch(Exception e) {
				System.out.println("입력 오류");
				gubun = 0;
			}
		}while(gubun != 0);


}
}
