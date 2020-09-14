<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.news_dao"%>
<%@page import="dto.news_dto"%>
<%@page import="java.util.ArrayList"%>
<% 
String no = request.getParameter("t_no");
request.setCharacterEncoding("utf-8");
news_dao newsDao = new news_dao();
ArrayList<news_dto> newsArr = new ArrayList<>(); 
newsArr = newsDao.getNewsList("view","t_no");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script>

	</script>
</head>
<body>
	<form name="news">
		<input type="hidden" name="t_no" value="<?=$no?>">
	</form>
	<div class="container">
	
		<div class="leftmargin">
			<h1>성명 : 홍길동</h1>
		</div>		
		<div class="write_wrap">
		
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="30%">
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>게시판 제목</th>
							<td class="th_left" >
								<%=newsArr.get(0).getTitle(); %>
							</td>
							<th>조회수</th>
							<td class="th_left" >
								1
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td class="th_left" colspan="3">
								<textarea name="t_content" class="board_textarea_H270_noBorder" readonly></textarea>
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td class="th_left">
								홍길동
							</td>
							<th>작성일</th>
							<td class="th_left">
								2020-09-09
							</td>
						</tr>						
					</tbody>
				</table>
			</div>
			<div class="btn_wrap">
				<input type="button" onClick="history.back()" value="목록" class="btn_list">
				<input type="button" onClick="" value="수정GET" class="btn_list">
				<input type="button" onClick="" value="수정POST" class="btn_list">
				<input type="button" onClick="" value="삭제" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>



















