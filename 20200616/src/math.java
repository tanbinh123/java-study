
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
		
		String sumyg = "";
		String getSumyg(int a) {
			
			if(a >= 80) {
					sumyg ="��";
				}
				else if(a >= 60){
					sumyg ="��";
				}
				else if(a >= 50){
					sumyg ="��";
				}
				else{
					sumyg ="��";
				}
		return sumyg;
		}
}
