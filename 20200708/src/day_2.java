import java.util.Scanner;

public class day_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		day1_dto[] dtos = new day1_dto[2];
		for (int i = 0; i < dtos.length; i++) {
			
			System.out.print("성명? : ");
			String name = sc.next();
			System.out.print("국어? : ");
			int kor = sc.nextInt();
			System.out.print("영어? : ");
			int eng = sc.nextInt();
			System.out.print("수학? : ");
			int mat = sc.nextInt();
			
			dtos[i] = new day1_dto();
			dtos[i].setName(name);
			dtos[i].setKor(kor);
			dtos[i].setEng(eng);
			dtos[i].setMat(mat);
		
			
		}
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균\t");
		for (int i = 0; i < dtos.length; i++) {
			int total = dtos[i].getKor()+dtos[i].getEng()+dtos[i].getMat();
			int avg = (total/3);
			
			System.out.print(dtos[i].getName()+"\t"+dtos[i].getKor()+"\t"+dtos[i].getEng()+"\t"+dtos[i].getMat()+"\t"+total+"\t"+avg+"\n");
		}
	}

}
