import java.util.*;
public class day_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		math m = new math();
		
		String t_list = "";
		int score = 0, total = 0;
		
		System.out.print("몇과목 ? :");
		int listnum = sc.nextInt();
		
		String[] title = new String[listnum+4];
		String[] main = new String[listnum+4];
		
		title[0] = "성명";
		title[title.length-3] = "총점";
		title[title.length-2] = "평균";
		title[title.length-1] = "등급";
		
		System.out.print("이름 ? :");
		String name = sc.next();
		main[0] = name;
		
		for(int i = 1; i <= title.length-4; i++) {
			System.out.print(i + "번째 과목명 : ");
			t_list = sc.next();
			title[i] = t_list;
		}
		
		for(int i = 1; i <= title.length-4; i++) {
			System.out.print(title[i] + "점수 : ");
			score = sc.nextInt();
			total += score;
			main[i] = Integer.toString(score);
		}
		
		main[main.length-3] = Integer.toString(total); //총점
		main[main.length-2] = m.ava(total, listnum); //평균
		main[main.length-1] = m.rank(Double.parseDouble(main[main.length-2])); //등급
		
		for(int i = 0; i < title.length; i++) {
			System.out.print(title[i]+"\t");	
		}
		System.out.println("");
		
		for(int i = 0; i < title.length; i++) {
			System.out.print(main[i]+"\t");
		}

}
}