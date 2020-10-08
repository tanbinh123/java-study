<%@page import="oracle.sql.CharacterSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*" %>
<%
	request.setCharacterEncoding("utf-8"); 
	Member_dao dao = new Member_dao();
	
	
	String id = request.getParameter("t_id");
	String name = request.getParameter("t_name");
	String pw = request.getParameter("t_pw");
	String area = request.getParameter("t_area");
	String adress = request.getParameter("t_adress");
	String tel_1 = request.getParameter("t_tel_1");
	String tel_2 = request.getParameter("t_tel_2");
	String tel_3 = request.getParameter("t_tel_3");
	String mf = request.getParameter("t_mf");
	String hobby_t = request.getParameter("t_hobby_t");
	String hobby_r = request.getParameter("t_hobby_r");
	String hobby_s = request.getParameter("t_hobby_s");
	String reg_date = Common.getToday();
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>