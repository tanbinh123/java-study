<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
    request.setCharacterEncoding("UTF-8");

    String id = request.getParameter("t_id");
    String name = request.getParameter("t_name");
    String pw = request.getParameter("t_pw");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
    <%=id%>
    <%=name%>
    <%=pw%>
</body>
</html>