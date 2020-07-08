
public class day_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		day1_dto dto = new day1_dto();
		String name = "ȫ�浿";
		int kor = 20;
		int eng = 30;
		int mat = 40;
		day1_dto dto2 = new day1_dto(name,kor,eng,mat);
		
		System.out.println(dto.getName());
		System.out.println(dto.getKor());
		System.out.println(dto.getEng());
		System.out.println(dto.getMat());
		
		System.out.println(dto2.getName());
		System.out.println(dto2.getKor());
		System.out.println(dto2.getEng());
		System.out.println(dto2.getMat());
	}

}
