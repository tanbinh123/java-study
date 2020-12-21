<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "dao.*, dto.*, java.util.*,common.*" %>  
<%
	ArrayList<Qanda_dto> arr = (ArrayList<Qanda_dto>)request.getAttribute("t_arr");
	
	String select = (String)request.getAttribute("t_select");
	String search = (String)request.getAttribute("t_search");

	int total_count 	= (int)request.getAttribute("total_count");
	int v_count 		= (int)request.getAttribute("v_count");
	int for_count 		= (int)request.getAttribute("for_count");
	int a_count 		= (int)request.getAttribute("a_count");
	int current_page 	= (int)request.getAttribute("current_page");
	int total_page 		= (int)request.getAttribute("total_page");
%> 
<script>
	function goSearch(){
		qna.method="post";
		qna.action="/Qna";
		qna.submit();
	}
	function goView(num){
		qnaView.t_no.value = num;
		qnaView.t_gubun.value = "view";
		qnaView.method = "post";
		qnaView.action = "/Qna";
		qnaView.submit();
	}
	function goPage(pageNumber){
		pageForm.r_page.value = pageNumber; 
		pageForm.method="post";
		pageForm.action="/Qna";
		pageForm.submit();
	}
	function goWrite(){
		qnaView.t_gubun.value = "write";
		qnaView.method = "post";
		qnaView.action = "/Qna";
		qnaView.submit();
	}
</script>   
<%@ include file="/common/common_subpage_head.jsp" %>	<!-- include 파일 소환, common_subpage_head에 있는 소스 전체를 그대로 가져온다 -->
		<form name = "pageForm">
			<input type="hidden" name ="r_page">
			<input type="hidden" name="t_select" value="<%=select%>">  
			<input type="hidden" name="t_search" value="<%=search%>">
		</form>
		<form name = "qnaView">
			<input type ="hidden" name="t_no">
			<input type ="hidden" name="t_gubun">
		</form>
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
			<form name ="qna">
				<div>
					<p class="leftBox">총게시글 : <%=arr.size() %> 건 </p>
					<p class="select_box">
						<select name="t_select" class="sel_box">
							<option value="title" <%if(select.equals("title")) out.print("selected");%>>Title</option>
							<option value="content"<%if(select.equals("content")) out.print("selected");%>>Content</option>
						</select>
						<input name="t_search" type="text" class="sel_text" value="<%=search%>">
						<button type="button" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
					</p>
				</div>
			</form>
			
			<table class="boardList">
				<colgroup>
					<col width="10%">
					<col width="50%">
					<col width="10%">
					<col width="10%">
					<col width="14%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Answer</th>
						<th>Reg Name</th>
						<th>Reg Date</th>
						<th>Hit</th>
					</tr>
				</thead>
				<tbody>
<%				if ( total_count > 0 ){
					for(int k = 0 ; k < total_count ; k++ )	{
						if(v_count == for_count){ 
%> 	
					<tr>
						<td><a href="javascript:goView('<%=arr.get(k).getNo() %>')"><%=arr.get(k).getNo() %></a></td>
						<td class="t_center">
						<a href="javascript:goView('<%=arr.get(k).getNo() %>')">
<%
						int titleLength = arr.get(k).getTitle().length();
%>
						<%=arr.get(k).getTitle() %></a></td>
						<td>
							<% if(arr.get(k).getAnswer() != null) {%>
								답변완료
							<%	} %>	
						</td>
						<td><%=arr.get(k).getQ_reg_name() %></td>
						<td><%=arr.get(k).getQ_reg_date() %></td>
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
<% 				out.println(CommonUtil.pageListPost(current_page, total_page, 5));
				if(!session_id.equals("")) {%>				
				<a href="javascript:goWrite()" class="write">질문하기</a>
<%       		} %>				
			</div>
		</div>	
<%@ include file ="/common/common_subpage_bottom.jsp" %> 

	</div>	
</body>
</html>