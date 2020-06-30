import java.util.*;
public class day_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"성명","국어","수학","영어","총점","평균"};
		Scanner sc = new Scanner(System.in);
		int total = 0;
		
		for(int i = 1; i <= 3; i++) {
			System.out.print(a[i] + "점수 ? :");
			a[i] = sc.next();
			total += Integer.parseInt(a[i]);
			a[i].toString();
		}
		
		a[4] =  Integer.toString(total);
		a[5] = Integer.toString(total/3);
		
		for(int i = 0; i<a.length; i++) {
			
			System.out.print(a[i] + " ");
		}
	}

}
