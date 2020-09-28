<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*"%>
<%
	Board_dao dao = new Board_dao();
dao.SetBoardGubun(whoamiPage);
String no = request.getParameter("t_no");
dao.hitCount(no);
Board_dto dto = dao.getBoardView(no);
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
function goUpdate(){
	updateForm.method = "post";
	updateForm.action = "/component/<%=whoamiPage%>/<%=whoamiPage%>_update.jsp";
	updateForm.submit();
}
function goDelete(){
	let yn = confirm('삭제하시겠습니까?');
	if(yn){
	updateForm.method = "post";
	updateForm.action = "/db_control/db_CUD.jsp";
	updateForm.submit();
	}
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
				<form name = "updateForm">
			<input type = "hidden" name = "t_no" value="<%=no%>">
			<input type="hidden" name="noGubun" value="delete">
			<input type="hidden" name="t_whoamiPage" value="<%=whoamiPage%>">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="55%">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="2"><%=dto.getTitle() %></td>
						<td> <i class="far fa-eye"></i> <%=dto.getHit() %></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly><%=dto.getContent() %></textarea>
						</td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3"><%=dto.getAttach() %></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=dto.getReg_name() %></td>
						<th>RegDate</th>
						<td><%=dto.getReg_date() %></td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goDelete()" class="butt">Delete</a>
				<a href="javascript:goUpdate()" class="butt">Update</a>
				<a href="/component/<%=whoamiPage%>/<%=whoamiPage%>_list.jsp" class="butt">List</a>
			</div>	
		</div>	
		<%@include file="/rayout/bottom.jsp" %>
	</div>	
</body>
</html>






