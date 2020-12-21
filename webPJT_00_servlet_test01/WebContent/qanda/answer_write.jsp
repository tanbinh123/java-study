<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  include file="/common/session_manager_check.jsp" %>
<%@ page import ="dao.*, dto.*,common.*" %>
<%
	Qanda_dao dao = new Qanda_dao();
	String no = request.getParameter("t_no");
	dao.setHitCount(no);
	Qanda_dto dto = dao.getQandaView(no);
%>
<%@  include file="/common/common_subpage_head.jsp" %>
<script type="text/javascript">
	function goSaveAnswer(){
		qna.method="post";
		qna.action="/Qna";
		qna.submit();
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
				QUESTION & ANSWER
			</p>
			<form name="qna">
				<input type="hidden" name="t_no" value="<%=no%>">		
				<input type="hidden" name="t_gubun" value="answerSave">		
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
							<td colspan="2"><%=dto.getTitle() %></td>
							<td> <i class="far fa-eye"></i><%=dto.getHit() %></td>
						</tr>	
						<tr>
							<th>Content</th>
							<td colspan="3">
								<textarea class="textArea_H120_noBorder" readonly><%=dto.getContent() %></textarea>
							</td>
						</tr>	
						<tr>
							<th>Writer</th>
							<td><%=dto.getQ_reg_name() %></td>
							<th>RegDate</th>
							<td><%=dto.getQ_reg_date() %></td>
						</tr>
					
						<tr>
							<th>Answer</th>
							<td colspan="3">
							<textarea name="t_answer" class="textArea_H120"></textarea>
						</tr>	
						<tr>
							<th>AnsName</th>
							<td><%=session_name%>
								<input type="hidden" name="t_reg_id" value="<%=session_id%>">
							</td>
							<th>AnsRegDate</th>
							<td><%=CommonUtil.getToday()%></td>
						</tr>	
	
					</tbody>
				</table>
			</form>				
			<div class="buttonGroup">
				<a href="javascript:goSaveAnswer()" class="butt">AnsSave</a>
				<a href="qanda_list.jsp" class="butt">List</a>		
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>