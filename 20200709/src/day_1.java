
public class day_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "È«±æµ¿";
		int kor = 90, eng = 80, mat = 70;
		day_dto dto = new day_dto(name,kor,eng,mat);
		
		System.out.println("name : "+dto.getName());
		dto.setTotal();
		System.out.println("total : "+dto.getTotal());
		
		
		day_dto dto1 = new day_dto(name,kor,eng);
		String result = dto1.getResult();
		System.out.println(name + "´Ô "+ result);
	}

}