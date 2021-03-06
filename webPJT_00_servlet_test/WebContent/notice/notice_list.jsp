<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*,common.*"%>    
<%
	ArrayList<Notice_dto> arr = (ArrayList<Notice_dto>)request.getAttribute("t_arr");
	String select 	= (String)request.getAttribute("t_select");
	String search 	= (String)request.getAttribute("t_search");
	int total_count = (int)request.getAttribute("total_count");
	int v_count 	= (int)request.getAttribute("v_count");
	int for_count 	= (int)request.getAttribute("for_count");
	int a_count 	= (int)request.getAttribute("a_count");
	int current_page= (int)request.getAttribute("current_page");
	int total_page 	= (int)request.getAttribute("total_page");

%>    
<%@ include file="/common/common_subpage_head.jsp"%>
<script type="text/javascript">
	function goWrite(){
		notiView.t_gubun.value="write";
		notiView.method = "post";
		notiView.action = "/Notice";
		notiView.submit();		
	}
	
	function goSearch(){
		noti.method="post";
		noti.action="/Notice";
		noti.submit();
	}
	function goView(num){
		notiView.t_no.value = num;
		notiView.method ="post";
		notiView.action ="/Notice";
		notiView.submit();
	}
	function goPage(pageNumber){
		pageForm.r_page.value = pageNumber;
		pageForm.method="post";
		pageForm.action="/Notice";
		pageForm.submit();
	}
</script>
		<form name="pageForm">
			<input type="hidden" name="r_page">
			<input type="hidden" name="t_select" value="<%=select%>">
			<input type="hidden" name="t_search" value="<%=search%>">
		</form>
		<form name="notiView">
			<input type="hidden" name="t_no">
			<input type="hidden" name="t_gubun" value="view">
		</form>
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/Notice"><span class="fnt"><i class="fas fa-apple-alt"></i></span> NOTICE</a></li>
				<li><a href="/News"> News</a></li>
				<li><a href="/Qna">Q & A</a></li>
				<li><a href="/Freeboard">Free Board</a></li>
				<li><a href="/Etc">Etc</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			<form name="noti">
				<div> 
					<p class="leftBox">???????????? : <%=arr.size()%> ???</p>			
					<p class="select_box">
						<select name="t_select" class="sel_box">
							<option value="title" <%if(select.equals("title")) out.print("selected");%>>Title</option>
							<option value="content" <%if(select.equals("content")) out.print("selected");%> >Content</option>
						</select>
						<input name="t_search" type="text" class="sel_text" value="<%=search%>">
						<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
					</p>
				</div>
			</form>
			<table class="boardList">
				<colgroup>
					<col width="8%">
					<col width="57%">
					<col width="5%">
					<col width="10%">
					<col width="14%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Attach</th>
						<th>Reg Name</th>
						<th>Reg Date</th>
						<th>Hit</th>
					</tr>
				</thead>
				<tbody>
<%	if ( total_count > 0 ){
		for(int k = 0 ; k < total_count ; k++ )	{
			if(v_count == for_count){ 
%>			
					<tr>
						<td><a href="javascript:goView('<%=arr.get(k).getNo()%>')"><%=arr.get(k).getNo()%></a></td>
						<td class="t_center">
<a href="javascript:goView('<%=arr.get(k).getNo()%>')">
<%
/*
	int titleLength = arr.get(k).getTitle().length();
	String title = arr.get(k).getTitle();
	if(titleLength > 30){
		String tit = title.substring(0,30);
		out.print(tit+"...");
	} else {
		out.print(title);
	}
*/
	if(arr.get(k).getTitle().length() > 30)	out.print(arr.get(k).getTitle().substring(0,30)+"...");
	else out.print(arr.get(k).getTitle());
	
%>
</a>
						</td>
						<td>
						<%  if(arr.get(k).getAttach() != null) { %>
							<img src="../images/clip.png">
						<%  } %>	
						</td>
						<td><%=arr.get(k).getReg_name()%></td>
						<td><%=arr.get(k).getReg_date()%></td>
						<td><%=arr.get(k).getHit()%></td>
					</tr>	
<%
				v_count = v_count + 1;
				for_count = for_count + 1;
			}else { 
				v_count = v_count + 1;
			}
			if(v_count == a_count)break; 
		}
	}
%>
				</tbody>
			</table>
			
			<div class="paging">
<!-- 			
				<a href=""><i class="fa fa-angle-double-left"></i></a>
				<a href=""><i class="fa fa-angle-left"></i></a>
				<a href="" class="active">1</a>
				<a href="">2</a>
				<a href="">3</a>
				<a href="">4</a>
				<a href="">5</a>
				<a href=""><i class="fa fa-angle-right"></i></a>
				<a href=""><i class="fa fa-angle-double-right"></i></a>
 -->
 
<%
				out.println(CommonUtil.pageListPost(current_page, total_page, 2));			
 			
				if(session_level.equals("top")){ %>				
				<a href="javascript:goWrite()" class="write">?????????</a>
<%				} %>				
				
				
			</div>
		</div>	
<%@ include file="/common/common_subpage_bottom.jsp" %>	

	</div>	
</body>
</html>






