<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="dao.*,dto.*"%>
<%
	request.setCharacterEncoding("utf-8");
	Event_dao dao = new Event_dao();
	String no = request.getParameter("t_event_no");
	Event_dto dto = dao.getEventView(no);
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<title>홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >
		
			<script type="text/javascript">
				function goUpdate(){
					alert('aa');
					event.method ="post";
					alert('bb');
					event.action ="db_update.jsp";
					event.submit();
				}
		</script>

</head>
<body>
	<div class="container">
		<div class="leftmargin">
			<h1>성명 : 홍길동</h1>
		</div>		
		<div class="write_wrap">
		
			<div class="board_list">
			<form name="event">
			<div class = "eventForm">
			<input type="hidden" name="t_event_no" value="<%=no%>">
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
							<td class="th_left" colspan="3">
								<input name="t_title"  class="input_100Per" type="text" value="<%=dto.getTitle()%>">
							</td>
						</tr>
						<tr>
							<th>Event 기간</th>
							<td class="th_left" colspan="3">
								<input name="t_s_date"  class="input_150px" type="date" value="<%=dto.getS_date()%>">
								~
								<input name="t_e_date"  class="input_150px" type="date" value="<%=dto.getE_date()%>">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td class="th_left" colspan="3">
								<textarea name="t_content"><%=dto.getContent()%></textarea>
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td class="th_left">
								<input name="t_reg_name"  class="input_100px" type="text" value="<%=dto.getReg_name()%>">
							</td>
							<th>작성일</th>
							<td class="th_left">
								<input name="t_reg_date"  class="input_150px" type="date" value="<%=dto.getReg_date()%>">
							</td>
						</tr>
					</tbody>
				</table>
				</div>
				</form>
			</div>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='event_list.jsp'" value="목록" class="btn_list">
				<input type="button" onClick="goUpdate()" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>



















    