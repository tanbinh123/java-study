<%@page import="dto.news_dto"%>
<%@page import="dao.news_dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% news_dao dao = new news_dao();
    String no = request.getParameter("t_no");
    news_dto dto = dao.getNewsView(no);
    %>
<!DOCTYPE html>
<html>
<head>
	<title>홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script>
	function goUpdate() {
		if(news.t_title.value ==""){
			alert("제목 입력 하시오~ ");
			news.t_title.focus();
			return;
		}
		if(news.t_content.value ==""){
			alert("내용 입력 하시오~ ");
			news.t_content.focus();
			return;
		}
		if(news.t_reg_name.value ==""){
			alert("등록자 입력 하시오~ ");
			news.t_reg_name.focus();
			return;
		}
		if(news.t_reg_date.value ==""){
			alert("등록일 입력 하시오~ ");
			news.t_reg_date.focus();
			return;
		}
		news.method ="post";
		news.action ="news_update.jsp";
		news.submit();
	}
	</script>
</head>
<body>
	<div class="container">
		<div class="leftmargin">
			<h1>성명 : 홍길동</h1>
		</div>		
		<div class="write_wrap">
		
			<div class="board_list">
				<form name="news">
				<input type="hidden" name="t_no" value="<%=no%>">
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
							<td class="th_left" colspan="3">
								<input name="t_title"  value="<%out.print(dto.getTitle()); %>" class="input_100Per" type="text">
							</td>
						</tr>
						<tr>
							<th>내 용</th>
							<td class="th_left" colspan="3">
								<textarea name="t_content"><%out.print(dto.getContent()); %></textarea>
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td class="th_left">
								<input name="t_reg_name" class="input_100px" type="text" value="<%out.print(dto.getReg_name()); %>">
							</td>
							<th>작성일</th>
							<td class="th_left">
								<input name="t_reg_date" class="input_150px" type="date" value="<%out.print(dto.getReg_date()); %>">
							</td>
						</tr>
					</tbody>
				</table>
				</form>
			</div>
			<div class="btn_wrap">
				<input type="button" onClick="history.back()" value="이전" class="btn_list">
				<input type="button" onClick="goUpdate()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>



















    