import java.util.*;
public class today_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner cs = new Scanner(System.in);
		math math = new math();
		
		System.out.print("����� ������ �Է����ּ��� : " );
		int a = cs.nextInt();
		
		
		String score = math.getScore(a);
		

		System.out.print("����� " + a + "�� �̹Ƿ� " + score);
		
		/*
		if(a >= 90) {
			System.out.println("��");
		}
		else if(a >= 80){
			System.out.println("��");
		}
		else if(a >= 70){
			System.out.println("��");
		}
		else if(a >= 60){
			System.out.println("��");
		}
		else{
			System.out.println("��");
		}*/
	}

}
