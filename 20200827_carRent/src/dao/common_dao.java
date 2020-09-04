package dao;

public class common_dao {
	//y or n check
	public String getYNResult(String scData) {
		String result = "";
		if(scData.equals("y") || scData.equals("Y") || scData.equals("ㅛ") || scData.equals("n") || scData.equals("N") || scData.equals("ㅜ")) {
			if(scData.equals("y") || scData.equals("Y") || scData.equals("ㅛ")) {
				result = "y";
			}
			else if(scData.equals("n") || scData.equals("N") || scData.equals("ㅜ")) {
				result = "n";
			}
		}else {
			System.out.println("-----------y 나 n 으로 입력해주세요-----------");
			scData = "";
		}
		return result;
	}
	
	//제조사 입력 예외처리 메소드
	public String getCarMadeEx(String scData) {
		String passResult = "";
		if(scData.equals("10") || scData.equals("20") || scData.equals("30") || scData.equals("40") || scData.equals("50") || scData.equals("60") || scData.equals("70") || scData.equals("80") || scData.equals("90")){
			passResult = "ture";
		}else {
			System.out.println("-----------다시 입력해주세요-----------");
			passResult = "false";
			scData = "";
		}
		return passResult;
	}
	
	//글자 수 예외처리 메소드
	public String getStringLengthEx(String title, String scData, int setLength) {
		String passResult = "";
		if (scData.length() > setLength) {
			System.out.println(title+"는(은) "+setLength+"글자까지만 입력해주세요.\n현재 글자수 : "+ scData.length());
			passResult = "false";
			scData = "";
		}
		else {
			passResult = "ture";
		}
		return passResult;
	}
}
