
package main;

public class interfaceMain 
extends parentMain
implements interfaceParent, interfaceParent2
{
	
	public String getName() {
		return "ȫ�浿";
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
		return "��";
	}
	
	@Override
	public int getEng() {
		return 50;
	};
	
}