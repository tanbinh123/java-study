import java.util.*;
public class today_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner cs = new Scanner(System.in);
		math math = new math();
		
		System.out.print("당신의 점수를 입력해주세요 : " );
		int a = cs.nextInt();
		
		
		//String score = math.getScore(a);
		String sumyg = math.getSumyg(a);
		
		
		System.out.print("당신은 " + a + "점 이므로 " + /*score +" 이며 */"등급은 " + sumyg +" 입니다.");
	}

}
