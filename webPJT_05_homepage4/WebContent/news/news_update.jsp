<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="/common/common_subpage_head.jsp"%>   
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/notice/notice_list.jsp">NOTICE</a></li>
				<li><a href="/news/news_list.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span> News</a></li>
				<li><a href="/qanda/qanda_list.jsp">Q & A</a></li>
				<li><a href="/freeboard/freeboard_list.jsp">Free Board</a></li>
				<li><a href="">Etc</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NEWS
			</p>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3"><input type="text" class="input600" value="구매 절차 과정 안내 드립니다."></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea class="textArea_H250">구매 절차 과정 안내 드립니다.구매 절차 과정 안내 드립니다.구매 절차 과정 안내 드립니다.</textarea></td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3">구매안내.hwp 삭제<input type="checkbox"><br>
							<input type="file" class="input600">
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><input type="text" value="관리자" class="input100"></td>
						<th>RegDate</th>
						<td><input type="date" value="2020-09-01" class="input130"></td>
					</tr>	

				</tbody>
			</table>
			<div class="buttonGroup">
				
				<a href="notice_list.html" class="butt">Save</a>
				<a href="notice_list.html" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>		
	</div>	
</body>
</html>