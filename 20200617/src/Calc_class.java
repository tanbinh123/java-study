
public class Calc_class {

	int getCalc(int a,int b,int cho) {
		
		int val = 0;
		
		if(cho==1) {
			val = a + b;
		}
		else if(cho==2) {
			val = a - b;
		}
		else if(cho==3) {
			val = a * b;
		}
		else if(cho==4) {
			val = a / b;
		}
		else {
			val = 0;
		}
		return val;
	}
}
