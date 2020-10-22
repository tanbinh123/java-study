<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>    
<%
	Member_dao dao = new Member_dao();
	String id = request.getParameter("t_id");
	int checkId = dao.idCheckCount(id);
 if(checkId == 0){ 
	out.print("사용 가능");
 } else{ 
	out.print("중복 ID");
 } %>

