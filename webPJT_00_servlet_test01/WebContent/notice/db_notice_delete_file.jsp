<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,common.*,java.io.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Notice_dao dao 		= new Notice_dao();
	String no 			= request.getParameter("t_no");
	String del_attach 	= request.getParameter("t_attach");
	if(!del_attach.equals("")){
		File delFile = new File(Common.file_dir_notice,del_attach);
		delFile.delete();
	}
	int result = dao.deleteNotice(no);
	String msg="";
	if(result == 1) msg =" 삭제 되었습니다. ";
	else msg=" 삭제 실패~ ";			
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