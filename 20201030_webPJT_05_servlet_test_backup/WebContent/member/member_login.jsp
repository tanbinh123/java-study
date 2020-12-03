<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common_subpage_head.jsp"%>	
<script>
	function abc(){
		var keyCodeValue = event.keyCode;
		if(keyCodeValue ==13){
			frmLogin.t_pw.focus();
		}
	}
	function memberLogin(){
		
		if(!checkEmpty(frmLogin.t_id," ID 입력! ")) return;
		if(!checkEmpty(frmLogin.t_pw," 비밀번호 입력! ")) return;
		
/*		
		if(frmLogin.t_id.value==""){
			alert(" ID 입력! ");
			frmLogin.t_id.focus();
			return;
		}
		if(frmLogin.t_pw.value==""){
			alert(" 비밀번호 입력! ");
			frmLogin.t_pw.focus();
			return;
		}
*/		
		frmLogin.method ="post";
		frmLogin.action ="db_member_login.jsp";
		frmLogin.submit();
	}
</script>
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="member_login.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span>LOGIN</a></li>
				<li><a href="">ID / PASSWORD</a></li>
				<li><a href="member_join.jsp"> CONTACK</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER LOGIN
			</p>
		
			<div class="login">
				<div class="member_boxL">
					<h2>LOGIN</h2>
					<div class="login_form">
						<form name="frmLogin">
							<input type="hidden" name="t_gubun" value="login">
							<div class="fl_clear"><label for="mbrId">아이디</label>
								<input name="t_id" id="mbrId" type="text" onkeypress="abc()"></div>
							<div class="fl_clear"><label for="scrtNo">비밀번호</label>
								<input name="t_pw" id="scrtNo" type="password" onkeypress="if(event.keyCode==13){memberLogin()}"></div>
							<a class="btn_login btn_Blue" href="javascript:memberLogin()">로그인</a>
						</form>
					</div>
				   
				</div>		
			</div>

		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>	
	</div>	
</body>
</html>
    
    
    
    
    
    
    
    