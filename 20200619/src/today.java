import java.util.*;
public class today {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sex = 0, army = 0, marry = 0;
		int money = 5000;
		
		System.out.print("�̸� : ");
		String name =sc.next();
		
		System.out.print("��:1 ��:2 : ");
		sex =sc.nextInt();
		
		if(sex == 2) {
			System.out.print("����:1 ����:2 : ");
			army =sc.nextInt();
		}
		
		System.out.print("��ȥ ���� ��ȥ:1 ��ȥ:2 : ");
		marry =sc.nextInt();
		if(marry == 1) money += 3000;
		

		if(sex==1) {
			money += 1000;
		}
		else if(sex == 2) {
			if(army == 1) {
				money += 2000;
			}
		}
	
		
		System.out.println(name + "�� " + "�ϴ� " + money +"�Դϴ�.");
	}
}
