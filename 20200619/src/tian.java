import java.util.*;
public class tian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		/*�Ƹ޸�ī�� 2���̻��̸� ����*/
		
		int menu = 0;
		int cup = 0;
		String array[] = {"","��������"};
		
		
		
		System.out.println("�Ƹ޸�ī�� 1: īǪġ�� 2: ī��� 3:");
		menu =sc.nextInt();
		
		System.out.println("�� ��:");
		cup =sc.nextInt();
		
		
		if(menu == 1) {
			array[0] = "�Ƹ޸�ī��";
			if(cup >= 2) {
				array[1] = "�߱�";
			}
		}else if(menu == 2){
			array[0] = "īǪġ��";
		}else if(menu == 3){
			array[0] = "ī���";
		}

		System.out.println(array[0] + cup +"�� " + array[1]);
		
		sc.close();
	}

}
