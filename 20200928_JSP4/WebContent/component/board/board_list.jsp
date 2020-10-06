<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*"%>
<%
request.setCharacterEncoding("utf-8");
Board_dao dao = new Board_dao();
dao.SetBoardGubun(whoamiPage);

String sort = request.getParameter("t_sort");
String title = request.getParameter("sel_box");
String search = request.getParameter("sel_text");

if (title == null) {
	title = "title";
	search = "";
	sort = "no";
} else if (search == null) {
	search = "";
}
ArrayList<Board_dto> arr = dao.getBoardList(title, search, sort);
%> 
<html>
<head>
<link href="/css/sub_c.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
<%@include file="/js/main.js" %>
</script>
<script type="text/javascript">
function goView(t_no) { 
	view.t_no.value = t_no;
	view.method = "post";
	view.action = "/component/<%=whoamiPage%>/<%=whoamiPage%>_view.jsp";
	view.submit();
}
</script>
</head>
<body>
	<div id="container">
		<%@include file="/rayout/header.jsp" %>
		<%@include file="/rayout/nav.jsp" %>
		
		
		<div id="b_right">
			<p class="n_title">
				<%=whoamiPage.toUpperCase() %>
			</p>
			<p class="select_box">
				<select class="sel_box">
					<option>Title</option>
					<option>Content</option>
				</select>
				<input type="text" class="sel_text">

				<button type="submit" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>
			
			<table class="boardList">
				<colgroup>
					<col width="5%">
					<col width="60%">
					<col width="5%">
					<col width="10%">
					<col width="14%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Attach</th>
						<th>Reg Name</th>
						<th>Reg Date</th>
						<th>Hit</th>
					</tr>
				</thead>
				<form name="view">
				<input type="hidden" name="t_no" />
				<tbody>
				<%for(int i = 0; i < arr.size(); i++){ %>
					<tr>
						<td><%=arr.get(i).getNo()%></td>
						<td class="t_center"><a href="javascript:goView('<%=arr.get(i).getNo()%>')"><%=arr.get(i).getTitle() %></a></td>
						<td>
						<% if (arr.get(i).getAttach() != null){ %>
						<img src="/images/clip.png"></td>
						<%} %>
						<td><%=arr.get(i).getReg_name() %></td>
						<td><%=arr.get(i).getReg_date() %></td>
						<td><%=arr.get(i).getHit() %></td>
					</tr>
					<%} %>
				</tbody>
				</form>
			</table>
			
			<div class="paging">
				<a href=""><i class="fa fa-angle-double-left"></i></a>
				<a href=""><i class="fa fa-angle-left"></i></a>
				<a href="" class="active">1</a>
				<a href="">2</a>
				<a href="">3</a>
				<a href="">4</a>
				<a href="">5</a>
				<a href=""><i class="fa fa-angle-right"></i></a>
				<a href=""><i class="fa fa-angle-double-right"></i></a>
				<a href="/component/<%=whoamiPage %>/<%=whoamiPage %>_write.jsp" class="write">글쓰기</a>
			</div>
		</div>	
		<%@include file="/rayout/bottom.jsp" %>
	</div>	
</body>
</html>






