import java.util.Scanner;

public class today {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   	int m;
    	double k;
    	Scanner sc = new Scanner(System.in);
    	System.out.print("�� ����? : ");
    	m = sc.nextInt();
    	
    	k = m * 1.609;
    	
    	System.out.println(k+"km");
    	
    	if(k >= 150) {
    		System.out.print("����� ���ӱ� ����");
    	}else if(k >= 140) {
    		System.out.print("����� �ӱ� ����");
    	}else {
    		System.out.print("�Ϲ� ����");
    	}
	}

}
