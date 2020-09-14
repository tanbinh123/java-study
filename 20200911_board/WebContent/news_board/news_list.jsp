<%@page import="javax.swing.border.TitledBorder"%>
<%@page import="dao.news_dao"%>
<%@page import="dto.news_dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
news_dao newsDao = new news_dao();
ArrayList<news_dto> newsArr = new ArrayList<>(); 

String select = request.getParameter("t_select");
String search = request.getParameter("t_search");
newsArr = newsDao.getNewsList("all","");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>윤태희</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
<style>	
	td{text-align:center;}
	.title{text-align:left;}
</style>	
<script type="text/javascript">
	function goSearch() {
		<% newsArr = newsDao.getNewsList("select","search");%>
		news.method = "post";
		news.action = "news_list.jsp";
		news.sumit();
	}
</script>
</head>
<body>
	<div class="container">
		<div class="leftmargin">
			<h1>성명 : 홍길동</h1>
		</div>	
		<form name="news">	
			<div class="search_wrap">
				<div class="record_group">
					<p>총게시글 : <span><%=newsArr.size() %></span>건</p>
				</div>
				<div class="search_group">
					
					<select name="t_select" class="select">
						<option value="title">제목</option>
						}
						<option value="content"> 내용</option>
					</select>
					
					<input name="t_search" type="text" value="<%=search %>" class="search_word">
					
					
					<button type="submit" class="btn_search" onclick="goSearch()">
						<i class="fa fa-search">
						</i>
						<span class="sr-only">검색버튼</span>
					</button>
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
				if(newsArr.size() != 0){
				for(int i=0; i<newsArr.size();i++){%>
				<tr>
					<td><a href="news_view.jsp?t_no=<%out.print(newsArr.get(i).getNo()); %>"><%out.print(newsArr.get(i).getNo()); %></a></td>
					<td class="title"><a href="news_view.jsp?t_no=<%out.print(newsArr.get(i).getNo()); %>"><%out.print(newsArr.get(i).getTitle());%></a></td>
					<td><%out.print(newsArr.get(i).getReg_name()); %></td>
					<td><%out.print(newsArr.get(i).getReg_date()); %></td>
					<td><%out.print(newsArr.get(i).getHit());%></td>
				</tr>					
				<%} }
				
				else{
				out.print("<tr><td>내용 없음</td></tr>");
				}%>		
			
			</tbody>
		</table>
		<div class="paging">
			<a href="news_write.jsp" class="write">글쓰기</a>
		</div>
	</div>
 </body>
</html>