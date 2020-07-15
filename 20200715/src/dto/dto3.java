package dto;

public class dto3 {

	public String name, result;
	public int kor, eng, mat, total;
	public double ava;

	public dto3(String name, String result, int kor, int eng, int mat, int total, double ava) {
		super();
		this.name = name;
		this.result = result;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.total = total;
		this.ava = ava;
	}
	
	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMat() {
		return mat;
	}
	public int getTotal() {
		return total;
	}
	public Double getAva() {
		return ava;
	}
	public String getReult() {
		return result;
	}
	
}
