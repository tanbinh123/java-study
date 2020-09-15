<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>    
<%
	news_dao dao = new news_dao();
	String no = request.getParameter("t_no");
	dao.hitAdd(no);
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
		function goUpdateForm() {
			news.method="post";
			news.action="news_updateForm.jsp";
			news.submit();
		}
	</script>
</head>
<body>
	<form name="news">
		<input type="hidden" name="t_no" value="<%=no%>">
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
								<%=dto.getTitle()%>
							</td>
							<th>조회수</th>
							<td class="th_left" >
								<%=dto.getHit()%>
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td class="th_left" colspan="3">
								<textarea name="t_content" class="board_textarea_H270_noBorder" readonly><%=dto.getContent()%></textarea>
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td class="th_left">
								<%=dto.getReg_name()%>
							</td>
							<th>작성일</th>
							<td class="th_left">
								<%=dto.getReg_date()%>
							</td>
						</tr>						
					</tbody>
				</table>
			</div>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='news_list.jsp'" value="목록" class="btn_list">
				<input type="button" onClick="location.href='news_updateForm.jsp?t_no=<%=no%>'" value="수정GET" class="btn_list">
				<input type="button" onClick="goUpdateForm()" value="수정POST" class="btn_list">
				<input type="button" onClick="" value="삭제" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>



















    