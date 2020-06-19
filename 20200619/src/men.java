
public class men {
	
	String[] array = {"","쿠폰없음"};
	int i = 0;
	
	String cho(int menu, int cup) {
	if(menu == 1) {
		array[0] = "아메리카노";
		if(cup >= 2) {
			array[1] = "발급";
		}
	}else if(menu == 2){
		array[0] = "카푸치노";
	}else if(menu == 3){
		array[0] = "카페라떼";
	}
	return array;
}
}
