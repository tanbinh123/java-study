package dto;

public class info_dto {

	String memberId, memberName, bookName, bookWriter, bookPublisher, rentDay;

	public info_dto(String memberId, String memberName, String bookName, String bookWriter, String bookPublisher,
			String rentDay) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookPublisher = bookPublisher;
		this.rentDay = rentDay;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public String getRentDay() {
		return rentDay;
	}
	
	
}
