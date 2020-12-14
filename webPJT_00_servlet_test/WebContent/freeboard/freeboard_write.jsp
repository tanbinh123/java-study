<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.*" %>    
<%@ include file="/common/common_subpage_head.jsp"%>   
<script type="text/javascript">
	function goSave(){
		news.method="post";
		news.action="/Freeboard";
		news.submit();
	}
</script>
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
			<form name="news">  
			<input type="hidden" name="t_gubun" value="save">
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
						<td colspan="3"><input type="text" name="t_title" class="input600"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea class="textArea_H250" name="t_content"></textarea></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=session_name%>
							<input type="hidden" name="t_reg_name"  value="<%=session_name%>">
							<input type="hidden" name="t_reg_id"  value="<%=session_id%>">
						</td>
						<th>RegDate</th>
						<td><input type="date" class="input130" name="t_reg_date" value="<%=CommonUtil.getToday()%>"></td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="javascript:history.back()" class="butt">List</a>
			</div>	
		</div>	
<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>