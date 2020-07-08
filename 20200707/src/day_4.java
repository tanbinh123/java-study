
public class day_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jsl_dto3[] dtos = new jsl_dto3[2];
		String[][] info = {{"홍길동","대전","30"},{"이순신","공주","25"}};
		
		
		for(int i = 0 ; i < info.length; i++) {
			dtos[i] = new jsl_dto3();
			
			dtos[i].setName(info[i][0]);
			dtos[i].setArea(info[i][1]);
			dtos[i].setAge(info[i][2]);
			
			System.out.print(dtos[i].getName() + "\t");
			System.out.print(dtos[i].getArea()+ "\t");
			System.out.print(dtos[i].getAge()+ "\t\n");
		}
		
		
		
		
		
		//dtos[0] = new jsl_dto3();
		//dtos[1] = new jsl_dto3();
		
		/*
		dtos[0].setName("홍길동");
		dtos[0].setArea("대전");
		dtos[0].setAge(30);
		
		dtos[1].setName("이순신");
		dtos[1].setArea("공주");
		dtos[1].setAge(25);
		
		for(int i = 0; i < dtos.length; i++) {
			System.out.print(dtos[i].getName() + "\t");	
			System.out.print(dtos[i].getArea()+ "\t");	
			System.out.print(dtos[i].getAge()+ "\t\n");	
		}
		*/
	}

}
