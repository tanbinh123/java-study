import java.util.*;
public class day_1_if문마지막 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int milk = 1200, cola = 1100, runch = 4000, age = 0;;
		double total = 0;
		
		System.out.print("물건 선택 (우유, 콜라, 도시락) : ");
		String menu = sc.next();
		System.out.print("수량 선택 : ");
		int amount = sc.nextInt();
		System.out.print("지역 선택 (서구, 중구, 대덕구) : ");
		String area = sc.next();
		
		if(menu.equals("우유") || menu.equals("도시락")) {
			System.out.print("나이 입력 : ");
			age = sc.nextInt();
				if(age < 14 && menu.equals("우유")) {
					total = milk * 0.8;
				}else if(age >= 55 && menu.equals("도시락")) {
					total = runch * 0.7;
				}
		}else if (menu.equals("콜라")) {
			total = cola;
		}else { 
			System.out.print("잘못 입력하셨습니다.");
			return;
		}
		
		total *= amount;
		
		if(area.equals("중구")) {
			total *= 0.95;
		}else if(area.equals("대덕구")) {
			total *= 0.9;
		}
		
		System.out.println(area +"주민 "+menu + " " +amount + "개 "+(int)total+"원"); 
	
		
		sc.close();
	}

}
