import java.util.*;

public class day_3_dowhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int a = 0;
		do {
			System.out.print("숫자 입력 : ");
			a = sc.nextInt();
			a--;
		}while(a !=0);

		System.out.println("do while 종료!");
	}

}
