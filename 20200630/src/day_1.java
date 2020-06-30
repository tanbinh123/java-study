import java.util.Scanner;

public class day_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 개 질문?:");
		int qnum = sc.nextInt();
		
		String[] q = new String[qnum];
		String[] a = new String[qnum];
		
		for(int i=0; i < q.length; i++) {
			System.out.print(i+1 + "번째로 질문하고 싶은 것 : ");
			q[i] = sc.next();
		}
		
		for(int i=0; i < q.length; i++) {
			System.out.print(q[i] + " ? : ");
			a[i] = sc.next();
		}
		System.out.println("-----결과-----");
		for(int i=0; i < q.length; i++) {
			System.out.println(q[i] + " : " + a[i]);
		}System.out.println("-------------");
	}

}
