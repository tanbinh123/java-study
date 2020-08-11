package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.book_dao;
import dao.member_dao;
import dto.book_dto;
import dto.member_dto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<member_dto> memberArr = new ArrayList<>();
		ArrayList<book_dto> bookArr = new ArrayList<>();
		member_dao memberDao = new member_dao();
		book_dao bookDao = new book_dao();
		Scanner sc = new Scanner(System.in);
		int workGubun = 0, gubun = 0, showGubun = 0, age = 0;
		String telValue= "", tel = "";
		
		
		
		do {
			try {
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
							memberArr = memberDao.selectDB(showGubun, "", "");
						}else if(showGubun == 2) {
							System.out.print("찾을 아이디 입력 : ");
							String id = sc.next();
							id = id.toUpperCase();
							memberArr = memberDao.selectDB(showGubun, id, "");
						}else if(showGubun == 3) {
							System.out.print("찾을 이름 입력 : ");
							String name = sc.next();
							memberArr = memberDao.selectDB(showGubun, "", name);
						}
						for (int i = 0; i < memberArr.size(); i++) {
							System.out.print(memberArr.get(i).getId()+"\t");
							System.out.print(memberArr.get(i).getName()+"\t");
							System.out.print(memberArr.get(i).getAddress()+"\t");
							System.out.print(memberArr.get(i).getTel()+"\t");
							System.out.print(memberArr.get(i).getAge()+"\t");
							System.out.print(memberArr.get(i).getReg_date()+"\n");
						}
						
					}else if(gubun == 2) {
						String id ="";
						memberArr = memberDao.selectDB(1, "", "");
						if(memberArr.size() == 0) {
							id = "B0001";
						}else {
							id = memberDao.insertDBNo();
							id = memberDao.getNo(id);
						}
						System.out.print("이름 입력 : ");
						String name = sc.next();
						System.out.print("주소 입력 : ");
						String address = sc.next();
						
						do {
						System.out.print("전화번호 입력 : ");
						tel = sc.next();
						for(int i=0;i<tel.length();i++){
							 char c = tel.charAt(i);
							 if(c<48 || c> 57){
							  System.out.println("전화 번호를 다시 입력해주세요");
							  telValue = "false";
							  tel = "";
							 }
							  else if(c>48 || c<57) {
							  telValue  = "ture";
							  }
							 }
						if(tel.length() > 13) {
							System.out.println("전화번호는 13자리까지만 입력해주세요");
							telValue = "false";
							tel = "";
						}
						}while(!telValue.equals("ture"));
						String Tel = memberDao.phone(tel);
						
						
						
						do {
							System.out.print("나이 입력 : ");
							age = sc.nextInt();
							if(age>200) {
								System.out.println("나이를 다시 입력해주세요");
							}
							}while(age>200);
						
						int result = memberDao.insertDB(id, name, address, Tel, age);
						System.out.println(result+"행 등록됌");
						
					}else if(gubun == 3) {
						System.out.print("수정할 아이디 검색 : ");
						String id = sc.next();
						id = id.toUpperCase();
						memberArr = memberDao.selectDB(2, id, "");
						System.out.print("기존 이름 : "+memberArr.get(0).getName()+"\n수정 할 이름 : ");
						String name = sc.next();
						System.out.print("기존 주소 : "+memberArr.get(0).getAddress()+"\n수정 할 주소 : ");
						String address = sc.next();
						
						do {
							System.out.print("기존 전화번호 : "+memberArr.get(0).getTel()+"\n수정 할 전화번호 : ");
							tel = sc.next();
							for(int i=0;i<tel.length();i++){
								 char c = tel.charAt(i);
								 if(c<48 || c> 57){
								  System.out.println("전화 번호를 다시 입력해주세요");
								  telValue = "false";
								  tel = "";
								 }
								  else if(c>48 || c<57) {
								  telValue  = "ture";
								  }
								 }
							if(tel.length() > 13) {
								System.out.println("전화번호는 13자리까지만 입력해주세요");
								telValue = "false";
								tel = "";
							}
							}while(!telValue.equals("ture"));
							String Tel = memberDao.phone(tel);
						
						do {
							System.out.print("기존 나이 : "+memberArr.get(0).getAge()+"\n수정 할 나이 : ");
							age = sc.nextInt();
							if(age>200) {
								System.out.println("나이를 다시 입력해주세요");
							}
							}while(age>200);
						
						int result = memberDao.updateDB(id, name, address, tel, age);
						System.out.println(result + "행 수정됌");
						
					}else if(gubun == 4) {
						System.out.print("삭제 할 아이디 검색 : ");
						String id = sc.next();
						id = id.toUpperCase();
						int result = memberDao.deleteDB(id);
						System.out.println(result + "행 삭제됌");
					}else if(gubun == 0) {
						
					}
				}while(gubun != 0);
				}
				else if(workGubun == 2) {
					System.out.println("도서 조회 [1], 등록[2], 수정[3], 삭제[4], 이전[0]");
					gubun = sc.nextInt();
					if(gubun == 1) {
						System.out.println("전체조회[1], 책 제목으로 조회[2], 작가명으로 조회[3]");
						showGubun = sc.nextInt();
						if(showGubun == 1) {
							bookArr = bookDao.selectDB(showGubun, "", "");
						}else if(showGubun == 2) {
							System.out.print("찾을 책 번호 입력 : ");
							String no = sc.next();
							no = no.toUpperCase();
							bookArr = bookDao.selectDB(showGubun, no, "");
						}else if(showGubun == 3) {
							System.out.print("찾을 책 이름 입력 : ");
							String name = sc.next();
							bookArr = bookDao.selectDB(showGubun, "", name);
						}
						for (int i = 0; i < memberArr.size(); i++) {
							System.out.print(bookArr.get(i).getNo()+"\t");
							System.out.print(bookArr.get(i).getName()+"\t");
							System.out.print(bookArr.get(i).getPublisher()+"\t");
							System.out.print(bookArr.get(i).getWriter()+"\t");
							System.out.print(bookArr.get(i).getReg_date()+"\t");
							System.out.print(bookArr.get(i).getRent_gubun()+"\n");
						}
				}
					}
				else if(workGubun == 3) {
					
				}
				else if(workGubun == 4) {
					
				}
				else if(workGubun == 0) {
					
				}
			}catch(Exception e){	
				System.out.println("입력 오류");
				workGubun = 0;
			}
	}while(workGubun != 0);

	System.out.println("시스템 종료");
		
}
}
