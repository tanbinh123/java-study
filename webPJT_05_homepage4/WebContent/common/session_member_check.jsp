<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String loginGubun = (String)session.getAttribute("session_id");
	if(loginGubun == null) loginGubun ="";
	if(loginGubun.equals("")){
%>
	<script type="text/javascript">
		alert(" 로그인 후 사용가능 합니다. ");
		location.href ="/index.jsp";
	</script>
<%		
	}
%> 