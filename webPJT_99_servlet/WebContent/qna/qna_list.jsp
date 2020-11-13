<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*,common.*"%>  
<% 
	request.setCharacterEncoding("utf-8");
	Qna_dao dao = new Qna_dao();
	
	ArrayList<Qna_dto> arr = (ArrayList<Qna_dto>)request.getAttribute("t_dtos");
	String select = (String)request.getAttribute("t_select");
	String search = (String)request.getAttribute("t_search");
	
	
		int v_count 	= (int)request.getAttribute("v_count");
		int for_count 	= (int)request.getAttribute("for_count");
		int a_count 	= (int)request.getAttribute("a_count");
		int current_page = (int)request.getAttribute("current_page");
		int total_page 	= (int)request.getAttribute("total_page");
		
		int searchCount = arr.size();
		String searchCountString = "0";
		
		if(request.getParameter("t_searchCount") != null){ 
			searchCountString = request.getParameter("t_searchCount");
			searchCount = Integer.parseInt(searchCountString);
		}

		
%>
<%@ include file="/common_head.jsp" %>

<script type="text/javascript">
	function formSearch(){
		notiForm.method="post";
		notiForm.action="/QnaList";
		notiForm.submit();
	}
	function goView(no){
		view.t_no.value= no;
		view.method="post";
		view.action="/QnaView";
		view.submit();
	}
	function goPage(pageNumber){
		notiForm.r_page.value = pageNumber;
		notiForm.method="post";
		notiForm.action="/QnaList";
		notiForm.submit();
	}
</script>
		<!--  header end -->
		<!-- sub page start -->
		<form name="view">
			<input type="hidden" name="t_no">
		</form>
		<div class="notice">
			<div class="sub-notice">
				<h2><a href="/NoticeList"> NOTICE</a></h2>	
				<h2 ><a href="NewsList"> NEWS</a></h2>	
				<h2 class="color"><a href="QnaList"><i class="fas fa-check"></i> QnA</a></h2>
				<h2 ><a href="QnaList"> FAQ</a></h2>	
			</div>

		<div class="search_wrap">
			<div class="record_group">
				<p>* 총게시글 : <span><%=arr.size()%></span>건</p>
			</div>
			<form name="notiForm">
			<input type="hidden" name="r_page">
			<input name="t_searchCount" type="hidden" value="<%=searchCount%>">
			<div class="search_group">
				<select name="t_select" class="select">
					<option value="question" <%if(select.equals("question")) out.print("selected");%>>질문</option>
					<option value="answer" <%if(select.equals("answer")) out.print("selected");%>>답변</option>
				</select>
				<input type="text" name="t_search" class="search_word" value="<%=search%>">
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
						<col width="10%">
						<col width="15%">
						<col width="10%">
					</colgroup>
					
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
							<th scope="col">작성일</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody>
<%				if(arr.size() > 0){
					for(int i = 0 ; i < arr.size(); i++ ){ 
						if(v_count == for_count){%>
						<tr>
							<td><a href="/QnaView?t_no=<%=arr.get(i).getNo()%>"><%=arr.get(i).getNo()%></td>
							<td class="txt"><a href="javascript:goView('<%=arr.get(i).getNo()%>')"><%=arr.get(i).getTitle() %></a>
							<%if(sessionLevel.equals("top")){%>
							<a href="/QnaUpdateForm?t_no=<%=arr.get(i).getNo()%>">수정</a> <a href = "/DBQna?t_no=<%=arr.get(i).getNo()%>&t_pageGubun=삭제">삭제</a>
							<%} %>
							</td>
							<td><%=arr.get(i).getReg_name() %></td>
							<td><%=arr.get(i).getReg_date() %></td>
							<td><%=arr.get(i).getHit() %></td>
						</tr>
<%						v_count++;
						for_count++;
				} else{
					v_count++;
				}if(v_count == a_count)break;
			}
		}else{%>
						<tr>
							<td colspan="5">게시글이 없습니다.</td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
			
			<div class="page-number">
				<div class="page-number">
				<!-- 	<a href="#" class="icon"><i class="fas fa-arrow-circle-left fa-lg"></i></a>
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
					<a href="/news/news_write.jsp" class="btn-write">글쓰기</a>
		 -->
		 <%
					out.println(CommonUtil.pageListPostCSS(current_page, total_page,5));	
	%>
				<%if(sessionLevel.equals("top")){%>
					<a href="/QnaWriteForm" class="btn-write">글쓰기</a>
				<%} %>
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









    