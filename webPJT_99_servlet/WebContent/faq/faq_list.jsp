<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*,common.*"%>  
<% 
	request.setCharacterEncoding("utf-8");
	Faq_dao dao = new Faq_dao();
	
	ArrayList<Faq_dto> arr = (ArrayList<Faq_dto>)request.getAttribute("t_dtos");
	String select = (String)request.getAttribute("t_select");
	String search = (String)request.getAttribute("t_search");
	
	
		int v_count 	= (int)request.getAttribute("v_count");
		int for_count 	= (int)request.getAttribute("for_count");
		int a_count 	= (int)request.getAttribute("a_count");
		int current_page = (int)request.getAttribute("current_page");
		int total_page 	= (int)request.getAttribute("total_page");
		
		int searchCount = arr.size();
		String searchCountString = "0";
		
		if(request.getParameter("t_searchCount") != null){ 
			searchCountString = request.getParameter("t_searchCount");
			searchCount = Integer.parseInt(searchCountString);
		}

		
%>
<%@ include file="/common_head.jsp" %>
<style>
.que{
	border: 1px solid gray;
	width: 100%;
	cursor: pointer;
	margin-bottom: 2px;
	background-color: #eff2fb;
}
.ans{
	//border: 1px solid gray;
	width: 100%;
	display: none;
}
.que span{
	display: inline-block;
	padding: 10px 0;
}
.que span:not(.s_que){
	text-align: center;
}
.s_no{width: 10%;}
.s_que{width: 50%;}
.s_name{width: 10%;}
.s_date{width: 10%;}
.s_hit{width: 8%;}

.textarea_H100_noBorder{
width: 100%;
height: 100px;
text-align: left;
font-size: 18px;
padding: 5px;
}
</style>

<script type="text/javascript">
$(function() {

    $(".que").on("click", function() {


        $(this).next().slideToggle("fast");

    });

});
</script>

<script type="text/javascript">
	function formSearch(){
		notiForm.method="post";
		notiForm.action="/FaqList";
		notiForm.submit();
	}
	function goView(no){
		view.t_no.value= no;
		view.method="post";
		view.action="/FaqView";
		view.submit();
	}
	function goPage(pageNumber){
		notiForm.r_page.value = pageNumber;
		notiForm.method="post";
		notiForm.action="/FaqList";
		notiForm.submit();
	}
</script>
		<!--  header end -->
		<!-- sub page start -->
		<form name="view">
			<input type="hidden" name="t_no">
		</form>
		<div class="notice">
			<div class="sub-notice">
				<h2><a href="/NoticeList"> NOTICE</a></h2>	
				<h2 ><a href="NewsList"> NEWS</a></h2>	
				<h2><a href="QnaList"> QnA</a></h2>
				<h2 class="color"><a href="FaqList"><i class="fas fa-check"></i> FAQ</a></h2>	
			</div>

		<div class="search_wrap">
			<div class="record_group">
				<p>* ???????????? : <span><%=arr.size()%></span>???</p>
			</div>
			<form name="notiForm">
			<input type="hidden" name="r_page">
			<input name="t_searchCount" type="hidden" value="<%=searchCount%>">
			<div class="search_group">
				<select name="t_select" class="select">
					<option value="question" <%if(select.equals("question")) out.print("selected");%>>??????</option>
					<option value="answer" <%if(select.equals("answer")) out.print("selected");%>>??????</option>
				</select>
				<input type="text" name="t_search" class="search_word" value="<%=search%>">
				<button class="btn_search" onclick="formSearch()"><i class="fa fa-search"></i><span class="sr-only">????????????</span></button>
			</div>
			</form>
		</div>



			
			<!-- table start-->
			<div class="table-box">
<%				if(arr.size() > 0){
					for(int i = 0 ; i < arr.size(); i++ ){ 
						if(v_count == for_count){%>
					<div class="que">
					<span class="s_no"><%=arr.get(i).getNo() %></span>
					<span class="s_que"><%=arr.get(i).getQuestion() %></span>
					<%if(sessionLevel.equals("top")){%>
							<a href="/FaqUpdateForm?t_no=<%=arr.get(i).getNo()%>">??????</a> <a href = "/DBFaq?t_no=<%=arr.get(i).getNo()%>&t_pageGubun=??????">??????</a>
							<%} %>
					<span class="s_name"><%=arr.get(i).getReg_id() %></span>
					<span class="s_date"><%=arr.get(i).getReg_date()%></span>
					<span class="s_hit"><%=arr.get(i).getHit() %></span>
					
					</div>
					<div class="ans">
						<textarea rows="" cols="" class="textarea_H100_noBorder"><%=arr.get(i).getAnswer() %></textarea>
					</div>
<%						v_count++;
						for_count++;
				} else{
					v_count++;
				}if(v_count == a_count)break;
			}} %>
			</div>
			
			
			
			
			<div class="page-number">
				<div class="page-number">
				<!-- 	<a href="#" class="icon"><i class="fas fa-arrow-circle-left fa-lg"></i></a>
					<a href="#" class="on">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<a href="#">5</a>
					<a href="#">6</a>
					<a href="#">7</a>
					<a href="#">8</a>
					<a href="#">9</a>
					<a href="#" class="more">???</a>
					<a href="#" class="icon"><i class="fas fa-arrow-circle-right fa-lg"></i></a>
					<a href="/news/news_write.jsp" class="btn-write">?????????</a>
		 -->
		 <%
					out.println(CommonUtil.pageListPostCSS(current_page, total_page,5));	
	%>
				<%if(sessionLevel.equals("top")){%>
					<a href="/FaqWriteForm" class="btn-write">?????????</a>
				<%} %>
		 		</div>				
			</div>
		
		</div>
		
		
		
		<!--  footer start  -->
		<div id="footer">
			<div class="footer-text">
				<ul class="sub-logo">
					<li><a href="index.html" alt="????????????">JSL ???????????????</a></li>
				</ul>
				
				<ul class="copy">
					<li>Copyright ??? EL WIDE. All Rights Reserved.</li>
				</ul>
			</div>
		</div>
		</div>
	
	
	
	</body>
</html>









    