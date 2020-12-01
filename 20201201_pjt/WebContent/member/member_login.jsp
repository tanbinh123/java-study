<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ include file="/common_head.jsp" %>  		
		<!--  header end -->
<script type="text/javascript">
	function loginCheck(){
		if(login.t_id.value ==""){
			alert("id 입력!");
			login.t_id.focus();
			return;
		}
		if(login.t_pw.value ==""){
			alert("pw 입력!");
			login.t_pw.focus();
			return;
		}
		login.action="/DBMemberLogin";
		login.method="post";
		login.submit();
	}
	function go_pw(){
		login.t_pw.focus();
	}
</script>		
<style>
/* login css */
.login-group {overflow:hidden; width:40%; margin:0 auto; background-color:#E6E6E6; padding:5% 3% 3% 3%;}
.sub-wrap .float-left {float:left; width:67%; margin-right:2%;}
.sub-wrap .float-right {float:right; width:31%; height:100px;}
.login-group .txt {width:100%; height:45px; line-height:45px;  border:1px solid #40547e; border-radius:3px; margin-bottom:10px; padding:0 10px;}
.login-group h2 {margin-bottom:30px; font-size:18px; font-weight:bold; color:#A4A4A4;}
.login-group .submit {width:95%; border-radius:3px;  color:white;background-color:#6DACB8; height:100px; border:0 none; cursor:pointer;}
.login-group p {color:#fff; clear:both;}
.login-group p.btn {margin-bottom:15px;}
.login-group p.btn a {display:inline-block; width:49%; height:45px; line-height:45px; text-align:center; color:#fff; background-color:#6DACB8;  border-radius:3px;}


</style>		
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
			<h2><span><i class="fas fa-edit"></i> MEMBER Login</span></h2>	
			</div>
			
			<div class="notice-write">
			
				
					<div class="sub-wrap">
						<div class="login-group">
							<h2>아이디/비밀번호로 로그인</h2>
							<form name="login" >
								<fieldset> <!-- 로그인이라는 필드셋의 묶음 -->
									<div class="float-left">
										<p>
										<label class="readonly">아이디</label>
										<input type="text" name="t_id" autofocus="autofocus" class="txt"  onkeypress="if(event.keyCode==13){go_pw()}" placeholder="아이디를 입력하세요">
										</p>
										<p>
										<label class="readonly">비밀번호</label>
										<input type="password" name="t_pw" class="txt" onkeypress="if(event.keyCode==13) {loginCheck()}" placeholder="비번호를 입력하세요">
										</p>
									</div>
									<div class="float-right">
										<p>
										<input type="button" value="로그인" class="submit" onClick="loginCheck()"> 
										</p> 
									</div>
									<p class="btn">
										<a href="/MemberPwFind">ID/PW 찾기</a>
										<a href="/MemberJoin">회원가입</a>
									</p>
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









    