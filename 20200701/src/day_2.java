import java.util.*;
public class day_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String t_list = "";
		int score = 0, total = 0;
		
		System.out.print("����� ? :");
		int listnum = sc.nextInt();
		
		String[] title = new String[listnum+4];
		String[] main = new String[listnum+4];
		
		System.out.print("�̸� ? :");
		String name = sc.next();
		main[0] = name;
		
		for(int i = 1; i <= title.length-4; i++) {
			System.out.print(i + "��° ����� : ");
			t_list = sc.next();
			title[i] = t_list;
		}
		
		for(int i = 1; i <= title.length-4; i++) {
			System.out.print(title[i] + "���� : ");
			score = sc.nextInt();
			total += score;
			main[i] = Integer.toString(score);
		}
		title[0] = "����";
		title[title.length-3] = "����";
		title[title.length-2] = "���";
		title[title.length-1] = "���";
		
		main[main.length-3] = Integer.toString(total);
		main[main.length-2] = Double.toString(total/(double)listnum);
		
		if(Double.parseDouble(main[main.length-2]) >= 90) {
			main[main.length-1] = "��";
		}else if(Double.parseDouble(main[main.length-2]) >= 80) {
			main[main.length-1] = "��";
		}else if(Double.parseDouble(main[main.length-2]) >= 70) {
			main[main.length-1] = "��";
		}else if(Double.parseDouble(main[main.length-2]) >= 60) {
			main[main.length-1] = "��";
		}else{
			main[main.length-1] = "��";
		}
		
		
		for(int i = 0; i < title.length; i++) {
			System.out.print(title[i]+"\t");	
		}
		System.out.println("");
		
		for(int i = 0; i < title.length; i++) {
			System.out.print(main[i]+"\t");
		}	

}
}