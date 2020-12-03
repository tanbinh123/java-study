package common;

import java.text.SimpleDateFormat;
import java.util.Date;
 
public class Common {
	
	public static String file_dir_notice = "C:/Users/JSLHRD/git/java-study/webPJT_05_homepage4/WebContent/file_room/notice/";
	
	// ¿À´Ã ³¯Â¥
	public static String getToday(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = sdf.format(date);
		return today;
	}

}



