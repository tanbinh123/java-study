import java.util.Scanner;

public class day_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jsl_dto2 dto = new jsl_dto2();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ? : ");
		dto.setName(sc.next());
		
		System.out.print("���� ���� ? : ");
		dto.setKor(sc.nextInt());
		
		System.out.print("���� ���� ? : ");
		dto.setEng(sc.nextInt());
		
		System.out.print("���� ���� ? : ");
		dto.setMat(sc.nextInt());
		
		System.out.println(dto.getName()+"\t"+dto.getKor()+"\t"+dto.getEng()+"\t"+dto.getMat());
	}

}
