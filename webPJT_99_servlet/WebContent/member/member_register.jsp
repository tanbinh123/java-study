<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common_head.jsp"%>

<style>
/*registerTable css*/
.registerTable {
	width: 600px;
	background: #fff;
	margin: 0 auto;
	padding: 20px;
}

.registerTable th {
	width: 20%;
	border-bottom: 1px solid #999;
	margin-bottom: 5px;
	padding: 5px 0px;
	background: #76b7c0;
	color: #fff;
}

.registerTable tr {
	margin-bottom: 20px;
}

.inputInfo {
	border-bottom: 1px solid #86ccda;
}

.registerTable td:not(.tdBtn) {
	padding: .8em .5em;
	height: 60px;
	font-size: 14px;
	text-align: left;
}

select {
	width: 40%;
	padding: .8em .5em;
	border: 1px solid #999;
}

.title {
	width: 40%;
	padding: .8em .5em;
	border: 1px solid #999;
	float: left;
}

.titleAddress {
	width: 100%;
	padding: .8em .5em;
	border: 1px solid #999;
	float: left;
}

.tel {
	width: 31%;
	padding: .8em .5em;
	border: 1px solid #999;
}

input:focus {
	outline: 1px gray solid
}

/*button css*/
.cosbtn {
	background: #76b7c0;
	color: #fff;
	border: none;
	position: relative;
	height: 40px;
	font-size: 1.3em;
	padding: 0 2em;
	cursor: pointer;
	transition: 800ms ease all;
	outline: none;
}

.cosbtn:hover {
	background: #fff;
	color: #76b7c0;
}

.cosbtn:before, .cosbtn:after {
	content: '';
	position: absolute;
	top: 0;
	right: 0;
	height: 2px;
	width: 0;
	background: #76b7c0;
	transition: 400ms ease all;
}

.cosbtn:after {
	right: inherit;
	top: inherit;
	left: 0;
	bottom: 0;
}

.cosbtn:hover:before, .cosbtn:hover:after {
	width: 100%;
	transition: 800ms ease all;
}

.btn2{
width: 70px;
height: 38px;
margin-left:10px;
}
</style>
<script>
	function goRegister() {
		if (register.t_id.value == "") {
			alert(" ID 입력! ");
			register.t_id.focus();
			return;
		} else if (register.t_name.value == "") {
			alert("성명 입력! ");
			register.t_name.focus();
			return;
		} else if (register.t_pw.value == "") {
			alert("비밀번호 입력! ");
			register.t_pw.focus();
			return;
		} else if (register.t_pw_confirm.value == "") {
			alert("비밀번호확인 입력! ");
			register.t_pw_confirm.focus();
			return;
		} else if (register.t_address.value == "") {
			alert("주소 입력! ");
			register.t_address.focus();
			return;
		} else if (register.t_tel_1.value == "") {
			alert("첫번째 연락처 입력! ");
			register.t_tel_1.focus();
			return;
		} else if (register.t_tel_2.value == "") {
			alert("두번째 연락처 입력! ");
			register.t_tel_2.focus();
			return;
		} else if (register.t_tel_3.value == "") {
			alert("세번째 연락처 입력! ");
			register.t_tel_3.focus();
			return;
		} else if (register.t_pw.value != register.t_pw_confirm.value) {
			alert("비밀번호를 확인 해주세요!");
			register.t_pw_confirm.focus();
			return;
		} else {
			register.method = "post";
			register.action = "/DBregister";
			register.submit();
		}
	}
</script>

<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){
	$("#idCheck").click(function(){
		var id = register.t_id.value;
		if(id==""){
			alert("ID 입력 후 검사!");
			register.t_id.focus();
			return;
		}
		
		$.ajax({
			type:"post",
			url:"/MemberIdCheck",
			data:"t_id="+id,
			dataType:"text",
			error:function(){
				alert("통신실패~");
			},
			success:function(data){
				alert("넘어온 값:===="+data+"====");
				$(".id_check_span").html(data);
				if($.trim(data) == "사용 가능"){
					$(".id_check_span").css("color","blue");
					register.id_check_gubun.value = id;
					register.t_name.focus();
				}else{
					$(".id_check_span").css("color","red");
					register.id_check_gubun.value = "";
					register.t_id.focus();
				}
			}
		});
		
		
		
	});
});
//]]>
</script>
<!--  header end -->


