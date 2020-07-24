package main;

import java.util.Scanner;

public class abstractMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		childMain child = new childMain();
		int total = child.getTotal(50, 60);
		int ava = child.getAva(total, 2);
		
		childMain2 child2 = new childMain2();
		String name = child2.getName();
		
		parentMain p = new childMain();
		parentMain p2 = new childMain2();
		
		
	}

}
