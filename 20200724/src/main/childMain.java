package main;

public class childMain extends parentMain{
	
	@Override
	public int getTotal(int kor, int eng) {
		return kor + eng;
	}
	
	@Override
	public int getAva(int t, int c) {
		return t /c ; 
	}
	
	public String getResult(int ava) {
		return "¼ö";
	}
	
	@Override
	public int getEng() {
		return 90;
	};
}
