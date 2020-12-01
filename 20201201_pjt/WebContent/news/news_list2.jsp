<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_head.jsp" %>

<script type="text/javascript">
	
</script>
		<!--  header end -->
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
				<h2 class="color"><a href="notice_list.jsp"><i class="fas fa-check"></i> NOTICE</a></h2>	
				<h2><a href="/news/news_list.jsp"> NEWS</a></h2>	
				<h2><a href="/qna/qna_list.jsp"> QnA</a></h2>
				<h2><a href="/faq/faq_list.jsp"> FAQ</a></h2>	
			</div>

		<div class="search_wrap">
			<div class="record_group">
				<p>* 총게시글 : <span>777</span>건</p>
			</div>
			<form name="notiForm">
			<div class="search_group">
				<select name="t_select" class="select">
					<option value="title" >제목</option>
					<option value="content" >내용</option>
				</select>
				<input type="text" name="t_search" class="search_word">
				<button class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</div>
			</form>
		</div>

			
			<!-- table start-->
			<div class="table-box">
				<table class="table">
					<caption>공지사항 - 번호, 제목, 첨부, 작성일, 조회수</caption>
					<colgroup>
						<col width="5%">
						<col width="*">
						<col width="7%">
						<col width="15%">
						<col width="10%">
					</colgroup>
					
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">첨부</th>
							<th scope="col">작성일</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td class="txt"><a href="notice_view.jsp">[사고공고] 졸~~ 면 둑는다...</a></td>
							<td></td>
							<td>2020-03-05</td>
							<td>154</td>
						</tr>
						<tr>
							<td>2</td>
							<td class="txt"><a href="">[채용공고] 음악콘텐츠본부 홍보마케팅</a></td>
							<td></td>
							<td>2020-03-5</td>
							<td>154</td>
						</tr>
						<tr>
							<td>3</td>
							<td class="txt"><a href="">언노운드레스, 감성캐롤 ‘On Christmas Day’ 16일 정오 발매…’마음을 위로하는 음악’</a></td>
							<td></td>
							<td>2020-03-01</td>
							<td>452</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div class="page-number">
				<div class="page-number">
					<a href="#" class="icon"><i class="fas fa-arrow-circle-left fa-lg"></i></a>
					<a href="#" class="on">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<a href="#">5</a>
					<a href="#">6</a>
					<a href="#">7</a>
					<a href="#">8</a>
					<a href="#">9</a>
					<a href="#" class="more">…</a>
					<a href="#" class="icon"><i class="fas fa-arrow-circle-right fa-lg"></i></a>
					<a href="notice_write.jsp" class="btn-write">글쓰기</a>
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









    