<!-- sub page start -->
<div class="notice">
	<div class="sub-notice">
		<h2>
			<span><i class="fas fa-edit"></i>Register</span>
		</h2>
	</div>

	<div class="notice-write">

		<form name="register">
			<!-- <h2 class="readonly">제목, 내용을 작성합니다</h2> -->

			<fieldset>
				<legend>회원가입</legend>

				<table class="registerTable">
					<caption>회원가입</caption>
					<colgroup>
						<col width="20%">
						<col width="*">
					</colgroup>

					<tr class="inputInfo">
						<th>아이디</th>
						<td><input type="text" name="t_id" id="id" class="title"
							placeholder="아이디를 입력해주세요">
							<input type="button" value="중복검사" class = "btn2" id="idCheck">
							<span id = "id_check_span"></span>
							<input type = "text" id="id_check_gubun">
							</td>
							
					</tr>
					<tr class="inputInfo">
						<th>이름</th>
						<td><input type="text" name="t_name" id="id" class="title"
							placeholder="이름을 입력해주세요"></td>
					</tr>
					<tr class="inputInfo">
						<th>비밀번호</th>
						<td><input type="password" name="t_pw" id="id" class="title"
							placeholder="비밀번호를 입력해주세요"></td>
					</tr>
					<tr class="inputInfo">
						<th>비밀번호 확인</th>
						<td><input type="password" name="t_pw_confirm" id="id"
							class="title" placeholder="비밀번호 재입력"></td>
					</tr>
					<tr class="inputInfo">
						<th>지역</th>
						<td><select name="t_area">
								<option value="01">서울</option>
								<option value="02">대전</option>
								<option value="03">부산</option>
								<option value="04">대구</option>
						</select></td>
					</tr>
					<tr class="inputInfo">
						<th>주소</th>
						<td><input type="text" name="t_address" id="id"
							class="titleAddress" placeholder="주소를 입력해주세요"></td>
					</tr>
					<tr class="inputInfo">
						<th>전화번호</th>
						<td><input name="t_tel_1" type="text" size="2" value="010"
							class="tel"> - <input name="t_tel_2" type="text" size="3"
							class="tel"> - <input name="t_tel_3" type="text" size="3"
							class="tel"></td>
					</tr>
					<tr class="inputInfo">
						<th>성별</th>
						<td><input type="radio" value="f" checked name="t_mf"
							class="middleCheck" /> 여&nbsp;&nbsp; <input type="radio"
							value="m" name="t_mf" class="middleCheck" /> 남</td>
					</tr>
					<tr class="inputInfo">
						<th>취미</th>
						<td><input type="checkbox" value="y" name="t_hobby_t"
							class="middleCheck" /> 여행&nbsp;&nbsp; <input type="checkbox"
							value="y" name="t_hobby_r" class="middleCheck" /> 독서&nbsp;&nbsp;
							<input type="checkbox" value="y" name="t_hobby_s"
							class="middleCheck" /> 운동</td>
					</tr>

					<tr>
						<td colspan="2" align='center' class="tdBtn"><br>
						<button type="button" onclick="goRegister()" 
						class="cosbtn"><span>Sign Up<span></button>
					<!--<input type="button" onclick="history.back();" value="뒤로" class="cosbtn">-->
						</td>
					</tr>

				</table>
			</fieldset>
		</form>
	</div>



	<!--  footer start  -->
	<div id="footer">
		<div class="footer-text">
			<ul class="sub-logo">
				<li><a href="index.html" alt="서브로고">JSL 인재개발원</a></li>
			</ul>

			<ul class="copy">
				<li>Copyright ⓒ EL WIDE. All Rights Reserved.</li>
			</ul>
		</div>
	</div>
</div>


<script>
	
</script>

</body>
</html>









