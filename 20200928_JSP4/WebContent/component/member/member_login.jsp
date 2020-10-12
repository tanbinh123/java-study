<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
<link href="/css/sub_c.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
    //<![CDATA[
    $(function(){
    	$(".main_menu > li > a").mouseover(function(){
			$(".main_menu li div").hide();
			$(this).next().slideDown(500);
    	});    
    	$(".main_menu").mouseleave(function(){
			$(".main_menu li div").stop().slideUp(500);
		}) 
    });     
    //]]>
</script> 


<script type="text/javascript">
function abc() {
	var keyCodeValue = event.keyCode;
	alert(keyCodeValue);
	if(keyCodeValue == 13){
		frmLogin.t_pw.focus();
	}
}
</script>

<script type="text/javascript">
function memberLogin() {
	frmLogin.method = "post";
	frmLogin.action = "/db_control/db_member.jsp";
	frmLogin.submit();
}
</script>
</head>
<body>
	<div id="container">

		<%@include file="/rayout/header.jsp" %>
	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="member_login.html"><span class="fnt"><i class="fas fa-apple-alt"></i></span>LOGIN</a></li>
				<li><a href="">ID / PASSWORD</a></li>
				<li><a href="member_join.html"> CONTACK</a></li>
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
							<div class="fl_clear"><label for="mbrId">아이디</label><input name="t_id" id="mbrId" type="text" onkeypress="if( event.keyCode==13 ){goPw()}"></div>
							<div class="fl_clear"><label for="scrtNo">비밀번호</label><input name="t_pw" id="scrtNo" type="password" onkeypress="if( event.keyCode==13 ){memberLogin()}"></div>
							<a class="btn_login btn_Blue" onkeypress="abc()">로그인</a>
						</form>
					</div>
				   
				</div>		
			</div>

		</div>	

		<%@include file="/rayout/bottom.jsp" %>
	</div>	
</body>
</html>






