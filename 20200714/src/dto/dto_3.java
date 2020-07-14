package dto;

public class dto_3 {
	String name;
	int kor, eng, mat, total, ava;
	public dto_3(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
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
	public void setTotal() {
		total = kor+eng+mat;
	}
	public int getTotal() {
		return total;
	}
	public void setAva() {
		ava = total/3;
	}
	public int getAva() {
		return ava;
	}
	
}
