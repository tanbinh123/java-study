import java.util.Scanner;

public class day_2for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("�� �Է� : ");
		int num = sc.nextInt();
		
		System.out.println(num + "��");
		for(int a=1 ; a<=9; a++) {
			System.out.println(num + "*" + a + "=" + num * a);
		}
	}

}
