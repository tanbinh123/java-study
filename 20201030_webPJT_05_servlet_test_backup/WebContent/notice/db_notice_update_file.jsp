<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<%@ page import ="dao.*,dto.*,common.*"%>
<%@ page import="com.oreilly.servlet.*, java.io.*" %>
<% 
	request.setCharacterEncoding("utf-8");
	Notice_dao dao = new Notice_dao();
	
	//String file_dir = "C:/Users/JSLHRD/git/java-study/webPJT_05_homepage4/WebContent/file_room/notice/";
	String file_dir = Common.file_dir_notice;
	int sizeLimit = 1024 * 1024 * 10;
	MultipartRequest mpr = new MultipartRequest(request,file_dir,sizeLimit,"utf-8");
	
	String no 		= mpr.getParameter("t_no");
	String title 	= mpr.getParameter("t_title"); 
	String content 	= mpr.getParameter("t_content"); 
	String reg_name = mpr.getParameter("t_reg_name"); 
	String reg_date = mpr.getParameter("t_reg_date");
	
	String del_attach = mpr.getParameter("t_del_attach");
	String dbAttachName = "";
	
	if(del_attach != null){
		File delFile = new File(file_dir,del_attach);
		boolean d = delFile.delete();
		out.print("삭제여부 : " + d);
	}else{
		dbAttachName = mpr.getParameter("t_ori_attach");
	}
	
	String attach 	= mpr.getFilesystemName("t_attach"); //aa.hwp
	if (attach != null){
		String df = mpr.getParameter("t_ori_attach");
		if(!df.equals("")){
			File delFile = new File(file_dir,df);
			boolean d = delFile.delete();		
		}
		File oldFile = new File(file_dir,attach);
		File newFile = new File(file_dir,no+"-"+attach);//N025-aaaa.hwp
		oldFile.renameTo(newFile);
		dbAttachName = newFile.getName();
	}
	
	out.print(dbAttachName);
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>