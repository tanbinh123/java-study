package dto;

public class Freeboard_dto {
	String no, title, content, reg_name, reg_date, reg_id;
	int hit;
	public Freeboard_dto(String no, String title, String content, String reg_name, String reg_date, String reg_id,
			int hit) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.reg_id = reg_id;
		this.hit = hit;
	}
	
	
	public Freeboard_dto(String no, String title, String content, String reg_name, String reg_date, String reg_id) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.reg_name = reg_name;
		this.reg_date = reg_date;
		this.reg_id = reg_id;
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
	public String getReg_name() {
		return reg_name;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getReg_id() {
		return reg_id;
	}
	public int getHit() {
		return hit;
	}
	
	
	
}
