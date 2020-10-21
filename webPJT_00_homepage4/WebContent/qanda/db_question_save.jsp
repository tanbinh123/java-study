<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*,common.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Qanda_dao dao = new Qanda_dao();
	
	String no 		= dao.getQandaNo();
	String title 	= request.getParameter("t_title"); 
	String content 	= request.getParameter("t_content"); 
	String reg_id   = request.getParameter("t_reg_id"); 
	String reg_date = Common.getToday(); 
	
	Qanda_dto dto = new Qanda_dto(no,title,content,reg_id,reg_date);
	int result = dao.saveQuestion(dto);
	String msg="";
	if(result == 1) msg =" 등록 되었습니다. ";
	else msg=" 등록 실패~ ";
%>    
    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="qanda_list.jsp";
</script>
</head>
<body>

</body>
</html>





