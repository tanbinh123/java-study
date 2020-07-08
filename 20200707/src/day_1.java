
public class day_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jsl_dto dto = new jsl_dto();
		

		String n = dto.getName();
		System.out.println(n);
		
		dto.setName("홍길동");
		n = dto.getName();
		System.out.println("name : "+n);

		
		dto.setAge(20);
		System.out.println("age : " + dto.getAge());
		
		
		
		
		
		jsl_dto dto2 = new jsl_dto();
		dto2.setName("이순신");
		String n2 = dto2.getName();
		System.out.println("name : "+n2);
		
		dto.setAge(28);
		System.out.println("age : " + dto.getAge());
	}

}