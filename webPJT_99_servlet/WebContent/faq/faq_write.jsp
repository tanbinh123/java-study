<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_head.jsp" %>  	
<script>
	
	function goSave() {
		
		if(!checkEmpty(write.t_title,"제목 입력!"))return;
		if(!checkEmpty(write.t_content,"내용 입력!")) return;
		if(write.t_title.value.length > 50){
			write.t_title.value = "";
			alert("제목은 50자 이내로 입력해주세요!");
			write.t_title.focus();
			return;
		}else{
			write.method="post";
			write.action="/DBFaq";
			write.submit();
		}
	}
	
</script>
		<!--  header end -->
		
		
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
			<h2><span><i class="fas fa-edit"></i> FAQ-write</span></h2>	
			</div>
			
			<div class="notice-write">
			
			<form name="write">
			<input type="hidden" name = "t_pageGubun" value = "등록">
					<h2 class="readonly">제목, 내용을 작성합니다</h2>
				
					<fieldset>
						<legend>faq 글쓰기</legend>
						
						<table class="table">
							<caption>뉴스 글쓰기</caption>
							<colgroup>
								<col width="20%">
								<col width="*">
							</colgroup>
							
							<tr>
								<th><label for="title">질문 제목</label></th>
								<td><input type="text" name="t_question" id="title" class="title" placeholder="제목을 입력해주세요"></td>
							</tr>
							
							<tr>
								<th><label for="cont">답변</label></th>
								<td><textarea type="cont" name="t_answer" id="cont" class="cont" placeholder="내용을 입력해주세요"></textarea>
							</tr>
							<tr>
								<th><label for="sory">중요도</label></th>
								<td><input type="text" name="t_sort" id="title" class="title" placeholder="제목을 입력해주세요"></td>
							</tr>
							<tr>
								<td colspan="2">
								<input type="button" onclick="goSave()" value="저장" class="btn" >
								<input type="button" onclick="history.back();" value="목록" class="btn">
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









    