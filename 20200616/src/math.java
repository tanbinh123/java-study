
public class math {

		int getTotal(int kor, int eng, int mat){
			int total = kor + eng + mat;
			return total;
		}

		double getAvg(int total, double count) {
			double avg = total / count;
			return avg;
		}
		
		String pass = "";
		String getScore(int a) {
			if(a >= 90) {
				pass = "�հ�";
			}
			else {
				pass = "���հ�";
			}
			
			return pass;
			
		}
}
