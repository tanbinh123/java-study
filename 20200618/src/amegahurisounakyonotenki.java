import java.util.*;
public class amegahurisounakyonotenki {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		String name = sc.next();
		
		System.out.print("�� ���� �ݾ� : ");
		int money = sc.nextInt();
		
		System.out.print("�� �� : ");
		int year = sc.nextInt();
		
		int total = money * (year * 12);
		
		String rank = "C";
		/*if(money >= 100000) {
			if(year >= 2) {
				rank = "A";
			}
		}
		else if(money >= 50000) {
			if(year >= 2) {
				rank = "B";
			}
		}*/
		
		if(year >= 2) {
			if(money >= 100000) rank = "A";
			else if(money >= 50000) rank = "B";
		}
		
		System.out.print(name + "�� �� ����ݾ� " + total + "�� " + "��� : " + rank);
	}

}
