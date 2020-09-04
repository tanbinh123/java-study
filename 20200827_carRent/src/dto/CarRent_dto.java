package dto;

public class CarRent_dto {

	String rent_no, member_no, car_no, rent_date, return_day, return_date;

	public CarRent_dto(String rent_no, String member_no, String car_no, String rent_date, String return_day, String return_date) {
		super();
		this.rent_no = rent_no;
		this.member_no = member_no;
		this.car_no = car_no;
		this.rent_date = rent_date;
		this.return_day = return_day;
		this.return_date = return_date;
	}
	

	public CarRent_dto(String car_no) {
		super();
		this.car_no = car_no;
	}


	public String getRent_no() {
		return rent_no;
	}

	public String getMember_no() {
		return member_no;
	}

	public String getCar_no() {
		return car_no;
	}

	public String getRent_date() {
		return rent_date;
	}

	public String getReturn_day() {
		return return_day;
	}

	public String getReturn_date() {
		return return_date;
	}
	
	
}
