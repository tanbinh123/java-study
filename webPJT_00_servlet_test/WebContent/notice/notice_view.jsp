<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*" %>    
<%
	Notice_dao dao = new Notice_dao();
	String no = request.getParameter("t_no");
	dao.setHitCount(no);
	Notice_dto dto = dao.getNoticeView(no);

%>
<%@ include file="/common/common_subpage_head.jsp"%>
<script>
	function goUpdateForm(){
		noti.t_gubun.value="updateForm";
		noti.method="post";
		noti.action="/Notice";
		noti.submit();
	}
	function goDelete(){
		if(confirm(" 증말 삭제 ? ")){
			noti.t_gubun.value="delete";
			noti.method="post";
//			noti.action="db_notice.jsp";
			noti.action="/Notice";
			noti.submit();		
		}
	}
</script> 	
		<form name="noti">
			<input type="hidden" name="t_no" value="<%=no%>">
			<input type="text" name="t_attach" value="<%=CommonUtil.checkNull(dto.getAttach())%>">
			<input type="hidden" name="t_gubun">
		</form>
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/Notice"><span class="fnt"><i class="fas fa-apple-alt"></i></span> NOTICE</a></li>
				<li><a href="/News">News</a></li>
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
						<th>Attach</th>
						<td colspan="3">
						<%  if(dto.getAttach() != null){ %>
<a href="/common/filedown.jsp?t_file=<%=dto.getAttach()%>&t_gubun=notice"><%=dto.getAttach()%></a>
						<%  } %>	
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
			<%  if(session_level.equals("top")){ %>
				<a href="javascript:goDelete()" class="butt">Delete</a>
				<a href="javascript:goUpdateForm()" class="butt">Update</a>
			<%  } %>
				<a href="/Notice" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>	
	</div>	
</body>
</html>






