<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
    request.setCharacterEncoding("UTF-8");

    String name = request.getParameter("t_name");
    String area = request.getParameter("t_area");
    String age = request.getParameter("t_age");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
    이름 : <%=name%><br>
    지역 : <%=area%><br>
    나이 : <%=age%><br>
    <input type="submit" value="뒤로" onclick="history.back()">
</body>
</html>