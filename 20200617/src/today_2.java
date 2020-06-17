import java.util.*;
public class today_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int money = 5000;
		int total = 0;
		String you = "";
		
		System.out.print("초딩:1 중딩:2 고딩:3 대딩:4 입력 : ");
		int select = sc.nextInt();
		
		System.out.print("남자:1 여자:2 입력 : ");
		int sex = sc.nextInt();
		
		if(select == 1) {
			you = "초딩";
			total = money;
		}
		else if(select == 2){
			you = "중딩";
			total = money + 2000;
		}
		else if(select == 3){
			you = "고딩";
			total = money + 3000;
			if(sex==2) {
				total +=3000;
			}
		}
		else if(select == 4){
			you = "대딩";
			total = money + 5000;
			if(sex==2) {
				total +=5000;
			}
		}
		else {
			System.out.println("너 잘못입력했다..");
		}
		System.out.print("받아라 " + you +"! 너의 용돈은 " + total +"원 이다.");
	}

}
