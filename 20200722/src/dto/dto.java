package dto;

public class dto {
	String no, name, area;
	int age;
	public dto(String no, String name, String area, int age) {
		super();
		this.no = no;
		this.name = name;
		this.area = area;
		this.age = age;
	}
	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public String getArea() {
		return area;
	}
	public int getAge() {
		return age;
	}
	
}
