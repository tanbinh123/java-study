
public class array_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = new String[5];
		
		a[0]="a";
		a[1]="b";
		a[2]="100";
		a[3]="°¡";
		a[4]="ab";
		
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		int[] b = {10,15,20};
		
		for(int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
			
	}

}
