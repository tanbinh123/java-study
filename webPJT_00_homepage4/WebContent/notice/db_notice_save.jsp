<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*,common.*" %>
<%@ page import="com.oreilly.servlet.*,java.io.*"%>
<%
	request.setCharacterEncoding("utf-8");
	int sizeLimit = 1024 * 1024 * 100 ; 
//	String file_dir ="C:/Users/JSLHRD/Desktop/jsl43_teacher/eclipse_source/webPJT_00_homepage4/WebContent/file_room/notice/";	
	String file_dir =CommonUtil.attach_dir_notice;	
	
	MultipartRequest ctl = new MultipartRequest(request,file_dir,sizeLimit,"UTF-8");

	Notice_dao dao = new Notice_dao();
/*	
	String no 		= dao.getNoticeNo();
	String title 	= request.getParameter("t_title"); 
	String content 	= request.getParameter("t_content"); 
	String attach 	= request.getParameter("t_attach"); 
	String reg_name = request.getParameter("t_reg_name"); 
	String reg_date = request.getParameter("t_reg_date"); 
*/
	String no 		= dao.getNoticeNo();
	String title 	= ctl.getParameter("t_title"); 
	String content 	= ctl.getParameter("t_content"); 
	String reg_name = ctl.getParameter("t_reg_name"); 
	String reg_date = ctl.getParameter("t_reg_date"); 
//	String attach 	= ctl.getParameter("t_attach");
	String attach   = ctl.getFilesystemName("t_attach");	
System.out.println("==============="+attach);
	String dbAttachName  = "";
//	if(!attach.equals("")){
	if(attach !=null){
		
		File oldFile = new File(file_dir,attach);	
		File newFile = new File(file_dir,no+"-"+attach);  			
		oldFile.renameTo(newFile);
		dbAttachName = newFile.getName();	
	}
	
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
	alert("<%=msg%>");
	location.href="notice_list.jsp";
</script>
</head>
<body>

</body>
</html>