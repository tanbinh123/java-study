<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*"%>
<%
	request.setCharacterEncoding("utf-8");
	Notice_dao dao = new Notice_dao();
	String no = request.getParameter("t_no");
	int result = dao.deleteNotice(no);
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
<%	if(result ==1) {%>
	alert(" 삭제 되었습니다. ");
<% } else {%>
	alert(" 삭제 실패~ 관리자에게 문의 하세요 ");
<% } %>
	location.href="/notice/notice_r.jsp";
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>