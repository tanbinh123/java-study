import java.util.*;

public class day_2 {

	public static void main(String[] args) {

		String name = "ȫ�浿";
		day_dto1 dto = new day_dto1(name);
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("���� ? :");
//		dto.setName(sc.next());
		System.out.print("���� ? :");
		dto.setKor(sc.nextInt());
		System.out.print("���� ? :");
		dto.setEng(sc.nextInt());
		System.out.print("���� ? :");
		dto.setMat(sc.nextInt());
		dto.setTotal();
		dto.setAvg();
		dto.setResult();
		dto.getPrint();
	}

}
