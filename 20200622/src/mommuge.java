import java.util.Scanner;

public class mommuge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double k, m, total;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("키 : ");
		k = sc.nextDouble();
		System.out.print("몸무게 : ");
		m = sc.nextDouble();
		
		total = (k-100)*0.9;
		
		System.out.println("표준 체중 : " + total);
		
		if(m >= total) {
			System.out.println("당신은 표준 체중 이상");
		}else{
			System.out.println("당신은 표준 체중 이하");
		}
	}

}
