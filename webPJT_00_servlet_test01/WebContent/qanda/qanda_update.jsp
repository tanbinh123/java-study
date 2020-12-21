<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  include file="/common/session_member_check.jsp" %>
<%@ page import = "dao.*, dto.*, common.*" %>
<%
	Qanda_dto dto = (Qanda_dto)request.getAttribute("t_dto");	
%>
<%@  include file="/common/common_subpage_head.jsp" %>
<script>
	function goUpdate(){
 		if(!checkEmpty(qanda.t_title, " 제목 입력 ")) return;
 		if(!checkEmpty(qanda.t_content, " 내용 입력 ")) return;
/*		if(qanda.t_title.value==""){
			alert("제목을 입력하시오");
			qanda.t_title.focus();
			return;
		}
		if(qanda.t_content.value==""){
			alert("내용을 입력하시오");
			qanda.t_content.focus();
			return;
		}
*/		qanda.t_gubun.value = "QueUpdate";
		qanda.method="post";
		qanda.action = "/Qna";
		qanda.submit();
	}
</script>
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/Notice"> NOTICE</a></li>
				<li><a href="/News"> NEWS</a></li>
				<li><a href="/Qna"><span class="fnt"><i class="fas fa-apple-alt"></i></span>Q & A</a></li>
				<li><a href="/Freeboard">FREE BOARD</a></li>
				<li><a href="/Etc">ETC</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NEWS
			</p>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<form name="qanda">
					<input type="hidden" name="t_no" value="<%=dto.getNo()%>">
					<input type="hidden" name="t_gubun" value="QueUpdate">
					<tbody>
						<tr>
							<th>Title</th>
							<td colspan="3"><input type="text" name="t_title" value="<%=dto.getTitle() %>" class="input600" maxlength="50"></td>
						</tr>	
						<tr>
							<th>Content</th>
							<td colspan="3"><textarea name="t_content"  class="textArea_H250" maxlength="1000"><%=dto.getContent() %></textarea></td>
						</tr>		
						<tr>
							<th>Writer</th>
							<td><%=dto.getQ_reg_name()%><!-- 매니저가 수정할 수 있기  때문에 -->
								<input type="hidden" name="t_reg_id" value="<%=dto.getQ_reg_id()%>" class="input100"></td>
							<th>RegDate</th>
							<td><%=CommonUtil.getToday() %>
								<!-- <input type="date" name="t_reg_date" value="<%=dto.getQ_reg_date() %>" class="input130"> -->
							</td>
						</tr>	
					</tbody>
				</form>
			</table>
			<div class="buttonGroup">
				<a href="javascript:goUpdate()" class="butt">Save</a>
				<a href="qanda_list.jsp" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>