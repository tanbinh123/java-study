import java.util.*;
public class Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J_0615_sub sub = new J_0615_sub();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		String name = scanner.next();
		System.out.print("���� ���� : ");
		int kor = scanner.nextInt();
		System.out.print("���� ���� : ");
		int mat = scanner.nextInt();
		System.out.print("���� ���� : ");
		int eng = scanner.nextInt();
		
		int total = sub.sum3(kor ,mat ,eng);
		
		J_0615_sub sub2 = new J_0615_sub();
		int avg = sub2.ava(total, 3);
		
		System.out.println(name + "���� ������ : " + total + " �� �Դϴ�.");
		System.out.println(name + "���� ����� : " + avg + " �� �Դϴ�.");
	}

}
