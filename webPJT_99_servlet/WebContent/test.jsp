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
	(el표현) test : ${t_test}<br>
	arr size : ${arr.size()}<br>
	arr index0 : ${arr[0]}<br>
	arr index1 : ${arr[1]}<br>
	arr index2 : ${arr[2]}<br>
	====================JSTL if===================<br>
	<c:if test ="${t_name == '홍길동'}">
		(jstl if) 홍길동이다111<br>
	</c:if>
	<c:if test ="${t_name eq '홍길동'}">
		(jstl if) 홍길동이다222<br>
	</c:if>
	<c:if test ="${t_age == 34 }">
		(jstl if) 34살이다<br>
	</c:if>
	<c:if test = "${t_age > 20 }">
		(jstl if) t_age가 20보다 크다.<br>
	</c:if>
	<c:if test ="${t_age > 20 && t_age < 50}">
		(jstl if) t_age가 20보다 크고 50보다 작다.111<br>
	</c:if>
	<c:if test ="${t_age > 20 and t_age < 50}">
		(jstl if) t_age가 20보다 크고 50보다 작다.222<br>
	</c:if>
	<c:if test ="${t_age > 20 || t_age < 23 }">
		(jstl if) t_age가 20보다 크거나 23보다 작을때<br>
	</c:if>
	<c:if test = "${t_age > 20 or t_name == '홍길동' }">
		(jstl if) t_age가 20보다 크거나 t_name이 홍길동일때<br>
	</c:if>
	<c:if test="${!empty t_name }">
		(jstl if) t_name이 공백이 아닐때 11<br>
	</c:if>
	<c:if test="${ t_name != null }">
		(jstl if) t_name이 공백이 아닐때 22<br>
	</c:if>
	====================JSTL choose===================<br>
	<c:choose>
		<c:when test="${t_age > 30}">
			30보다 크다 <br>
		</c:when>
		<c:when test="${t_age > 40 }">
			40보다 크다 <br>
		</c:when>
		<c:otherwise>
			다른것 <br>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${t_score > 90 }">
		수 <br>
		</c:when>
		<c:when test="${t_score > 80 }">
		우 <br>
		</c:when>
		<c:when test="${t_score > 70 }">
		미 <br>
		</c:when>
		<c:otherwise>
		양
		</c:otherwise>
		</c:choose>
		====================JSTL 반복===================<br>
		<table border="1">
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>내용</td>
					<td>등록자</td>
					<td>등록일</td>
					<td>조회수</td>
				</tr>
			<c:forEach items="${newsarr}" var="dtos">
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
	
	</body>
</html>