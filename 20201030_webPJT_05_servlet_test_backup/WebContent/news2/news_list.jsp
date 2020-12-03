<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.*, java.util.*" %>
<% 
String name = (String)request.getAttribute("t_name");
String area = (String)request.getAttribute("t_area");
ArrayList<News_dto> arr = (ArrayList<News_dto>)request.getAttribute("t_arr");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
성명 : <%=name %><br>
지역 : <%=area %>
-->
<%

	for(int i = 0 ; i < arr.size(); i++){
		out.print(arr.get(i).getNo()+"\t");
		out.print(arr.get(i).getTitle()+"\t");
		out.print(arr.get(i).getReg_name()+"\t");
		out.print(arr.get(i).getReg_date());
		out.print("<br>");
		
}
%>
</body>
</html>