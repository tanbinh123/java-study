<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/session_member_check.jsp" %>     
<%@ include file="/common/common_subpage_head.jsp"%>  
<%@ page import="dao.*,dto.*,common.*"%>
<%
	Common common = new Common();
	Qanda_dao dao = new Qanda_dao();
	String no = request.getParameter("t_no");
	Qanda_dto dto = dao.getQuestionInfo(no);
%>    

<script type="text/javascript">
	function goUpdate(){
		if(!checkEmpty(qna.t_title," 제목 입력! ")) return;
		if(!checkEmpty(qna.t_content," 내용 입력! ")) return;
		qna.method="post";
		qna.action="/Qna";
		qna.submit();
	}
</script>	
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/Notice">NOTICE</a></li>
				<li><a href="/News">News</a></li>
				<li><a href="/Qna"><span class="fnt"><i class="fas fa-apple-alt"></i></span>Q & A</a></li>
				<li><a href="/Freeboard">Free Board</a></li>
				<li><a href="/Etc">Etc</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				QUESTION & ANSWER
			</p>
			<form name="qna">
			<input type="hidden" name="t_no" value="<%=no%>">
			<input type="hidden" name="t_gubun" value="qnaUpdate">
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
						<td colspan="3"><input type="text" name="t_title" value="<%=dto.getTitle()%>" class="input600"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250"><%=dto.getContent()%></textarea></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=dto.getQ_reg_name()%>
							<input type="hidden" name="t_reg_id" value="<%=dto.getQ_reg_id()%>" class="input100">
						</td>
						<th>RegDate</th>
						<td><%=CommonUtil.getToday()%></td>
					</tr>	
				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goUpdate()" class="butt">Update</a>
				<a href="qanda_list.jsp" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>	
	</div>	
</body>
</html>






