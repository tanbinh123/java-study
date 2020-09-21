<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>글쓰기</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
<link href="../css/common.css" rel="stylesheet">
<link href="../css/layout.css" rel="stylesheet" >	
<script type="text/javascript">
	function goSave(){
		if(board.t_title.value ==""){
			alert("제목 입력! ");
			board.t_title.focus();
			return;
		}
		if(board.t_s_date.value ==""){
			alert("시작일 입력! ");
			board.t_s_date.focus();
			return;
		}
		if(board.t_e_date.value ==""){
			alert("종료일 입력! ");
			board.t_e_date.focus();
			return;
		}
		if(board.t_content.value ==""){
			alert("내용 입력! ");
			board.t_content.focus();
			return;
		}		
		if(board.t_reg_name.value ==""){
			alert("작성자 입력! ");
			board.t_reg_name.focus();
			return;
		}
		if(board.t_reg_date.value ==""){
			alert("등록일 입력! ");
			board.t_reg_date.focus();
			return;
		}
		board.method ="post";
		board.action ="db_save.jsp";
		board.submit();
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
	<div class="container">
	<a href="event_list.jsp"><img alt="logo" src="../img/logo.png" id="logo"></a>
		<div class="leftmargin">
			<h1>글쓰기</h1>
		</div>		
		<div class="write_wrap">
			<form name="board">
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="30%">
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Event 제목</th>
							<td class="th_left" colspan="3">
								<input name="t_title"  class="input_100Per" type="text">
							</td>
						</tr>
						<tr>
							<th>Event 기간</th>
							<td class="th_left" colspan="3">
								<input name="t_s_date"  class="input_150px" type="date">
								~
								<input name="t_e_date"  class="input_150px" type="date">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td class="th_left" colspan="3">
								<textarea name="t_content"></textarea>
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td class="th_left">
								<input name="t_reg_name"  class="input_100px" type="text">
							</td>
							<th>작성일</th>
							<td class="th_left">
								<input name="t_reg_date"  class="input_150px" type="date">
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			</form>
			<div class="btn_wrap">
				<!--  <a href="javascript:goSave()">등록</a>-->
				<input type="button" onclick="goSave()" value="저장" class="btn_ok">&nbsp;&nbsp;
				<input type="button" onclick="history.back()" value="목록" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>



















    