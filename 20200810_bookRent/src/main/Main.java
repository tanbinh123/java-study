package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.book_dao;
import dto.book_dto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<book_dto> arr = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int workGubun = 0, gubun = 0, showGubun = 0;
		book_dao dao = new book_dao();
		
		
		
		do {
		System.out.println("회원관리[1], 도서관리[2], 대여[3], 반납[4], 종료[0]");
		workGubun = sc.nextInt();
		
		if(workGubun == 1) {
		do {
			System.out.println("회원 조회 [1], 등록[2], 수정[3], 삭제[4], 이전[0]");
			gubun = sc.nextInt();
			if(gubun == 1) {
				System.out.println("전체조회[1], 아이디로 조회[2], 이름으로 조회[3]");
				showGubun = sc.nextInt();
				if(showGubun == 1) {
					arr = dao.selectDB(showGubun, "", "");
				}else if(showGubun == 2) {
					System.out.print("찾을 아이디 입력 : ");
					String id = sc.next();
					arr = dao.selectDB(showGubun, id, "");
				}else if(showGubun == 3) {
					System.out.print("찾을 이름 입력 : ");
					String name = sc.next();
					arr = dao.selectDB(showGubun, "", name);
				}
				for (int i = 0; i < arr.size(); i++) {
					System.out.print(arr.get(i).getId()+"\t");
					System.out.print(arr.get(i).getName()+"\t");
					System.out.print(arr.get(i).getAddress()+"\t");
					System.out.print(arr.get(i).getTel()+"\t");
					System.out.print(arr.get(i).getAge()+"\t");
					System.out.print(arr.get(i).getReg_date()+"\n");
				}
				
			}else if(gubun == 2) {
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("이름 입력 : ");
				String name = sc.next();
				System.out.print("주소 입력 : ");
				String address = sc.next();
				System.out.print("전화번호 입력 : ");
				String tel = sc.next();
				System.out.print("나이 입력 : ");
				int age = sc.nextInt();
				System.out.print("가입날짜 입력 : ");
				String reg_date = sc.next();
				int result = dao.insertDB(id, name, address, tel, age, reg_date);
				System.out.println(result+"행 등록됌");
			}else if(gubun == 3) {
				arr = dao.selectDB(1, "", "");
				System.out.print("수정 할 ");
			}else if(gubun == 4) {
				
			}else if(gubun == 0) {
				
			}
		}while(gubun != 0);
		}
		else if(workGubun == 2) {
			
		}
		else if(workGubun == 3) {
			
		}
		else if(workGubun == 4) {
			
		}
		else if(workGubun == 0) {
			
		}
	}while(workGubun != 0);
		
	System.out.println("시스템 종료");
}

	private static int insertDB(String id, String name, String address, String tel, int age, String reg_date) {
		// TODO Auto-generated method stub
		return 0;
	}
}
