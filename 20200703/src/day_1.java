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
			for (int j = 0; j < arry2[0].length-13;j++) { //�̸� ���
				System.out.print(arry2[i][j] + "\t");
			}
			
			for (int j = 1; j < arry2[0].length-3;j++) { // ���� ��� �� ���� ���
				System.out.print(arry2[i][j] + "\t");
				total += Integer.parseInt(arry2[i][j]);
				
			}

			arry2[i][arry2[0].length-3] = Integer.toString(total); //���� ���
			int ava = ma.getAvg(total, arry2); //���
			arry2[i][arry2[0].length-2] = Integer.toString(ava); //��մ��
			arry2[i][arry2[0].length-1] = ma.getRank(ava); //��� ���
			
			for (int j = 10; j < arry2[0].length;j++) { // ����, ��� , ��� ���
				System.out.print(arry2[i][j] + "\t");
			}
			total=0;
			
			System.out.print("\n");
		}
	}

}
