<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8" />
    <title>JSL 방문을 환영합니다</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!-- <link href="../css/font-awesome.min.css" rel="stylesheet"> -->
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
      integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" type="text/css" href="../css/reset.css" />
    <link rel="stylesheet" type="text/css" href="../css/base.css" />
    <link rel="stylesheet" href="../css/common.css" />
    <link rel="stylesheet" href="../css/menu.css" />
    <link rel="stylesheet" href="../css/n_w.css" />
    <script type="text/javascript" src="../js/jquery-1.8.1.min.js"></script>
    <!--menu drop down-->
    <script type="text/javascript">
      <%@ include file="../js/common.js"%>
    </script>
  </head>
  <body>
    <div id="container">
      <%@ include file="header.jsp"%> <%@ include file="menu.jsp"%>
      <div id="content">
        <%@ include file="content_home_btn.jsp"%>
        <div class="bord_list">
          <table class="bord_table">
            <colgroup>
              <col width="10%" />
              <col width="*" />
            </colgroup>
            <tbody>
              <tr>
                <th>작성자</th>
                <td>홍길동</td>
              </tr>
              <tr>
                <th>제 목</th>
                <td><input type="text" class="t_title" maxlength="30" /></td>
              </tr>
              <tr>
                <th>내 용</th>
                <td>
                  <textarea
                    name="t_contents"
                    class="board_textarea_H270"
                  ></textarea>
                </td>
              </tr>
            </tbody>
          </table>
          <div class="paging">
            <a href="notice_r.jsp" class="btn_write">목 록</a>
            <a href="notice_t.jsp" class="btn_write">등 록</a>
          </div>
        </div>
      </div>
      <%@ include file="footer.jsp"%>
    </div>
  </body>
</html>
