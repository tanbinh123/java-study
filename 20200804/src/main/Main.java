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
		int gubun = 0, selectgubun = 0;
		String blankString = "";
		int blankValue = 0;
		
		do {
			try {
			System.out.print(
					"=================\n"
					+ "       메인 메뉴\n"
					+ "=================\n"
					+"조회:1 \n"
					+ "입력:2  \n"
					+ "수정:3 \n"
					+ "삭제:4\n"
					+ "종료:0\n"
					+ "=================\n"
					+ "입력 : ");
			gubun = sc.nextInt();
			
			//조회
			if(gubun == 1) {
				do {
					System.out.print(
						"=================\n"
						+"       조회 메뉴\n"
						+"=================\n"
						+"전체조회:1 \n"
						+ "번호로조회:2 \n"
						+ "이름으로조회:3 \n"
						+ "지역으로 조회:4 \n"
						+ "종료:0 \n"
						+ "=================\n"
						+ "입력 : ");
				selectgubun = sc.nextInt();
				if(selectgubun == 1) {
					arr = dao.selectDB(selectgubun, blankString, blankString, blankString, blankValue);
				}
				else if (selectgubun == 2) {
					System.out.print("번호로 검색 : ");
					String no = sc.next();
					arr = dao.selectDB(selectgubun, no, blankString, blankString, blankValue);
				}
				else if (selectgubun == 3) {
					System.out.print("이름으로 검색 : ");
					String name = sc.next();
					name= name.toUpperCase();
					arr = dao.selectDB(selectgubun, blankString, name, blankString, blankValue);
				}
				else if (selectgubun == 4) {
					System.out.print("지역명으로 검색 : ");
					String area = sc.next();
					area= area.toUpperCase();
					arr = dao.selectDB(selectgubun, blankString, blankString, area, blankValue);
				}
				else if(selectgubun == 0) {
					System.out.println("-----조회메뉴 종료-----");
				}
				if(arr.size() != 0) {
				System.out.println("번호\t이름\t지역\t나이");
				for (int i = 0; i < arr.size(); i++) {
					System.out.print(arr.get(i).getNo()+"\t");
					System.out.print(arr.get(i).getName()+"\t");
					System.out.print(arr.get(i).getArea()+"\t");
					System.out.print(arr.get(i).getAge()+"\n");
				}
				System.out.println("-----조회 완료-----");
				}
				gubun = -1;
			}while(selectgubun != 0);
				
				
			//등록
			}else if(gubun == 2) {
				System.out.print("=================\n"
						+"       등록 화면\n"
						+"=================\n");
				System.out.print("번호 입력 : ");
				String no = sc.next();
				System.out.print("이름 입력 : ");
				String name = sc.next();
				System.out.print("지역 입력 : 서울[10], 대전[20], 부산[30] : ");
				String area = sc.next();
				if(area.equals("10")||area.equals("20")||area.equals("30")) {
				System.out.print("나이 입력 : ");
				int age = sc.nextInt();
				testDB_dto dto = new testDB_dto(no,name,area,age);
				int result = dao.insertDB(dto); // dao.insertDB(no, name, area, age);
				System.out.println("-----입력 완료-----");
				System.out.println("-----"+result + "행 업데이트됌-----");
				}
				else {
					System.out.println("다시 입력해주세요.");
				}
				
			//수정	
			}else if(gubun == 3) {
				System.out.print("=================\n"
						+"       수정 화면\n"
						+"=================\n");
				System.out.print("수정할 번호 입력 : ");
				String whereno = sc.next();
				System.out.print("번호 입력 : ");
				String no = sc.next();
				System.out.print("이름 입력 : ");
				String name = sc.next();
				System.out.print("지역 입력 : 서울[10], 대전[20], 부산[30] : ");
				String area = sc.next();
				System.out.print("나이 입력 : ");
				int age = sc.nextInt();
				int result = dao.updateDB(no, name, area, age, whereno);
				System.out.println("-----수정 완료-----");
				System.out.println("-----"+result + "행 업데이트됌-----");
				
			//삭제	
			}else if(gubun == 4) {
				System.out.print("=================\n"
						+"       삭제 화면\n"
						+"=================\n");
				System.out.print("삭제할 번호 입력 : ");
				String no = sc.next();
				int result = dao.deleteDB(no, blankString, blankString, blankValue);
				System.out.println("번호 : "+no + " 삭제 완료");
				System.out.println("-----"+result + "행 업데이트됌-----");
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
