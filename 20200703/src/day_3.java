public class day_3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] arr = {
				{"È«±æµ¿","90","80","70","60","",""},
				{"±èÁ¡·Ê","80","60","60","50","",""},
				{"¿À¸¸µæ","70","50","90","80","",""}
				};
		for(int i = 0; i < arr.length; i++) {
			int total = 0;								//ÃÑÁ¡¼±¾ð ¹× ÃÊ±âÈ­
			for(int j = 1; j < arr[0].length-2; j++) {
				total += Integer.parseInt(arr[i][j]);  //ÃÑÁ¡ °è»ê
			}arr[i][arr[i].length-2] = Integer.toString(total); //ÃÑÁ¡ ¹è¿­¿¡ ´ëÀÔ
			arr[i][arr[i].length-1] = Integer.toString(total/(arr[0].length-3)); //Æò±Õ °è»ê ¹× ´ëÀÔ
		}
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+"\t"); //¹è¿­ Ãâ·Â
			}System.out.println("");
		}
	}
}
