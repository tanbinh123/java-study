package main;

import java.util.ArrayList;

public class day_ArrayList {
	public static void main(String[] arg) {
		ArrayList<String> arr = new ArrayList<>(); //����
		
		arr.add("AAA"); //����Ʈ ������� ����
		arr.add("BBB");
		arr.add("CCC");
		for (int i = 0; i < arr.size(); i++) { //length�� �ƴ� size()
			System.out.print("=for= : " + arr.get(i)+"\n");
		}
		System.out.println();
		
		
		
		
		arr.remove(1);	//�迭�� 1��° �׸� ���� 2��° �迭�� 1��°�� �ȴ�.
		for (int i = 0; i < arr.size(); i++) {
			System.out.print("=remove= : " + arr.get(i)+"\n");
		}
		System.out.println();
		
		
		
		arr.add(1, "DDD"); //�迭 1��°�ڸ��� ���� , ���� 1��° �׸��� 2������ �з�����.
		for (int i = 0; i < arr.size(); i++) {
			System.out.print("=add(1,DDD\")= : " + arr.get(i)+"\n");
		}
		System.out.println();
		
		
		
		arr.clear(); //�迭�� �ִ� �׸� ��ü ����
			System.out.print("=clear= : " + arr.size()+"\n");
			
		arr.add("A");
		arr.add("B");
		for (int i = 0; i < arr.size(); i++) { 
			System.out.print("=for= : " + arr.get(i)+"\n");
		}
		System.out.println();
		
		arr.set(1, "CCC");
		for (int i = 0; i < arr.size(); i++) { //set�� ���� �ٷ� ġȯ
			System.out.print("=set= : " + arr.get(i)+"\n");
		}
		System.out.println();
	}
}
