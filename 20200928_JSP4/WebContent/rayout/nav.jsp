<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<div id="b_left">
    <P>NOTICE & NEWS</P>
    <ul>
        <li><a href="/component/notice/notice_list.jsp">
        	<%if(whoamiPage.equals("notice")){
        	%><span class="fnt"><i class="fas fa-apple-alt"></i></span>
        	<% } %> NOTICE</a></li>
        <li><a href="/component/news/news_list.jsp">
        <%if(whoamiPage.equals("news")){
        	%><span class="fnt"><i class="fas fa-apple-alt"></i></span>
        	<% } %> NEWS</a></li>
        <li><a href="/component/qna/qna_list.jsp">
        <%if(whoamiPage.equals("qna")){
        	%><span class="fnt"><i class="fas fa-apple-alt"></i></span>
        	<% } %> Q & A</a></li>
        <li><a href="/component/freeboard/freeboard_list.jsp">
        <%if(whoamiPage.equals("freeboard")){
        	%><span class="fnt"><i class="fas fa-apple-alt"></i></span>
        	<% } %> FREE BOARD</a></li>
        <li><a href="/component/etc/etc_list.jsp">
        <%if(whoamiPage.equals("etc")){
        	%><span class="fnt"><i class="fas fa-apple-alt"></i></span>
        	<% } %> ETC</a></li>
    </ul>
</div>