<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
<link href="/css/sub_c.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
<%@include file="/js/main.js" %>
</script> 
<script type="text/javascript">
function checkEmpty() {
	
}


if(!checkEmpty(mem.t_id,"ID 입력 ! "))return;

</script>
</head>
<body>
	<div id="container">
<%@include file="/rayout/header.jsp" %>
	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="member_login.html">LOGIN</a></li>
				<li><a href="">ID / PASSWORD</a></li>
				<li><a href="member_join.html"><span class="fnt"><i class="fas fa-apple-alt"></i></span> CONTACK</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER JOIN
			</p>
			<form action="mem">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>
					<input name="t_id" type="text" size="10" id="id" title="id입력하세요">
					<input type="button" onclick="checkId()" value="ID중복검사" class="checkB">
				  </td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td><input type="text" size="8" id="nana"></td>
				</tr>
				<tr>
				  <th>비빌번호</th>
				  <td><input type="text" size="13"></td>
				</tr>
				<tr>
				  <th>비밀번호확인</th>
				  <td><input type="text" size="13"></td>
				</tr>
				<tr>
				  <th>지역</th>
				  <td>
					<select>
						<option value="">서울</option>
						<option value="">대전</option>
						<option value="">부산</option>
						<option value="">대구</option>        
					</select>	  
				  </td>
				</tr>	
				
				<tr>
				  <th>주소</th>
				  <td><input type="text" size="40"></td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					<input type="text" size="2"> -
					<input type="text" size="3"> -
					<input type="text" size="3">
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					  <input type="radio" value="y" name="receive" class="middleCheck" /> 여&nbsp;&nbsp;        
					  <input type="radio" value="y" name="receive" class="middleCheck" /> 남        
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <input type="checkbox" value="" name="chk1" class="middleCheck" /> 여행&nbsp;&nbsp; 
					  <input type="checkbox" value="" name="chk2" class="middleCheck" /> 독서&nbsp;&nbsp; 
					  <input type="checkbox" value="" name="chk3" class="middleCheck" /> 운동
				  </td>
				</tr>
			  </tbody>
			</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:checkEmpty()" class="butt">JOIN</a>
			</div>	
		</div>	

		<%@include file="/rayout/bottom.jsp" %>
	</div>	
</body>
</html>






