import java.util.*;

public class day_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("��Ģ����");
		
		System.out.print("ù��° �� �Է� :");
		int a = sc.nextInt();
		System.out.print("�ι�° �� �Է� :");
		int b = sc.nextInt();
		int total = 0;
		
		System.out.print("��ȣ �Է� (+,-,*,/) :");
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
			System.out.print("�߸��� �Է�");
			return;
		}

		System.out.print(a + calc + b + " = " + total);
		
		sc.close();
	}

}
