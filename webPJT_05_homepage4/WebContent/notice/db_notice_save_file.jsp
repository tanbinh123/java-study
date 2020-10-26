<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*,common.*" %>
<%@ page import="com.oreilly.servlet.*, java.io.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Notice_dao dao = new Notice_dao();
	
	//String file_dir = "C:/Users/JSLHRD/git/java-study/webPJT_05_homepage4/WebContent/file_room/notice/";
	String file_dir = Common.file_dir_notice;
	int sizeLimit = 1024 * 1024 * 10;
	MultipartRequest mpr = new MultipartRequest(request,file_dir,sizeLimit,"utf-8");
	
	String no 		= dao.getNoticeNo();
	String title 	= mpr.getParameter("t_title"); 
	String content 	= mpr.getParameter("t_content"); 
	String reg_name = mpr.getParameter("t_reg_name"); 
	String reg_date = mpr.getParameter("t_reg_date");
	
	
	String attach 	= mpr.getFilesystemName("t_attach"); //aa.hwp
	String dbAttachName = "";
	
	if (attach != null){ //파일 저장 이름 변경
		File oldFile = new File(file_dir,attach);
		File newFile = new File(file_dir,no+"-"+attach);//N025-aaaa.hwp
		oldFile.renameTo(newFile);
		dbAttachName = newFile.getName();
	}
	
	out.print(" attach : "+ attach);
	out.print(" dbAttachName : "+ dbAttachName);
/*	
	String no 		= dao.getNoticeNo();

	String title 	= request.getParameter("t_title"); 
	String content 	= request.getParameter("t_content"); 
	String attach 	= request.getParameter("t_attach"); 
	String reg_name = request.getParameter("t_reg_name"); 
	String reg_date = request.getParameter("t_reg_date"); 
	*/
	
	Notice_dto dto = new Notice_dto(no,title,content,dbAttachName,reg_name,reg_date,0);
	int result = dao.saveNotice(dto);
	String msg="";
	if(result == 1) msg =" 등록 되었습니다. ";
	else msg=" 등록 실패~ ";
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>")
	location.href="notice_list.jsp";
</script>
</head>
<body>

</body>
</html>