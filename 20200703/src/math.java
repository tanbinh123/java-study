
public class math {
	
		int ava = 0;								//평균 구하기
		int getAvg(int total, String[][] arr) {
			ava = total/(arr[0].length-4);
		return ava;
		}
	
		
		
		String rank ="";
		String getRank(int ava) {
		if(ava >= 90) {								//등급 산정
			rank = "수";
		}else if(ava >= 80) {
			rank = "우";
		}else if(ava >= 70) {
			rank = "미";
		}else if(ava >= 60) {
			rank = "양";
		}else{
			rank = "가";
		}
			return rank;
		}
		
		
		int total = 0;							//총점구하기
		int getTotal(String[][] arry2,int for1,int for2) {
			total += Integer.parseInt(arry2[for1][for2]);
		return total;
		}
}
