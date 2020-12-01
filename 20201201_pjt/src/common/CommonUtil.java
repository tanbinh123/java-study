package common;
import java.text.*;
import java.util.*;
import java.io.*;  //첨부관련
public class CommonUtil{
	public static String file_dir_notice = "C:/Users/JSLHRD/Desktop/jsl43_홍길동/eclipse_source/webPJT_99_servlet/WebContent/file_room/notice/";
	public static String file_dir_news = "";
	
	//첨부파일 용량검사
    public static boolean chkFileSize(String ff, int size, String dir){
		boolean yn = true;
		File fileSizeLong = new File(dir,ff);
        long fileLength = fileSizeLong.length();
        if(fileLength ==0){
            File dF = new File(dir,ff);
            dF.delete();
            yn= false;

        }
        if(fileLength > 1024 * 1024 * size){
            File dF = new File(dir,ff);
            boolean aa  = dF.delete();
            yn= false;
        }
		return yn;
	}	
	// null 검사
	public static String checkNull(String sValue){
		String result="";
		if(sValue != null) result = sValue;
		return result;
	}
	// 입력받은 날짜에 날짜더하기
	public String getInputPlusDate(String inDate, int dayC){
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");		
        Date toDate = new Date();
        try {
        	toDate = df.parse(inDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }		
		cal.setTime(toDate);
		

		cal.add(Calendar.DATE, dayC);
		
		return df.format(cal.getTime());
	}	
	
	// 오늘 날짜에 날짜더하기
	public String getPlusToday(int dayC){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		cal.add(Calendar.DATE, dayC);
		
		return df.format(cal.getTime());
	}		
	
	// 오늘날짜
	public static String getToday(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String today = sdf.format(date);
		return today;
	}	
	// 날짜형식 검사
	public static boolean checkDate(String checkDate){
		SimpleDateFormat dateFormat = 
			new SimpleDateFormat("yyyy-MM-dd");
		boolean checkD = true;
		dateFormat.setLenient(false);
		try{
			dateFormat.parse(checkDate);
		}catch(ParseException e){
			checkD = false;
		}
		return checkD;
	}	
	// 부족한 자리수 만큼 채우기 왼쪽채우기
    public static String getLPad(String str, int size, String strFillText) {
//    	                          "13"           4            "9"
//    	                          "0013"
        for(int i = (str.getBytes()).length; i < size; i++) {
            str = strFillText + str;
        }
        return str;
    }
	// 부족한 자리수 만큼 채우기 양쪽채우기
    public static String getCPad(String str, int size, String strFillText) {
        int intPadPos = 0;
        for(int i = (str.getBytes()).length; i < size; i++) {
            if(intPadPos == 0) {
                str += strFillText;
                intPadPos = 1;
            } else {
                str = strFillText + str;
                intPadPos = 0;
            }
        }
        return str;
    }
	// 부족한 자리수 만큼 채우기 오른쪽채우기
    public static String getRPad(String str, int size, String strFillText) {
        for(int i = (str.getBytes()).length; i < size; i++) {
            str += strFillText;
        }
        return str;
    }

	// 페이지                                                      
	public static String pageListPost(int current_page,int totalpage, int pageCount){
		int pagenumber;    //화면에 보여질 페이지 인덱스수
		int startpage;     //화면에 보여질 시작 페이지 번호
		int endpage;       //화면에 보여질 마지막 페이지 번호
		int curpage;       //이동하고자 하는 페이지 번호
		
		String strList=""; //리턴될 페이지 인덱스 리스트
		
		pagenumber = pageCount;   //한 화면의 페이지 인덱스수
		
		//시작 페이지 번호 구하기
		startpage = ((current_page - 1)/ pagenumber) * pagenumber + 1;
		//마지막 페이지 번호 구하기
		endpage = (((startpage -1) + pagenumber) / pagenumber)*pagenumber;
		//총페이지수가 계산된 마지막 페이지 번호보다 작을 경우
		//총페이지수가 마지막 페이지 번호가 됨
		
		if(totalpage <= endpage)  endpage = totalpage;
					
		//첫번째 페이지 인덱스 화면이 아닌경우
		if(current_page > pagenumber){
			curpage = startpage -1;  //시작페이지 번호보다 1적은 페이지로 이동
			strList = strList +"<a href=javascript:goPage("+curpage+")><i class='fa fa-angle-double-left'></i></a>";
		}
						
		//시작페이지 번호부터 마지막 페이지 번호까지 화면에 표시
		curpage = startpage;
		while(curpage <= endpage){
			if(curpage == current_page){
				strList = strList +"<a href='' class='on'>["+current_page+"]</a>";
			} else {
				strList = strList +"<a href=javascript:goPage("+curpage+")><font color=#666699>["+curpage+"]</font></a>";
				//					//NoticeList?t_sel="+selValue+"&t_search="+txtValue&r_page="+curpage+"
			}
			curpage++;
		}
		//뒤에 페이지가 더 있는 경우
		if(totalpage > endpage){
			curpage = endpage+1;
			strList = strList + "<a href=javascript:goPage("+curpage+")><i class='fa fa-angle-double-right'></i></a>";
								///NoticeList?t_sel="+selValue+"&t_search="+txtValue&r_page="+curpage+"
		}
		
		return strList;
	}			
    
    
    
	// 페이지
	public static String pageListPost(int current_page,int totalpage){
		int pagenumber;    //화면에 보여질 페이지 인덱스수
		int startpage;     //화면에 보여질 시작 페이지 번호
		int endpage;       //화면에 보여질 마지막 페이지 번호
		int curpage;       //이동하고자 하는 페이지 번호
		
		String strList=""; //리턴될 페이지 인덱스 리스트
		
//		pagenumber = 5;   //한 화면의 페이지 인덱스수
		pagenumber = 2;   //한 화면의 페이지 인덱스수
		
		//시작 페이지 번호 구하기
		startpage = ((current_page - 1)/ pagenumber) * pagenumber + 1;
		//마지막 페이지 번호 구하기
		endpage = (((startpage -1) + pagenumber) / pagenumber)*pagenumber;
		//총페이지수가 계산된 마지막 페이지 번호보다 작을 경우
		//총페이지수가 마지막 페이지 번호가 됨
		
		if(totalpage <= endpage)  endpage = totalpage;
					
		//첫번째 페이지 인덱스 화면이 아닌경우
		if(current_page > pagenumber){
			curpage = startpage -1;  //시작페이지 번호보다 1적은 페이지로 이동
			strList = strList +"<a href=javascript:goPage("+curpage+")><i class='fa fa-angle-double-left'></i></a>";
		}
						
		//시작페이지 번호부터 마지막 페이지 번호까지 화면에 표시
		curpage = startpage;
		while(curpage <= endpage){
			if(curpage == current_page){
				strList = strList +"<a href='' class='on'>["+current_page+"]</a>";
			} else {
				strList = strList +"<a href=javascript:goPage("+curpage+")><font color=#666699>["+curpage+"]</font></a>";
				//					//NoticeList?t_sel="+selValue+"&t_search="+txtValue&r_page="+curpage+"
			}
			curpage++;
		}
		//뒤에 페이지가 더 있는 경우
		if(totalpage > endpage){
			curpage = endpage+1;
			strList = strList + "<a href=javascript:goPage("+curpage+")><i class='fa fa-angle-double-right'></i></a>";
								///NoticeList?t_sel="+selValue+"&t_search="+txtValue&r_page="+curpage+"
		}
		
		return strList;
	}			
    
    
	// 페이지
	public static String pageList(int current_page,int totalpage, String list_url){
		int pagenumber;    //화면에 보여질 페이지 인덱스수
		int startpage;     //화면에 보여질 시작 페이지 번호
		int endpage;       //화면에 보여질 마지막 페이지 번호
		int curpage;       //이동하고자 하는 페이지 번호
		
		String strList=""; //리턴될 페이지 인덱스 리스트
		
		pagenumber = 5;   //한 화면의 페이지 인덱스수
		
		//시작 페이지 번호 구하기
		startpage = ((current_page - 1)/ pagenumber) * pagenumber + 1;
		//마지막 페이지 번호 구하기
		endpage = (((startpage -1) + pagenumber) / pagenumber)*pagenumber;
		//총페이지수가 계산된 마지막 페이지 번호보다 작을 경우
		//총페이지수가 마지막 페이지 번호가 됨
		
		if(totalpage <= endpage)  endpage = totalpage;
					
		//첫번째 페이지 인덱스 화면이 아닌경우
		if(current_page > pagenumber){
			curpage = startpage -1;  //시작페이지 번호보다 1적은 페이지로 이동
			strList = strList +"<a href='"+list_url+"&r_page="+curpage+"'><i class='fa fa-angle-double-left'></i></a>";
		}
						
		//시작페이지 번호부터 마지막 페이지 번호까지 화면에 표시
		curpage = startpage;
		while(curpage <= endpage){
			if(curpage == current_page){
				strList = strList +"<a href='' class='on'>["+current_page+"]</a>";
			} else {
				strList = strList +"<a href='"+list_url+"&r_page="+curpage+"'><font color=#666699>["+curpage+"]</font></a>";
			}
			curpage++;
		}
		//뒤에 페이지가 더 있는 경우
		if(totalpage > endpage){
			curpage = endpage+1;
			strList = strList + "<a href='"+list_url+"&r_page="+curpage+"'><i class='fa fa-angle-double-right'></i></a>";
		}
		
		return strList;
	}			
	
}









