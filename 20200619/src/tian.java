import java.util.*;
public class tian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		/*아메리카노 2잔이상이면 쿠폰*/
		
		int menu = 0;
		int cup = 0;
		String array[] = {"","쿠폰없음"};
		
		
		
		System.out.println("아메리카노 1: 카푸치노 2: 카페라떼 3:");
		menu =sc.nextInt();
		
		System.out.println("몇 잔:");
		cup =sc.nextInt();
		
		
		if(menu == 1) {
			array[0] = "아메리카노";
			if(cup >= 2) {
				array[1] = "발급";
			}
		}else if(menu == 2){
			array[0] = "카푸치노";
		}else if(menu == 3){
			array[0] = "카페라떼";
		}

		System.out.println(array[0] + cup +"잔 " + array[1]);
		
		sc.close();
	}

}
