
public class math {


	String ava(int a, int b) {
		String c = Double.toString(a/(double)b);
		return c;
	}
	
	
	String b;
	String rank(double a) {
		if(a >= 90) {
			b = "수";
		}else if(a >= 80) {
			b = "우";
		}else if(a >= 70) {
			b = "미";
		}else if(a >= 60) {
			b = "양";
		}else{
			b = "가";
		}
		return b;
	}
	
	
}
