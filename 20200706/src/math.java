
public class math {
	
		int ava = 0;								//��� ���ϱ�
		int getAvg(int total, String[][] arr) {
			ava = total/(arr[0].length-4);
		return ava;
		}
	
		
		
		String rank ="";
		String getRank(int ava) {
		if(ava >= 90) {								//��� ����
			rank = "��";
		}else if(ava >= 80) {
			rank = "��";
		}else if(ava >= 70) {
			rank = "��";
		}else if(ava >= 60) {
			rank = "��";
		}else{
			rank = "��";
		}
			return rank;
		}
		
		
		int total = 0;							//�������ϱ�
		int getTotal(String[][] arry2,int for1,int for2) {
			total += Integer.parseInt(arry2[for1][for2]);
		return total;
		}
		
		
		
		String[][] getRank(String[][] arr, int ava) {
			int[] rank = new int[arr.length];
			
			for(int i = 0; i < arr.length; i++) {
				rank[i] = 1;
				arr[i][arr[0].length-1] = Integer.toString(rank[i]);
				for(int j = 0; j<arr.length; j++) {
				int avg = Integer.parseInt(arr[i][arr[0].length-1]);
				if(avg<avg) {
					rank[i] ++;
					
				}
				arr[i][arr[0].length-1] = Integer.toString(rank[i]);
				}
				
			}
			return arr;
		}
		
}
