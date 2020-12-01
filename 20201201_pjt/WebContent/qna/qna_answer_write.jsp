<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*" %>  
<%
	Qanda_dto dto = (Qanda_dto)request.getAttribute("t_dto");
%>
<%@ include file="/common_head.jsp" %> 
<script>
	function goAnswerSave(){
		if(qna.t_answer.value ==""){
			alert("답변 내용 작성!");
			qna.t_answer.focus();
			return;
		}
		qna.method="post";
		qna.action="/DBAnswerSave";
		qna.submit();		
	}
</script>	
	<form name="qna">
		<input type="hidden" name="t_no" value="<%=dto.getNo()%>">
		<input type="hidden" name="t_reg_id" value="<%=session_id%>">
		<input type="hidden" name="t_work_gubun" value="등록">
		<!--  header end -->
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
			<h2><span><i class="fas fa-edit"></i> QandA-Answer Write</span></h2>	
			</div>
			<div class="notice-write">
					<h2 class="readonly">제목, 첨부파일, 내용을 작성합니다</h2>
					<fieldset>
						<table class="table">
							<colgroup>
								<col width="15%">
								<col width="35%">
								<col width="15%">
								<col width="35%">
							</colgroup>
							<tr>
								<th><label for="title">질문 제목</label></th>
								<td colspan="3" style="text-align:left"><%=dto.getTitle()%></td>
							</tr>
							
							<tr>
								<th><label for="cont">질문 내용</label></th>
								<td colspan="3"><textarea name="t_content" readonly id="cont" class="cont"><%=dto.getContent()%></textarea>
							</tr>

							<tr>
								<th>등록자</th>
								<td style="text-align:left"><%=dto.getQ_reg_name()%></td>
								<th>등록일자</th>
								<td style="text-align:left"><%=dto.getQ_reg_date()%></td>
							</tr>

							
							<tr>
								<th><label for="cont">답변 내용</label></th>
								<td colspan="3"><textarea name="t_answer" id="cont" autofocus='autofocus' class="cont"></textarea>
							</tr>
							
							<tr>
								<td colspan="4">
								<input type="button" onclick="history.back();" value="뒤로" class="btn">
								<input type="button" onclick="goAnswerSave()" value="답변저장" class="btn">
								</td>
							</tr>

							</table>
					</fieldset>
			</div>
		</form>		

		
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









    