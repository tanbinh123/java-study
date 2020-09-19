package Main;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//List , Map
		//List는 배열과 비슷함 (인터페이스)
		//특징 : 인덱스를 이용한다. 데이터 중복이 가능하다.
		
		//ArrayList 객체 생성
		ArrayList<String> list = new ArrayList<String>();
		
		//데이터 추가
		list.add("Hello");
		list.add("JAVA");
		list.add("WORLD");
		
		System.out.println("list size : " + list.size());
		System.out.println("list : " + list);
		
		//데이터 추가
		list.add(2,"Programing");
		System.out.println("list : " + list);
		
		//데이터 변경
		list.set(1, "c");
		System.out.println("list : " + list);
		
		//데이터 추출
		String str = list.get(2);
		System.out.println("list get :" + str);
		System.out.println("list : " + list);
		
		//데이터 제거
		str = list.remove(2);
		System.out.println("list remove :" + str);
		System.out.println("list : " + list);
		
		//데이터 전체 제거
		list.clear();
		System.out.println("list : " + list);
		
		//데이터 존재여부
		boolean b = list.isEmpty();
		
		System.out.println("list.isEmpty : " + b);
		
		
		System.out.println("=======================================================");
		
		//Map도 인터페이스
		//특징 : key를 이용한다. key는 중복될 수 없다. 데이터 중복이 가능하다.
		
		//HashMap 객체 생성
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		//데이터 추가
		map.put(5, "Hello");
		map.put(6, "Java");
		map.put(7, "World");
		System.out.println("map : " + map);
		System.out.println("map.size() : " + map.size());
		
		map.put(8, "!!!!");
		System.out.println("map : " + map);
		
		//데이터 교체
		map.put(6, "C");
		System.out.println("map : " + map);
		
		//데이터 추출
		str = map.get(5);
		System.out.println("map.get(5) : " + str);
		
		//데이터 제거
		map.remove(8);
		System.out.println("map : " + map);
		
		//특정 데이터 포함 유무
		b = map.containsKey(7);
		System.out.println("map.containsKey(7) : " + b);
		
		b = map.containsValue("World");
		System.out.println("map.containsValue(\"World\") : " + b);
		
		//데이터 전체 제거
		map.clear();
		System.out.println("map : " + map);
		
		//데이터 유무
		b = map.isEmpty();
		System.out.println("map.isEmpty() : " + b);
	}

}
