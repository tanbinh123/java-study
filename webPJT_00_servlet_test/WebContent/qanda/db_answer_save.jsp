<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*,common.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Qanda_dao dao = new Qanda_dao();
	
	String no 		= request.getParameter("t_no");
	String answer	= request.getParameter("t_answer");
	String reg_id   = request.getParameter("t_reg_id"); 
	String reg_date = CommonUtil.getToday(); 
	
	String work 	= request.getParameter("t_work_gubun");
	
	int result = dao.saveAnswer(no, answer, reg_id, reg_date);
	String msg="";
	if(result == 1) msg =" 답변 "+work+" 되었습니다. ";
	else msg=" 답변 "+work+" 실패~ ";
%>    
    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function goView(){
		alert("<%=msg%>");
		qna.method="post";
		qna.action="qanda_view.jsp";
		qna.submit();
		//location.href="qanda_view.jsp";
	}
</script>
</head>
<body onload="goView()">
<form name="qna">
	<input type="hidden" name="t_no" value="<%=no%>">
</form>
</body>
</html>


















