<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*"%>
<%
	request.setCharacterEncoding("utf-8");
Event_dao dao = new Event_dao();

String select = request.getParameter("t_select");
String search = request.getParameter("t_search");
if (select == null) {
	select = "title";
	search = "";
} else if (search == null) {
	search = "";
}
ArrayList<Event_dto> arr = dao.getEventList(select, search);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>게시판</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<link href="../css/common.css" rel="stylesheet">
<link href="../css/layout.css" rel="stylesheet">
<style type="text/css">
td {
	text-align: center;
}

.title {
	text-align: left;
}
</style>
<script type="text/javascript">
	function search() {
		board.method = "post";
		board.action = "event_list.jsp";
		board.submit();
	}
	function goView(event_no) { //post방식으로 넘기기
		view.t_event_no.value = event_no;
		view.method = "post";
		view.action = "event_view.jsp";
		view.submit();
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
	<form name="view">
		<!-- post용 form -->
		<input type="hidden" name="t_event_no">
	</form>
	<div class="container">
	<a href="event_list.jsp"><img alt="logo" src="../img/logo.png" id="logo"></a>
		<div class="leftmargin">
			<h1>게시판</h1>
		</div>
		<div class="search_wrap">
			<div class="record_group">
				<p>
					총게시글 : <span><%=arr.size()%></span>건
				</p>
			</div>
			<form name="board">
				<div class="search_group">
					<select class="select" name="t_select">
						<option value="title"<%if (select.equals("title"))out.print("selected");%>>제목</option>
						<option value="content"<%if (select.equals("content"))out.print("selected");%>>내용</option>
					</select> <input type="text" class="search_word" name="t_search"value="<%=search%>">
					<button onclick="search()" class="btn_search">
						<i class="fa fa-search"></i><span class="sr-only">검색버튼</span>
					</button>
				</div>
			</form>
		</div>
	</div>
	<div class="board_list">
		<table class="board_table">
			<colgroup>
				<col width="8%">
				<col width="*">
				<col width="20%">
				<col width="10%">
				<col width="10%">
				<col width="8%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>기간</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>

				<%
					if (arr.size() != 0) {
					for (int i = 0; i < arr.size(); i++) {
				%>
				<tr>
					<!-- post방식 -->
					<td><a href="javascript:goView('<%=arr.get(i).getNo()%>')"><%=arr.get(i).getNo()%></a></td>
					<!-- get방식 -->
					<td class="title"><a
						href="event_view.jsp?t_event_no=<%=arr.get(i).getNo()%>"><%=arr.get(i).getTitle()%></a></td>
					<td><%=arr.get(i).getS_date()%> ~ <%=arr.get(i).getE_date()%></td>
					<td><%=arr.get(i).getReg_name()%></td>
					<td><%=arr.get(i).getReg_date()%></td>
					<td><%=arr.get(i).getHit()%></td>
				</tr>
				<%
					}
				} else {
				out.print("<tr>" + "<td>" + "내용없음" + "</td>" + "</tr>");
				}
				%>
			</thead>
			<tbody>


			</tbody>
		</table>
		<div class="paging">
			<a href="event_writeForm.jsp" class="write">글쓰기</a>
		</div>
	</div>
</body>
</html>







