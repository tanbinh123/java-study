import java.util.*;

public class day_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사칙연산");
		
		System.out.print("첫번째 수 입력 :");
		int a = sc.nextInt();
		System.out.print("두번째 수 입력 :");
		int b = sc.nextInt();
		int total = 0;
		
		System.out.print("기호 입력 (+,-,*,/) :");
		String calc = sc.next();
		
		switch(calc) {
		case "+" :
			total = a + b;
			break;
		case "-" :
			total = a - b;
			break;
		case "*" :
			total = a * b;
			break;
		case "/" :
			total = a / b;
			break;
		case "%" :
			total = a % b;
			break;
		default :
			System.out.print("잘못된 입력");
			return;
		}

		System.out.print(a + calc + b + " = " + total);
		
		sc.close();
	}

}
