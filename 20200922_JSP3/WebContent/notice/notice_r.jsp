<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*"%>
<%
	request.setCharacterEncoding("utf-8");
Board_dao dao = new Board_dao();

String title = request.getParameter("sel_box");
String search = request.getParameter("sel_text");

if (title == null) {
	title = "title";
	search = "";
} else if (search == null) {
	search = "";
}
ArrayList<Board_dto> arr = dao.getNoticeList(title,search);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>JSL 방문을 환영합니다</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="../css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../css/reset.css" />
<link rel="stylesheet" type="text/css" href="../css/base.css" />
<link rel="stylesheet" type="text/css" href="../css/notice.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<script>
	$(function() {
		$(".menu1").mouseover(function() {
			$("#s_div_1").stop().slideDown("slow");
		});
		$(".menu1").mouseleave(function() {
			$("#s_div_1").stop().slideUp("slow");
		});
		$(".menu2").mouseover(function() {
			$("#s_div_2").stop().slideDown("slow");
		});
		$(".menu2").mouseleave(function() {
			$("#s_div_2").stop().slideUp("slow");
		});
		$(".menu3").mouseover(function() {
			$("#s_div_3").stop().slideDown("slow");
		});
		$(".menu3").mouseleave(function() {
			$("#s_div_3").stop().slideUp("slow");
		});
		$(".menu4").mouseover(function() {
			$("#s_div_4").stop().slideDown("slow");
		});
		$(".menu4").mouseleave(function() {
			$("#s_div_4").stop().slideUp("slow");
		});
		$(".menu5").mouseover(function() {
			$("#s_div_5").stop().slideDown("slow");
		});
		$(".menu5").mouseleave(function() {
			$("#s_div_5").stop().slideUp("slow");
		});

	});
</script>
<script type="text/javascript">
	function search() {

		searchForm.method = "get";
		searchForm.action = "notice_r.jsp";
		searchForm.submit();
	}

	function goView(no) {
		view.t_no.value = no;
		view.method = "post";
		view.action = "notice_v.jsp";
		view.submit();
	}
</script>
</head>
<body>
	<div id="container">
		<%@ include file="top_right.jsp"%>
		<%@ include file="header.jsp"%>
		<%@ include file="menu.jsp"%>

		<div id="content">
			<ul>
				<!-- <li class="btn_home"> -->
				<!-- <a href="index.html"><i class="fa fa-home btn_plus"></i></a> -->
				<!-- </li> -->
				<li class="btn_home"><a href="index.html"> <img
						src="../images/home3.png" class="home_icon">
				</a> &nbsp;HOME | &nbsp;커뮤니티 | NOTICE</li>
			</ul>
			<form name="searchForm">
				<p class="select_Box">
					<select class="sel_box" name="sel_box">
						<option value="title"
							<%if (title.equals("title"))out.print("selected");%>>제목</option>
						<option value="content"
							<%if (title.equals("content"))out.print("selected");%>>내용</option>
					</select> <input type="text" maxlength="20" class="sel_text"
						value="<%=search%>" name="sel_text" /> <input type="button"
						value="검&nbsp;&nbsp;색" class="sel_button" onclick="search()">
				</p>
			</form>

			<div class="bord_list">
				<table class="bord_table">
					<colgroup>
						<col width="10%">
						<col width="*">
						<col width="10%">
						<col width="15%">
						<col width="10%">
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
					<form name="view">
						<tbody>
							<%for(int i = 0 ; i < arr.size(); i++){%>
							<tr>
								<input type="hidden" name="t_no" />
								<td><%=arr.get(i).getNo()%></td>
								<td class="title"><a
									href="javascript:goView('<%=arr.get(i).getNo()%>')"><%=arr.get(i).getTitle()%></a></td>
								<td><%=arr.get(i).getReg_name()%></td>
								<td><%=arr.get(i).getReg_date()%></td>
								<td><%=arr.get(i).getHit()%></td>
							</tr>
							<%}%>
						</tbody>
					</form>
				</table>
				<div class="paging">
					<a href=""><i class="fa fa-angle-double-left"></i></a> <a href=""><i
						class="fa fa-angle-left"></i></a> <a href="" class="active">1</a> <a
						href="">2</a> <a href="">3</a> <a href="">4</a> <a href="">5</a> <a
						href=""><i class="fa fa-angle-right"></i></a> <a href=""><i
						class="fa fa-angle-double-right"></i></a> <a href="notice_w.jsp"
						class="btn_write">글쓰기</a>
				</div>
			</div>


		</div>

		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>