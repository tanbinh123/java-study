import java.util.Scanner;

public class mommuge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double k, m, total;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Ű : ");
		k = sc.nextDouble();
		System.out.print("������ : ");
		m = sc.nextDouble();
		
		total = (k-100)*0.9;
		
		System.out.println("ǥ�� ü�� : " + total);
		
		if(m >= total) {
			System.out.println("����� ǥ�� ü�� �̻�");
		}else{
			System.out.println("����� ǥ�� ü�� ����");
		}
	}

}
