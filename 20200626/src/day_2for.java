import java.util.Scanner;

public class day_2for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�� �ܺ��� : ");
		int start = sc.nextInt();
		System.out.print("�� �ܱ��� : ");
		int end = sc.nextInt();
		

		for(int i=start; i<=end;i++) {
			System.out.println(i+"��");
			for(int j=1; j<=9;j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
		}
	}

}
