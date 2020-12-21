<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg 		= (String)request.getAttribute("t_msg");
	String url 		= (String)request.getAttribute("t_url");
	String gubun 	= (String)request.getAttribute("t_gubun");
	String no 		= (String)request.getAttribute("t_no");
%>    
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<form name="urlForm">
		<input type="hidden" name="t_gubun" value="<%=gubun%>">
		<input type="hidden" name="t_no" value="<%=no%>">
	</form>
<%	if(gubun == null) {%>
	<script type="text/javascript">
		alert("<%=msg%>");
		location.href="<%=url%>";
	</script>		
<%	} else { %>	
	<script type="text/javascript">
		alert("<%=msg%>");
		urlForm.method="post";
		urlForm.action="<%=url%>";
		urlForm.submit();		
	</script>	
<%  } %>	
</body>
</html>








