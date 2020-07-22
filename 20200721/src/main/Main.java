package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.dao1;
import dto.dto1;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<dto1> arr = new ArrayList<>();
		arr.add(new dto1("N001","ȫ�浿","�ѹ�","���",25));
		arr.add(new dto1("N002","�Ȼ굿","�λ�","�븮",35));
		arr.add(new dto1("N003","���̼�","�ѹ�","�븮",28));
		for(int k=0; k < arr.size(); k++) {
			System.out.print(arr.get(k).getNo()+"\t");
			System.out.print(arr.get(k).getName()+"\t");
			System.out.print(arr.get(k).getDepart()+"\t");
			System.out.print(arr.get(k).getPosition()+"\t");
			System.out.print(arr.get(k).getAge()+"\n");
		}
		System.out.println("------------------------------------");
		System.out.print("���:0 �̸��˻�:1, �μ��˻�:2, ��������:3, ����:4   ���� ? ");
		int gubun = sc.nextInt();
		if(gubun == 0){

				System.out.print(" ��� �̸� ? ");
				String name = sc.next();
				System.out.print(" ��� �μ��� ? ");
				String depart = sc.next();
				System.out.print(" ��� ���� �� ? ");
				String position = sc.next();
				System.out.print(" ��� ���� ? ");
				int age = sc.nextInt();
				
				dao1 dao = new dao1();
				String no = arr.get(arr.size()-1).getNo();
				
				arr.add(new dto1(dao.getNo(no),name, depart, position,age));
				
				for(int k=0; k < arr.size(); k++) {
						System.out.print(arr.get(k).getNo()+"\t");
						System.out.print(arr.get(k).getName()+"\t");
						System.out.print(arr.get(k).getDepart()+"\t");
						System.out.print(arr.get(k).getPosition()+"\t");
						System.out.print(arr.get(k).getAge()+"\n");					
				}
				System.out.println("-------------��� ����------------------");
		}
		else if(gubun == 1) {
			System.out.print(" �˻� �̸� ? ");
			String search = sc.next();
		
			for(int k=0; k < arr.size(); k++) {
				if(arr.get(k).getName().indexOf(search) != -1) {
					System.out.print(arr.get(k).getNo()+"\t");
					System.out.print(arr.get(k).getName()+"\t");
					System.out.print(arr.get(k).getDepart()+"\t");
					System.out.print(arr.get(k).getPosition()+"\t");
					System.out.print(arr.get(k).getAge()+"\n");					
				}
			}
			System.out.println("-------------�̸��˻� ����------------------");
		} else if(gubun == 2) {
			System.out.print(" �μ� �̸� ? ");
			String search = sc.next();			
			for(int k=0; k < arr.size(); k++) {
				if(arr.get(k).getDepart().indexOf(search) != -1) {
					System.out.print(arr.get(k).getNo()+"\t");
					System.out.print(arr.get(k).getName()+"\t");
					System.out.print(arr.get(k).getDepart()+"\t");
					System.out.print(arr.get(k).getPosition()+"\t");
					System.out.print(arr.get(k).getAge()+"\n");							
				}
			}	
			System.out.println("-------------�μ��˻� ����------------------");
			
		} else if(gubun == 3) {
			System.out.print(" ���� ��� ? ");
			String no = sc.next();
			int updateNo = -1;
			for(int k=0; k < arr.size(); k++) {
				if(arr.get(k).getNo().equals(no)) {
					updateNo = k;
					System.out.print(arr.get(k).getNo()+"\t");
					System.out.print(arr.get(k).getName()+"\t");
					System.out.print(arr.get(k).getDepart()+"\t");
					System.out.print(arr.get(k).getPosition()+"\t");
					System.out.print(arr.get(k).getAge()+"\n");							
				} 
			}
			if(updateNo == -1) {
				System.out.println("���� ���� ����~~~~");
			} else {
				System.out.print(" ���� �̸� ? ");
				String name = sc.next();
				System.out.print(" ���� �μ��� ? ");
				String depart = sc.next();
				System.out.print(" ���� ���� �� ? ");
				String position = sc.next();
				System.out.print(" ���� ���� ? ");
				int age = sc.nextInt();
				
				dto1 d = new dto1(no, name, depart, position,age);
				arr.set(updateNo, d);
				
//				arr.get(updateNo).setName(name);
//				arr.get(updateNo).setDepart(depart);
//				arr.get(updateNo).setPosition(position);
//				arr.get(updateNo).setAge(age);
//				
				for(int k=0; k < arr.size(); k++) {
					System.out.print(arr.get(k).getNo()+"\t");
					System.out.print(arr.get(k).getName()+"\t");
					System.out.print(arr.get(k).getDepart()+"\t");
					System.out.print(arr.get(k).getPosition()+"\t");
					System.out.print(arr.get(k).getAge()+"\n");							
				}				
				System.out.println("-------------����  ����------------------");
			}
		}else if(gubun == 4) {
			System.out.print(" ���� �� ��� ? ");
			String no = sc.next();
			int deleteNo = -1;
			for(int k=0; k < arr.size(); k++) {
				if(arr.get(k).getNo().equals(no)) {
					deleteNo = k;
					System.out.print(arr.get(k).getNo()+"\t");
					System.out.print(arr.get(k).getName()+"\t");
					System.out.print(arr.get(k).getDepart()+"\t");
					System.out.print(arr.get(k).getPosition()+"\t");
					System.out.print(arr.get(k).getAge()+"\n");							
				} 
			}if(deleteNo == -1) {
				System.out.println("���� ���� ����~~~~");
			} else {
				System.out.println("���� ���� �ϰڽ��ϱ�? (y/n) : ");
				String yn = sc.next();
				if(yn.equals("y")||yn.equals("Y")||yn.equals("��")) {
					arr.remove(deleteNo);
					for(int k=0; k < arr.size(); k++) {
						System.out.print(arr.get(k).getNo()+"\t");
						System.out.print(arr.get(k).getName()+"\t");
						System.out.print(arr.get(k).getDepart()+"\t");
						System.out.print(arr.get(k).getPosition()+"\t");
						System.out.print(arr.get(k).getAge()+"\n");							
					}				
					System.out.println("-------------����  ����------------------");
				}
			}
		}

		
		
		
		
		
/*			
		DecimalFormat df = new DecimalFormat("0000");
		String a = "kB_0104_A";
		a = a.substring(3, 7);
		int n = Integer.parseInt(a);
		n++;
		a = df.format(n);
		
//		a = Integer.toString(n);
//		if(a.length() == 1) a = "000"+a;
//		if(a.length() == 2) a = "00"+a;		
//		if(a.length() == 3) a = "0"+a;
		
		a ="KB_"+a+"_A";
		System.out.println(" a :"+a);		
	
		String a = "S001-DE";
		a = a.substring(1, 4);
		System.out.println(" a :"+a);
		int n = Integer.parseInt(a);
		System.out.println(" n :"+n);
		n = n + 1;
		a = Integer.toString(n);
		if(a.length() == 1) a = "00"+a;
		if(a.length() == 2) a = "0"+a;
		
		System.out.println(" a :"+a);
		a ="S"+a+"-DE";
		System.out.println(" a :"+a);
*/		
	}
}
