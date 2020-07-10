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
//		for (int i = 0; i < dtoar.length; i++) {
//			System.out.print(i+1+"번째");
//			dtoar[i].getPrintStudySum();
//		}
		int serch = 0;
		do {
			System.out.print("이름 검색 : 1:검색, 0:종료");
			serch = sc.nextInt();
			if(serch == 1) {
				System.out.print("검색 이름 입력 ? :");
				String serchname = sc.next();
				for (int i = 0; i < dtoar.length; i++) {
					if(serchname.indexOf(dtoar[i].getName()) != -1){
						System.out.print(i+1+"번 \t");
						dtoar[i].getPrintStudySum();  
					}
				}
			}
		}while(serch != 0);
	}

}