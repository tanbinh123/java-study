package dto;

public class testDB_dto {
int no;
String name, title, content;
public testDB_dto(int no, String name, String title, String content) {
	super();
	this.no = no;
	this.name = name;
	this.title = title;
	this.content = content;
}
public int getNo() {
	return no;
}
public String getName() {
	return name;
}
public String getTitle() {
	return title;
}
public String getContent() {
	return content;
}
public void setNo(int no) {
	this.no = no;
}
public void setName(String name) {
	this.name = name;
}
public void setTitle(String title) {
	this.title = title;
}
public void setContent(String content) {
	this.content = content;
}


}
