<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*" %>    
<%
Freeboard_dto dto = (Freeboard_dto)request.getAttribute("t_dto");
%>  
<script type="text/javascript">
function goUpdate(){
	news.t_gubun.value="updateForm";
	news.method="post";
	news.action="/Freeboard";
	news.submit();
}
function goDelete(){
	news.t_gubun.value="delete";
	news.method="post";
	news.action="/Freeboard";
	news.submit();
}
</script>  
 <%@ include file="/common/common_subpage_head.jsp"%>  
 	<form name="news">
 		<input type="hidden" name="t_no" value="<%=dto.getNo()%>">
 		<input type="hidden" name="t_gubun">
 	</form> 
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
							<li><a href="/Notice">NOTICE</a></li>
				<li><a href="/News"> News</a></li>
				<li><a href="/Qna">Q & A</a></li>
				<li><a href="/Freeboard">Free Board<span class="fnt"><i class="fas fa-apple-alt"></i></span></a></li>
				<li><a href="/Etc">Etc</a></li>
			</ul>
		</div>
			<div id="b_right">
				<p class="n_title">
					FREEBOARD
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
						<td colspan="2"><%=dto.getTitle()%></td>
						<td> <i class="far fa-eye"></i> <%=dto.getHit()%></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly><%=dto.getContent()%></textarea>
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=dto.getReg_name()%></td>
						<th>RegDate</th>
						<td><%=dto.getReg_date()%></td>
					</tr>	

				</tbody>
			</table>
			<div class="buttonGroup">
			<%  if(session_level.equals("top") || session_id.equals(dto.getReg_id())){ %>
				<a href="javascript:goDelete()" class="butt">Delete</a>
				<a href="javascript:goUpdate()" class="butt">Update</a>
				<%  } %>
				<a href="javascript:history.back()" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>	
	</div>	
</body>
</html>
    