package dto;

public class testDB_dto {

String No, Name, Area;
int Age;
public testDB_dto(String no, String name, String area, int age) {
	super();
	No = no;
	Name = name;
	Area = area;
	Age = age;
}
public String getNo() {
	return No;
}
public String getName() {
	return Name;
}
public String getArea() {
	return Area;
}
public int getAge() {
	return Age;
}



}
