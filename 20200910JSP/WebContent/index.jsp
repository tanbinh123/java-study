<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>

<script>

    function goFrom(){
        mem.method = "post";
        mem.action = "form_3.jsp";
        mem.submit();
    }
</script>

</head>
<body>
    <form action="form_2.jsp" name="member" method="post">
        성명 : <input type="text" name="t_name" size="5"><br>
        지역 : <input type="text" name="t_area" size="5"><br>
        나이 : <input type="text" name="t_age" size="5"><br>
        <input type="submit" value="저장1">
    </form>

    <form name="mem">
        아이디 : <input type="text" name="t_id" size="5"><br>
        성명 : <input type="text" name="t_name" size="5"><br>
        비밀번호 : <input type="text" name="t_pw" size="5"><br>
        지역 : <select name="" id="">

                </select>
        <input type="submit" onclick="goForm()" value="저장2">
    </form>
</body>
</html>