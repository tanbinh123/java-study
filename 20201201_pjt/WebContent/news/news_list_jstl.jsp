<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="dto.*,java.util.*,common.*" %>   
<%
/*
	ArrayList<News_dto> dtos = 
					(ArrayList<News_dto>)request.getAttribute("t_dtos");
	String select = (String)request.getAttribute("t_select");
	String search = (String)request.getAttribute("t_search");

	// 페이지 관련 변수
	int v_count 	= (int)request.getAttribute("v_count");
	int for_count 	= (int)request.getAttribute("for_count");
	int a_count 	= (int)request.getAttribute("a_count");
	int current_page = (int)request.getAttribute("current_page");
	int total_page 	= (int)request.getAttribute("total_page");
	// 페이지 관련 변수
*/	
%>
    
<%@ include file="/common_head.jsp" %>
<script type="text/javascript">
	function formSearch(){
		newsForm.method="post";
		newsForm.action="/NewsController";
		newsForm.submit();
	}
	function goView(no){
		view.t_gubun.value ="view";
		view.t_no.value= no;
		view.method="post";
		view.action="/NewsController";
		view.submit();
	}
	function goPage(pageNumber){
		newsForm.r_page.value = pageNumber;
		newsForm.method="post";
		newsForm.action="/NewsController";
		newsForm.submit();
	}	
	function goWriteForm(){
		view.t_gubun.value ="write";
		view.method="post";
		view.action="/NewsController";
		view.submit();		
	}	
</script>
<!-- 
		<form name="pageForm">
			<input type="hidden" name="r_page">
			<input type="hidden" name="t_select" >
			<input type="hidden" name="t_search" >
		</form>
 -->
		<form name="view">
			<input type="hidden" name="t_no">
			<input type="hidden" name="t_gubun">
		</form>
		<!--  header end -->
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
				<h2><a href="/NoticeList">NOTICE</a></h2>	
				<h2 class="color"><a href="/News"><i class="fas fa-check"></i>  NEWS</a></h2>	
				<h2><a href="/QnaList"> QnA</a></h2>
				<h2><a href="/FaqList"> FAQ</a></h2>	
			</div>

		<div class="search_wrap">
			<div class="record_group">
				<p>* 총게시글 : <span>${dtos.size()}</span>건</p>
			</div>
			<form name="newsForm">
				<input type="hidden" name="r_page">
				<div class="search_group">
					<select name="t_select" class="select">
						<option value="title" <c:if test="${t_select eq 'title'}">selected</c:if> >제목</option>
						<option value="content" <c:if test="${t_select eq 'content'}">selected</c:if>>내용</option>
					</select>
					<input type="text" name="t_search" value="${t_search}" class="search_word">
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
						<col width="15%">
						<col width="10%">
					</colgroup>
					
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성일</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody>
<%	
//	if ( dtos.size() > 0 ){
//		for(int k = 0 ; k < dtos.size() ; k++ )	{
//			if(v_count == for_count){ 
%>	
					<c:forEach items="${t_dtos}" var="dtos">
						<tr>
							<td><a href="/NewsView?t_no=${dtos.getNo()}">${dtos.getNo()}</a></td>
							<td class="txt"><a href="javascript:goView('${dtos.getNo()}')">${dtos.getTitle()}</a></td>
							<td>${dtos.getReg_date()}</td>
							<td>${dtos.getHit()}</td>
						</tr>
					</c:forEach>	
<%
//				v_count = v_count + 1;
//				for_count = for_count + 1;
//			}else { 
//				v_count = v_count + 1;
//			}
//			if(v_count == a_count)break; 
//		}
//	}
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
	
%>
<!--				<a href="/NewsWriteForm" class="btn-write">글쓰기</a>-->
					<a href="javascript:goWriteForm()" class="btn-write">글쓰기</a>
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









    