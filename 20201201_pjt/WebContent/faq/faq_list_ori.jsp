<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dao.*, dto.*, common.*, java.util.*" %>
<%
	Faq_dao dao = new Faq_dao();
	ArrayList<Faq_dto> dtos 	= (ArrayList<Faq_dto>)request.getAttribute("t_arr");
	String select 				= (String)request.getAttribute("t_select");
	String search 				= (String)request.getAttribute("t_search");
	ArrayList<Faq_dto> arr = dao.getFaqList(select, search);

	
	//페이징 관련 변수 start
	int v_count 		= (int)request.getAttribute("v_count");
	int for_count 		= (int)request.getAttribute("for_count");
	int a_count 		= (int)request.getAttribute("a_count");
	int current_page	= (int)request.getAttribute("current_page");
	int total_page 		= (int)request.getAttribute("total_page");
	//페이징 관련 변수 end
	
%>
<%@ include file="/common_head.jsp" %>
<script type="text/javascript">
	function goUpdateForm(no){
		viewOrDelete.t_no.value = no;
		viewOrDelete.method="post";
		viewOrDelete.action="/FaqUpdateForm";
		viewOrDelete.submit();
	}
	function goPage(pageNumber){
		Faqform.r_page.value= pageNumber;
		Faqform.method="post";
		Faqform.action="/FaqList";
		Faqform.submit();
	}
	function godeleteForm(no){
		if(confirm(" 정말 삭제 하시겠습니까? ")){
			viewOrDelete.t_no.value = no;
			viewOrDelete.method="post";
			viewOrDelete.action="/FaqdeleteForm";
			viewOrDelete.submit();
		}
	}
</script>
	<form name="viewOrDelete">
		<input type="hidden" name="t_no">
	</form>
		<!--  header end -->
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
				<h2><a href="/NoticeList"> NOTICE</a></h2>	
				<h2><a href="/NewsList"> NEWS</a></h2>	
				<h2><a href="/qna/qna_list.jsp"> QnA</a></h2>
				<h2 class="color"><a href="/FaqList"><i class="fas fa-check"></i> FAQ</a></h2>	
			</div>

		<div class="search_wrap">
			<div class="record_group">
				<p>* 총게시글 : <span><%=arr.size() %></span>건</p>
			</div>
			<form name="Faqform">
			<input type="hidden" name="r_page">
			<input type="hidden" name="t_no">
			<div class="search_group">
				<select name="t_select" class="select">
					<option value="question" <%if(select.equals("question")) out.print("selected");%>>질문</option>
					<option value="answer" <%if(select.equals("answer")) out.print("selected");%>>답변</option>
				</select>
				<input type="text" name="t_search" value="<%=search %>" class="search_word">
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
						<col width="15%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
					</colgroup>
					
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">질문 제목</th>
							<th scope="col">작성일</th>
							<th scope="col">작성자</th>
							<th scope="col">조회수</th>
<%							if(session_level.equals("top")){ %>
							<th scope="col">수정/삭제</th>
<%							} %>
						</tr>
					</thead>
					<tbody>
<%						if ( arr.size() > 0 ){
						for(int k = 0 ; k < arr.size() ; k++ )	{
							if(v_count == for_count){ 
%> 
						<tr>
							<td><%=arr.get(k).getNo() %></td>
							<td class="txt"><%=arr.get(k).getQuestion() %></td>
							<td><%=arr.get(k).getReg_date() %></td>
							<td><%=arr.get(k).getReg_id()%></td>
							<td><%=arr.get(k).getHit() %></td>
<%							if(session_level.equals("top")){ %>
							<td>
							<input type="button" value="수정" onclick="goUpdateForm('<%=arr.get(k).getNo()%>');">/
							<input type="button" value="삭제" onclick="godeleteForm('<%=arr.get(k).getNo()%>');">
							</td>
<%							} %>
						</tr>
<%
					v_count = v_count + 1;
					for_count = for_count + 1;
					}else { 
						v_count = v_count + 1;
					}
					if(v_count == a_count) break; 
				}
		}
%>		
					</tbody>
				</table>
			</div>
			
			<div class="page-number">
				<div class="page-number">
<!-- 
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
 -->
 <%
					out.println(CommonUtil.pageListPost(current_page, total_page, 5));			
%>
<%					if(session_level.equals("top")) {%>
					<a href="/FaqWrite" class="btn-write">글쓰기</a>
<%					} %>	
<%
	//				out.println(CommonUtil.pageListPost(current_page, total_page, 5));			
%>
				</div>				
			</div>
		
		</div>
		
		
		
		<!--  footer start  -->
		<div id="footer">
			<div class="footer-text">
				<ul class="sub-logo">
					<li><a href="index.jsp" alt="서브로고">JSL 인재개발원</a></li>
				</ul>
				
				<ul class="copy">
					<li>Copyright ⓒ EL WIDE. All Rights Reserved.</li>
				</ul>
			</div>
		</div>
		</div>
	
	
	
	</body>
</html>