<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<%@ page import="dao.*,dto.*,common.*" %>    
<%
//	Notice_dto dto = (Notice_dto)request.getAttribute("t_dto");

%>
<%@ include file="/common/common_subpage_head.jsp"%>
<script>
	function goUpdateForm(){
		noti.t_gubun.value ="updateForm";
		noti.method="post";
//		noti.action="notice_update.jsp";
		noti.action="/Notice";
		noti.submit();
	}
	function goDelete(){
		if(confirm(" 증말 삭제 ? ")){
			noti.t_gubun.value ="delete";
			noti.method="post";
//			noti.action="db_notice.jsp";
//			noti.action="db_notice_delete_file.jsp";
			noti.action="/Notice";
			noti.submit();		
		}
	}
</script> 	
		<form name="noti">
			<input type="hidden" name="t_no" value="${t_dto.getNo()}">
			<input type="text" name="t_attach" value="${t_dto.getAttach()}">
			<input type="hidden" name="t_gubun" >
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
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="55%">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="2">${t_dto.getTitle()}</td>
						<td> <i class="far fa-eye"></i> ${t_dto.getHit()}</td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly>${t_dto.getContent()}</textarea>
						</td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3">
 <c:if test="${!t_dto.getAttach()}">
	<a href="/common/filedown.jsp?t_file=${t_dto.getAttach()}&t_gubun=notice">${t_dto.getAttach()}</a> 	
 </c:if>						
						

						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>${t_dto.getReg_name()}</td>
						<th>RegDate</th>
						<td>${t_dto.getReg_date()}</td>
					</tr>	
				</tbody>
			</table>
			<div class="buttonGroup">
 			<c:if test="${session_level eq 'top'}">
				<a href="javascript:goDelete()" class="butt">Delete</a>
				<a href="javascript:goUpdateForm()" class="butt">Update</a>
 			</c:if>
				<a href="/Notice" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>	
	</div>	
</body>
</html>






