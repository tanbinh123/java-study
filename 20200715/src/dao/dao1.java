package dao;

public class dao1 {

		public int getTotal(int kor, int eng, int mat) {
			int total = kor + eng + mat;
			return total;
		}
		public int getAva(int total,int count) {
			int ava = total/count;
			return ava;
		
	}

}
