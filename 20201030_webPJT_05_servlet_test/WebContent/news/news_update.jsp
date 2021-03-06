<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*" %>
<%@ include file="/common/session_manager_check.jsp" %>    
<%
	News_dao dao = new News_dao();
	String no = request.getParameter("t_no"); 
	News_dto dto = dao.getNewsView(no);
%>    
<%@ include file="/common/common_subpage_head.jsp"%>
<script type="text/javascript">
	function goUpdate(){
		if(!checkEmpty(noti.t_title," 제목 입력! ")) return;
		if(!checkEmpty(noti.t_content," 내용 입력! ")) return;
		if(!checkEmpty(noti.t_reg_date," 수정일 입력! ")) return;
		
		if(noti.t_s_date.value > noti.t_e_date.value){
			alert("시작일은 종료일보다 늦을 수 없습니다!");
			noti.t_s_date.focus();
			return;
		}else if(noti.t_title.value.length > 50){
			noti.t_title.value = "";
			alert("제목은 50자 이내로 입력해주세요!")
			noti.t_title.focus();
			return;
		}else{
			noti.method="post";
			//noti.action="db_notice.jsp";
			noti.action="db_news.jsp";
			noti.submit();
		}
		
	}
</script>
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/notice/notice_list.jsp"> NOTICE</a></li>
				<li><a href="/news/news_list.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span>News</a></li>
				<li><a href="/qanda/qanda_list.jsp">Q & A</a></li>
				<li><a href="/freeboard/freeboard_list.jsp">Free Board</a></li>
				<li><a href="/event/event_list.jsp">Etc</a></li>
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
				<form name="noti">
					<input type="hidden" name="t_work_gubun" value="update">
					<input type="hidden" name="t_no" value="<%=no%>">
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3"><input type="text" name="t_title" class="input600" value="<%=dto.getTitle()%>"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea  name="t_content" class="textArea_H250"><%=dto.getContent()%></textarea></td>
					</tr>		
					<tr>
						<th>Writer</th>
						<td><%=session_name%>
							<input type="hidden" name="t_reg_name" value="<%=session_name%>" class="input100">
						</td>						
						<th>RegDate</th>
						<td><input type="date" name="t_reg_date" value="<%=dto.getReg_date()%>" class="input130"></td>
					</tr>	

				</tbody>
			</form>	
			</table>
			<div class="buttonGroup">
				
				<a href="javascript:goUpdate()" class="butt">Update</a>
				<a href="news_list.jsp" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>	>	
	</div>	
</body>
</html>






