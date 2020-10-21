<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, common.*,java.io.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Notice_dao dao = new Notice_dao();
	String msg="";
	String no     = request.getParameter("t_no");
	String attach = request.getParameter("t_attach");
	String file_dir = CommonUtil.attach_dir_notice;
	
	if(attach != null){
		File dFa = new File(file_dir, attach);
		dFa.delete();
	}		
	
	int result = dao.deleteNotice(no); 
	if(result == 1) msg =" 삭제 되었습니다. ";
	else msg=" 삭제 실패~ ";		

%>        
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
//	location.href="notice_list.jsp";
</script>
</head>
<body>

</body>
</html>




