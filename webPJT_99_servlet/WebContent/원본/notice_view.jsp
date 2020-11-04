<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
  
<%@ include file="/common_head.jsp" %>  
		<!--  header end -->
<script type="text/javascript">

</script>		
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
			<h2><span><i class="fas fa-edit"></i> NOTICE-View</span></h2>	
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
								<col width="20%">
								<col width="10%">
							</colgroup>
							
							<tr>
								<th><label for="title">제목</label></th>
								<td style="text-align:left">
									[채용공고] 음악콘텐츠본부 홍보마케팅
								</td>
								<th><label for="title">조회수</label></th>
								<td>55</td>
							</tr>
							
							<tr>
								<th><label for="cont">내용</label></th>
								<td colspan="3"><textarea type="cont" name="cont" id="cont" class="contView" readonly>
								음악콘텐츠본부 홍보마케팅 음악콘텐츠본부 홍보마케팅 음악콘텐츠본부 홍보마케팅
								</textarea>
							</tr>
							
							<tr>
								<th><label for="file">파일 첨부</label></th>
								<td  colspan="3" style="text-align:left"></td>
							</tr>
							
							<tr>
								<td colspan="4">
									<input type="button" onclick="" value="목록" class="btn">
									<input type="button" onclick="" value="수정" class="btn" >
									<input type="button" onclick="" value="삭제" class="btn" >
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









    