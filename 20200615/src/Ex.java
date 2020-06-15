import java.util.*;
public class Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		J_0615_sub sub = new J_0615_sub();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = scanner.next();
		System.out.print("국어 점수 : ");
		int kor = scanner.nextInt();
		System.out.print("수학 점수 : ");
		int mat = scanner.nextInt();
		System.out.print("영어 점수 : ");
		int eng = scanner.nextInt();
		
		int total = sub.sum3(kor ,mat ,eng);
		
		J_0615_sub sub2 = new J_0615_sub();
		int avg = sub2.ava(total, 3);
		
		System.out.println(name + "님의 총점은 : " + total + " 점 입니다.");
		System.out.println(name + "님의 평균은 : " + avg + " 점 입니다.");
	}

}
