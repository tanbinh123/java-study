<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*"%>
<%
Notice_dao dao = new Notice_dao();
String no = request.getParameter("t_no");
dao.hitCount(no);
Notice_dto dto = dao.getNoticeView(no);
%>

<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>JSL 방문을 환영합니다</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link href="../css/font-awesome.min.css" rel="stylesheet"> -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
<link rel="stylesheet" type="text/css" href="../css/reset.css" />
<link rel="stylesheet" type="text/css" href="../css/base.css" /> 
<link rel="stylesheet" href="../css/menu.css" />
<link rel="stylesheet" href="../css/common.css" />
<link rel="stylesheet" href="../css/n_v.css" />
<script type="text/javascript" src="../js/jquery-1.8.1.min.js"></script>
<!--menu drop down-->
<script type="text/javascript">
	<%@ include file="../js/common.js"%>
  </script>
<script type="text/javascript">
function goUpdate(){
	updateForm.method = "post";
	updateForm.action = "notice_u.jsp";
	updateForm.submit();
}
function goDelete(){
	let yn = confirm('삭제하시겠습니까?');
	if(yn){
	updateForm.method = "post";
	updateForm.action = "db_delete.jsp";
	updateForm.submit();
	}
}
</script>
</head>
<body>
    <div id="container">
		<%@ include file="/rayout/header.jsp"%> <%@ includefile="/rayout/menu.jsp"%>
      <div id="content">
		<%@ include file="/rayout/content_home_btn.jsp"%>		
	<form name = "updateForm">
	<input type = "hidden" name = "t_no" value="<%=no%>">
	  <div class="bord_list">
		<table class="bord_table">
			<colgroup>
				<col width="10%">
				<col width="40%">
				<col width="10%">
				<col width="*">
			</colgroup>
			<tbody>
			
				<tr>
					<th>제 목</th>
					<td colspan="2"><%=dto.getTitle() %></td>
					<td><i class="fa fa-eye"> 조회수 : <%=dto.getHit()%></td>
				</tr>
				<tr>
					<th>내 용</th>
					<td colspan="3">
						<textarea class="board_textarea_H270_noBorder" readonly>
						<%=dto.getContent() %>						
						</textarea>
					</td>
				</tr>
				<tr>
					<th>등록자</th>
					<td><%=dto.getReg_name() %>	</td>
					<th>등록일</th>
					<td><%=dto.getReg_date() %>	</td>
				</tr>
			</tbody>
				
		</table>
		<div class="paging">
			<a href="notice_r.jsp" class="btn_write">목 록</a>
			<a href="javascript:goUpdate()" class="btn_write">수 정</a>
			<a href="javascript:goDelete()" class="btn_write">삭 제</a>
		</div>
	  </div>			
		</form>	
	</div>		
	<%@ include file="/rayout/footer.jsp"%>
    </div>
  </body>
</html>