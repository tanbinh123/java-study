import java.util.Scanner;

public class day_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("�� �� ����?:");
		int qnum = sc.nextInt();
		
		String[] q = new String[qnum];
		String[] a = new String[qnum];
		
		for(int i=0; i < q.length; i++) {
			System.out.print(i+1 + "��°�� �����ϰ� ���� �� : ");
			q[i] = sc.next();
		}
		
		for(int i=0; i < q.length; i++) {
			System.out.print(q[i] + " ? : ");
			a[i] = sc.next();
		}
		System.out.println("-----���-----");
		for(int i=0; i < q.length; i++) {
			System.out.println(q[i] + " : " + a[i]);
		}System.out.println("-------------");
	}

}
