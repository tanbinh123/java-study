import java.util.Scanner;

public class day_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇명? :");
		int n = sc.nextInt();
		day_dto[] dtos = new day_dto[n];
		
		for (int i = 0; i < dtos.length; i++) {
			System.out.print("이름 ? : ");
			String name = sc.next();
			System.out.print("지역 ? : ");
			String area = sc.next();
			System.out.print("나이 ? : ");
			int age = sc.nextInt();
			dtos[i]= new day_dto(name, area, age);
		}
		for (int i = 0; i < dtos.length; i++) {
			System.out.print(dtos[i].getName()+"\t");
			System.out.print(dtos[i].getArea()+"\t");
			System.out.print(dtos[i].getAge()+"\n");
		}
		int q = 0;
		do {
			System.out.print("검색 이름 검색:1, 지역 검색:2, 나이 검색:3 나이 범위 검색:4 종료:0 ?");
			q = sc.nextInt();
				if(q == 1) {
					System.out.print("이름 검색 ? : ");
					 String qn = sc.next();
					for (int i = 0; i < dtos.length; i++) {
						if(dtos[i].getName().indexOf(qn) != -1) {
							System.out.print(dtos[i].getName()+"\t");
							System.out.print(dtos[i].getArea()+"\t");
							System.out.print(dtos[i].getAge()+"\n");
						}
					}System.out.println();
				}
				if(q == 2) {
					System.out.print("지역 검색 ? : ");
					 String qa = sc.next();
					for (int i = 0; i < dtos.length; i++) {
						if(dtos[i].getArea().indexOf(qa) != -1) {
							System.out.print(dtos[i].getName()+"\t");
							System.out.print(dtos[i].getArea()+"\t");
							System.out.print(dtos[i].getAge()+"\n");
						}
					}System.out.println();
				}
				if(q == 3) {
					System.out.print("나이 검색 ? : ");
					 String qag = sc.next();
					for (int i = 0; i < dtos.length; i++) {
						if(Integer.toString(dtos[i].getAge()).indexOf(qag) != -1) {
							System.out.print(dtos[i].getName()+"\t");
							System.out.print(dtos[i].getArea()+"\t");
							System.out.print(dtos[i].getAge()+"\n");
						}
					}System.out.println();
				}
				if(q==4) {
					System.out.print("몇살부터? :");
					int sa = sc.nextInt();
					System.out.print("몇살까지? :");
					int ea = sc.nextInt();
					for (int i = 0; i < dtos.length; i++) {
						if(dtos[i].getAge() >= sa && dtos[i].getAge() <= ea) {
						//20 >= 10&&(&&가 두개일 땐 앞에가 참일 경우에 뒤에 조건 검사함)20 <= 30
						System.out.print(dtos[i].getName()+"\t");
						System.out.print(dtos[i].getArea()+"\t");
						System.out.print(dtos[i].getAge()+"\n");
					}
					}System.out.println();
				}
		}while(q != 0);
		
	}

}
