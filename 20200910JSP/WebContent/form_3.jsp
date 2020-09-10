<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("t_id");
	String name = request.getParameter("t_name");
	String pw = request.getParameter("t_pw");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>결과 페이지</h1>
아이디 : <% out.print(id); %><br>
이름 : <%= name %><br>
비밀번호 : <%= pw %><br>
<input type="button" onclick="history.back()" value="뒤로">
</body>
</html>