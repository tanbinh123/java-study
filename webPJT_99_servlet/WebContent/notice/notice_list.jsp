<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="/common_head.jsp" %>
<%@ page import="dto.*, java.util.*" %>


<%
	ArrayList<Notice_dto> dtos = (ArrayList<Notice_dto>)request.getAttribute("t_dtos");
	String select = (String)request.getAttribute("t_select");
	String search = (String)request.getAttribute("t_search");
	
%>

<script type="text/javascript">
		function formSearch(){
				notiForm.method="post";
				notiForm.action="/NoticeList";
				notiForm.submit();
		}	
</script>
		<!--  header end -->
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
				<h2 class="color"><a href="/NoticeList"><i class="fas fa-check"></i> NOTICE</a></h2>	
				<h2><a href="/news/news_list.jsp"> NEWS</a></h2>	
				<h2><a href="/qna/qna_list.jsp"> QnA</a></h2>
				<h2><a href="/faq/faq_list.jsp"> FAQ</a></h2>	
			</div>

		<div class="search_wrap">
			<div class="record_group">
				<p>* 총게시글 : <span><%=dtos.size() %></span>건</p>
			</div>
			<form name="notiForm">
			<div class="search_group">
				<select name="t_select" class="select">
					<option value="title" <%if(select.equals("title")) out.print("selected"); %> >제목</option>
					<option value="content" <%if(select.equals("content")) out.print("selected"); %>>내용</option>
				</select>
				<input type="text" name="t_search" value="<%=search %>" class="search_word">
				<button class="btn_search" onclick="formSearch()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
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
				<%for(int k = 0; k < dtos.size(); k++){ %>	
						<tr>
							<td><%=dtos.get(k).getNo() %></td>
							<td class="txt"><a href="notice_view.jsp"><%=dtos.get(k).getTitle() %></a></td>
							<td>
								<%if(dtos.get(k).getAttach() != null) {%>
									<img src="/images/clip.png">	
								<%} %>
							</td>
							<td><%=dtos.get(k).getReg_date() %></td>
							<td><%=dtos.get(k).getHit() %></td>
						</tr>
				<%		}		 %>		
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
					<a href="/NoticeWriteForm" class="btn-write">글쓰기</a>
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









    