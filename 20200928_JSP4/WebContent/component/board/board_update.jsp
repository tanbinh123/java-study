<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*"%>
<%
	request.setCharacterEncoding("utf-8");
Board_dao dao = new Board_dao();
dao.SetBoardGubun(whoamiPage);
String no = request.getParameter("t_no");
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
	function goUpdate() {
		//alert('aa');
		if (board.t_title.value == "") {
			alert('제목을 입력하세요');
			board.t_title.focus();
			return;
		}
		if (board.t_content.value == "") {
			alert('내용을 입력하세요');
			board.t_content.focus();
			return;
		}
		if (board.t_reg_name.value == "") {
			alert('등록자를 입력하세요');
			board.t_reg_name.focus();
			return;
		}
		if (board.t_reg_date.value == "") {
			alert('등록일을 입력하세요');
			board.t_reg_date.focus();
			return;
		}

		let yn = confirm('수정 하시겠습니까?');
		if (yn) {
			board.method = "post";
			board.action = "/db_control/db_CUD.jsp";
			board.submit();
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
			<form name="board">
			<input type = "hidden" name = "t_no" value="<%=no%>">
			<input type="hidden" name="noGubun" value="update">
			<input type="hidden" name="t_whoamiPage" value="<%=whoamiPage%>">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3"><input type="text" class="input600" value="<%=dto.getTitle()%>" name="t_title"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea class="textArea_H250" name="t_content"><%=dto.getContent() %></textarea></td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3">구매안내.hwp 삭제<input type="checkbox"><br>
							<input type="file" class="input600" name="t_attach">
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><input type="text" value="<%=dto.getReg_name() %>" class="input100" name="t_reg_name"></td>
						<th>RegDate</th>
						<td><input type="date" value="<%=dto.getReg_date() %>" class="input130" name="t_reg_date"></td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				
				<a href="javascript:goUpdate()" class="butt">Save</a>
				<a href="/component/<%=whoamiPage%>/<%=whoamiPage%>_list.jsp" class="butt">List</a>
			</div>	
		</div>	
		<%@include file="/rayout/bottom.jsp" %>
	</div>	
</body>
</html>






