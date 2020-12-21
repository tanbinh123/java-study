<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  include file="/common/session_member_check.jsp" %>
<%@ page import = "common.*" %>
<%
//	Common common = new Common();
%>
<%@  include file="/common/common_subpage_head.jsp" %>
<script>
	function goSave(){
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
		} */
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
					<input type="hidden" name="t_gubun" value="save">
					<tbody>
						<tr>
							<th>Title</th>
							<td colspan="3"><input type="text" name="t_title" class="input600" maxlength="50"></td>
						</tr>	
						<tr>
							<th>Content</th>
							<td colspan="3"><textarea name="t_content" class="textArea_H250" maxlength="1000"></textarea></td>
						</tr>		
						<tr>
							<th>Writer</th>
							<td><%=session_name%>
								<input type="hidden" name="t_reg_id" value="<%=session_id%>" class="input100"></td>
							<th>RegDate</th>
							<td><%=CommonUtil.getToday() %>
							<!-- <input type="date" name="t_reg_date" value="" class="input130">-->
							</td>
						</tr>	
					</tbody>
				</form>
			</table>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="/Qna" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>