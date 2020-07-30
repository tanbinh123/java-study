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
				//arr = dao.selectTestDB();
				arr = dao.allControlTestDB(gubun, blankValue, blankString, blankString, blankValue);
				System.out.println("Empno\tEname\tJob");
				for (int i = 0; i < arr.size(); i++) {
					System.out.print(arr.get(i).getEmpno()+"\t");
					System.out.print(arr.get(i).getEname()+"\t");
					System.out.print(arr.get(i).getJob()+"\n");
				}
				System.out.println("-----조회 완료-----");
				gubun = -1;
				
			//입력	
			}else if(gubun == 2) {
				System.out.print("번호 입력 : ");
				int no = sc.nextInt();
				System.out.print("이름 입력 : ");
				String name = sc.next();
				System.out.print("직업 입력 : ");
				String job = sc.next();
				//arr = dao.insertTestDB(no, name, job);
				arr = dao.allControlTestDB(gubun, no, name, job, blankValue);
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
				//arr = dao.updateTestDB(no, name, job, where);
				arr = dao.allControlTestDB(gubun, no, name, job, where);
				System.out.println("-----수정 완료-----");
			
			//삭제	
			}else if(gubun == 4) {
				System.out.print("삭제할 번호 입력 : ");
				int no = sc.nextInt();
				//arr = dao.deleteTestDB(no);
				arr = dao.allControlTestDB(gubun, no, blankString, blankString, blankValue);
				System.out.println("empno:"+no + " 삭제 완료");
			}else if(gubun == 0) {
				System.out.println("-----종료되었습니다-----");
			}
			}catch(Exception e) {
				System.out.println("입력 오류");
				gubun = 0;
			}
		}while(gubun != 0);


}
}
