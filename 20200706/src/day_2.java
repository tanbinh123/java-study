
public class day_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayData arr = new ArrayData();
		int[][] array = arr.array3;
		int max = array[0][0];
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				if(max<array[i][j]) {
					max=array[i][j];
				}
			}
		}System.out.println(max);
	}

}
