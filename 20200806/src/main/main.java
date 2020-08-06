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
		int gubun = 0;
		
		
		do {
			System.out.print("검색:[1], 등록[2], 수정[3], 삭제[4], 종료[0] ?");
			gubun = sc.nextInt();
			if(gubun == 1) {
				
			}else if(gubun == 2) {
				System.out.print("번호 입력 :");
				String no = sc.next();
				System.out.print("이름 입력 :");
				String name = sc.next();
				System.out.println("국어 점수 입력 : ");
				int kor = sc.nextInt();
				System.out.println("영어 점수 입력 : ");
				int eng = sc.nextInt();
				System.out.println("수학 점수 입력 : ");
				int mat = sc.nextInt();
				
				int result = dao.insertDB(no,name,kor,eng,mat);
				System.out.println(result + "업데이트");
				
			}else if(gubun == 3) {
				
			}else if(gubun == 4) {
				
			}
		}while(gubun != 0);
	}

}
