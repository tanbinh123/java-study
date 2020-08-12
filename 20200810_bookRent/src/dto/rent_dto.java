package dto;

public class rent_dto {

	String no, member_id, book_no, rent_date, return_date;

	public rent_dto(String no, String member_id, String book_no, String rent_date, String return_date) {
		super();
		this.no = no;
		this.member_id = member_id;
		this.book_no = book_no;
		this.rent_date = rent_date;
		this.return_date = return_date;
	}

	public String getNo() {
		return no;
	}

	public String getMember_id() {
		return member_id;
	}

	public String getBook_no() {
		return book_no;
	}

	public String getRent_date() {
		return rent_date;
	}

	public String getReturn_date() {
		return return_date;
	}
	
	
}
