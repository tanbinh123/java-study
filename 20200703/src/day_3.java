public class day_3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] arr = {
				{"ȫ�浿","90","80","70","60","",""},
				{"������","80","60","60","50","",""},
				{"������","70","50","90","80","",""}
				};
		for(int i = 0; i < arr.length; i++) {
			int total = 0;								//�������� �� �ʱ�ȭ
			for(int j = 1; j < arr[0].length-2; j++) {
				total += Integer.parseInt(arr[i][j]);  //���� ���
			}arr[i][arr[i].length-2] = Integer.toString(total); //���� �迭�� ����
			arr[i][arr[i].length-1] = Integer.toString(total/(arr[0].length-3)); //��� ��� �� ����
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+"\t"); //�迭 ���
			}System.out.println("");
		}
	}
}
