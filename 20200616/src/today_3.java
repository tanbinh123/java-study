import java.util.*;
public class today_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner cs = new Scanner(System.in);
		math math = new math();
		
		System.out.print("당신의 점수를 입력해주세요 : " );
		int a = cs.nextInt();
		
		
		String score = math.getScore(a);
		

		System.out.print("당신은 " + a + "점 이므로 " + score);
		
		/*
		if(a >= 90) {
			System.out.println("수");
		}
		else if(a >= 80){
			System.out.println("우");
		}
		else if(a >= 70){
			System.out.println("미");
		}
		else if(a >= 60){
			System.out.println("양");
		}
		else{
			System.out.println("가");
		}*/
	}

}
