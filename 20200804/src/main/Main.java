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
		int gubun = 0, selectGubun = 0;
		String blankString = "";
		int blankValue = 0;
		int result = 0;
		
		do {
			try {
			System.out.print(
					"==================\n"
					+ "‖    메인 메뉴      ‖\n"
					+ "==================\n"
					+ "‖조   회:\t\t1‖ \n"
					+ "‖입   력:\t\t2‖  \n"
					+ "‖수   정:\t\t3‖ \n"
					+ "‖삭   제:\t\t4‖\n"
					+ "‖종   료:\t\t0‖\n"
					+ "==================\n"
					+ "입력 : ");
			gubun = sc.nextInt();
			
			//조회
			if(gubun == 1) {
				do {
					System.out.print(
						"=================\n"
						+"       조회 화면\n"
						+"=================\n"
						+"전체 조회:\t1 \n"
						+ "번호로 조회:\t2 \n"
						+ "이름으로 조회:\t3 \n"
						+ "지역으로 조회:\t4 \n"
						+ "나이로 조회:\t5 \n"
						+ "종료:\t\t0 \n"
						+ "=================\n"
						+ "입력 : ");
				selectGubun = sc.nextInt();
				if(selectGubun == 1) {
					arr = dao.selectDB(selectGubun, blankString, blankString, blankString, blankValue);
				}
				else if (selectGubun == 2) {
					System.out.print("번호로 검색 : ");
					String no = sc.next();
					arr = dao.selectDB(selectGubun, no, blankString, blankString, blankValue);
				}
				else if (selectGubun == 3) {
					System.out.print("이름으로 검색 : ");
					String name = sc.next();
					name= name.toUpperCase();
					arr = dao.selectDB(selectGubun, blankString, name, blankString, blankValue);
				}
				else if (selectGubun == 4) {
					System.out.print("지역명으로 검색 : ");
					String area = sc.next();
					area= area.toUpperCase();
					arr = dao.selectDB(selectGubun, blankString, blankString, area, blankValue);
				}
				else if(selectGubun == 0) {
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
				if(arr.size() == 0) {
					System.out.println("-----조회 결과 없음-----");
				}
				gubun = -1;
			}while(selectGubun != 0);
				
				
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
				result = dao.insertDB(dto); // dao.insertDB(no, name, area, age);
				System.out.println("-----입력 완료-----");
				System.out.println("-----"+result + "행 업데이트됌-----");
				}
				else {
					System.out.println("-----다시 입력해주세요.-----");
				}
				
			//수정	
			}else if(gubun == 3) {
				System.out.print("=================\n"
						+"       수정 화면\n"
						+"=================\n");
				System.out.print("수정할 번호 입력 : ");
				String whereno = sc.next();
				testDB_dto dto = dao.updateDB(whereno);
					System.out.print("이름 입력 : " + dto.getName() +" -> ") ;
					String name = sc.next();
					System.out.print("지역 입력 : 서울[10], 대전[20], 부산[30] : " + dto.getArea()+" -> ");
					String area = sc.next();
					if(area.equals("10")||area.equals("20")||area.equals("30")) {
					System.out.print("나이 입력 : " + dto.getAge()+" -> ");
					int age = sc.nextInt();
					System.out.println("수정하겠습니까?(Y/N)");
					String yn = sc.next();
					if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
						result = dao.updateDB(name, area, age, whereno);
					}else {
						gubun = 0;
					}
				System.out.println("-----수정 완료-----");
				System.out.println("----- "+result+" 행 업데이트됌-----");
				}
				else {
					System.out.println("-----다시 입력해주세요.-----");
				}
			//삭제	
			}else if(gubun == 4) {
				System.out.print("=================\n"
						+"       삭제 화면\n"
						+"=================\n");
				System.out.print("삭제할 번호 입력 : ");
				String no = sc.next();
				result = dao.deleteDB(no, blankString, blankString, blankValue);
				System.out.println("번호 : "+no + " 삭제 완료");
				System.out.println("-----"+result + "행 업데이트됌-----");
			}
			}catch(Exception e) {
				System.out.println("-----입력 오류-----");
				gubun = 0;
			}
		}while(gubun != 0);
		System.out.println("-----종료되었습니다-----");

}
}
