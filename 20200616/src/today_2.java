import java.util.*;
public class today_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		math math = new math();
		
		int count = 3;
		
		System.out.print("���� : ");
		String name = sc.next();
		
		System.out.print("�������� : ");
		int kor = sc.nextInt();
		
		System.out.print("�������� : ");
		int eng = sc.nextInt();
		
		System.out.print("�������� : ");
		int mat = sc.nextInt();
		
		
		//int total = kor+mat+eng;
		int total = math.getTotal(kor, eng, mat);
		//double avg = (double)total /2;
		double avg = math.getAvg(total, count);
		
		
		System.out.println(name + "���� ������ : " + total + "�� �̰� ����� :" + avg + " �� �Դϴ�.");
	}

}
