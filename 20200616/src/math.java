
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
				pass = "합격";
			}
			else {
				pass = "불합격";
			}
			
			return pass;
		}
		
		String sumyg = "";
		String getSumyg(int a) {
			
			if(a >= 80) {
					sumyg ="수";
				}
				else if(a >= 60){
					sumyg ="우";
				}
				else if(a >= 50){
					sumyg ="미";
				}
				else{
					sumyg ="양";
				}
		return sumyg;
		}
}
