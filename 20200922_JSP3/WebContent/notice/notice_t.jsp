<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*"%>

<%
	request.setCharacterEncoding("utf-8");
Board_dao dao = new Board_dao();

String no = dao.getNoticeNo();
String title = request.getParameter("t_title");
String content = request.getParameter("t_content");
String attach = request.getParameter("t_attach");
String reg_name = request.getParameter("t_reg_name");
String reg_date = request.getParameter("t_reg_date");

if(attach == null){
	attach = "notting";
}
Board_dto dto = new Board_dto(no, title, content, attach, reg_name, reg_date,0);
int result = dao.noticeSave(dto);
%>


<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
<% if(result == 1){%>
alert('등록 완료');
<%}else{%>
alert('등록 실패');
<%}%>

location.href="notice_r.jsp";
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>