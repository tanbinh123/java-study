<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*,java.util.*,common.*" %>    
<%
	ArrayList<Qanda_dto> dtos = (ArrayList<Qanda_dto>)request.getAttribute("t_dtos");
	String select = (String)request.getAttribute("t_select");
	String search = (String)request.getAttribute("t_search");
	
	//*************page 시작**************/
	int	list_setup_count = 10;			// 한페이지에 출력될 List 수 

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
	if(dtos == null) total_count =0;
	else total_count = dtos.size(); 

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
		a_count		= p_no * current_page; // 2 * 2 = 4
		for_count	= a_count - list_setup_count; // 4-2 = 2
	}
	if(total_page * list_setup_count != total_count)   total_page = total_page +1;
//*************page 끝**************/		
	
%>    
    
<%@ include file="/common_head.jsp" %>
<script type="text/javascript">
	function goSearch(){
		qnaForm.method="post";
		qnaForm.action="/QnaList";
		qnaForm.submit();
	}
	function goPage(no){
		qnaForm.r_page.value =no;
		qnaForm.method="post";
		qnaForm.action="/QnaList";
		qnaForm.submit();		
	}
	function goView(no){
		viewForm.t_no.value = no;
		viewForm.method="post";
		viewForm.action="/QnaView";
		viewForm.submit();
	}
</script>
		<form name="viewForm">
			<input type="hidden" name="t_no">
		</form>
		<!--  header end -->
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
				<h2><a href="/NoticeList">NOTICE</a></h2>	
				<h2><a href="/News"> NEWS</a></h2>	
				<h2 class="color"><a href="/QnaList"><i class="fas fa-check"></i>  QnA</a></h2>
				<h2><a href="/FaqList"> FAQ</a></h2>	
			</div>

		<div class="search_wrap">
			<div class="record_group">
				<p>* 총게시글 : <span><%=dtos.size()%></span>건</p>
			</div>
			<form name="qnaForm">
			<input type="hidden" name="r_page">
			<div class="search_group">
				<select name="t_select" class="select">
					<option value="title" <%if(select.equals("title")) out.print("selected");%>>제목</option>
					<option value="content" <%if(select.equals("content")) out.print("selected");%>>내용</option>
				</select>
				<input type="text" name="t_search" value="<%=search%>" class="search_word">
				<button class="btn_search" onclick="goSearch()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</div>
			</form>
		</div>

			
			<!-- table start-->
			<div class="table-box">
				<table class="table">
					<colgroup>
						<col width="5%">
						<col width="*">
						<col width="10%">
						<col width="10%">
						<col width="10%">
						<col width="10%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">질 문</th>
							<th scope="col">등록자</th>
							<th scope="col">답변</th>
							<th scope="col">등록일</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody>
<%	if ( total_count > 0 ){
		for(int k = 0 ; k < total_count ; k++ )	{
			if(v_count == for_count){ 
%>					
						<tr>
							<td><%=dtos.get(k).getNo()%></td>
							<td class="txt"><a href="javascript:goView('<%=dtos.get(k).getNo()%>')"><%=dtos.get(k).getTitle()%></a></td>
							<td><%=dtos.get(k).getQ_reg_name()%></td>
							<td>
<%								if(dtos.get(k).getAnswer()==null) out.print("-");
								else out.print("답변완료");
%>								
							</td>
							<td><%=dtos.get(k).getQ_reg_date()%></td>
							<td><%=dtos.get(k).getHit()%></td>
						</tr>
<%
				v_count = v_count + 1;
				for_count = for_count + 1;
			} else { 
				v_count = v_count + 1;
			}
			if(v_count == a_count) break; 
		}
	}
%>						
					</tbody>
				</table>
			</div>
			
			<div class="page-number">
				<div class="page-number">
<%				
out.println(CommonUtil.pageListPost(current_page, total_page, 2));

%>
<!-- 
<a href='' class='on'>[1]</a>
<a href=javascript:goPage(2)><font color=#666699>[2]</font></a>
<a href=javascript:goPage(3)><i class='fa fa-angle-double-right'></i></a>
 -->
<!-- 
					<a href="#" class="icon"><i class="fas fa-arrow-circle-left fa-lg"></i></a>
					<a href="#" class="on">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<a href="#">5</a>
					<a href="#">6</a>
					<a href="#">7</a>
					<a href="#">8</a>
					<a href="#">9</a>
					<a href="#" class="more">…</a>
					<a href="#" class="icon"><i class="fas fa-arrow-circle-right fa-lg"></i></a>
-->
<%					if(!session_name.equals("")){ %>
						<a href="/QnaWrite" class="btn-write">질문등록</a>
<%					} else {%>
						[로그인 후 질문등록 가능합니다.]					
<%					} %>					
				</div>				
			</div>
		
		</div>
		
		
		
		<!--  footer start  -->
		<div id="footer">
			<div class="footer-text">
				<ul class="sub-logo">
					<li><a href="index.html" alt="서브로고">JSL 인재개발원</a></li>
				</ul>
				
				<ul class="copy">
					<li>Copyright ⓒ EL WIDE. All Rights Reserved.</li>
				</ul>
			</div>
		</div>
		</div>
	
	
	
	</body>
</html>









    