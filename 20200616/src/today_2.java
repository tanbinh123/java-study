import java.util.*;
public class today_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		math math = new math();
		
		int count = 3;
		
		System.out.print("성함 : ");
		String name = sc.next();
		
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학점수 : ");
		int mat = sc.nextInt();
		
		
		//int total = kor+mat+eng;
		int total = math.getTotal(kor, eng, mat);
		//double avg = (double)total /2;
		double avg = math.getAvg(total, count);
		
		
		System.out.println(name + "님의 총점은 : " + total + "점 이고 평균은 :" + avg + " 점 입니다.");
	}

}
