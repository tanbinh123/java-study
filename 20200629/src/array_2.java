import java.util.Scanner;

public class array_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] info = new String[3];
		String q[] = {"이름","지역","나이"};
		
		Scanner sc = new Scanner(System.in);
		
		
		for(int i = 0; i < info.length; i++) {
			System.out.print(q[i] + " 입력?:");
			info[i] = sc.next();
		}
		
		for(int i = 0; i < info.length; i++) {
			System.out.print(q[i]+" : "+info[i]+" / ");
		}
	}

}
