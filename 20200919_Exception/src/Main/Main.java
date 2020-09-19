package Main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 10;
		int j = 0;
		int r = 0;
		
		System.out.println("Exception BEFORE");
		
		try {
			r = i / j;
		}catch(Exception e) {
			e.printStackTrace();
			String msg = e.getMessage();
			System.out.println("Exception : " + msg);
		}
		
		System.out.println("Exception AFTER");
	}
	
	//finally 예외 관계없이 무조건 실행
	//throws 예외 발생시 호출한 곳으로 예외처리 넘김

}
