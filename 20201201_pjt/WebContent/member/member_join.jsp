<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ include file="/common_head.jsp" %>  
<style>
	/*registerTable css*/
	.registerTable {
		width: 600px;
		background: #fff;
		margin: 0 auto;
		padding: 20px;
		border-top: 1px solid #86ccda;
	  
	}
	.registerTable th {
		width: 20%;
		border-bottom: 1px solid #999;
		margin-bottom: 5px;
		padding: 5px 0px;
		background: #76b7c0;
		color: #fff;
	}
	.registerTable tr{
		margin-bottom: 20px;
	}
	.inputInfo{
		border-bottom: 1px solid #86ccda;
	}
	.registerTable td:not(.tdBtn){
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
	
	.title{
		width: 40%;
		padding: .8em .5em; 
	    border: 1px solid #999;
	    float:left;
	}
	.titleAddress{
		width: 100%;
		padding: .8em .5em; 
	    border: 1px solid #999;
	    float:left;
	}
	.tel{
		width: 31%;
		padding: .8em .5em;
		border: 1px solid #999;
	}
	input:focus {
		outline:1px gray solid
	}
	.btn2{
		height:38px;
		width:70px;
		margin-left:5px;
	}
</style>
			
<!--  header end -->
<script type="text/javascript">
	function goRegister(){
		if(!checkEmpty(mem.t_id," ID 입력 하시오! ")) return;
		if(!checkEmpty(mem.id_check_gubun," ID 중복검사 하시오! ")) return;
		if(mem.id_check_gubun.value != mem.t_id.value){
			alert(" 변경된 ID 중복 검사 하시오~ ");
			return;
		}
		
		if(!checkEmpty(mem.t_name," 성명 입력! ")) return;

		if(mem.t_pw.value != mem.t_pw_confirm.value){
			alert("비밀번호 확인 오류~~");
			mem.t_pw_confirm.focus();
			return;
		}	
		mem.method="post";
		mem.action="DBMemberJoin";
		mem.submit();
	}

</script>
<script type="text/javascript">
//<![CDATA[
	$(document).ready(function(){
		$("#idCheck").click(function(){
			var id = mem.t_id.value;
			if(id==""){
				alert("ID 입력 후 검사!");
				mem.t_id.focus();
				return;
			}
			
			$.ajax({		
				type:"post",
				url:"/MemberIdCheck",
				data:"t_id="+id,
				dataType:"text",
				error :function(){
					alert("통신실패~");
				},
				success:function(data){
					//alert("넘어온 값:"+data);
					$(".id_check_span").html(data);
					if($.trim(data) =="사용가능"){
						$(".id_check_span").css("color","blue");
						mem.id_check_gubun.value = id;
						mem.t_name.focus();
					} else {
						$(".id_check_span").css("color","red");
						mem.id_check_gubun.value = "";
						mem.t_id.focus();
					}
					
				}
			});
			
		});		
	});
//]]>
</script>		

		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
			<h2><span><i class="fas fa-edit"></i> MEMBER Join</span></h2>	
			</div>
			
			<div class="notice-write">
			
			<form name="mem">
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
								<td>
									<input type="text" name="t_id" id="id" class="title" placeholder="아이디를 입력해주세요">
									<input type="button" id="idCheck" value="중복검사" class="btn2" >
									<span class="id_check_span"></span>
									<input type="hidden" name="id_check_gubun">
								</td>
							</tr>
							<tr class="inputInfo">
								<th>이름</th>
								<td><input type="text" name="t_name" id="id" class="title" placeholder="이름을 입력해주세요"></td>
							</tr>
							<tr class="inputInfo">
								<th>비밀번호</th>
								<td><input type="password" name="t_pw" id="id" class="title" placeholder="비밀번호를 입력해주세요"></td>
							</tr>
							<tr class="inputInfo">
								<th>비밀번호 확인</th>
								<td><input type="password" name="t_pw_confirm" id="id" class="title" placeholder="비밀번호를 다시 입력해주세요"></td>
							</tr>
							<tr class="inputInfo">
								<th>지역</th>
								<td>
								<select name="t_area">
									<option value="01">서울</option>
									<option value="02">대전</option>
									<option value="03">부산</option>
									<option value="04">대구</option>        
								</select>	  
								</td>
							</tr>
							<tr class="inputInfo">
								<th>주소</th>
								<td><input type="text" name="t_address" id="id" class="titleAddress" placeholder="주소를 입력해주세요"></td>
							</tr>
							<tr class="inputInfo">
								<th>전화번호</th>
								<td>
									<input name="t_tel_1" type="text" size="2" value="010" class="tel"> -
									<input name="t_tel_2" type="text" size="3" class="tel"> -
									<input name="t_tel_3" type="text" size="3" class="tel">
								</td>
							</tr>
							<tr class="inputInfo">
								<th>성별</th>
								<td>
									<input type="radio" value="f" checked name="t_mf" class="middleCheck" /> 여&nbsp;&nbsp;        
									<input type="radio" value="m" name="t_mf" class="middleCheck" /> 남 
								</td>
							</tr>
							<tr class="inputInfo">
								<th>취미</th>
								<td>
									<input type="checkbox" value="y" name="t_hobby_t" class="middleCheck" /> 여행&nbsp;&nbsp; 
								  	<input type="checkbox" value="y" name="t_hobby_r" class="middleCheck" /> 독서&nbsp;&nbsp; 
								 	 <input type="checkbox" value="y" name="t_hobby_s" class="middleCheck" /> 운동
								 </td>
							</tr>
							
							<tr>
								<td colspan="2" align='center' class="tdBtn">
								<input type="button" onclick="goRegister()" value="Sign Up" class="btn" >
								<!--<input type="button" onclick="history.back();" value="뒤로" class="btn">-->
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








    