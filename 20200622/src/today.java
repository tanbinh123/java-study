import java.util.Scanner;

public class today {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   	int m;
    	double k;
    	Scanner sc = new Scanner(System.in);
    	System.out.print("몇 마일? : ");
    	m = sc.nextInt();
    	
    	k = m * 1.609;
    	
    	System.out.println(k+"km");
    	
    	if(k >= 150) {
    		System.out.print("당신은 강속구 투수");
    	}else if(k >= 140) {
    		System.out.print("당신은 속구 투수");
    	}else {
    		System.out.print("일반 투수");
    	}
	}

}
