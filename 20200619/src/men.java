
public class men {
	
	String[] array = {"","��������"};
	int i = 0;
	
	String cho(int menu, int cup) {
	if(menu == 1) {
		array[0] = "�Ƹ޸�ī��";
		if(cup >= 2) {
			array[1] = "�߱�";
		}
	}else if(menu == 2){
		array[0] = "īǪġ��";
	}else if(menu == 3){
		array[0] = "ī���";
	}
	return array;
}
}
