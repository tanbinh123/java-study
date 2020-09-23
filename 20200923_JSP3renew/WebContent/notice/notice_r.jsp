<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html lang="ko">
    <head>
      <meta charset="utf-8" />
      <title>JSL 방문을 환영합니다</title>
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <link
        rel="stylesheet"
        type="text/css"
        href="../css/font-awesome.min.css"
      />
      <link rel="stylesheet" type="text/css" href="../css/reset.css" />
      <link rel="stylesheet" type="text/css" href="../css/base.css" />
      <link rel="stylesheet" href="../css/common.css" />
      <link rel="stylesheet" href="../css/menu.css" />
      <link rel="stylesheet" href="../css/n_r.css" />

      <!-- <link href="../css/font-awesome.min.css" rel="stylesheet">  -->
      <!-- <script type="text/javascript" src="../js/jquery-1.8.1.min.js"></script> -->
      <link
        rel="stylesheet"
        href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
        integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
        crossorigin="anonymous"
      />
      <!--menu drop down-->
      <script type="text/javascript">
        <%@ include file="../js/common.js"%>
      </script>
    </head>
    <body>
      <div id="container">
        <!--header-->
        <%@ include file="header.jsp"%> <%@ includefile="menu.jsp"%>
        <div id="content">
          <%@ include file="content_home_btn.jsp"%>
          <p class="select_Box">
            <select class="sel_box">
              <option value="제목">제목</option>
              <option value="제목">내용</option>
            </select>
            <input type="text" maxlength="20" class="sel_text" />
            <input type="button" value="검&nbsp;&nbsp;색" class="sel_button" />
          </p>

          <div class="bord_list">
            <table class="bord_table">
              <colgroup>
                <col width="10%" />
                <col width="*" />
                <col width="10%" />
                <col width="10%" />
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
              <tbody>
                <tr>
                  <td>10</td>
                  <td class="title">
                    <a href="notice_v.jsp">구매절차에 대하여 알고 싶어요</a>
                  </td>
                  <td>관리자</td>
                  <td>18-10-16</td>
                  <td>187</td>
                </tr>
              </tbody>
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
              <a href="notice_w.jsp" class="btn_write">글쓰기</a>
            </div>
          </div>
        </div>
        <%@ include file="footer.jsp"%>
      </div>
    </body>
  </html>
</Notice_dto>
