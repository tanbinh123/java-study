<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dto.*, java.util.*,common.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/common/common_subpage_head.jsp" %>
<%
	
%>
<script>
	function goWrite(){
		news.t_gubun.value="write";
		news.method = "post";
		news.action = "/News";
		news.submit();		
	}
	function goView(nn){
		//alert("1234");
		news.t_no.value = nn;
		news.method = "post";
		news.action = "/News";
		news.submit();		
	}
	function goSearch(){
		//alert("1234");
		sacyu.method="post";
//		sacyu.action="news_list.jsp";
		sacyu.action="/News";
		sacyu.submit();
	}
	function goPage(pageNumber){
		pageForm.r_page.value= pageNumber;
		pageForm.method="post";
		pageForm.action="/News";
		pageForm.submit();
	}
</script>
	<form name="pageForm">
		<input type="hidden" name="r_page">
		<input type="hidden" name="t_select" value="${t_select}">  
		<input type="hidden" name="t_search" value="${t_search}">
	</form>
	<form name="news">
		<input type="hidden" name="t_no">
		<input type="hidden" name="t_gubun" value="view">
	</form>
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/Notice">NOTICE</a></li>
				<li><a href="/News"><span class="fnt"><i class="fas fa-apple-alt"></i></span> News</a></li>
				<li><a href="/Qna">Q & A</a></li>
				<li><a href="/Freeboard">Free Board</a></li>
				<li><a href="/Etc">Etc</a></li>
			</ul>
		</div>
			<div id="b_right">
				<p class="n_title">
					NEWS
				</p>
				<form name="sacyu">
					<p class="leftBox">총 게시글 : ${t_arr.size()}건</p>
					<p class="select_box">
					
						<select class="sel_box" name="t_select">
							<option value="title" <c:if test="${t_select eq 'title'}">selected</c:if> >Title</option>
							<option value="content" <c:if test="${t_select eq 'content'}">selected</c:if> >Content</option>
						</select>
						<input type="text" name="t_search" value="${t_search}" class="sel_text">
				<button type="submit" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
				</form>
			</p>
			
			<table class="boardList">
				<colgroup>
					<col width="8%">
					<col width="60%">
					<col width="10%">
					<col width="14%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Reg Name</th>
						<th>Reg Date</th>
						<th>Hit</th>
					</tr>
				</thead>
				<tbody>

	<c:set var="forYN" value="true"></c:set>
	<c:if test="${t_arr.size() > 0}"> 
		<c:forEach items="${t_arr}" var="arr">
			<c:if test="${forYN==true}">
				<c:choose>
					<c:when test="${v_count == for_count}">
					<tr>
						<td><a href="javascript:goView('${arr.getNo()}')">${arr.getNo()}</a></td>
						<td class="t_center"><a href="javascript:goView('${arr.getNo()}')">${arr.getTitle()}</a></td>
						<td>${arr.getReg_name()}</td>
						<td>${arr.getReg_date()}</td>
						<td>${arr.getHit()}</td>
					</tr>	
						<c:set var="v_count" value="${v_count+1}"></c:set>	
						<c:set var="for_count" value="${for_count+1}"></c:set>	
					</c:when>
					<c:otherwise>
						<c:set var="v_count" value="${v_count+1}"></c:set>
					</c:otherwise>
				</c:choose>
				<c:if test="${v_count==a_count}">
					<c:set var="forYN" value="false"></c:set>
				</c:if>
			</c:if>				
		</c:forEach>	
	</c:if>	

				</tbody>
			</table>
			
			<div class="paging">
<!-- 			
				<a href=""><i class="fa fa-angle-double-left"></i></a>
				<a href=""><i class="fa fa-angle-left"></i></a>
				<a href="" class="active">1</a>
				<a href="">2</a>
				<a href="">3</a>
				<a href="">4</a>
				<a href="">5</a>
				<a href=""><i class="fa fa-angle-right"></i></a>
				<a href=""><i class="fa fa-angle-double-right"></i></a>
 -->				
<%
				int current_page = (int)request.getAttribute("current_page");
				int total_page = (int)request.getAttribute("total_page");
				
				out.println(CommonUtil.pageListPost(current_page, total_page, 2));		
				if(session_level.equals("top")) { %>
					<a href="javascript:goWrite()" class="write">글쓰기</a>
				<%} %>
			</div>
		</div>	
	
<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>