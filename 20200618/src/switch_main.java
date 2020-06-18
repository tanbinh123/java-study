import java.util.*;
public class switch_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("알파벳 입력: ");
		String txt = sc.next();
		
		switch(txt) {
			case "a":
				System.out.println("switch txt : " + txt);
				break;
			case "b":
				System.out.println("switch  txt : " + txt);
				break;
			case "c":
				System.out.println("switch  txt : " + txt);
				break;
			default :
				System.out.println("switch 나머지 모든 경우");
				break;
		}
		
		if(txt.equals("a")) {
			System.out.println("if txt : " + txt);
		}
		else if(txt.equals("b")) {
			System.out.println("if txt : " + txt);
		}
		else if(txt.equals("c")) {
			System.out.println("if txt : " + txt);
		}
		else {
			System.out.println("if 나머지 모든 경우");
		}
		sc.close();
	}

}
