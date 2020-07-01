
public class math {


	String ava(int a, int b) {	//평균 구하기
		Double c = a/(double)b;
		c = Math.round(c*100)/100.0;
		String d = Double.toString(c);
		return d;
	}
	
	
	String b; 		//평균 기준 등급 구하기
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
	
	int total = 0;	//총점 구하기
	int total(String[] a) {
		for(int i=1; i<=a.length-4;i++) {
			total += Integer.parseInt(a[i]);
		}
		return total;
	}
	
}
