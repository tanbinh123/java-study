
public class day1_dto {
	
	String name;
	int kor, eng, mat, total;
	
	day1_dto(){
		
	}
	
	day1_dto(String name, int kor, int eng, int mat){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	void setName(String name){
		this.name = name;
	}
	String getName() {
		return name;
	}
	

	
	void setKor(int kor) {
		this.kor = kor;
	}
	int getKor() {
		return kor;
	}
	
	void setEng(int eng) {
		this.eng = eng;
	}
	int getEng() {
		return eng;
	}
	
	void setMat(int mat) {
		this.mat = mat;
	}
	int getMat() {
		return mat;
	}
	
	void setTotal(int total) {
		this.total=total;
	}
	int getTotal() {
		return total;
	}
	
}
