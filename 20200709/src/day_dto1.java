
public class day_dto1 {
	
	String name, result;
	int kor, eng, mat, total,avg;
	
	day_dto1(){
		
	}
	day_dto1(String name){
		this.name = name;
	}
	void setName(String name){ //name
		this.name = name;
	}
	String getName() {
		return name;
	}
	
	void setKor(int kor) { //kor
		this.kor = kor;
	}
	int getKor() {
		return kor;
	}
	
	void setEng(int eng) { //eng
		this.eng = eng;
	}
	int getEng() {
		return eng;
	}
	
	void setMat(int mat) { //mat
		this.mat = mat;
	}
	int getMat() {
		return mat;
	}
	
	void setTotal() { //total
		total = kor + eng + mat;
	}
	int getTotal() {
		return total;
	}
	
	void setAvg() { //avg
		avg = total/3;
	}
	int getAvg() {
		return avg;
	}
	void setResult() { //result
		if(avg>90) {
			result = "��";	
		}else if (avg > 80) {
			result = "��";
		}else if (avg > 70) {
			result = "��";
		}else if (avg > 60) {
			result = "��";
		}else {
			result = "��";
		}
	}
	String getResult() {
		return result;
	}
	
	void getPrint() { //print
		System.out.print(getName()+"�� ���:"+getAvg()+" ���:"+getResult());
	}
}
