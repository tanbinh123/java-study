<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %> 
   
<%
	request.setCharacterEncoding("utf-8");
	Member_dao dao = new Member_dao();
	String id = request.getParameter("t_id");
	String pw = request.getParameter("t_pw");
	String name = dao.getLoginName(id, pw);
	String msg ="";
	if(name == null){
		msg =" ID나 비밀번호가 맞지 않습니다. ";
	} else {
		msg = name +"님 환영합니다. ";
		session.setAttribute("session_name",name);
		session.setAttribute("session_id",id);
		if(id.equals("manager")) {
			session.setAttribute("session_level","top");
		}
		session.setMaxInactiveInterval(60*60*1);
	}
//	out.print("============="+msg);
%>
    
<!DOCTYPE html>
<html>
<head>
<script>
	alert("<%=msg%>");
<%	if(name==null){ %>	
		location.href="member_login.jsp";
<%  } else { %>
		location.href="/index.jsp";
<%  }  %>	
</script>
</head>
<body>

</body>
</html>




