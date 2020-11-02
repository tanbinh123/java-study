<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Notice_dao dao = new Notice_dao();
	
	String no 		= dao.getNoticeNo();
	String title 	= request.getParameter("t_title"); 
	String content 	= request.getParameter("t_content"); 
	String attach 	= request.getParameter("t_attach"); 
	String reg_name = request.getParameter("t_reg_name"); 
	String reg_date = request.getParameter("t_reg_date"); 
	
	Notice_dto dto = new Notice_dto(no,title,content,attach,reg_name,reg_date,0);
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