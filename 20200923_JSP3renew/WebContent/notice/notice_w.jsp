<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" type="text/css" href="../css/reset.css" />
<link rel="stylesheet" type="text/css" href="../css/base.css" />
<link rel="stylesheet" href="../css/common.css" />
<link rel="stylesheet" href="../css/menu.css" />
<link rel="stylesheet" href="../css/n_w.css" />
<script type="text/javascript" src="../js/jquery-1.8.1.min.js"></script>
<!--menu drop down-->
<script type="text/javascript">
	
<%@ include file="../js/common.js"%>
	
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

		let yn = confirm('등록 하시겠습니까?');
		if (yn) {
			board.method = "post";
			board.action = "notice_t.jsp";
			board.submit();
		}
	}
</script>
</script>
</head>
<body>
	<div id="container">
		<%@ include file="header.jsp"%>
		<%@ include file="menu.jsp"%>
		<div id="content">
			<%@ include file="content_home_btn.jsp"%>
			<form name="board">
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
									maxlength="30" name="t_title" /></td>
							</tr>
							<tr>
								<th>내 용</th>
								<td colspan="3"><textarea name="t_content"
										class="board_textarea_H270"></textarea></td>
							</tr>
							<tr>
								<th>첨부파일</th>
								<td colspan="3"><input type="file" name="t_attach" /></td>
							</tr>
							<tr>
								<th>등록자</th>
								<td><input type="text" name="t_reg_name" /></td>
								<th>등록일</th>
								<td><input type="date" name="t_reg_date" /></td>
							</tr>
						</tbody>
					</table>
					<div class="paging">
						<a href="notice_r.jsp" class="btn_write">목 록</a> <a
							href="javascript:goSave()" class="btn_write">등 록</a>
					</div>
				</div>
			</form>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
