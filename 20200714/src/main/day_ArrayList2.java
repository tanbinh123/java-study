package main;
import java.util.ArrayList;
import dto.dto_2;
public class day_ArrayList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<dto_2> arr = new ArrayList<>();
		dto_2 dto1 = new dto_2("홍길동","대전",30);
		dto_2 dto2 = new dto_2("박길수","서울",50);
		
		arr.add(dto1);
		arr.add(dto2);
		arr.add(new dto_2("안상수","부산",40));
		
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).getName() + "\t "+arr.get(i).getArea()+"\t"+arr.get(i).getAge());
		}
		
		
	}

}
