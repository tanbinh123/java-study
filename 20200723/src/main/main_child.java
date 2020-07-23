package main;

public class main_child extends main_parents {
	
	
		public main_child() {
			System.out.println("자식 클래스 생성");
		}
		public void childPrint() {
			System.out.println("child~~");
		}
		
		@Override //오버라이드(상속)와 오버로딩(매개변수) 착각 주의
		public void samePrint() {
			System.out.println("중복2");
		}
		
}
