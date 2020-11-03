<%@ page pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
	<title>홍길동</title>
		<meta charset="utf-8">
 		<link href="/css/noticewrite.css" rel="stylesheet"> 
		<link href="/css/common.css" rel="stylesheet">
		<link href="/css/login.css" rel="stylesheet">
		<link href="/css/join.css" rel="stylesheet">
		<link href="/css/sub-notice.css" rel="stylesheet">
		<link href="/css/sub-qna.css" rel="stylesheet">

		
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css">
		<script src="/js/jquery-3.3.1.min.js"></script>
		<script src="/js/common.js"></script>
		
	<body>
		<!-- skip navigation -->
		<dl id="access">
			<dt>바로가기 및 건너띄기 링크</dt>
			<dd><a href="#contents">본문바로가기</a></dd>
			<dd><a href="#navigation">주메뉴 바로가기</a></dd>
		</dl>
		<hr>
		
		<div id="big-box">
			<header>
			<div id="header">
				<div class="nav">
						<ul class="nav-menu">
							<li><a href="sub1.html">ABOUT EL WIDE</a></li>
							<li><a href="sub2.html">MUSIC</a></li>
							<li><a href="sub3.html">MEDIA</a></li>
							<li><a href="/NoticeList">NOTICE</a></li>
						</ul>
				<div class="logo">
					<h1 class="el-logo"><a href="<%=request.getContextPath()%>/index.jsp"><img src="/images/elwide-logo.svg" width="88" height="88"></a></h1>
				</div>
				<div class="side-bar">
					<div class="side-menu">
						<ul>
							<li><a href="http://www.facebook.com/elmusickorea" target="_blank"><i class="fab fa-facebook-f"></i></a></li>
							<li><a href="https://blog.naver.com/elmusicstudio" target="_blank"><i class="fab fa-blogger-b"> </i></a></li>
							<li><a href="https://www.youtube.com/channel/UCkoJ_TsGn-WqDVWEzGnhfcA"target="_blank"><i class="fab fa-youtube"> </i></a></li>
							<li><a href="/member/member_login.jsp"><i class="fas fa-user"></i></a></li>
						</ul>
					</div>
					<div class="side-text">
						 <ul>
							<li>CONNECT WITH JSL 인재개발원</li>
						 </ul>
					</div>
				</div>
				</div>
			</div>
			</header>
		</div>
