import java.util.Scanner;

public class day_2_�ݺ��� {

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
		
	/*//for�� ������
	for(dan = 2; dan<=9;dan++) {
		System.out.println(dan+"��");
		for(num = 2; num<=9; num++) {
			System.out.println(dan + " * " + num + " = " + dan*num);
		}
	};
	
	
	//while�� ������
	while(dan <= 9) {
		System.out.println(dan+"��");
			while(num <= 9) {
				System.out.println(dan + " * " + num + " = " + dan*num);
				num++;
			}
		dan++;
		num = 2;
	*/
		System.out.println("��� ��� ? :");
		dan = sc.nextInt();
		
		while(num <= 9) {
			System.out.println(dan + " * " + num + " = " + dan*num);
			num++;
		
		
	}
	}
	
}
