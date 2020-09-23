<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>JSL 방문을 환영합니다</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link href="../css/font-awesome.min.css" rel="stylesheet"> -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
<link rel="stylesheet" type="text/css" href="../css/reset.css" />
<link rel="stylesheet" type="text/css" href="../css/base.css" /> 
<link rel="stylesheet" href="../css/menu.css" />
<link rel="stylesheet" href="../css/common.css" />
<link rel="stylesheet" href="../css/n_v.css" />
<script type="text/javascript" src="../js/jquery-1.8.1.min.js"></script>
<!--menu drop down-->
<script type="text/javascript">
	<%@ include file="../js/common.js"%>
  </script>
</head>
<body>
    <div id="container">
		<%@ include file="header.jsp"%> <%@ includefile="menu.jsp"%>
      <div id="content">
		<%@ include file="content_home_btn.jsp"%>		
			
	  <div class="bord_list">
		<table class="bord_table">
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="20%">
			</colgroup>
			<tbody>
				<tr>
					<th>제 목</th>
					<td>구매절차에 대하여 알고 싶어요</td>
					<td><i class="fa fa-eye"> 조회수 : 56</td>
				</tr>
				<tr>
					<th>내 용</th>
					<td colspan="2">
						<textarea class="board_textarea_H270_noBorder" readonly>
내부 객체는 JSP페이지 내에서 특정한 변수로 호출하고자 하는 변수와 메소드로 접근을 한다. JSP페이지에서 사용하게 되는 특정한 변수가 아무런 선언과 객체 생성없이 사용할 수 있는 이유는 JSP페이지가 서블릿으로 변환이 될 때 JSP 컨테이너가 자동적으로 제공을 하기 때문이다.						
						</textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="paging">
			<a href="notice_r.jsp" class="btn_write">목 록</a>
			<a href="notice_u.jsp" class="btn_write">수 정</a>
		</div>
	  </div>			
			
	</div>		
	<%@ include file="footer.jsp"%>
    </div>
  </body>
</html>