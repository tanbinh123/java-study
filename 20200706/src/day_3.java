
public class day_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		day_dto dto = new day_dto();
		

		String n = dto.getName();
		System.out.println(n);
		
		dto.setName("ȫ�浿");
		n = dto.getName();
		System.out.println(n);

		
		day_dto dto2 = new day_dto();
		dto2.setName("�̼���");
		String n2 = dto2.getName();
		System.out.println(n2);
	}

}
