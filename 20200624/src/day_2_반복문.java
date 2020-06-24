import java.util.Scanner;

public class day_2_반복문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int dan = 2, num = 2;
		
		/*while(i<=10){
			System.out.println(i);
			i += 1;
		};
		
		for(int j = 0;j<=10;j++) {
			System.out.println(j);
		};*/
		
	/*//for문 구구단
	for(dan = 2; dan<=9;dan++) {
		System.out.println(dan+"단");
		for(num = 2; num<=9; num++) {
			System.out.println(dan + " * " + num + " = " + dan*num);
		}
	};
	
	
	//while문 구구단
	while(dan <= 9) {
		System.out.println(dan+"단");
			while(num <= 9) {
				System.out.println(dan + " * " + num + " = " + dan*num);
				num++;
			}
		dan++;
		num = 2;
	*/
		System.out.println("몇단 출력 ? :");
		dan = sc.nextInt();
		
		while(num <= 9) {
			System.out.println(dan + " * " + num + " = " + dan*num);
			num++;
		
		
	}
	}
	
}
