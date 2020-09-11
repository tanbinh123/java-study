<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>윤태희</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script type="text/javascript">
		function goSave() {
			if(news.t_title.value == ""){
				alert('제목을 입력하시오.');
				news.t_title.focus();
				return;
			}
			if(news.t_content.value == ""){
				alert('내용을 입력하시오.');
				news.t_content.focus();
				return;
			}
			if(news.t_reg_name.value == ""){
				alert('등록자를 입력하시오.');
				news.t_reg_name.focus();
				return;
			}
			if(news.t_reg_date.value == ""){
				alert('등록일을 입력하시오.');
				news.t_reg_date.focus();
				return;
			}
			news.method = "post";
			news.action = "news_save.jsp";
			news.submit();
		}
	</script>
</head>
<body>
	<div class="container">

		<div class="leftmargin">
			<h1>성명 : 홍길동</h1>
		</div>		
		<div class="write_wrap">
			<form name="news">
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
							<th>게시판 제목</th>
							<td class="th_left" colspan="3">
								<input name="t_title"  class="input_100Per" type="text"  required="required">
							</td>
						</tr>
						<tr>
							<th>내 용</th>
							<td class="th_left" colspan="3">
								<textarea name="t_content" class="board_textarea_H270"></textarea>
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
			
			<div class="btn_wrap">
				<input type="button" onclick="goSave()" value="저장" class="btn_ok">&nbsp;&nbsp;
				<input type="button" value="목록" onclick="history.back()" class="btn_list">
			</div>
			</form>
		</div>
	</div>
</body>
</html>








