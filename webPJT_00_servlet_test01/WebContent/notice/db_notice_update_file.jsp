<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*"%>
<%@ page import="com.oreilly.servlet.*, java.io.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Notice_dao dao = new Notice_dao();
	
	//String file_dir ="C:/Users/JSLHRD/Desktop/jsl43_홍길동/eclipse_source/webPJT_00_homepage4/WebContent/file_room/notice/";
	String file_dir = Common.file_dir_notice;
	int sizeLimit = 1024 * 1024 * 10;
	MultipartRequest mpr = new MultipartRequest(request,file_dir,sizeLimit,"utf-8");
	
	String no 		= mpr.getParameter("t_no"); 
	String title 	= mpr.getParameter("t_title"); 
	String content 	= mpr.getParameter("t_content"); 
	String reg_name = mpr.getParameter("t_reg_name"); 
	String reg_date = mpr.getParameter("t_reg_date"); 	

	String del_attach = mpr.getParameter("t_del_attach");
	String dbAttachName =""; 
	boolean delYN = true;
	if(del_attach != null){
		File delFile = new File(file_dir,del_attach);
		delFile.delete();
		delYN = false;
	} else {
		dbAttachName = mpr.getParameter("t_ori_attach");
	}

	String attach 	= mpr.getFilesystemName("t_attach"); // aaa.hwp
	if(attach != null){
		String df = mpr.getParameter("t_ori_attach");
		if(!df.equals("") && delYN==true){
			File delFile = new File(file_dir,df);
			delFile.delete();	
		}
		File oldFile = new File(file_dir,attach);
		File newFile = new File(file_dir, no+"-"+attach); //N025-aaa.hwp
		oldFile.renameTo(newFile);
		dbAttachName = newFile.getName();
	}	
	
	String msg="";
	Notice_dto dto = new Notice_dto(no,title,content,dbAttachName,reg_name,reg_date,0);				
	int result = dao.updateNotice(dto);
	if(result == 1) msg =" 수정 되었습니다. ";
	else msg=" 수정 실패~ ";			
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