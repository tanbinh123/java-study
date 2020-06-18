import java.util.*;
public class amegahurisounakyonotenki {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("성명 : ");
		String name = sc.next();
		
		System.out.print("월 저축 금액 : ");
		int money = sc.nextInt();
		
		System.out.print("몇 년 : ");
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
		
		System.out.print(name + "님 총 저축금액 " + total + "원 " + "등급 : " + rank);
	}

}
