import java.util.*;
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0, b = 0;
		
		Scanner cs= new Scanner(System.in);
		
		System.out.print("ù��° �� �Է� : ");
		a = cs.nextInt();
		
		System.out.print("�ι�° �� �Է� : ");
		b = cs.nextInt();
		
		System.out.print("���ϱ�:1 \n����:2 \n���ϱ�:3 \n������:4 	\n�Է� : ");
		int cho = cs.nextInt();
		
		Calc_class calc = new Calc_class();
		int val = calc.getCalc(a, b, cho);
		
		System.out.print(val);
		
	}

}
