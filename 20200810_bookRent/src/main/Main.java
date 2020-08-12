package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.book_dao;
import dao.member_dao;
import dao.rent_dao;
import dao.return_dao;
import dto.book_dto;
import dto.member_dto;
import dto.rent_dto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<member_dto> memberArr = new ArrayList<>();
		ArrayList<book_dto> bookArr = new ArrayList<>();
		ArrayList<rent_dto> rentArr = new ArrayList<>();
		member_dao memberDao = new member_dao();
		book_dao bookDao = new book_dao();
		rent_dao rentDao = new rent_dao();
		return_dao returnDao = new return_dao();
		Scanner sc = new Scanner(System.in);
		int workGubun = 0, gubun = 0, showGubun = 0, age = 0;
		String telValue= "", tel = "";
		
		
		
		do {
			try {
				System.out.println("║===========================================║");
				System.out.println(
						"║ _      _  _                               ║\r\n" + 
						"║| |    (_)| |                              ║\r\n" + 
						"║| |     _ | |__   _ __   __ _  _ __  _   _ ║\r\n" + 
						"║| |    | || '_ \\ | '__| / _` || '__|| | | |║\r\n" + 
						"║| |____| || |_) || |   | (_| || |   | |_| |║\r\n" + 
						"║\\_____/|_||_.__/ |_|    \\__,_||_|    \\__, |║\r\n" + 
						"║                                      __/ |║\r\n" + 
						"║                                     |___/ ║" );
				System.out.println("║===========================================║");
				System.out.println("║회원 관리--------[1]     도서 관리--------[2]║");
				System.out.println("║도서 대여--------[3]     도서 반납--------[4]║");
				System.out.println("║종료 하기--------[0]                        ║");
				System.out.println("║===========================================║");
				System.out.print("입력 : ");
				workGubun = sc.nextInt();
				
				if(workGubun == 1) {
					System.out.println("║============================================║");
					System.out.println(
							"║___  ___                  _                 ║\r\n" + 
							"║|  \\/  |                 | |                ║\r\n" + 
							"║| .  . |  ___  _ __ ___  | |__    ___  _ __ ║\r\n" + 
							"║| |\\/| | / _ \\| '_ ` _ \\ | '_ \\  / _ \\| '__|║\r\n" + 
							"║| |  | ||  __/| | | | | || |_) ||  __/| |   ║\r\n" + 
							"║\\_|  |_/ \\___||_| |_| |_||_.__/  \\___||_|   ║");
					System.out.println("║============================================║");
					System.out.println("║회원 조회--------[1]     회원 등록--------[2] ║");
					System.out.println("║회원 수정--------[3]     회원 삭제--------[4] ║");
					System.out.println("║이전 화면--------[0]                         ║");
					System.out.println("║============================================║");
					System.out.print("입력 : ");
					gubun = sc.nextInt();
					if(gubun == 1) {
						System.out.println("║===========================================║");
						System.out.println(""
								+ "║           _   _  _                        ║\r\n" + 
								  "║          | | | |(_)                       ║\r\n" + 
								  "║          | | | | _   ___ __      __       ║\r\n" + 
								  "║          | | | || | / _ \\\\ \\ /\\ / /       ║\r\n" + 
								  "║          \\ \\_/ /| ||  __/ \\ V  V /        ║\r\n" + 
							      "║           \\___/ |_| \\___|  \\_/\\_/         ║");
						System.out.println("║===========================================║");
						System.out.println("║전체 조회--------[1]    아이디로 조회-----[2]║");
						System.out.println("║이름으로 조회-----[3]    이전 화면--------[0]║");
						System.out.println("║===========================================║");
						System.out.print("입력 : ");
						showGubun = sc.nextInt();
						if(showGubun == 1) {
							memberArr = memberDao.selectDB(showGubun, "", "");
						}else if(showGubun == 2) {
							System.out.println("║===========================================║");
							System.out.println("║             아이디로 회원 조회                     ║");
							System.out.println("║===========================================║");
							System.out.print("조회할 아이디 입력 : ");
							String id = sc.next();
							id = id.toUpperCase();
							memberArr = memberDao.selectDB(showGubun, id, "");
						}else if(showGubun == 3) {
							System.out.println("║===========================================║");
							System.out.println("║             이름으로 회원 조회                     ║");
							System.out.println("║===========================================║");
							System.out.print("조회할 이름 입력 : ");
							String name = sc.next();
							memberArr = memberDao.selectDB(showGubun, "", name);
						}
						if(memberArr.size() != 0) {
							
							System.out.println("║=========================================================║");
							System.out.println(""
									+ "║          ______                    _  _                 ║\r\n" + 
									  "║          | ___ \\                  | || |                ║\r\n" + 
									  "║          | |_/ /  ___  ___  _   _ | || |_               ║\r\n" + 
								   	  "║          |    /  / _ \\/ __|| | | || || __|              ║\r\n" + 
									  "║          | |\\ \\ |  __/\\__ \\| |_| || || |_               ║\r\n" + 
									  "║          \\_| \\_| \\___||___/ \\__,_||_| \\__|              ║");
						System.out.println("║=========================================================║");
							System.out.println("║아이디\t이름\t주소\t전화 번호\t나이\t가입일\t  ║");
							System.out.println("║=========================================================║");
							for (int i = 0; i < memberArr.size(); i++) {
								System.out.print("║"+memberArr.get(i).getId()+"\t");
								System.out.print(memberArr.get(i).getName()+"\t");
								System.out.print(memberArr.get(i).getAddress()+"\t");
								System.out.print(memberArr.get(i).getTel()+"\t");
								System.out.print(memberArr.get(i).getAge()+"\t");
								System.out.print(memberArr.get(i).getReg_date()+"║\n");
							}
							System.out.println("║=========================================================║");
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
						System.out.println("║===========================================║");
						System.out.println("║                  회원 등록                          ║");
						System.out.println("║===========================================║");
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
						System.out.println("║==============="+result+"행 등록되었습니다============║");
						
					}else if(gubun == 3) {
						System.out.println("║===========================================║");
						System.out.println("║                회원 정보 수정                      ║");
						System.out.println("║===========================================║");
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
						System.out.println("║==============="+result+"행 수정되었습니다============║");
						
					}else if(gubun == 4) {
						System.out.println("║===========================================║");
						System.out.println("║                 회원 삭제                           ║");
						System.out.println("║===========================================║");
						System.out.print("삭제 할 아이디 검색 : ");
						String id = sc.next();
						id = id.toUpperCase();
						int result = memberDao.deleteDB(id);
						System.out.println("║==============="+result+"행 삭제되었습니다============║");
					}else if(gubun == 0) {
					}
				}
				else if(workGubun == 2) {
					System.out.println("║===========================================║");
					System.out.println(
							"║       ______                _             ║\r\n" + 
							"║       | ___ \\              | |            ║\r\n" + 
							"║       | |_/ /  ___    ___  | | __         ║\r\n" + 
							"║       | ___ \\ / _ \\  / _ \\ | |/ /         ║\r\n" + 
							"║       | |_/ /| (_) || (_) ||   <          ║\r\n" + 
							"║       \\____/  \\___/  \\___/ |_|\\_\\         ║");
					System.out.println("║===========================================║");
					System.out.println("║도서 조회--------[1]     도서 등록--------[2]║");
					System.out.println("║도서 정보 수정----[3]     도서 삭제--------[4]║");
					System.out.println("║이전 화면--------[0]                        ║");
					System.out.println("║===========================================║");
					System.out.print("입력 : ");
					gubun = sc.nextInt();
					if(gubun == 1) {
						System.out.println("║===========================================║");
						System.out.println(""
								+ "║           _   _  _                        ║\r\n" + 
								  "║          | | | |(_)                       ║\r\n" + 
								  "║          | | | | _   ___ __      __       ║\r\n" + 
								  "║          | | | || | / _ \\\\ \\ /\\ / /       ║\r\n" + 
								  "║          \\ \\_/ /| ||  __/ \\ V  V /        ║\r\n" + 
							      "║           \\___/ |_| \\___|  \\_/\\_/         ║");
						System.out.println("║===========================================║");
						System.out.println("║전체 조회--------[1]   책 제목으로  조회---[2]║");
						System.out.println("║작가명으로 조회 ---[3]    회원 삭제--------[4]║");
						System.out.println("║이전 화면--------[0]                        ║");
						System.out.println("║===========================================║");
						System.out.print("입력 : ");
						showGubun = sc.nextInt();
						if(showGubun == 1) {
							bookArr = bookDao.selectDB(showGubun, "", "","");
						}else if(showGubun == 2) {
							System.out.println("║===========================================║");
							System.out.println("║             책이름으로 회원 조회                  ║");
							System.out.println("║===========================================║");
							System.out.print("조회할 책 이름 입력 : ");
							String no = sc.next();
							no = no.toUpperCase();
							bookArr = bookDao.selectDB(showGubun, no, "","");
						}else if(showGubun == 3) {
							System.out.println("║===========================================║");
							System.out.println("║            작가명으로 회원 조회                    ║");
							System.out.println("║===========================================║");
							System.out.print("조회할 작가명 입력 : ");
							String name = sc.next();
							bookArr = bookDao.selectDB(showGubun, "", name,"");
						}
						
						if(bookArr.size() != 0) {
							System.out.println("║=================================================║");
							System.out.println(""
									+ "║       ______                    _  _            ║\r\n" + 
									  "║       | ___ \\                  | || |           ║\r\n" + 
									  "║       | |_/ /  ___  ___  _   _ | || |_          ║\r\n" + 
								   	  "║       |    /  / _ \\/ __|| | | || || __|         ║\r\n" + 
									  "║       | |\\ \\ |  __/\\__ \\| |_| || || |_          ║\r\n" + 
									  "║       \\_| \\_| \\___||___/ \\__,_||_| \\__|         ║");
							System.out.println("║=================================================║");
							System.out.println("║책번호\t이름\t출판사\t저자\t가입일\t\t보유║");
							System.out.println("║=================================================║");
						
						for (int i = 0; i < bookArr.size(); i++) {
							System.out.print("║"+bookArr.get(i).getNo()+"\t");
							System.out.print(bookArr.get(i).getName()+"\t");
							System.out.print(bookArr.get(i).getPublisher()+"\t");
							System.out.print(bookArr.get(i).getWriter()+"\t");
							System.out.print(bookArr.get(i).getReg_date()+"\t");
							System.out.print(bookArr.get(i).getRent_gubun()+"║\n");
						}
							System.out.println("║=================================================║");
						}
				}else if(gubun == 2) {
					String no ="";
					bookArr = bookDao.selectDB(1, "", "","");
					if(bookArr.size() == 0) {
						no = "K001";
					}else {
						no = bookDao.insertDBNo();
						no = bookDao.getNo(no);
					}
					System.out.println("║===========================================║");
					System.out.println("║                  책 제품 등록                      ║");
					System.out.println("║===========================================║");
					System.out.print("책 제목 입력 : ");
					String name = sc.next();
					System.out.print("출판사 입력 : ");
					String publisher = sc.next();
					System.out.print("저자 입력 : ");
					String writer = sc.next();
					String rent_gubun = "y";
					
					int result = bookDao.insertDB(no, name, publisher, writer, rent_gubun);
					System.out.println("║==============="+result+"행 등록되었습니다============║");
				}else if(gubun == 3) {
					System.out.println("║===========================================║");
					System.out.println("║                  도서 정보 수정                   ║");
					System.out.println("║===========================================║");
					System.out.print("수정할 번호 검색 : ");
					String no = sc.next();
					no = no.toUpperCase();
					bookArr = bookDao.selectDB(4, "", "",no);
					System.out.print("기존 책 이름 : "+bookArr.get(0).getName()+"\n수정 할 책 이름 : ");
					String name = sc.next();
					System.out.print("기존 출판사 : "+bookArr.get(0).getPublisher()+"\n수정 할 출판사 : ");
					String publisher = sc.next();
					System.out.print("기존 저자 : "+bookArr.get(0).getWriter()+"\n수정 할 저자 : ");
					String writer = sc.next();
					int result = bookDao.updateDB(no, name, publisher, writer);
					System.out.println("║==============="+result+"행 수정되었습니다============║");
				}else if(gubun == 4) {
					System.out.println("║===========================================║");
					System.out.println("║                 회원 삭제                           ║");
					System.out.println("║===========================================║");
					System.out.print("삭제 할 번호 검색 : ");
					String id = sc.next();
					id = id.toUpperCase();
					int result = bookDao.deleteDB(id);
					System.out.println("║==============="+result+"행 삭제되었습니다============║");
				}
					}
				else if(workGubun == 3) {
					
					int memberExist =0;
					String member_id = "";
					int bookExist =0;
					String book_no = "";
					System.out.println("║===========================================║");
					System.out.println(
							"║         ______               _            ║\r\n" + 
							"║         | ___ \\             | |           ║\r\n" + 
							"║         | |_/ /  ___  _ __  | |_          ║\r\n" + 
							"║         |    /  / _ \\| '_ \\ | __|         ║\r\n" + 
							"║         | |\\ \\ |  __/| | | || |_          ║\r\n" + 
							"║         \\_| \\_| \\___||_| |_| \\__|         ║");
					System.out.println("║===========================================║");
					
					do {
					System.out.print("대여자 아이디 입력 : ");
					member_id = sc.next();
					member_id = member_id.toUpperCase();
					try {
						memberArr = memberDao.selectDBId(member_id);
						System.out.println(memberArr.get(0).getName()+"님");
						memberExist= 0;
					}catch(Exception e) {
						System.out.println("대여자 아이디를 다시 입력해주세요.");
						memberExist= 1;
					}
					}while(memberExist != 0);
					
					
					do {
						System.out.print("대여하고싶은 책 번호 입력 : ");
						book_no = sc.next();
						book_no = book_no.toUpperCase();
						try {
							bookArr = bookDao.selectDBId(book_no);
							if(bookArr.get(0).getRent_gubun().equals("y")) {
								System.out.println("책 제목 : "+bookArr.get(0).getName());
								bookExist= 0;
							}else if(bookArr.get(0).getRent_gubun().equals("n")){
								System.out.println("이미 대여 중인 책입니다.");
								bookExist= 1;
							}
						}catch(Exception e) {
							System.out.println("대여하고싶은 책 번호를 다시 입력해주세요.");
							bookExist= 1;
						}
						}while(bookExist != 0);
					
					String no ="";
					rentArr = rentDao.selectDB(1, "", "");
					if(rentArr.size() == 0) {
						no = "R0001";
					}else {
						no = rentDao.insertDBNo();
						no = rentDao.getNo(no);
					}
					int result = rentDao.insertDB(no, member_id, book_no);
					rentDao.updateDB(book_no);
					System.out.println("║=================================================║");
					System.out.println(""
							+ "║       ______                    _  _            ║\r\n" + 
							  "║       | ___ \\                  | || |           ║\r\n" + 
							  "║       | |_/ /  ___  ___  _   _ | || |_          ║\r\n" + 
						   	  "║       |    /  / _ \\/ __|| | | || || __|         ║\r\n" + 
							  "║       | |\\ \\ |  __/\\__ \\| |_| || || |_          ║\r\n" + 
							  "║       \\_| \\_| \\___||___/ \\__,_||_| \\__|         ║");
					System.out.println("║=================================================║");
					System.out.println(memberArr.get(0).getName()+"님 ║ "+bookArr.get(0).getName()+" ║ "+result + "권 대여되었습니다.");
				}
				else if(workGubun == 4) {
					int bookExist = 0;
					do {
					System.out.println("반납할 책 번호 입력 : ");
					String book_no = sc.next();
					book_no = book_no.toUpperCase();
					int result = returnDao.updateDB(book_no);
					if(result == 1) {
						returnDao.updateReturnDate(book_no);
						System.out.println("반납되었습니다.");
						bookExist = 0;
					}else {
						System.out.println("다시 입력해주세요.");
						bookExist = 1;
					}
					}while(bookExist != 0);
					
				}
				else if(workGubun == 0) {
					
				}
			}catch(Exception e){	
				System.out.println("입력 오류");
				workGubun = 0;
			}
			System.out.println("계속하려면 아무키나 입력...종료[0]");
			String keepgoing = sc.next();
			if(keepgoing.equals("0")) {
				workGubun = 0;
				System.out.println("시스템 종료");
			}
	}while(workGubun != 0);

	
		
}
}
