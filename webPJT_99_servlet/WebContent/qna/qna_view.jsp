<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import = "dto.*" %>
<% Qna_dto dto = (Qna_dto)request.getAttribute("t_dto"); %>
<%@ include file="/common_head.jsp" %>  
		<!--  header end -->
<script type="text/javascript">
function goUpdateForm(){
	noti.method="post";
	noti.action="/QnaUpdateForm";
	noti.submit();
}
function goReplyForm(){
	noti.method="post";
	noti.action="/QnaReplyForm";
	noti.submit();
}
function goDelete(){
	if(confirm(" 정말 삭제? ")){
		noti.method="post";
		noti.action="/DBQna";
		noti.submit();
	}	
}	
</script>		
	<form name="noti">
		<input type="hidden" name="t_no" value="<%=dto.getNo()%>">
		<input type="hidden" name = "t_groupno" value = "<%=dto.getGroupno() %>">
		<input type="hidden" name = "t_seg" value = "<%=dto.getSeg() %>">
		<input type="hidden" name = "t_depth" value = "<%=dto.getDepth() %>">
		<input type="hidden" name="t_pageGubun" value="삭제">
	</form>	
		<!-- sub page start -->
		<div class="notice">
		
			<div class="sub-notice">
			<h2><span><i class="fas fa-edit"></i> QNA	-View</span></h2>	
			</div>
			
			<div class="notice-write">
					
					<h2 class="readonly">제목, 첨부파일, 내용을 작성합니다</h2>
				
					<fieldset>
						<legend>공지사항 글쓰기</legend>
						
						<table class="table">
							<caption>공지사항 글쓰기</caption>
							<colgroup>
								<col width="20%">
								<col width="*">
								<col width="10%">
								<col width="20%">
							</colgroup>
							
							<tr>
								<th><label for="title">제목</label></th>
								<td style="text-align:left">
									<%=dto.getTitle()%>
								</td>
								
								<th><label for="title">조회수</label></th>
								<td><%=dto.getHit()%></td>
							</tr>
							
							<tr>
								<th><label for="cont">내용</label></th>
								<td colspan="4"><textarea type="cont" name="cont" id="cont" class="contView" readonly><%=dto.getContent()%>
								</textarea>
							</tr>
								<tr>
								<th>등록자</th>
								<td style="text-align:left">
									<%=dto.getReg_name()%>
								</td>
								<th>등록일</th>
								<td><%=dto.getReg_date()%></td>
							</tr>
							
							<tr>
								<td colspan="4">
									<input type="button" onclick="history.back()" value="목록" class="btn">
									<%if(sessionLevel.equals("top")){%>
									<input type="button" onclick="goReplyForm()" value="답글" class="btn" >
									<input type="button" onclick="goUpdateForm()" value="수정" class="btn" >
									<input type="button" onclick="goDelete()" value="삭제" class="btn" >
									<%} %>
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

	</body>
</html>









    