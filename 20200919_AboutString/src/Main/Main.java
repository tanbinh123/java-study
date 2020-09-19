package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		//String 생성
		String str1 = new String("aa");
		
		System.out.println(str1);
		
		String str = "JAVA";
		System.out.println(str);
		
		str = str + "_8";
		System.out.println(str);
	
	
	
	
		//StringBlider가 속도가 빠르고 StringBuffer가 테이터 안정성 더 좋음
		//객체 생성
		StringBuffer sf = new StringBuffer("Java");
		System.out.println(sf);

		//글자 추가 append
		sf.append("_8");
		System.out.println(sf);
		
		//문자 길이
		System.out.println(sf.length());
		
		//문자열 추가 (어디에, 무엇을)
		sf.insert(sf.length(), "~~~~");
		System.out.println(sf);
		
		//문자열 삭제(어디에서부터, 어디까지)
		sf.delete(2, 5);
		System.out.println(sf);
		
		
		StringBuilder sb = new StringBuilder("JAVA WORLD!!");
		System.out.println(sb);
		
	}

}
