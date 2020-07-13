
public class day_dto {
	
	String name, area;
	int age;
	
	public day_dto(String name, String area, int age) {
		this.name = name;
		this.area = area;
		this.age = age;
	}
	
	String getName(){
		return name;
	}
	
	String getArea() {
		return area;
	}
	
	int getAge() {
		return age;
	}
}
