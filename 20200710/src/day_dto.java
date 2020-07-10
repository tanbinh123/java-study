
public class day_dto {
	String name, area;
	int kor, eng, mat, age, total;
	
	day_dto(String name, int kor, int eng, int mat){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	day_dto(String name, int kor, int eng){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		total = this.kor + this.eng;
		
	}
	day_dto(String name, String area, int age){
		this.name = name;
		this.area = area;
		this.age = age;
	}
	day_dto(){

	}
	void setName(String name) {
		this.name = name;
	}
	void setArea(String area) {
		this.area = area;
	}
	void setAge(int age) {
		this.age = age;
	}
	void setKor(int kor) {
		this.kor = kor;
	}
	void setEng(int eng) {
		this.eng = eng;
	}
	
	
	String getName() {
		return name;
	}
	int getKor() {
		return kor;
	}
	int getEng() {
		return eng;
	}
	int getMat() {
		return mat;
	}
	String getArea() {
		return area;
	}
	int getAge() {
		return age;
	}
	void getPrintStudy() {
		System.out.println(name +"\t"+ kor +"\t"+ eng +"\t"+ mat);
	}
	void getPrintStudySum() {
		System.out.println(name +"\t"+ kor +"\t"+ eng +"\t"+ total);
	}
	void getPrintPersonalInfo() {
		System.out.println(getName() +"\t"+ getArea() +"\t"+ getAge());
	}
}
