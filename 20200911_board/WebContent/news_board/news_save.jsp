<%@page import="dao.news_dao"%>
<%@page import="dto.news_dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	news_dao newsDao = new news_dao();
	ArrayList<news_dto> newsArr = new ArrayList<>(); 
	
%>
<%
	String no="";
	
	newsArr = newsDao.getNewsList("all", "");
	if (newsArr.size() == 0) {
		no = "N001";
	} else {
		no = newsDao.selectDBNo();
		no = newsDao.getNo(no);
	}
	
	String title = request.getParameter("t_title");
	String content = request.getParameter("t_content");
	String reg_name = request.getParameter("t_reg_name");
	String reg_date = request.getParameter("t_reg_date");
	
	int result = newsDao.saveNews(no, title, content, reg_name, reg_date);
	out.print("result : " + result);
	//out.print(title+"<br>"+content+"<br>"+reg_name+"<br>"+reg_date+"<br>");
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
<% if (result == 1){%>
alert('등록 성공~');
<% }else{ %>
alert('실패~');
<% } %>

location.href = "news_list.jsp";

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>