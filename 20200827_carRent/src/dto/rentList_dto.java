package dto;

public class rentList_dto {

	String memberid, memberName, carId, carName, rentDate, returnDate, returnDay;

	public rentList_dto(String memberid, String memberName, String carId, String carName, String rentDate, String returnDate, String returnDay) {
		super();
		this.memberid = memberid;
		this.memberName = memberName;
		this.carId = carId;
		this.carName = carName;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.returnDay = returnDay;
	}

	public String getMemberid() {
		return memberid;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getCarId() {
		return carId;
	}

	public String getCarName() {
		return carName;
	}

	public String getRentDate() {
		return rentDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public String getReturnDay() {
		return returnDay;
	}
	
	
}
