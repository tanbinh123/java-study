<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>
<%
	request.setCharacterEncoding("utf-8");
	News_dao dao = new News_dao();
	String gubun 	= request.getParameter("t_work_gubun"); 
	
	String title 	= request.getParameter("t_title"); 
	String content 	= request.getParameter("t_content"); 
	String s_date 	= request.getParameter("t_s_date"); 
	String e_date 	= request.getParameter("t_e_date"); 
	String reg_name = request.getParameter("t_reg_name"); 
	String reg_date = request.getParameter("t_reg_date"); 
	int result =0;
	String msg="";
	if(gubun.equals("insert")){
		String no 		= dao.getNewsNo();
		News_dto dto = new News_dto(no,title,content,reg_name,reg_date,0);
		result = dao.saveNews(dto);
		if(result == 1) msg =" 등록 되었습니다. ";
		else msg=" 등록 실패~ ";		
	} else if(gubun.equals("update")){
		String no = request.getParameter("t_no");
		News_dto dto = new News_dto(no,title,content,reg_name,reg_date,0);				
		result = dao.updateNews(dto);
		if(result == 1) msg =" 수정 되었습니다. ";
		else msg=" 수정 실패~ ";		
	} else if(gubun.equals("delete")){
		String no = request.getParameter("t_no");
		result = dao.deleteNews(no); 
		if(result == 1) msg =" 삭제 되었습니다. ";
		else msg=" 삭제 실패~ ";		
	}
%>        
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="news_list.jsp";
</script>
</head>
<body>

</body>
</html>




