import java.util.*;
public class day_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		math m = new math();
		
		String t_list = "";
		int score = 0, total = 0;
		
		System.out.print("����� ? :");
		int listnum = sc.nextInt();
		
		String[] title = new String[listnum+4];	//ex) listnum�� 3�϶� ������ �� 7ĭ name/list1/list2/list3/total/avg/rank
		String[] main = new String[listnum+4];
		
		title[0] = "����";
		title[title.length-3] = "����";
		title[title.length-2] = "���";
		title[title.length-1] = "���";
		
		System.out.print("�̸� ? :"); //�̸� �ޱ�
		String name = sc.next();
		main[0] = name;
		
		for(int i = 1; i <= title.length-4; i++) { //����� �ޱ�
			System.out.print(i + "��° ����� : ");
			t_list = sc.next();
			title[i] = t_list;
		}
		
		for(int i = 1; i <= title.length-4; i++) { //���� ���� �ޱ�
			System.out.print(title[i] + " ���� : ");
			score = sc.nextInt();
			main[i] = Integer.toString(score);
		}
		
		total = m.total(main);
		main[main.length-3] = Integer.toString(total); //����
		main[main.length-2] = m.ava(total, listnum); //���
		main[main.length-1] = m.rank(Double.parseDouble(main[main.length-2])); //���
		
		for(int i = 0; i < title.length; i++) { //��� ���
			System.out.print(title[i]+"\t");	
		}
		System.out.print("=");
		for(int i = 0; i < title.length; i++) { //�ϴ� ���
			System.out.print(main[i]+"\t");
		}

}
}