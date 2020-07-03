import java.util.* ;
public class day_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner (System.in);
		ArrayData arr = new ArrayData();
		math ma = new math();
		
		String[][] arry2= arr.arry2; 
		
		int total = 0;
		String rank = "";
		
		for(int i=0; i < arry2.length; i++) {
			for (int j = 0; j < arry2[0].length-13;j++) { //이름 출력
				System.out.print(arry2[i][j] + "\t");
			}
			
			for (int j = 1; j < arry2[0].length-3;j++) { // 점수 출력 및 총점 계산
				System.out.print(arry2[i][j] + "\t");
				total += Integer.parseInt(arry2[i][j]);
				
			}

			arry2[i][arry2[0].length-3] = Integer.toString(total); //총점 담기
			int ava = ma.getAvg(total, arry2); //평균
			arry2[i][arry2[0].length-2] = Integer.toString(ava); //평균담기
			arry2[i][arry2[0].length-1] = ma.getRank(ava); //등급 담기
			
			for (int j = 10; j < arry2[0].length;j++) { // 총점, 평균 , 등급 출력
				System.out.print(arry2[i][j] + "\t");
			}
			total=0;
			
			System.out.print("\n");
		}
	}

}
