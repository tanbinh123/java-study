import java.util.*;
public class today_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int money = 5000;
		int total = 0;
		String[] who = {"�ʵ�", "�ߵ�", "���", "���"};
		
		System.out.print(who[0] + ":1 " + who[1]+ ":2 " + who[2]+ ":3 " + who[3]+ ":4 ");
		int select = sc.nextInt();
		
		System.out.print("����:1 ����:2 �Է� : ");
		int sex = sc.nextInt();
		
		if(select == 1) {
			total = money;
		}
		else if(select == 2){
			total = money + 2000;
		}
		else if(select == 3){
			total = money + 3000;
			if(sex==2) {
				total +=3000;
			}
		}
		else if(select == 4){
			total = money + 5000;
			if(sex==2) {
				total +=5000;
			}
		}
		else {
			System.out.println("�� �߸��Է��ߴ�..");
		}
		System.out.print("�޾ƶ�! ���� �뵷�� " + total +"�� �̴�.");
	}

}
