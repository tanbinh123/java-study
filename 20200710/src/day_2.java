import java.util.Scanner;

public class day_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("몇명? :");
		int num = sc.nextInt();
		
		day_dto[] dtoar = new day_dto[num];
		
		for (int i = 0; i < dtoar.length; i++) {
			System.out.print("성함? : ");
			String name = sc.next();
			System.out.print("국어 : ");
			int kor = sc.nextInt();
			System.out.print("영어 : ");
			int eng = sc.nextInt();
			dtoar[i] = new day_dto(name, kor, eng);
		}
		for (int i = 0; i < dtoar.length; i++) {
			dtoar[i].getPrintStudySum();
		}
		
	}

}