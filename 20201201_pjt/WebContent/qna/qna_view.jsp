<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*" %>  
<%
	Qanda_dto dto = (Qanda_dto)request.getAttribute("t_dto");
%>
<%@ include file="/common_head.jsp" %> 
<script>
	function goQuestionUpdate(){
		qna.method="post";
		qna.action="/QnaUpdate";
		qna.submit();
	}
	function goQuestionDelete(){
		if(confirm(" 정말 삭제 ? ")){
			qna.method="post";
			qna.action="/DBQnaDelete";
			qna.submit();
		}
	}
	function goAnswer(){
		qna.method="post";
		qna.action="/QnaAnswerWrite";
		qna.submit();		
	}
	function goAnswerUpdate(){
		qna.method="post";
		qna.action="/QnaAnswerUpdate";
		qna.submit();			
	}
	function goAnswerDelete(){
		if(confirm(" 정말 답변 삭제 ? ")){
			qna.method="post";
			qna.action="/QnaAnswerDelete";
			qna.submit();			
		}
	}
</script>	
	<form name="qna">
		<input type="hidden" name="t_no" value="<%=dto.getNo()%>">
	</form>	
		<!--  header end -->
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
			<h2><span><i class="fas fa-edit"></i> QandA-View</span></h2>	
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
<%							if(dto.getAnswer() != null){ %>							
							<tr>
								<th><label for="cont">답변 내용</label></th>
								<td colspan="3"><textarea name="t_content" readonly id="cont" class="cont"><%=dto.getAnswer()%></textarea>
							</tr>
							<tr>
								<th>답변자</th>
								<td style="text-align:left"><%=dto.getA_reg_name()%></td>
								<th>답변일자</th>
								<td style="text-align:left"><%=dto.getA_reg_date()%></td>
							</tr>
<%							} %>							
							
							<tr>
								<td colspan="4">
								<input type="button" onclick="history.back();" value="뒤로" class="btn">
<%  if(dto.getAnswer()==null){ 
	// 답변이 엄으면
		if(session_id.equals(dto.getQ_reg_id())){
%>
<input type="button" onclick="goQuestionUpdate()" value="질문수정" class="btn">
<input type="button" onclick="goQuestionDelete()" value="질문삭제" class="btn">
<%
		}
		if(session_level.equals("top")){
%>
<input type="button" onclick="goAnswer()" value="답변등록" class="btn">		
<%			
		}
	} else {
	// 답변이 있으면	
		if(session_level.equals("top")){
%>
<input type="button" onclick="goAnswerUpdate()" value="답변수정" class="btn">
<input type="button" onclick="goAnswerDelete()" value="답변삭제" class="btn">
<%			
		}
	}
%>
								</td>
							</tr>

							</table>
					</fieldset>
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









    