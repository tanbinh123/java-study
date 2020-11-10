<%
	String sessionName = (String)session.getAttribute("session_name");
	if(sessionName == null) sessionName ="";
	
	String sessionId = (String)session.getAttribute("session_id");
	if(sessionId == null) sessionId ="";
	
	String sessionLevel = (String)session.getAttribute("session_level");
	if(sessionLevel == null) sessionLevel ="";
%>