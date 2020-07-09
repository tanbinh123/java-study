import java.util.*;

public class day_2 {

	public static void main(String[] args) {

		String name = "홍길동";
		day_dto1 dto = new day_dto1(name);
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("성명 ? :");
//		dto.setName(sc.next());
		System.out.print("국어 ? :");
		dto.setKor(sc.nextInt());
		System.out.print("영어 ? :");
		dto.setEng(sc.nextInt());
		System.out.print("수학 ? :");
		dto.setMat(sc.nextInt());
		dto.setTotal();
		dto.setAvg();
		dto.setResult();
		dto.getPrint();
	}

}
