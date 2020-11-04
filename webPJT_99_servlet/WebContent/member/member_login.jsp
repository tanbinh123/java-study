<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_head.jsp" %>  	
<script>
	
	function goLogin() {
		if(!checkEmpty(login.t_id,"아이디 입력!"))return;
		if(!checkEmpty(login.t_pw,"비밀번호 입력!")) return;
		if(login.t_id.value.length > 20){
			login.t_id.value = "";
			alert("아이디를 확인해주세요!");
			login.t_id.focus();
			return;
		}else if(login.t_pw.value.length > 20){
			login.t_pw.value = "";
			alert("비밀번호를 확인해주세요!");
			login.t_pw.focus();
		}else{
			login.method="post";
			login.action="/DBLogin";
			login.submit();
		}
	}
	
</script>
<style>
	/*loginTable css*/
	.loginTable {
	  width: 300px;
	  background: #fff;
	  margin: 0 auto;
	  padding: 20px;
	  text-align: center;
	}
	.loginTable th {
		width: 200px;
	  border-bottom: 1px solid #999;
	  margin-bottom: 5px;
	  padding: 5px 0px;
	  background: #e1e1e1;
	}
	.loginTable tr{
	  
	  margin-bottom: 5px;
	}
	.inputInfo{
	border-bottom: 1px solid #76b7c0;
	}
	.loginTable .txt {
	  text-align: left;
	}
	.loginTable td {
	  padding: 10px;
	  font-size: 14px;
	}
	.loginTable #id,#pw{
	width: 100%;
	height: 30px;
	border:none;
	border-right:0px;
	border-top:0px;
	boder-left:0px;
	boder-bottom:0px;

	}
</style>
		<!--  header end -->
		
		
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
		<h2><span><i class="fas fa-edit"></i>Login</span></h2>
			</div>
			
			<div class="notice-write">
			
			<form name="login">
					<!-- <h2 class="readonly">제목, 내용을 작성합니다</h2> -->
				
					<fieldset>
						<legend>뉴스 글쓰기</legend>
						
						<table class="loginTable">
							<caption>뉴스 글쓰기</caption>
							<colgroup>
								<col width="20%">
								<col width="*">
							</colgroup>
							
							<tr class="inputInfo">
								<td><input type="text" name="t_id" id="id" class="title" placeholder="아이디를 입력해주세요"></td>
							</tr>
							
							<tr class="inputInfo">
								<td><input type="password" name="t_pw" id="pw" class="cont" placeholder="비밀번호를 입력해주세요"></textarea>
							</tr>
							
							<tr>
								<td colspan="2">
								<input type="button" onclick="goLogin()" value="로그인" class="btn" >
								<input type="button" onclick="location.href='/member/member_register.jsp'" value="회원가입" class="btn" >
								<!-- <input type="button" onclick="history.back();" value="뒤로" class="btn">-->
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









    