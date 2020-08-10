package dto;

public class book_dto {
	String id, name, address, tel, reg_date;
	int age;
	public book_dto(String id, String name, String address, String tel, int age, String reg_date) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.reg_date = reg_date;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getTel() {
		return tel;
	}
	public String getReg_date() {
		return reg_date;
	}
	public int getAge() {
		return age;
	}
	
	
}
