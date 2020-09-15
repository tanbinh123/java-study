<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");
	news_dao dao = new news_dao();

	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");
	
	if(select == null){
		select ="title";
		search ="";
	}
	ArrayList<news_dto> arr = dao.getNewsList(select, search);

%>
    
<!DOCTYPE html>
<html>
<head>
	<title>홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >
	<Script>
		function goSearch(){
			news.method ="post";
			news.action ="news_list.jsp";
			news.submit();
		}
	</Script>	
<style>	
	td{text-align:center;}
	.title{text-align:left;}
</style>	
</head>
<body>
	<div class="container">
		<div class="leftmargin">
			<h1>성명 : 홍길동</h1>
		</div>	
		<form name="news">	
			<div class="search_wrap">
				<div class="record_group">
					<p>총게시글 : <span><%=arr.size()%></span>건</p>
				</div>
				<div class="search_group">
					<select name="t_select" class="select">
						<option value="title" <% if(select.equals("title")) out.print("selected");%> >제목</option>
						<option value="content" <% if(select.equals("content")) out.print("selected");%>> 내용</option>
					</select>
					<input name="t_search" type="text" value="<%=search%>" class="search_word">
					<button type="submit" onclick="goSearch()" class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
				</div>
			</div>
		</form>
	</div>
	<div class="board_list">
		<table class="board_table">
			<colgroup>
				<col width="8%">
				<col width="*">
				<col width="20%">
				<col width="8%">
				<col width="10%">
				<col width="8%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
<%
			for(int k=0; k < arr.size(); k++){
%>			
				<tr>
					<td><a href="news_view.jsp?t_no=<%=arr.get(k).getNo()%>"><%=arr.get(k).getNo()%></a></td>
					<td class="title"><a href="news_view.jsp?t_no=<%=arr.get(k).getNo()%>"><%=arr.get(k).getTitle()%></a></td>
					<td><%=arr.get(k).getReg_name()%></td>
					<td><%=arr.get(k).getReg_date()%></td>
					<td><%=arr.get(k).getHit()%></td>
				</tr>					
<%
			}
			if(arr.size() == 0){
%>
				<tr>
					<td colspan="5">내용 없음.</td>
				</tr>
<%
			}
%>


			</tbody>
		</table>
		<div class="paging">
			<a href="news_writeForm.jsp" class="write">글쓰기</a>
		</div>
	</div>
 </body>
</html>







    