package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.dao;
import dto.dto;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dao dao = new dao();
		ArrayList<dto> arr = new ArrayList<>();
		int gubun = 0;
		String no = "";
		
			for (int i = 0; i < 1000; i++) {
				dao.getRinfo(arr);
			}
		
		do {
			System.out.print("�˻�:1 ���:2 ����:3 ����:4 ����:0 : ");
			gubun = sc.nextInt();
			if(gubun == 1) {
				int search = 0;
				do {
					System.out.print("��ü �˻� : 0 \n������� �˻� : 1 \n�̸����� �˻� : 2 \n�������� �˻� : 3 \n���̷� �˻� : 4\n�˻� ���� : 9 \n=================== \n");
					search = sc.nextInt();
					if(search == 0){
						for (int i = 0; i < arr.size(); i++) {
								System.out.print(arr.get(i).getNo()+"\t");
								System.out.print(arr.get(i).getName()+"\t");
								System.out.print(arr.get(i).getArea()+"\t");
								System.out.print(arr.get(i).getAge()+"\n");
						}
					}
					else if(search == 1) {
						System.out.print("�˻��� ��� �Է� : ");
						String searchNo = sc.next();
						for (int i = 0; i < arr.size(); i++) {
							if(searchNo.equals(arr.get(i).getNo())){
								System.out.print(arr.get(i).getNo()+"\t");
								System.out.print(arr.get(i).getName()+"\t");
								System.out.print(arr.get(i).getArea()+"\t");
								System.out.print(arr.get(i).getAge()+"\n");
							}
						}
					}else if(search ==2) {
						System.out.print("�˻��� �̸� �Է� : ");
						String searchName = sc.next();
						for (int i = 0; i < arr.size(); i++) {
							if(arr.get(i).getName().indexOf(searchName) != -1){
								System.out.print(arr.get(i).getNo()+"\t");
								System.out.print(arr.get(i).getName()+"\t");
								System.out.print(arr.get(i).getArea()+"\t");
								System.out.print(arr.get(i).getAge()+"\n");
							}
						}
					
					}else if(search ==3) {
						System.out.print("�˻��� ���� �Է� : ");
						String searchArea = sc.next();
						for (int i = 0; i < arr.size(); i++) {
							if(arr.get(i).getArea().indexOf(searchArea) != -1){
								System.out.print(arr.get(i).getNo()+"\t");
								System.out.print(arr.get(i).getName()+"\t");
								System.out.print(arr.get(i).getArea()+"\t");
								System.out.print(arr.get(i).getAge()+"\n");
							}
						}
					
					}else if(search ==4) {
						System.out.print("�˻� ���� ���� �Է� : ");
						int searchAge1 = sc.nextInt();
						System.out.print("�˻� �� ���� �Է� : ");
						int searchAge2 = sc.nextInt();
						for (int i = 0; i < arr.size(); i++) {
							if(arr.get(i).getAge()>searchAge1 && arr.get(i).getAge()<searchAge2){
								System.out.print(arr.get(i).getNo()+"\t");
								System.out.print(arr.get(i).getName()+"\t");
								System.out.print(arr.get(i).getArea()+"\t");
								System.out.print(arr.get(i).getAge()+"\n");
							}
						}
					
					}}while(search != 9);
				
			}
				else if(gubun == 2) {
				if(arr.size()==0){
					no = "S0001";
				}else {
					no = arr.get(arr.size()-1).getNo();
					no = dao.getNo(no);
				}
				System.out.print("�̸�? :");
				String name = sc.next();
				System.out.print("����? :");
				String area = sc.next();
				System.out.print("����? :");
				int age = sc.nextInt();
				arr.add(new dto(no, name, area, age));
				for (int i = 0; i < arr.size(); i++) {
					System.out.print(arr.get(i).getNo()+"\t");
					System.out.print(arr.get(i).getName()+"\t");
					System.out.print(arr.get(i).getArea()+"\t");
					System.out.print(arr.get(i).getAge()+"\n");
				}
			}else if(gubun == 3) {
				System.out.print("������ ��� �Է� : ");
				String edit = sc.next();
				for (int i = 0; i < arr.size(); i++) {
					if(edit.equals(arr.get(i).getNo())){
						no = arr.get(i).getNo();
						System.out.print("���� �̸�? :");
						String name = sc.next();
						System.out.print("���� ����? :");
						String area = sc.next();
						System.out.print("���� ����? :");
						int age = sc.nextInt();
						arr.set(i, new dto(no, name, area, age));
						
						System.out.print(arr.get(i).getNo()+"\t");
						System.out.print(arr.get(i).getName()+"\t");
						System.out.print(arr.get(i).getArea()+"\t");
						System.out.print(arr.get(i).getAge()+"\n");
					}
					
				}
				
			}else if(gubun == 4) {
				System.out.print("������ ��� �Է� : ");
				String remove = sc.next();
				for (int i = 0; i < arr.size(); i++) {
					if(remove.equals(arr.get(i).getNo())){
						arr.remove(i);
						System.out.println("��� ��ȣ >" + remove + "< �����Ǿ����ϴ�.");
					}
				}
				for (int i = 0; i < arr.size(); i++) {
					System.out.print(arr.get(i).getNo()+"\t");
					System.out.print(arr.get(i).getName()+"\t");
					System.out.print(arr.get(i).getArea()+"\t");
					System.out.print(arr.get(i).getAge()+"\n");
				}
			}
			else if(gubun == 0) {
				System.out.println("���� �Ǿ����ϴ�.");
			}
			else {
				System.out.println("�ٽ� �������ּ���.");
			}
		}while(gubun != 0);
	}
}
