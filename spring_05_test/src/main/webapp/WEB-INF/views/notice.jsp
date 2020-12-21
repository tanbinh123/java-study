<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page import = "dto.*"%>
<%	String name = (String)request.getAttribute("t_name");
	String age = (String)request.getAttribute("t_age");
	News_dto dto = (News_dto)request.getAttribute("t_dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>반갑읍니다 ^^ Hello</h1>
	성명 : <%=name %><br>
	나이 : <%=age %><br>
	el표현 성명 : ${t_name}<br>
	el표현 나이 : ${t_age}<br>
	
	dto 제목 : <%=dto.getTitle() %><br>
	el표현 dto 제목 : ${t_dto.getTitle()} <br>
</body>
</html>