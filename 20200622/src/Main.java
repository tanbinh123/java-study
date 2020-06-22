import java.util.*;
public class Main {
    public static void main(String[] args) {
    	int a, b, c;
    	Scanner sc = new Scanner(System.in);
    	a = sc.nextInt();
    	b = sc.nextInt();	
    	
    	c = (a>=0 && b>=0)? 1:3;
    	if(c == 1)System.out.print(c);
    	else{
    		c = (a<=0 && b>=0) ? 2:3;
    			if(a>=0){
    				c = 4;
    				System.out.print(c);
    				return;
    				}
    		System.out.print(c);
    		
    	}
    }
}