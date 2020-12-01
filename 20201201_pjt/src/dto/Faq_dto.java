package dto;

public class Faq_dto {
	String no, question, answer, reg_id, reg_date, sort;
	int hit;
	public Faq_dto(String no, String question, String answer, String reg_id, String reg_date, String sort, int hit) {
		super();
		this.no = no;
		this.question = question;
		this.answer = answer;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.sort = sort;
		this.hit = hit;
	}
	public String getNo() {
		return no;
	}
	public String getQuestion() {
		return question;
	}
	public String getAnswer() {
		return answer;
	}
	public String getReg_id() {
		return reg_id;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getSort() {
		return sort;
	}
	public int getHit() {
		return hit;
	}
	
	
}
