import java.util.*;
public class day_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int total = 0;
		
		System.out.print("�����?");
		int num = sc.nextInt();
		String[] arraynum = new String[num+3];
		
		System.out.print("�̸� ? :");
		arraynum[0] = sc.next();
		
		for(int i = 1; i <= arraynum.length-3; i++) {
			System.out.print("���� ? :");
			arraynum[i] = sc.next();
			total += Integer.parseInt(arraynum[i]);
		}
		
		arraynum[arraynum.length-2] = Integer.toString(total);
		arraynum[arraynum.length-1] = Integer.toString(total/num);
		
		for(int i = 0; i<arraynum.length; i++) {
			System.out.print(arraynum[i] + " ");
		}
	}

}
