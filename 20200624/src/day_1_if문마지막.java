import java.util.*;
public class day_1_if�������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int milk = 1200, cola = 1100, runch = 4000, age = 0;;
		double total = 0;
		
		System.out.print("���� ���� (����, �ݶ�, ���ö�) : ");
		String menu = sc.next();
		System.out.print("���� ���� : ");
		int amount = sc.nextInt();
		System.out.print("���� ���� (����, �߱�, �����) : ");
		String area = sc.next();
		
		if(menu.equals("����") || menu.equals("���ö�")) {
			System.out.print("���� �Է� : ");
			age = sc.nextInt();
				if(age < 14 && menu.equals("����")) {
					total = milk * 0.8;
				}else if(age >= 55 && menu.equals("���ö�")) {
					total = runch * 0.7;
				}
		}else if (menu.equals("�ݶ�")) {
			total = cola;
		}else { 
			System.out.print("�߸� �Է��ϼ̽��ϴ�.");
			return;
		}
		
		total *= amount;
		
		if(area.equals("�߱�")) {
			total *= 0.95;
		}else if(area.equals("�����")) {
			total *= 0.9;
		}
		
		System.out.println(area +"�ֹ� "+menu + " " +amount + "�� "+(int)total+"��"); 
	
		
		sc.close();
	}

}
