package dto;

public class Qna_dto {
	
	String no,title,groupno,reg_date,reg_name,content;
	int depth, seg,hit;
	public Qna_dto(String no, String title, String groupno, String reg_date, String reg_name, String content, int depth,
			int seg, int hit) {
		super();
		this.no = no;
		this.title = title;
		this.groupno = groupno;
		this.reg_date = reg_date;
		this.reg_name = reg_name;
		this.content = content;
		this.depth = depth;
		this.seg = seg;
		this.hit = hit;
	}
	
	
	
	
	public Qna_dto(String no, String title, String reg_date, String reg_name, String content) {
		super();
		this.no = no;
		this.title = title;
		this.reg_date = reg_date;
		this.reg_name = reg_name;
		this.content = content;
	}

	



	public Qna_dto(String no, String title, String content) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
	}




	public String getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getGroupno() {
		return groupno;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getReg_name() {
		return reg_name;
	}
	public String getContent() {
		return content;
	}
	public int getDepth() {
		return depth;
	}
	public int getSeg() {
		return seg;
	}
	public int getHit() {
		return hit;
	}
	
	
}
