
public class math {


	String ava(int a, int b) {	//��� ���ϱ�
		Double c = a/(double)b;
		c = Math.round(c*100)/100.0;
		String d = Double.toString(c);
		return d;
	}
	
	
	String b; 		//��� ���� ��� ���ϱ�
	String rank(double a) {
		if(a >= 90) {
			b = "��";
		}else if(a >= 80) {
			b = "��";
		}else if(a >= 70) {
			b = "��";
		}else if(a >= 60) {
			b = "��";
		}else{
			b = "��";
		}
		return b;
	}
	
	int total = 0;	//���� ���ϱ�
	int total(String[] a) {
		for(int i=1; i<=a.length-4;i++) {
			total += Integer.parseInt(a[i]);
		}
		return total;
	}
	
}
