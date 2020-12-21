package dto;

public class Freeboard_dto {
	String no, title, content, reg_id, reg_date;
	int hit;
	public Freeboard_dto(String no, String title, String content, String reg_id, String reg_date, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.hit = hit;
	}
	public String getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getReg_id() {
		return reg_id;
	}
	public String getReg_date() {
		return reg_date;
	}
	public int getHit() {
		return hit;
	}
	
}
