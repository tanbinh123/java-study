import java.util.Scanner;
public class ScannerEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			/*
			Scanner sc = new Scanner(System.in);
			System.out.print("What is your name? : ");
			String name = sc.next();
			System.out.println("your name is : " + name);
			*/
			
			System.out.print("더할 첫번째 수 입력 : ");
			int n1 = sc.nextInt();
			System.out.print("더할 두번째 수 입력 : ");
			int n2 = sc.nextInt();
			
			int total = n1 + n2;
					
			System.out.print("더한 결과 값은 : " + total);
	}		

}
