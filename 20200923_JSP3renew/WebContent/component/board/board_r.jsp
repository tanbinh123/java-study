<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*"%>
<%
request.setCharacterEncoding("utf-8");
Board_dao dao = new Board_dao();

dao.SetBoardGubun(whoamiPage);

String sort = request.getParameter("t_sort");
String title = request.getParameter("sel_box");
String search = request.getParameter("sel_text");

if (title == null) {
	title = "title";
	search = "";
	sort = "no";
} else if (search == null) {
	search = "";
}
ArrayList<Board_dto> arr = dao.getBoardList(title, search, sort);
%> 



  <!DOCTYPE html>
  <html lang="ko">
    <head>
      <meta charset="utf-8" />
      <title>JSL 방문을 환영합니다</title>
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <link
        rel="stylesheet"
        type="text/css"
        href="/css/font-awesome.min.css"
      />
      <link rel="stylesheet" type="text/css" href="/css/reset.css" />
      <link rel="stylesheet" type="text/css" href="/css/base.css" />
      <link rel="stylesheet" href="/css/common.css" />
      <link rel="stylesheet" href="/css/menu.css" />
      <link rel="stylesheet" href="/css/n_r.css" />

      <!-- <link href="../css/font-awesome.min.css" rel="stylesheet">  -->
      <!-- <script type="text/javascript" src="../js/jquery-1.8.1.min.js"></script> -->
      <link
        rel="stylesheet"
        href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
        integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
        crossorigin="anonymous"
      />
      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      
      



      <!--menu drop down-->
      <script type="text/javascript">
        <%@ include file="/js/common.js"%>
      </script>

      <script type="text/javascript">
	function search() {

		searchForm.method = "get";
		searchForm.action = "/component/<%=whoamiPage%>/<%=whoamiPage%>_r.jsp";
		searchForm.submit();
	}

	function goView(t_no) {
		view.t_no.value = t_no;
		view.method = "post";
		view.action = "/component/<%=whoamiPage%>/<%=whoamiPage%>_v.jsp";
		view.submit();
	}
</script>
    </head>
    <body>
      <div id="container">
        <!--header-->
        <%@ include file="/component/rayout/header.jsp"%> <%@ includefile="/component/rayout/menu.jsp"%>
        <div id="content">
          <%@ include file="/component/rayout/content_home_btn.jsp"%>
        <form name="searchForm">
				<p class="select_Box">
					<select class="sel_box" name="sel_box">
						<option value="title"
							<%if (title.equals("title"))out.print("selected");%>>제목</option>
						<option value="content"
							<%if (title.equals("content"))out.print("selected");%>>내용</option>
					</select> <input type="text" maxlength="20" class="sel_text"
						value="<%=search%>" name="sel_text" /> 
						<input type="radio" name="t_sort" value="no" <%if (sort.equals("no"))out.print("checked");%>>번호순
						<input type="radio" name="t_sort" value="reg_date" <%if (sort.equals("reg_date"))out.print("checked");%>>등록일순
						<input type="button" value="검&nbsp;&nbsp;색" class="sel_button" onclick="search()">
				</p>
			</form>
          <div class="bord_list">
            <table class="bord_table">
              <colgroup>
                <col width="10%" />
                <col width="*" />
                <col width="10%" />
                <col width="15%" />
                <col width="10%" />
              </colgroup>
              <thead>
                <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>글쓴이</th>
                  <th>작성일</th>
                  <th>조회수</th>
                </tr>
              </thead>
              <form name="view">
              <input type="hidden" name="t_no" />
						<tbody>
							<%for(int i = 0 ; i < arr.size(); i++){%>
							<tr>
								<td><%=arr.get(i).getNo()%></td>
								<td class="title"><a href="javascript:goView('<%=arr.get(i).getNo()%>')"><%=arr.get(i).getTitle()%></a></td>
								<td><%=arr.get(i).getReg_name()%></td>
								<td><%=arr.get(i).getReg_date()%></td>
								<td><%=arr.get(i).getHit()%></td>
							</tr>
							<%}%>
						</tbody>
					</form>
            </table>
            <div class="paging">
              <a href=""><i class="fa fa-angle-double-left"></i></a>
              <a href=""><i class="fa fa-angle-left"></i></a>
              <a href="" class="active">1</a>
              <a href="">2</a>
              <a href="">3</a>
              <a href="">4</a>
              <a href="">5</a>
              <a href=""><i class="fa fa-angle-right"></i></a>
              <a href=""><i class="fa fa-angle-double-right"></i></a>
              <a href="/component/<%=whoamiPage%>/<%=whoamiPage%>_w.jsp" class="btn_write">글쓰기</a>
            </div>
          </div>
        </div>
        <%@ include file="/component/rayout/footer.jsp"%>
      </div>
    </body>
  </html>
</Notice_dto>
