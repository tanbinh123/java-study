package common;

import java.text.SimpleDateFormat;
import java.util.Date;
 
public class Common {
	// 오늘날짜
	public static String getToday(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = sdf.format(date);
		return today;
	}
	
}



