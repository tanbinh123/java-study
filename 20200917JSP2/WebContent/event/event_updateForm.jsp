<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<title>홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script>
		function update(){
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
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="*">
					</colgroup>
					<form name="event">
					<input type="hidden" name="t_eventNo" >
					<tbody>
						<tr>
							<th>Event 제목</th>
							<td class="th_left">
								<input name="t_title" class="input_100Per" type="text">
							</td>
						</tr>
						<tr>
							<th>Event 기간</th>
							<td class="th_left">
								<input name="t_start_date"  class="input_100px" type="text">
								~
								<input name="t_end_date" class="input_100px" type="text">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td class="th_left">
								<textarea name="t_contents"></textarea>
							</td>
						</tr>
					</tbody>
					</form>
				</table>
			</div>
			<div class="btn_wrap">
				<input type="button" onClick="" value="목록" class="btn_list">
				<input type="button" onClick="" value="수정저장" class="btn_ok">&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>



















    