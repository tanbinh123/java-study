import java.util.Scanner;

public class day_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String[] a = new String[2];
		a[0] = "È«±æµ¿";
		
		jsl_dto2[] dtos = new jsl_dto2[2];
		dtos[0] = new jsl_dto2();
		dtos[0].setName("ÀÌ¼ø½Å");
		dtos[0].setKor(10);
		dtos[0].setEng(100);
		dtos[0].setMat(1000);
		/*System.out.print(dtos[0].getName()+"\t");
		System.out.print(dtos[0].getKor()+"\t");
		System.out.print(dtos[0].getEng()+"\t");
		System.out.print(dtos[0].getMat()+"\t\n");*/
		
		dtos[1] = new jsl_dto2();
		dtos[1].setName("±èÁ¤Àº");
		dtos[1].setKor(4);
		dtos[1].setEng(44);
		dtos[1].setMat(444);
		/*System.out.print(dtos[1].getName()+"\t");
		System.out.print(dtos[1].getKor()+"\t");
		System.out.print(dtos[1].getEng()+"\t");
		System.out.print(dtos[1].getMat()+"\t");*/
		
		
		
		for(int i =0; i<dtos.length; i++) {
			System.out.print(dtos[i].getName()+"\t");
			System.out.print(dtos[i].getKor()+"\t");
			System.out.print(dtos[i].getEng()+"\t");
			System.out.print(dtos[i].getMat()+"\t\n");
		}
		
	}

}
