
package main;

public class interfaceMain 
extends parentMain
implements interfaceParent, interfaceParent2
{
	
	public String getName() {
		return "È«±æµ¿";
	}
	@Override
	public int getTotal(int kor, int eng) {
		return kor + eng;
	}
	
	@Override
	public int getAva(int total, int count) {
		return total / count;
	}
	
	@Override
	public String getResult(int ava) {
		return "¼ö";
	}
	
	@Override
	public int getEng() {
		return 50;
	};
	
}