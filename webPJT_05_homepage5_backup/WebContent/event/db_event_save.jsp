<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*,java.text.SimpleDateFormat,java.util.Date" %>
<%
	request.setCharacterEncoding("utf-8");
	Event_dao dao = new Event_dao();
	
	String no 		= dao.getEventNo();
	String title 	= request.getParameter("t_title"); 
	String content 	= request.getParameter("t_content"); 
	String s_date 	= request.getParameter("t_s_date"); 
	String e_date 	= request.getParameter("t_e_date"); 
	String reg_name = request.getParameter("t_reg_name"); 
	String reg_date = request.getParameter("t_reg_date"); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String msg="";
		
	/*	if(sdf.parse(s_date).before(sdf.parse(e_date)) || sdf.parse(s_date).equals(sdf.parse(e_date))){
			Event_dto dto = new Event_dto(no,title,content,s_date,e_date,reg_name,reg_date,0);
			int result = dao.saveEvent(dto);
			if(result == 1) msg =" 등록 되었습니다. ";
			else msg=" 등록 실패~ ";
		}else{
			msg = "시작일은 종료일보다 늦을 수 없습니다!";
		}*/
		
        
%>    
    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="event_list.jsp";
</script>
</head>
<body>

</body>
</html>