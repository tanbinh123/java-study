package main;

public class childMain2 extends parentMain{

	@Override
	public int getTotal(int kor, int eng) {
		return kor + eng;
	}
	
	@Override
	public int getAva(int t, int c) {
		return t /c ; 
	}
	public String getName() {
		return "ȫ�浿";
	}
	
	@Override
	public int getEng() {
		return 90;
	};
}
