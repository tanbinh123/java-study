package main;

public class main_child extends main_parents {
	
	
		public main_child() {
			System.out.println("�ڽ� Ŭ���� ����");
		}
		public void childPrint() {
			System.out.println("child~~");
		}
		
		@Override //�������̵�(���)�� �����ε�(�Ű�����) ���� ����
		public void samePrint() {
			System.out.println("�ߺ�2");
		}
		
}
