<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ include file="/common_head.jsp" %>  		
		<!--  header end -->
<script type="text/javascript">
	function loginCheck(){
		if(id_find.t_id.value ==""){
			alert("id 입력!");
			id_find.t_id.focus();
			return;
		}
		if(!checkEmpty(id_find.t_tel_1," 첫번째 번호 입력!")) return;
		if(!checkEmpty(id_find.t_tel_2," 두번째 번호 입력!")) return;
		if(!checkEmpty(id_find.t_tel_3," 세번째 번호 입력!")) return;
		if(!checkEmpty(id_find.t_mail_1," 이메일  입력!")) return;
		if(!checkEmpty(id_find.t_mail_input," 이메일 입력!")) return;
		
		id_find.action="/DBFindPassword";
		id_find.method="post";
		id_find.submit();
	}
	function go_tel(){
		id_find.t_tel_2.focus();
	}
	function domainCheck() {
		//  var frm = document.id_find;
		  if (id_find.t_email_2.value == 1) {
			  id_find.t_mail_input.value = "naver.com";
			  
		  } else if(id_find.t_email_2.value == 2) {
			  id_find.t_mail_input.value = "nate.com";
			  
		  }else if(id_find.t_email_2.value == 3) {
			  id_find.t_mail_input.value = "gmail.com";
			  
		  }else if(id_find.t_email_2.value == 4) {
			  id_find.t_mail_input.value = "yahoo.com";
			  
		  }else if(id_find.t_email_2.value == 5) {
			  id_find.t_mail_input.value = "";
			  id_find.t_mail_input.focus();
		  }
	}
</script>		
<style>
/* find css */
.login-group {overflow:hidden; width:50%; margin:0 auto; background-color:#E6E6E6; padding:5% 3% 3% 3%;}
.sub-wrap .float-left {float:left; width:67%; margin-right:2%;}
.sub-wrap .float-left-pw {float:left; width:67%; margin-right:2%; padding-top:}
.sub-wrap .float-right {float:right; width:31%; height:200px;}
.login-group .txt {width:99%; height:45px; line-height:45px;  border:1px solid #40547e; border-radius:3px; margin-bottom:10px; padding:0 10px;}
.login-group h2 {margin-bottom:30px; font-size:18px; font-weight:bold; color:#A4A4A4;}
.login-group .submit {width:80%; border-radius:3px;  color:white; background-color:#6DACB8; height:156px; border:0 none; cursor:pointer;}
.login-group p {color:#gray; clear:both;}
.login-group p.btn {margin-bottom:15px;}
.login-group p.btn a {display:inline-block; width:49%; height:45px; line-height:45px; text-align:center; color:#fff; background-color:#6DACB8;  border-radius:3px;}
	.login-group .tel{
		width: 30%;
		height:45px;
		padding: .8em .8em;
		text-align:center;
		margin:1px 2px 10px 1px;	
		border:1px solid #40547e;
		border-radius:3px;
	}
	.login-group .tel_1{
		width: 29%; 
		height:45px;
		padding: .8em .8em;
		text-align:center;
		margin:1px 3px 10px 1px;	
		border:1px solid #40547e;
		border-radius:3px;
	}
	.login-group .mail{
		width:31%;
		height:45px;
		padding: 1px 3px;
		border:1px solid #40547e;
		border-radius:3px;
	}

</style>		
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
			<h2><span><i class="fas fa-edit"></i> MEMBER Find</span></h2>	
			</div>
			
			<div class="notice-write">
			
				
					<div class="sub-wrap">
						<div class="login-group">
							<h2>아이디/비밀번호 찾기</h2>
							<form name="id_find" >
								<fieldset> <!-- 로그인이라는 필드셋의 묶음 -->
									<div class="float-left">
										<p>
											<label class="readonly">아이디</label>
											<input type="text" name="t_id" autofocus class="txt"  onkeypress="if(event.keyCode==13){go_tel()}" placeholder="아이디 입력">
										</p>
										<p>
											<label class="readonly">전화번호</label>
												<input type="text" name="t_tel_1" class="tel_1" onkeypress="if(event.keyCode==13) {loginCheck()}" value="010">-
												<input type="text" name="t_tel_2" class="tel" onkeypress="if(event.keyCode==13) {loginCheck()}" placeholder="전화번호">-
												<input type="text" name="t_tel_3" class="tel" onkeypress="if(event.keyCode==13) {loginCheck()}" placeholder="전화번호">
										</p>
										<p>
											<label class="readonly">이메일</label>
											<input type="text" name="t_mail_1" class="mail" onkeypress="if(event.keyCode==13) {loginCheck()}" placeholder="이메일 입력">
											@
											<input type="text" name="t_mail_input" class="mail" onkeypress="if(event.keyCode==13) {loginCheck()}" placeholder="직접 입력">
											<select name="t_email_2" onchange="domainCheck();" style="width:27%;height:45px;border-radius:3px;margin-left:7px;">
												<option value="1">naver.com</option>
												<option value="2">nate.com</option>
												<option value="3">gmail.com</option>    
												<option value="4">yahoo.com</option>    
												<option value="5" selected>직접 입력</option>    
											</select>
										</p>
									</div>
									<div class="float-right">
										<p>
										<input type="button" value="아이디/비번 찾기" class="submit" onClick="loginCheck()"> 
										</p> 
									</div>

								</fieldset>
							</form>
						</div>						
					</div>
				
			

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

	</body>
</html>









    