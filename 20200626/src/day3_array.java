
public class day3_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		/*int[] a = {10,20,30,40,50};
		
			for(int i=0;i<a.length;i++) {
				System.out.println("a : " + a[i]);
				}
		}*/
	
		/*String[] b = new String[2];
		
		b[0] = "a";
		b[1] = "b";
		
		for(int i=0;i<b.length;i++) {
			System.out.println("b : " + b[i]);
			}*/
		
		int[] a = {10,20,30,40,50};
		int total = 0;
		for(int i=0;i<a.length;i++) {
			total += a[i];
			System.out.println("a : " + a[i]);
			}
		System.out.println(total);
			
			
	}		
		
	
}
