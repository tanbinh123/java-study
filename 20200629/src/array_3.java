import java.util.Scanner;

public class array_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 개 질문?:");
		int qnum = sc.nextInt();
		
		int[] array = new int[qnum];
		String[] q = new String[qnum];
		
		for(int i=0; i < array.length; i++) {
			System.out.print(i+1 + "번째 질문 ? ");
			q[i] = sc.next();
		}
		
		for(int i=0; i < array.length; i++) {
			System.out.println("질문 리스트 : " + q[i]+" ");
		}
		

	}

}
