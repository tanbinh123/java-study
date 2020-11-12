<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*,common.*"%>  
<% 
	request.setCharacterEncoding("utf-8");
	Faq_dao dao = new Faq_dao();
	
	ArrayList<Faq_dto> arr = (ArrayList<Faq_dto>)request.getAttribute("t_dtos");
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
		notiForm.action="/FaqList";
		notiForm.submit();
	}
	function goView(no){
		view.t_no.value= no;
		view.method="post";
		view.action="/FaqView";
		view.submit();
	}
	function goPage(pageNumber){
		notiForm.r_page.value = pageNumber;
		notiForm.method="post";
		notiForm.action="/FaqList";
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
				<h2><a href="QnaList"> QnA</a></h2>
				<h2 class="color"><a href="FaqList"><i class="fas fa-check"></i> FAQ</a></h2>	
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
					<option value="title" <%if(select.equals("title")) out.print("selected");%>>제목</option>
					<option value="content" <%if(select.equals("content")) out.print("selected");%>>내용</option>
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
						<col width="5%">
						<col width="*">
						<col width="10%">
						<col width="15%">
						<col width="10%">
					</colgroup>
					
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">중요도</th>
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
							<td><a href="/FaqView?t_no=<%=arr.get(i).getNo()%>"><%=arr.get(i).getNo()%></td>
							<td><%=arr.get(i).getSort()%></td>
							<td class="txt"><a href="javascript:goView('<%=arr.get(i).getNo()%>')"><%=arr.get(i).getQuestion() %></a></td>
							<td><%=arr.get(i).getReg_id() %></td>
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
							<td colspan="4">게시글이 없습니다.</td>
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
				<a href="/FaqWriteForm" class="btn-write">글쓰기</a>
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









    