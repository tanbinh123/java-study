import java.util.Scanner;

public class jumsu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int c = 3;
		
		System.out.print("���� ? :");
		String name = sc.next();
		System.out.print("���� ? :");
		int kor = sc.nextInt();
		System.out.print("���� ? :");
		int mat = sc.nextInt();
		System.out.print("���� ? :");
		int eng = sc.nextInt();
		
		int avg = (kor + mat + eng) / c; 
		
		if((avg >= 85 && kor >= 90)|| mat == 100) {
			System.out.print("�հ�");
		}else {
			System.out.print("���հ�");
		}
	}

}
