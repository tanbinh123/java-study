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
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<title>JSL 방문을 환영합니다</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- <link href="../css/font-awesome.min.css" rel="stylesheet"> -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css" href="/css/reset.css" />
<link rel="stylesheet" type="text/css" href="/css/base.css" />
<link rel="stylesheet" href="/css/common.css" />
<link rel="stylesheet" href="/css/menu.css" />
<link rel="stylesheet" href="/css/n_w.css" />
<script type="text/javascript" src="/js/jquery-1.8.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!--menu drop down-->
<script type="text/javascript">
	
<%@ include file="/js/common.js"%>
	
</script>

<script type="text/javascript">
	function goSave() {
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
			board.action = "/component/db_control/db_CUD.jsp";
			board.submit();
		}
	}
</script>
</head>
<body>
	<div id="container">
		<%@ include file="/component/rayout/header.jsp"%>
		<%@ include file="/component/rayout/menu.jsp"%>
		<div id="content">
			<%@ include file="/component/rayout/content_home_btn.jsp"%>
			<form name="board">
			<input type = "hidden" name = "t_no" value="<%=no%>">
			<input type="hidden" name="noGubun" value="update">
			<input type="hidden" name="t_whoamiPage" value="<%=whoamiPage%>">
				<div class="bord_list">
					<table class="bord_table">
						<colgroup>
							<col width="10%">
							<col width="40">
							<col width="10%">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
								<th>제 목</th>
								<td colspan="3"><input type="text" class="t_title"
									maxlength="30" name="t_title" value="<%=dto.getTitle() %>"/></td>
							</tr>
							<tr>
								<th>내 용</th>
								<td colspan="3"><textarea name="t_content"
										class="board_textarea_H270"><%=dto.getContent() %></textarea></td>
							</tr>
							<tr>
								<th>첨부파일</th>
								<td colspan="3"><input type="file" name="t_attach" value="<%=dto.getAttach() %>"/></td>
							</tr>
							<tr>
								<th>등록자</th>
								<td><input type="text" name="t_reg_name" value="<%=dto.getReg_name() %>"/></td>
								<th>등록일</th>
								<td><input type="date" name="t_reg_date" value="<%=dto.getReg_date() %>"/></td>
							</tr>
						</tbody>
					</table>
					<div class="paging">
						<a href="/component/<%=whoamiPage%>/<%=whoamiPage%>_r.jsp" class="btn_write">목 록</a> <a
							href="javascript:goSave()" class="btn_write">등 록</a>
					</div>
				</div>
			</form>
		</div>
		<%@ include file="/component/rayout/footer.jsp"%>
	</div>
</body>
</html>
