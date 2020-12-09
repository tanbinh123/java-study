<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*,common.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Qanda_dao dao = new Qanda_dao();
	
	String no 		= request.getParameter("t_no"); 
	String title 	= request.getParameter("t_title"); 
	String content 	= request.getParameter("t_content"); 
	String reg_id   = request.getParameter("t_reg_id"); 
	String reg_date = CommonUtil.getToday(); 
	
	Qanda_dto dto = new Qanda_dto(no,title,content,reg_id,reg_date);
	int result = dao.updateQuestion(dto);
	String msg="";
	if(result == 1) msg =" 질문 수정 되었습니다. ";
	else msg=" 질문 수정 실패~ ";
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





