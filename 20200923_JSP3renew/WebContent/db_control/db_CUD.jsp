<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*"%>
<%
	request.setCharacterEncoding("utf-8");
	Board_dao dao = new Board_dao();
	
	//게시판 종류 받기
	String boardGubun = request.getParameter("boardGubun");
	//dao에 게시판 종류 넘기기
	dao.SetBoardGubun(boardGubun);
	//번호 생성 or CUD 종류 받기
	String noGubun = request.getParameter("noGubun");
	String no = "";
	int result = 0;
	
	if(noGubun.equals("save")){
		no = dao.getBoardNo();
	}else{
		no = request.getParameter("t_no");
	}
	String title = request.getParameter("t_title");
	String content = request.getParameter("t_content");
	String attach = request.getParameter("t_attach");
	String reg_name = request.getParameter("t_reg_name");
	String reg_date = request.getParameter("t_reg_date");
	
	
	if(noGubun.equals("save")){
		result = dao.BoardCUD("insert into h05_"+boardGubun+" \r\n" + 
				"(no,title,content,attach,reg_name,reg_date,hit) \r\n" + 
				"values \r\n" + 
				"('"+no+"','"+title+"','"+content+"','"+attach+"','"+reg_name+"','"+reg_date+"',"+0+")");
	}else if(noGubun.equals("update")){
		result = dao.BoardCUD("update h05_"+boardGubun+" set title = '"+title+"',content = '"+content+"',attach = '"+attach+"',reg_name = '"+reg_name+"',reg_date = '"+reg_date+"' where no = '"+no+"'");
	}else if(noGubun.equals("delete")){
		result = dao.BoardCUD("DELETE FROM h05_"+boardGubun+" WHERE no = '"+no+"'");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>db_CUD</title>

<script type="text/javascript">
<% if(result == 1){%>
alert('<%=noGubun%> 완료');
<%}else{%>
alert('<%=noGubun%> 실패');
<%}%>

<% if (boardGubun.equals("Notice")){%>
location.href="/notice/notice_r.jsp";
<% }else if(boardGubun.equals("News")){;%>
location.href="/news/news_r.jsp";
<%}%>
</script>
</head>
<body>

</body>
</html>