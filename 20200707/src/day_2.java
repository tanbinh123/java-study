import java.util.Scanner;

public class day_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jsl_dto2 dto = new jsl_dto2();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("성명 ? : ");
		dto.setName(sc.next());
		
		System.out.print("국어 점수 ? : ");
		dto.setKor(sc.nextInt());
		
		System.out.print("영어 점수 ? : ");
		dto.setEng(sc.nextInt());
		
		System.out.print("수학 점수 ? : ");
		dto.setMat(sc.nextInt());
		
		System.out.println(dto.getName()+"\t"+dto.getKor()+"\t"+dto.getEng()+"\t"+dto.getMat());
	}

}
