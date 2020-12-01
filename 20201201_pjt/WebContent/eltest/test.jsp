<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
(el표현) 성명 : ${t_name}<br>
(el표현) 나이 : ${t_age}<br>
(el표현) area : ${t_area}<br>

(el표현 arraylist) size : ${t_arr.size()}<br>
(el표현 arraylist) 첫번째 : ${t_arr[0]}<br>
(el표현 arraylist) 두번째 : ${t_arr[1]}<br>
(el표현 arraylist) 세번째 : ${t_arr[2]}<br>

(el표현 arraylist dtos) t_dtos size : ${t_dtos.size()}<br>
(el표현 arraylist dtos) 첫번째 : ${t_dtos[0].getNo()} ${t_dtos[0].getTitle()}<br>
<br>================JSTL=== if ==================<br>
<c:if test="${t_name =='홍길동'}">
	(jstl if) 홍길동이다111 <br>
</c:if>
<c:if test="${t_name eq '홍길동' }">
	(jstl if) 홍길동이다222 <br>
</c:if>
<c:if test="${t_age == 25}">
	(jstl if) 25살 이다 <br>
</c:if>
<c:if test="${t_age >= 20}">
	(jstl if) 20보다 크다<br>
</c:if>
<c:if test="${t_age > 20}">
	<c:if test="${t_age < 30}">
		(jstl if) 20보다 크고 30보다 작다 111<br>
	</c:if>
</c:if>
<c:if test="${t_age > 20 && t_age < 30}">
		(jstl if) 20보다 크고 30보다 작다 222<br>
</c:if>
<c:if test="${t_age > 20 and t_age < 30}">
		(jstl if) 20보다 크고 30보다 작다 333<br>
</c:if>
<c:if test="${t_age > 20 || t_age < 30}">
		(jstl if) 20보다 크거나 30보다 작다 444<br>	
</c:if>
<c:if test="${t_age > 20 or t_age < 30}">
		(jstl if) 20보다 크거나 30보다 작다 555<br>	
</c:if>
<c:if test="${t_age > 20 or t_name=='홍길동동동'}">
	(jstl if) 20보다 크거나 이름이 홍길동이면 666<br>
</c:if>
<c:if test="${t_area == null}">
	(jstl if) null 이다 11<br>
</c:if>
<c:if test="${t_area == ''}">
	(jstl if) null 이다 22<br>
</c:if>
<c:if test="${empty t_area}">
	(jstl if) 공백 이다<br>
</c:if>

<br>================JSTL=== choose ==================<br>
<c:choose>
	<c:when test="${t_age > 30}">30보다 크다<br></c:when>
	<c:when test="${t_age > 20}">20보다 크다<br></c:when>
	<c:otherwise>나머지 모두<br></c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${t_score >90 }">수<br></c:when>
	<c:when test="${t_score >85 }">우<br></c:when>
	<c:when test="${t_score >75 }">미<br></c:when>
	<c:otherwise>양</c:otherwise>
</c:choose>

<br>================JSTL=== 반복 ==================<br>
<table border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>내용</td>
		<td>등록자</td>
		<td>등록일</td>
		<td>조회수</td>
	</tr>
	<c:forEach items="${t_dtos}" var="dtos">
		<tr>
			<td>${dtos.getNo()}</td>
			<td>${dtos.getTitle()}</td>
			<td>${dtos.getContent()}</td>
			<td>${dtos.getReg_name()}</td>
			<td>${dtos.getReg_date()}</td>
			<td>${dtos.getHit()}</td>
		</tr>	
	</c:forEach>
	
</table>





<%
//	out.print("name : "+name+"<br>");
%>
</body>
</html>









