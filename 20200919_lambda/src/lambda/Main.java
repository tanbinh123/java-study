package lambda;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//매개변수와 실행문만으로 작성한다(접근자, 반환형, return 키워드 생략)
		Lambda1 lam1 = (String s1, String s2, String s3) -> {System.out.println(s1 + " " + s2 + " " + s3);};
		lam1.method("Hello", "java", "world");
		
		//매개변수가 1개이거나 타입이 같을 때, 타입을 생략할 수 있다.
		Lambda1 lam2 = (s1, s2, s3) -> {System.out.println(s1 + " " + s2 + " " + s3);};
		lam2.method("Hello", "java", "world");
		
		Lambda2 lam3 = (s1) -> {System.out.println(s1);};
		lam3.method("Hello");
		
		//실행문이 1개일 때, {}를 생략할 수 있다.
		Lambda2 lam4 = (s1) -> System.out.println(s1);
		lam4.method("Hello");
		
		//매개변수와 실행문이 1개일 때, ()와 {}를 생략할 수 있다.
		Lambda2 lam5 = s1 -> System.out.println(s1);
		lam5.method("Hello");
		
		//매개변수가 없을 때 ()만 작성한다.
		Lambda3 lam6 = () -> System.out.println("no parameter");
		lam6.method();
		
		//반환값이 있는 경우
		Lambda4 lam7 =(x,y) -> {
			int result = x + y;
			return result;
		};
		System.out.printf("lam7.method(10, 20) :  %d\n", lam7.method(10, 20) );
		
		lam7 =(x,y) -> {
			int result = x * y;
			return result;
		};
		System.out.printf("lam7.method(10, 20) :  %d\n", lam7.method(10, 20) );
		
		lam7 =(x,y) -> {
			int result = x - y;
			return result;
		};
		System.out.printf("lam7.method(10, 20) :  %d\n", lam7.method(10, 20) );
	}

}
