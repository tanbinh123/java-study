<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>index</title>
	<script>
		function goForm(){
			mem.method = "post"
			mem.action = "form_3.jsp";
			mem.submit();
		}
	</script>
</head>
<body>
	<form name = "member" method = "post" action="form_2.jsp">
	성명 : <input type="text" size="5" name="t_name"> <br> 
	지역 : <input type="text" size="5" name="t_area"> <br> 
	나이 : <input type="text" size="5" name="t_age"> <br>
	<input type = "submit" value="저장1">
	
	</form>
	<form name="mem">
	아이디 : <input type="text" size="5" name="t_id"> <br> 
	성명 : <input type="text" size="5" name="t_name"> <br> 
	비밀번호 : <input type="password" size="5" name="t_pw"> <br>
	<input type ="button" onclick="goForm()" value="저장2" >
	</form>
</body>
</html>