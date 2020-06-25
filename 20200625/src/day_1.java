
public class day_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=5,j=1;
		/*while(i <= 9) {
				System.out.println(i + "단");
			while(j <= 9) {
				System.out.println(i + "*" + j + "=" + i * j);
				j++;
			}i++; j=1;
		}*/
		
		/*while(j<=5) {
			System.out.println(j + "개 먹었습니다.");
			j++;
		}System.out.println("다 먹었습니다.");*/
		
		while(j <= 10) {
			System.out.println("j :" + j);
			if(j >= 5) break;
			j++;
		}
	}

}
