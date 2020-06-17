import java.util.*;
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0, b = 0;
		
		Scanner cs= new Scanner(System.in);
		
		System.out.print("첫번째 수 입력 : ");
		a = cs.nextInt();
		
		System.out.print("두번째 수 입력 : ");
		b = cs.nextInt();
		
		System.out.print("더하기:1 \n빼기:2 \n곱하기:3 \n나누기:4 	\n입력 : ");
		int cho = cs.nextInt();
		
		Calc_class calc = new Calc_class();
		int val = calc.getCalc(a, b, cho);
		
		System.out.print(val);
		
	}

}
