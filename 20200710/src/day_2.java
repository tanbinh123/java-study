import java.util.Scanner;

public class day_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("���? :");
		int num = sc.nextInt();
		
		day_dto[] dtoar = new day_dto[num];
		
		for (int i = 0; i < dtoar.length; i++) {
			System.out.print("����? : ");
			String name = sc.next();
			System.out.print("���� : ");
			int kor = sc.nextInt();
			System.out.print("���� : ");
			int eng = sc.nextInt();
			dtoar[i] = new day_dto(name, kor, eng);
		}
//		for (int i = 0; i < dtoar.length; i++) {
//			System.out.print(i+1+"��°");
//			dtoar[i].getPrintStudySum();
//		}
		int serch = 0;
		do {
			System.out.print("�̸� �˻� : 1:�˻�, 0:����");
			serch = sc.nextInt();
			if(serch == 1) {
				System.out.print("�˻� �̸� �Է� ? :");
				String serchname = sc.next();
				for (int i = 0; i < dtoar.length; i++) {
					if(serchname.indexOf(dtoar[i].getName()) != -1){
						System.out.print(i+1+"�� \t");
						dtoar[i].getPrintStudySum();  
					}
				}
			}
		}while(serch != 0);
	}

}