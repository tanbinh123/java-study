import java.util.*;
public class today_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner cs = new Scanner(System.in);
		math math = new math();
		
		System.out.print("����� ������ �Է����ּ��� : " );
		int a = cs.nextInt();
		
		
		//String score = math.getScore(a);
		String sumyg = math.getSumyg(a);
		
		
		System.out.print("����� " + a + "�� �̹Ƿ� " + /*score +" �̸� */"����� " + sumyg +" �Դϴ�.");
	}

}
