import java.util.Scanner;

public class day_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		day_dto[] dtos = new day_dto[3];
		dtos[0] = new day_dto("ȫ�浿","����",30);
		dtos[1] = new day_dto("��ȫ��","�ݻ�",20);
		dtos[2] = new day_dto("�����","�뱸",35);
		
		
		for (int i = 0; i < dtos.length; i++) {
			System.out.print(dtos[i].getName()+"\t");
			System.out.print(dtos[i].getArea()+"\t");
			System.out.print(dtos[i].getAge()+"\n");
		}
		System.out.println();
		for (int i = 0; i < dtos.length; i++) {
			if(dtos[i].getArea().indexOf("��") != -1) {
				System.out.print(dtos[i].getName()+"\t");
				System.out.print(dtos[i].getArea()+"\t");
				System.out.print(dtos[i].getAge()+"\n");
			}
		}
		System.out.println();
		int q = 0;
		do{
			System.out.print("�˻� �̸� �˻�:1, ���� �˻�:2, ����:0 ?");
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
		}while(q != 0);
	}

}
