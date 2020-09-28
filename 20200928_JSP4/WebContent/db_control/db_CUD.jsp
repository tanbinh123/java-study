<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*"%>
<%
	request.setCharacterEncoding("utf-8");
	Board_dao dao = new Board_dao();
	
	//게시판 종류 받기
	String whoamiPage = request.getParameter("t_whoamiPage");
	//dao에 게시판 종류 넘기기
	dao.SetBoardGubun(whoamiPage);
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
		result = dao.BoardCUD("insert into h05_"+whoamiPage+" \r\n" + 
				"(no,title,content,attach,reg_name,reg_date,hit) \r\n" + 
				"values \r\n" + 
				"('"+no+"','"+title+"','"+content+"','"+attach+"','"+reg_name+"','"+reg_date+"',"+0+")");
	}else if(noGubun.equals("update")){
		result = dao.BoardCUD("update h05_"+whoamiPage+" set title = '"+title+"',content = '"+content+"',attach = '"+attach+"',reg_name = '"+reg_name+"',reg_date = '"+reg_date+"' where no = '"+no+"'");
	}else if(noGubun.equals("delete")){
		result = dao.BoardCUD("DELETE FROM h05_"+whoamiPage+" WHERE no = '"+no+"'");
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

<% if (whoamiPage.equals("notice")){%>
location.href="/component/notice/notice_list.jsp";
<% }else if(whoamiPage.equals("news")){;%>
location.href="/component/news/news_list.jsp";
<% }else if(whoamiPage.equals("freeboard")){;%>
location.href="/component/freeboard/freeboard_list.jsp";
<% }else if(whoamiPage.equals("qna")){;%>
location.href="/component/qna/qna_list.jsp";
<% }else if(whoamiPage.equals("etc")){;%>
location.href="/component/etc/etc_list.jsp";
<%}%>
</script>
</head>
<body>

</body>
</html>