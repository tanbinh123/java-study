<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*,common.*"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<%@ include file="/common/common_subpage_head.jsp"%>
<script type="text/javascript">
	function goWrite(){
		notiView.t_gubun.value="write";
		notiView.method = "post";
		notiView.action = "/Notice";
		notiView.submit();		
	}
	
	function goSearch(){
		noti.method="post";
		noti.action="/Notice";
		noti.submit();
	}
	function goView(num){
		notiView.t_no.value = num;
		notiView.method ="post";
		notiView.action ="/Notice";
		notiView.submit();
	}
	function goPage(pageNumber){
		pageForm.r_page.value = pageNumber;
		pageForm.method="post";
		pageForm.action="/Notice";
		pageForm.submit();
	}
</script>
		<form name="pageForm">
			<input type="hidden" name="r_page">
			<input type="hidden" name="t_select" value="${t_select}">  
			<input type="hidden" name="t_search" value="${t_search}">
		</form>
		<form name="notiView">
			<input type="hidden" name="t_no">
			<input type="hidden" name="t_gubun" value="view">
		</form>
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/Notice"><span class="fnt"><i class="fas fa-apple-alt"></i></span> NOTICE</a></li>
				<li><a href="/News"> News</a></li>
				<li><a href="/Qna">Q & A</a></li>
				<li><a href="/Freeboard">Free Board</a></li>
				<li><a href="/Etc">Etc</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			<form name="noti">
				<div> 
					<p class="leftBox">총 게시글 : ${t_arr.size()}건</p>
					<p class="select_box">
					
						<select class="sel_box" name="t_select">
							<option value="title" <c:if test="${t_select eq 'title'}">selected</c:if> >Title</option>
							<option value="content" <c:if test="${t_select eq 'content'}">selected</c:if> >Content</option>
						</select>
						<input type="text" name="t_search" value="${t_search}" class="sel_text">
					</p>
				</div>
			</form>
			<table class="boardList">
				<colgroup>
					<col width="8%">
					<col width="57%">
					<col width="5%">
					<col width="10%">
					<col width="14%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Attach</th>
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
						<td class="t_center">
<a href="javascript:goView('${arr.getNo()}')">
<%
/*
	int titleLength = arr.get(k).getTitle().length();
	String title = arr.get(k).getTitle();
	if(titleLength > 30){
		String tit = title.substring(0,30);
		out.print(tit+"...");
	} else {
		out.print(title);
	}

	if(arr.get(k).getTitle().length() > 30)	{
		out.print(arr.get(k).getTitle().substring(0,30)+"...");
	}else{
		out.print(arr.get(k).getTitle());
	}
	*/	
%>
	<c:if test="${fn:length(arr.getTitle()) > 3}">
		${fn:substring(arr.getTitle(),0,3)}...
	</c:if>
	<c:if test="${fn:length(arr.getTitle()) <= 3}">
		${arr.getTitle()}
	</c:if>
</a>
						</td>
						<td>
							<c:if test="${arr.getAttach() != null}">
								<img src="../images/clip.png">
							</c:if>	
						</td>
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
 %>	
 <c:if test="${session_level eq 'top'}">
	<a href="javascript:goWrite()" class="write">글쓰기2</a>
 </c:if>
<!--  
<%		
				if(session_level.equals("top")){ %>				
				<a href="javascript:goWrite()" class="write">글쓰기</a>
<%				} %>				
 -->				
				
			</div>
		</div>	
<%@ include file="/common/common_subpage_bottom.jsp" %>	

	</div>	
</body>
</html>






