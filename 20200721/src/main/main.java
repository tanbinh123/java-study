package main;

import java.util.ArrayList;
import java.util.Scanner;

import dto.dto1;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<dto1> arr = new ArrayList<>();
		arr.add(new dto1("N001","ȫ�浿","�ѹ�","���",25));
		arr.add(new dto1("N002","�Ȼ굿","�λ�","�븮",35));
		arr.add(new dto1("N003","���̼�","�ѹ�","���",28));

		for(int i=0; i < arr.size(); i++) {
			System.out.print(arr.get(i).getNo()+"\t");
			System.out.print(arr.get(i).getName()+"\t");
			System.out.print(arr.get(i).getDepart()+"\t");
			System.out.print(arr.get(i).getPosition()+"\t");
			System.out.print(arr.get(i).getAge()+"\n");
		}
		System.out.println("-----------------------------------");
		System.out.println("�̸� �˻�:1 , �μ� �˻�:2 , ���� ����:3       ���� ? :");
		int gubun = sc.nextInt();


		if(gubun == 1) {
			System.out.print("�˻� �̸�? :");
			String search = sc.next();

			for(int i=0; i < arr.size(); i++) {
				if(arr.get(i).getName().indexOf(search) != -1) { //indexOf
					System.out.print(arr.get(i).getNo()+"\t");
					System.out.print(arr.get(i).getName()+"\t");
					System.out.print(arr.get(i).getDepart()+"\t");
					System.out.print(arr.get(i).getPosition()+"\t");
					System.out.print(arr.get(i).getAge()+"\n");
				}
			}
			System.out.println("-----------�̸� �˻� ����---------------");


		}else if(gubun == 2) {
			System.out.print("�μ� �̸�? :");
			String search = sc.next();
			for(int i=0; i < arr.size(); i++) {
				 if(arr.get(i).getDepart().indexOf(search) != -1) {
					System.out.print(arr.get(i).getNo()+"\t");
					System.out.print(arr.get(i).getName()+"\t");
					System.out.print(arr.get(i).getDepart()+"\t");
					System.out.print(arr.get(i).getPosition()+"\t");
					System.out.print(arr.get(i).getAge()+"\n");
				}
			}
			System.out.println("-----------�μ� �˻� ����---------------");
		}else if(gubun == 3) {
			System.out.print("���� ��� ? :");
			String no = sc.next();
			int updateNo = -1;
			for(int i=0; i < arr.size(); i++) {
				if(arr.get(i).getNo().equals(no)) {
					updateNo = i;
					System.out.print(arr.get(i).getNo()+"\t");
					System.out.print(arr.get(i).getName()+"\t");
					System.out.print(arr.get(i).getDepart()+"\t");
					System.out.print(arr.get(i).getPosition()+"\t");
					System.out.print(arr.get(i).getAge()+"\n");
				}
			}
			if(updateNo == -1) {
				System.out.print("--------���� ���� ����--------");
			}else {
				System.out.print("���� �̸� ? :");
				String name  = sc.next();
				System.out.print("���� �μ��� ? :");
				String depart = sc.next();
				System.out.print("���� ������ ? :");
				String position = sc.next();
				System.out.print("���� ���� ? :");
				int age = sc.nextInt();

				arr.get(updateNo).setNo(no);
				arr.get(updateNo).setName(name);
				arr.get(updateNo).setDepart(depart);
				arr.get(updateNo).setPosition(position);
				arr.get(updateNo).setAge(age);

				for(int i=0; i < arr.size(); i++) {
						System.out.print(arr.get(i).getNo()+"\t");
						System.out.print(arr.get(i).getName()+"\t");
						System.out.print(arr.get(i).getDepart()+"\t");
						System.out.print(arr.get(i).getPosition()+"\t");
						System.out.print(arr.get(i).getAge()+"\n");
					}
				System.out.print("-----------------���� ����-----------------");
			}
		}
	}
}
/*
		DecimalFormat df = new DecimalFormat("0000");
		String a = "KB_0024_A";
		a = a.substring(3, 7);
		int n =Integer.parseInt(a);
		n++; //25
		a = df.format(n);
		//a = Integer.toString(n);
		//if(a.length() == 1) a = "000"+a;
		//if(a.length() == 2) a = "00"+a;
		//if(a.length() == 3) a = "0"+a;
		System.out.println("a :"+a);
		a ="KB_"+a+"_A";
		System.out.println("a :"+a);
/===========================================================
	 *
		String a = "S001-DE";
		a = a.substring(1, 4);
		System.out.println("a :"+a);
		int n = Integer.parseInt(a);
		System.out.println("n :"+n);
		n++; // n = n + 1;
		a = Integer.toString(n);
		if(a.length() == 1) a = "00"+a;
		if(a.length() == 2) a = "0"+a;
		System.out.println("a :"+a);
		a = "S"+a+"-DE";
		System.out.println("a :"+a);
*/