package variable;

public class VarEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 20;
		int tmp;
		
		System.out.println("x: "+ x + " y: " + y);
		
		tmp = x;
		x = y;
		y = tmp;
		
		System.out.println("x: "+ x + " y: " + y);
		System.out.println("x: "+ 10 + " y: " + 20);
		System.out.println("x: 10" + " y: " + y);
		System.out.println("x: 10 y: " + y);
		System.out.println("x: 10 y: 20");
	}

}
