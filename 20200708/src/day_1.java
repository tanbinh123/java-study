
public class day_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		day1_dto[] dtos = new day1_dto[2];
		
		String[][] namelist = {{"홍길동"},{"안상수"}};
		int[][] scorelist = {{50,60,30,},{40,30,60,}};
		
		for(int i = 0; i < dtos.length; i++) {
			int total = 0;
			dtos[i] = new day1_dto();
			dtos[i].setName(namelist[i][0]);
			dtos[i].setKor(scorelist[i][0]);
			dtos[i].setEng(scorelist[i][1]);
			dtos[i].setMat(scorelist[i][2]);
			
			total = dtos[i].getKor() + dtos[i].getEng() + dtos[i].getMat();
			System.out.print(dtos[i].getName()+"\t"+dtos[i].getKor()+"\t"+dtos[i].getEng()+"\t"+dtos[i].getMat()+"\t"+total+"\n");
		}
		
	}

}
