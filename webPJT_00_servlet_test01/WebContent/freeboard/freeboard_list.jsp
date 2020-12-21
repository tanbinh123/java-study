<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dto.*, java.util.*, common.*" %>
<%@ include file="/common/common_subpage_head.jsp" %>
<%
	ArrayList<Freeboard_dto> arr = (ArrayList<Freeboard_dto>)request.getAttribute("t_arr");
	String select = (String)request.getAttribute("t_select");
	String search = (String)request.getAttribute("t_search");
	
	int total_count 	= (int)request.getAttribute("total_count");
	int v_count 		= (int)request.getAttribute("v_count");
	int for_count 		= (int)request.getAttribute("for_count");
	int a_count 		= (int)request.getAttribute("a_count");
	int current_page 	= (int)request.getAttribute("current_page");
	int total_page 		= (int)request.getAttribute("total_page");
/*
	request.setCharacterEncoding("utf-8");
	News_dao dao = new News_dao();
	
	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");
	if(select == null){
		select = "title";
		search = "";
	}
	ArrayList<News_dto> arr = dao.saveNewsList(select, search);
*/	


%>
<style type="text/css">
	a { color : #000; } 
	a:hover { color : #f00; }
</style>
<script>
	function goView(nn){
		free.t_no.value = nn;
		free.method = "post";
		free.action = "/Freeboard";
		free.submit();		
	}
	function goSearch(){
		//alert("1234");
		sacyu.method="post";
//		sacyu.action="news_list.jsp";
		sacyu.action="/Freeboard";
		sacyu.submit();
	}
	function goPage(pageNumber){
		pageForm.r_page.value= pageNumber;
		pageForm.method="post";
		pageForm.action="/Freeboard";
		pageForm.submit();
	}
	function goWrite(){
		free.t_gubun.value = "write";
		free.method="post";
		free.action="/Freeboard";
		free.submit();
	}
</script>
	<form name="pageForm">
		<input type="hidden" name="r_page">
		<input type="hidden" name="t_select" value="<%=select%>">  
		<input type="hidden" name="t_search" value="<%=search%>">
	</form>
	<form name="free">
		<input type="hidden" name="t_no">
		<input type="hidden" name="t_gubun" value="view">
	</form>
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/Notice"> NOTICE</a></li>
				<li><a href="/News"> NEWS</a></li>
				<li><a href="/Qna">Q & A</a></li>
				<li><a href="/Freeboard"><span class="fnt"><i class="fas fa-apple-alt"></i></span>FREE BOARD</a></li>
				<li><a href="/Etc">ETC</a></li>
			</ul>
		</div>
			<div id="b_right">
				<p class="n_title">
					FREEBOARD
				</p>
				<form name="sacyu">
					<p class="leftBox">총 게시글 : <%=arr.size() %>건</p>
					<p class="select_box">
					
						<select class="sel_box" name="t_select">
							<option value="title" <%if(select.equals("title")) out.print("selected"); %>>Title</option>
							<option value="content" <%if(select.equals("content")) out.print("selected"); %>>Content</option>
						</select>
						<input type="text" name="t_search" value="<%=search %>" class="sel_text">
				<button type="submit" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
				</form>
			</p>
			
			<table class="boardList">
				<colgroup>
					<col width="8%">
					<col width="60%">
					<col width="10%">
					<col width="14%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
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
							<td><a href="javascript:goView('<%=arr.get(k).getNo()%>')"><%=arr.get(k).getNo() %></a></td>
							<td class="t_center"><a href="javascript:goView('<%=arr.get(k).getNo()%>')"><%=arr.get(k).getTitle() %></a></td>
							<td><%=arr.get(k).getReg_id() %></td>
							<td><%=arr.get(k).getReg_date() %></td>
							<td><%=arr.get(k).getHit() %></td>
						</tr>	
					<%
					v_count = v_count + 1;
					for_count = for_count + 1;
					}else { 
						v_count = v_count + 1;
					}
					if(v_count == a_count) break; 
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
<%				out.println(CommonUtil.pageListPost(current_page, total_page, 3));		
				if(!session_id.equals("")) { %>
					<a href="javascript:goWrite()" class="write">글쓰기</a>
					<%} %>
			</div>
		</div>	
	
<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>