import java.util.Scanner;

public class day_2for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("단 입력 : ");
		int num = sc.nextInt();
		
		System.out.println(num + "단");
		for(int a=1 ; a<=9; a++) {
			System.out.println(num + "*" + a + "=" + num * a);
		}
	}

}
