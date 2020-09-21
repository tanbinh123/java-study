<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*"%>

<%
	Event_dao dao = new Event_dao();
String no = request.getParameter("t_event_no");
dao.hitCount(no);
Event_dto dto = dao.getEventView(no);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>상세페이지</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<link href="../css/common.css" rel="stylesheet">
<link href="../css/layout.css" rel="stylesheet">
<script type="text/javascript">
	function goDelete(){
		let yn = confirm('삭제하시겠습니까?');
		if(yn){
		setNo.method = "post";
		setNo.action = "db_delete.jsp";
		setNo.submit();
		}
	}
</script>
<style type="text/css">
#logo{
	display: block; 
	margin: 0px auto;
	height: 150px;
}
</style>
</head>
<body>
<form name="setNo">
<input type="hidden" name="t_event_no" value="<%=no%>">
</form>
	<div class="container">
	<a href="event_list.jsp"><img alt="logo" src="../img/logo.png" id="logo"></a>
		<div class="leftmargin">
			<h1>상세페이지</h1>
		</div>
		<div class="write_wrap">

			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="10%">
						<col width="50%">
						<col width="10%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Event 제목</th>
							<td class="th_left"><%=dto.getTitle()%></td>

							<th>조회수</th>
							<td class="th_left"><%=dto.getHit()%></td>
						</tr>
						<tr>
							<th>Event 기간</th>
							<td class="th_left" colspan="3"><%=dto.getS_date()%> ~ <%=dto.getE_date()%>
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td class="th_left" colspan="3"><textarea name="t_contents"
									readonly="readonly"><%=dto.getContent()%></textarea></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td class="th_left"><%=dto.getReg_name()%></td>
							<th>작성일</th>
							<td class="th_left"><%=dto.getReg_date()%></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='event_list.jsp'"
					value="목록" class="btn_list"> <input type="button"
					onClick="location.href='event_updateForm.jsp?t_event_no=<%=dto.getNo()%>'"
					value="수정" class="btn_list"> 
					
					<input type="button" onClick="goDelete()"
					value="삭제" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>



















