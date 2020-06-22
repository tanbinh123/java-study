import java.util.Scanner;

public class nemui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
			int kor = 90, eng = 80, total = kor + eng;
			
			if(kor >= 90 && eng >= 90) {
				System.out.println("합격");
			}else {
				System.out.println("불합격");
			}
	}

}
