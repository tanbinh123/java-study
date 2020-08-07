package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.score_dao;
import dto.score_dto;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		score_dao dao = new score_dao();
		ArrayList<score_dto> arr = new ArrayList<>();
		int gubun = 0, select = 0, eng = 0, mat = 0;
		String blank = "" , no;
		
		do {
			System.out.print("검색:[1], 등록[2], 수정[3], 삭제[4], 종료[0] ? ");
			gubun = sc.nextInt();
			try {
			if(gubun == 1) {
				do {
				System.out.print("전체[1] 번호[2] 이름[3] 종료[0]? ");
				select = sc.nextInt();
				if(select == 1) {
					arr = dao.selectDB(blank, blank);
				}
				else if(select == 2) {
					System.out.print("번호 입력 : ");
					no = sc.next();
					arr = dao.selectDB(no, blank);
				}
				else if(select == 3) {
					System.out.print("이름 입력 : ");
					String name = sc.next();
					arr = dao.selectDB(blank,name);
				}
				if(arr.size() != 0) {
					System.out.println("====================================================");
					System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균");
					System.out.println("----------------------------------------------------");
				}
				for (int i = 0; i < arr.size(); i++) {
					System.out.print(arr.get(i).getNo()+"\t");
					System.out.print(arr.get(i).getName()+"\t");
					System.out.print(arr.get(i).getKor()+"\t");
					System.out.print(arr.get(i).getEng()+"\t");
					System.out.print(arr.get(i).getMat()+"\t");
					System.out.print(arr.get(i).getTotal()+"\t");
					System.out.print(arr.get(i).getAva()+"\n");
				}
				if(arr.size() != 0)System.out.println("===================================================="); 
				}while(select != 0);
			}else if(gubun == 2) {
				do {
				System.out.print("번호 입력 :");
				no = sc.next();
				if(no.length() > 4) {
					System.out.println("4자리 이하만 입력 가능");
					no = "";
				}
				}while(no.length() > 4 || no.equals(""));
				System.out.print("이름 입력 :");
				String name = sc.next();
				
				
				System.out.println("국어 점수 입력 : ");
				int kor = sc.nextInt();
				if(kor > 100 || kor < 0) {
					do {
					System.out.println("0~100 사이 값 입력");
					kor = sc.nextInt();
					}while(kor > 100 || kor < 0);
				}
				
				
				do {
				System.out.println("영어 점수 입력 : ");
				eng = sc.nextInt();
				if(eng <= 0 ||eng >= 100) {
					System.out.println("0~100 사이 값 입력 : ");
				}
				}while(eng < 0 ||eng > 100);
				
						
				do {
				System.out.println("수학 점수 입력 : ");
				mat = sc.nextInt();
				if(mat <= 0 ||mat >= 100) {
					System.out.println("0~100 사이 값 입력 : ");
				}
				}while(mat < 0 ||mat > 100);
				
				
				int result = dao.insertDB(no,name,kor,eng,mat);
				System.out.println(result + "행 등록됌");
				
			}else if(gubun == 3) {
				System.out.print("수정 대상 번호 입력 :");
				no = sc.next();
				arr = dao.selectDB(no, blank);
				
				System.out.print("바꿀 이름 입력 " + arr.get(0).getName() + " -> : ");
				String name = sc.next();
				System.out.println("바꿀 국어 점수 입력 " +  arr.get(0).getKor() + " -> : ");
				int kor = sc.nextInt();
				System.out.println("바꿀 영어 점수 입력 " +  arr.get(0).getEng() + " -> : ");
				eng = sc.nextInt();
				System.out.println("바꿀 수학 점수 입력 " +  arr.get(0).getMat() + " -> : ");
				mat = sc.nextInt();
				
				int result = dao.updateDB(no, name, kor, eng, mat);
				System.out.println(result + "행 수정됌");
			}else if(gubun == 4) {
				System.out.print("삭제할 번호 : ");
				String deleteNo = sc.next();
				int result = dao.deleteDB(deleteNo);
				System.out.println(result + "행 삭제됌");
			}else if(gubun == 0) {
				System.out.println("종료되었습니다.");
			}
			}catch(Exception error){
				System.out.println("입력 오류 \n종료되었습니다."+error.getMessage());
				gubun = 0;
			}
		}while(gubun != 0);
	}

}
