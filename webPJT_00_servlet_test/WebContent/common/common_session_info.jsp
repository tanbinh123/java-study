<%
	String session_name = (String)session.getAttribute("session_name");
	if(session_name == null) session_name ="";
	
	String session_id = (String)session.getAttribute("session_id");
	if(session_id == null) session_id ="";
	
	String session_level = (String)session.getAttribute("session_level");
	if(session_level == null) session_level ="";
%>