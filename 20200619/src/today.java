import java.util.*;
public class today {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sex = 0, army = 0, marry = 0;
		int money = 5000;
		
		System.out.print("이름 : ");
		String name =sc.next();
		
		System.out.print("여:1 남:2 : ");
		sex =sc.nextInt();
		
		if(sex == 2) {
			System.out.print("군필:1 미필:2 : ");
			army =sc.nextInt();
		}
		
		System.out.print("결혼 유무 기혼:1 미혼:2 : ");
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
	
		
		System.out.println(name + "님 " + "일당 " + money +"입니다.");
	}
}
