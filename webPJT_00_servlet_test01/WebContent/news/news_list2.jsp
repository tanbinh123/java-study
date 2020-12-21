<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dto.*, java.util.*,common.*" %>
<%@ include file="/common/common_subpage_head.jsp" %>
<%

	ArrayList<News_dto> arr = 
				(ArrayList<News_dto>)request.getAttribute("t_arr");
	String select 	= (String)request.getAttribute("t_select");
	String search 	= (String)request.getAttribute("t_search");
	int total_count = (int)request.getAttribute("total_count");
	int v_count 	= (int)request.getAttribute("v_count");
	int for_count 	= (int)request.getAttribute("for_count");
	int a_count 	= (int)request.getAttribute("a_count");
	int current_page= (int)request.getAttribute("current_page");
	int total_page 	= (int)request.getAttribute("total_page");
	/*
	request.setCharacterEncoding("utf-8");
	News_dao dao = new News_dao();
	
	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");
	if(select == null){
		select = "title";
		search = "";
	}
	ArrayList<News_dto> arr = dao.getNewsList(select, search);
	
	int	list_setup_count = 3;			// 한 페이지에 출력될 List 수
	String r_page = request.getParameter("r_page");
	if(r_page==null) r_page= "";
	int			current_page;					// 현재페이지 번호
	int			total_page;						// 총페이지 수
	int			total_count;					// 총레코드 수
	int			for_count;						
	int			p_no;
	int			v_count;
	int			a_count;
	String		url				= null;	

	// 조회된 건수 구하기  total_count : 설정
	if(arr == null) total_count =0;
	else total_count = arr.size(); 


	// 페이지번호가 없으면 1페이지로 간주
	if(r_page.equals("")) current_page = 1;
	else current_page = Integer.parseInt(r_page);
		
	for_count		= list_setup_count;
	p_no			= list_setup_count;				// 페이지수가 10
	total_page = total_count / list_setup_count;		// 전체페이지수 계산 (if 23개 게시물이면 2)
   
	if(current_page == 1) {
		v_count		= 0;
		a_count		= list_setup_count;
		for_count	= 0;
	} else{
		v_count		= 0;
		a_count		= p_no * current_page;
		for_count	= a_count - list_setup_count;
	}
	if(total_page * list_setup_count != total_count)   total_page = total_page +1;
*/
//*************page 끝**************/	
%>
<style type="text/css">
	a { color : #000; } 
	a:hover { color : #f00; }
</style>
<script>
	function goWrite(){
		news.t_gubun.value="write";
		news.method = "post";
		news.action = "/News";
		news.submit();		
	}
	function goView(nn){
		//alert("1234");
		news.t_no.value = nn;
		news.method = "post";
		news.action = "/News";
		news.submit();		
	}
	function goSearch(){
		//alert("1234");
		sacyu.method="post";
//		sacyu.action="news_list.jsp";
		sacyu.action="/News";
		sacyu.submit();
	}
	function goPage(pageNumber){
		pageForm.r_page.value= pageNumber;
		pageForm.method="post";
		pageForm.action="/News";
		pageForm.submit();
	}
</script>
	<form name="pageForm">
		<input type="hidden" name="r_page">
		<input type="hidden" name="t_select" value="<%=select%>">  
		<input type="hidden" name="t_search" value="<%=search%>">
	</form>
	<form name="news">
		<input type="hidden" name="t_no">
		<input type="hidden" name="t_gubun" value="view">
	</form>
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/Notice">NOTICE</a></li>
				<li><a href="/News"><span class="fnt"><i class="fas fa-apple-alt"></i></span> News</a></li>
				<li><a href="/Qna">Q & A</a></li>
				<li><a href="/Freeboard">Free Board</a></li>
				<li><a href="/Etc">Etc</a></li>
			</ul>
		</div>
			<div id="b_right">
				<p class="n_title">
					NEWS
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
						<td><%=arr.get(k).getReg_name() %></td>
						<td><%=arr.get(k).getReg_date() %></td>
						<td><%=arr.get(k).getHit() %></td>
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
				if(session_level.equals("top")) { %>
					<a href="javascript:goWrite()" class="write">글쓰기</a>
				<%} %>
			</div>
		</div>	
	
<%@ include file="/common/common_subpage_bottom.jsp" %>
	</div>	
</body>
</html>