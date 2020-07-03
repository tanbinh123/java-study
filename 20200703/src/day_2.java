
public class day_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"가","나","다","라"};
		
		String[][] array = {{"10", "20", "30",""},{"40","50","60",""}};
		
		for(int i = 0; i<array.length;i++) {
			int total=0;
			for(int j = 0; j<array[0].length-1;j++) {
				total += Integer.parseInt(array[i][j]);
				System.out.print(array[i][j]+"\t");
			}
			array[i][array[i].length-1] = Integer.toString(total);
			System.out.print(array[i][array[i].length-1] + "\n");
		}
	}

}
