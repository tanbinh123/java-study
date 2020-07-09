
public class day_dto {
	
	String name, result;
	int kor, eng, mat, total;
	
	public day_dto(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public day_dto(String name, int kor, int eng) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	
	void setTotal() {
		total = kor+eng+mat;
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
	int getTotal() {
		return total;
	}
	
	String getResult() {
		if(((kor+eng)/2)>80) {
			result = "합격";
		}else{
			result = "불합격";
		};
		return result;
	}
}