<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String msg = (String) request.getAttribute("t_msg");
String url = (String) request.getAttribute("t_url");
String gubun = (String) request.getAttribute("t_gubun");
String no = (String) request.getAttribute("t_no");
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
</script>
</head>
<body>
	<%
		if (gubun != null) {
	%>
	<form name="gubun">
		<input type="hidden" name="t_gubun" value="<%=gubun%>">
		<input type="hidden" name="t_no" value="<%=no%>">
	</form>

	<script type="text/javascript">
		gubun.action="/Notice";
		gubun.method="post";
		gubun.submit();
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
			location.href="<%=url%>";
	</script>
	<%
		}
	%>



</body>
</html>