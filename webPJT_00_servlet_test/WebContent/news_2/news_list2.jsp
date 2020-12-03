<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,java.util.*" %>    
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
성 명 : <%=name%><br>
지 역 : <%=area%><br>
<%
	for(int k=0; k<arr.size(); k++){
		out.print(arr.get(k).getNo()+" ");
		out.print(arr.get(k).getTitle()+" ");
		out.print(arr.get(k).getReg_name()+" ");
		out.print(arr.get(k).getReg_date()+" ");
		out.print(arr.get(k).getHit()+" <br>");
			
	} %>
	
</body>
</html>





