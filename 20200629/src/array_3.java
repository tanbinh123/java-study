import java.util.Scanner;

public class array_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("�� �� ����?:");
		int qnum = sc.nextInt();
		
		int[] array = new int[qnum];
		String[] q = new String[qnum];
		
		for(int i=0; i < array.length; i++) {
			System.out.print(i+1 + "��° ���� ? ");
			q[i] = sc.next();
		}
		
		for(int i=0; i < array.length; i++) {
			System.out.println("���� ����Ʈ : " + q[i]+" ");
		}
		

	}

}
