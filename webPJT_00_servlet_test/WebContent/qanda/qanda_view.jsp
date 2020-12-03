<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>    
<%
	Qanda_dao dao = new Qanda_dao();
	String no = request.getParameter("t_no");
	dao.setHitCount(no);
	Qanda_dto dto = dao.getQandaView(no);
%>
<%@ include file="/common/common_subpage_head.jsp"%>
<script>
	function goQueDelete(){
		if(confirm(" 질문 삭제 하겠습니까? ")){
			qna.method="post";
			qna.action="db_question_delete.jsp";
			qna.submit();			
		}
	}
	function goQueUpdateForm(){
		qna.method="post";
		qna.action="qanda_update.jsp";
		qna.submit();			
	}	
	function goAnswer(){
		qna.method="post";
		qna.action="answer_write.jsp";
		qna.submit();			
	}			
	function goAnsDelete(){
		if(confirm(" 답변 삭제 하겠습니까? ")){
			qna.method="post";
			qna.action="db_answer_delete.jsp";
			qna.submit();			
		}
	}
	function goAnsUpdateForm(){
		qna.method="post";
		qna.action="answer_update.jsp";
		qna.submit();			
	}	
	
</script> 	
		<form name="qna">
			<input type="hidden" name="t_no" value="<%=no%>">
		</form>
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/notice/notice_list.jsp">NOTICE</a></li>
				<li><a href="/news/news_list.jsp">News</a></li>
				<li><a href="/qanda/qanda_list.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span> Q & A</a></li>
				<li><a href="/freeboard/freeboard_list.jsp">Free Board</a></li>
				<li><a href="">Etc</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				QUESTION & ANSWER
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
							<textarea class="textArea_H120_noBorder" readonly><%=dto.getContent()%></textarea>
						</td>
					</tr>
					<tr>
						<th>Writer</th>
						<td><%=dto.getQ_reg_name()%></td>
						<th>RegDate</th>
						<td><%=dto.getQ_reg_date()%></td>
					</tr>
<%					if(dto.getAnswer() != null){ %>											
					<tr>
						<th>Answer</th>
						<td colspan="3">
							<textarea class="textArea_H120_noBorder" readonly><%=dto.getAnswer()%></textarea>
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=dto.getA_reg_name()%></td>
						<th>RegDate</th>
						<td><%=dto.getA_reg_date()%></td>
					</tr>	
<%					} %>					
				</tbody>
			</table>
			<div class="buttonGroup">
			
<%				if(dto.getAnswer() == null){ // 답변이 안달려 있고 
					if(dto.getQ_reg_id().equals(session_id) || session_level.equals("top")){ 
						// 등록id가 로그인id와 같거나 관리자 이면 수정 삭제
%>						
						<a href="javascript:goQueDelete()" class="butt">QueDelete</a>
						<a href="javascript:goQueUpdateForm()" class="butt">QueUpdate</a>					
<%					}
					if(session_level.equals("top")){
						// 답변이 없고 관리자 이면 답변달기 창으로
%>						
						<a href="javascript:goAnswer()" class="butt">Answer</a>	
<%						
					}
				} 
%>			

<%				if(dto.getAnswer() != null){ //답변이 달려있고
					if(session_level.equals("top")){ // 관리자이면 답변 수정 삭제 가능
%>
					<a href="javascript:goAnsDelete()" class="butt">AnsDelete</a>
					<a href="javascript:goAnsUpdateForm()" class="butt">AnsUpdate</a>
<%					} 
				}	
%>


				<a href="qanda_list.jsp" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>	
	</div>	
</body>
</html>






