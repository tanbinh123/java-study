import java.util.Scanner;

public class day_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���? :");
		int n = sc.nextInt();
		day_dto[] dtos = new day_dto[n];
		
		for (int i = 0; i < dtos.length; i++) {
			System.out.print("�̸� ? : ");
			String name = sc.next();
			System.out.print("���� ? : ");
			String area = sc.next();
			System.out.print("���� ? : ");
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
			System.out.print("�˻� �̸� �˻�:1, ���� �˻�:2, ���� �˻�:3 ���� ���� �˻�:4 ����:0 ?");
			q = sc.nextInt();
				if(q == 1) {
					System.out.print("�̸� �˻� ? : ");
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
					System.out.print("���� �˻� ? : ");
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
					System.out.print("���� �˻� ? : ");
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
					System.out.print("������? :");
					int sa = sc.nextInt();
					System.out.print("������? :");
					int ea = sc.nextInt();
					for (int i = 0; i < dtos.length; i++) {
						if(dtos[i].getAge() >= sa && dtos[i].getAge() <= ea) {
						//20 >= 10&&(&&�� �ΰ��� �� �տ��� ���� ��쿡 �ڿ� ���� �˻���)20 <= 30
						System.out.print(dtos[i].getName()+"\t");
						System.out.print(dtos[i].getArea()+"\t");
						System.out.print(dtos[i].getAge()+"\n");
					}
					}System.out.println();
				}
		}while(q != 0);
		
	}

}
