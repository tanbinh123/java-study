import java.util.Scanner;

public class day_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("���? :");
		int num = sc.nextInt();
		
		day_dto[] dtoar = new day_dto[num];
		
		for (int i = 0; i < dtoar.length; i++) {
			dtoar[i] = new day_dto();
			System.out.print("����? : ");
			dtoar[i].setName(sc.next());
			System.out.print("����? : ");
			dtoar[i].setArea(sc.next());
			System.out.print("����? : ");
			dtoar[i].setAge(sc.nextInt());
			
		}
		for (int i = 0; i < dtoar.length; i++) {
			dtoar[i].getPrintPersonalInfo();
		}
		
	}

}
