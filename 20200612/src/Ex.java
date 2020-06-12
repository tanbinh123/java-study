import java.util.*;
public class Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = scanner.next();
		System.out.print("국어 점수 : ");
		int korean = scanner.nextInt();
		System.out.print("수학 점수 : ");
		int math = scanner.nextInt();
		
		int total = korean+math;
		
		System.out.println(name + "님의 총점은 : " + total + " 점 입니다.");
	}

}
