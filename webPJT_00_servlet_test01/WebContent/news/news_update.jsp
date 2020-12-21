<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*" %>    
<%
	News_dto dto = (News_dto)request.getAttribute("t_dto");
%>  
<script type="text/javascript">
	function goUpdate(){
		news.method="post";
		news.action="/News";
		news.submit();
	}
</script>   
 <%@ include file="/common/common_subpage_head.jsp"%>   
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
			<form name="news">
	 		<input type="hidden" name="t_no" value="<%=dto.getNo()%>">
	 		<input type="hidden" name="t_gubun" value="update">				
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3"><input type="text" class="input600" value="<%=dto.getTitle()%>"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea class="textArea_H250"><%=dto.getContent()%></textarea></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=dto.getReg_name()%>
							<input type="hidden" value="<%=dto.getReg_name()%>" class="input100">
						</td>
						<th>RegDate</th>
						<td><input type="date" value="<%=dto.getReg_date()%>" class="input130"></td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				
				<a href="javascript:goUpdate()" class="butt">Update</a>
				<a href="/News" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>		
	</div>	
</body>
</html>

