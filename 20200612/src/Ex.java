import java.util.*;
public class Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		String name = scanner.next();
		System.out.print("���� ���� : ");
		int korean = scanner.nextInt();
		System.out.print("���� ���� : ");
		int math = scanner.nextInt();
		
		int total = korean+math;
		
		int avg =  total/2;
		
		System.out.println(name + "���� ������ : " + total + " �� �Դϴ�.");
		System.out.println(name + "���� ����� : " + avg + " �� �Դϴ�.");
	}

}