<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>UIUX_홍길동_두번째</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
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
		<form name="news" method="post" action="">	
			<div class="search_wrap">
				<div class="record_group">
					<p>총게시글 : <span>211</span>건</p>
				</div>
				<div class="search_group">
					<select name="t_select" class="select">
						<option value="title" >제목</option>
						<option value="content"> 내용</option>
					</select>
					<input name="t_search" type="text" class="search_word">
					<button type="submit" class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
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
		
				<tr>
					<td>103</a></td>
					<td class="title">제목이다~~~</a></td>
					<td>홍길동</td>
					<td>2020-09-30</td>
					<td>12</td>
				</tr>					
				<tr>
					<td>102</a></td>
					<td class="title">제목이다~~~</a></td>
					<td>홍길동</td>
					<td>2020-09-30</td>
					<td>12</td>
				</tr>					
				<tr>
					<td>101</a></td>
					<td class="title">제목이다~~~</a></td>
					<td>홍길동</td>
					<td>2020-09-30</td>
					<td>12</td>
				</tr>					
			
			</tbody>
		</table>
		<div class="paging">
			<a href="board_write.html" class="write">글쓰기</a>
		</div>
	</div>
 </body>
</html>