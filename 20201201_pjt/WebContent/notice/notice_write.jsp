<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.*" %>
<%@ include file="/common/session_manager_check.jsp" %>    
<%@ include file="/common_head.jsp" %> 
<script>
	function goSave(){
		if(!checkEmpty(write.t_title,"제목 입력!")) return;
		if(!checkEmpty(write.t_content,"내용 입력!")) return;
		
		/*		첨부파일 용량, 확장자 검사 */	
		var maxSize  = 1024 * 1024 * 1;  // 첨부 용량 설정 2MB
//		var maxSize  = 100; // 첨부 용량 설정 2MB
		var msg =" 첨부파일 사이즈는 1MB 이내로 등록 가능합니다.";
		
		var fileName = write.t_attach.value;
		//파일명.확장자 검사
		/*
		if(fileName != ""){
			var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
			var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
			if(extension != "jpg" && extension != "gif" && extension != "png"){
				alert(extension +" 형식 파일은 업로드 안됩니다.이미지 파일만 가능!");
				return;
			}		
		}
		*/
		//첨부 용량 체크		
		var file = write.t_attach;
		if(file.value !=""){
			var fileSize = 0;
			// 브라우저 확인
			var browser=navigator.appName;
			// 익스플로러일 경우
			if (browser=="Microsoft Internet Explorer"){
				var oas = new ActiveXObject("Scripting.FileSystemObject");
				fileSize = oas.getFile(file.value).size;
			}else {
			// 익스플로러가 아닐경우
				fileSize = file.files[0].size;
			}
			if(fileSize > maxSize){
				alert(msg);
				return;
			}	
		}		
/*		첨부파일 용량, 확장자 검사 */			
		
		write.method="post";
		write.action="/DBNoticeSave";
		write.submit();
	}
</script>		
		<!--  header end -->
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
			<h2><span><i class="fas fa-edit"></i> NOTICE-write</span></h2>	
			</div>
			
			<div class="notice-write">
			
			<form name="write" enctype="multipart/form-data">
					<h2 class="readonly">제목, 첨부파일, 내용을 작성합니다</h2>
					<fieldset>
						<legend>공지사항 글쓰기</legend>
						<table class="table">
							<caption>공지사항 글쓰기</caption>
							<colgroup>
								<col width="15%">
								<col width="35%">
								<col width="15%">
								<col width="35%">
							</colgroup>
							<tr>
								<th><label for="title">제목</label></th>
								<td colspan="3"><input type="text" name="t_title" id="title" class="title" placeholder="제목을 입력해주세요"></td>
							</tr>
							
							<tr>
								<th><label for="cont">내용</label></th>
								<td colspan="3"><textarea type="cont" name="t_content" id="cont" class="cont" placeholder="내용을 입력해주세요"></textarea>
							</tr>
							
							<tr>
								<th><label for="file">파일 첨부</label></th>
								<td colspan="3"><input type="file" name="t_attach" class="file" id="file"></label></td>
							</tr>
							<tr>
								<th>등록자</th>
								<td style="text-align:left">관리자</td>
								<th>등록일자</th>
								<td style="text-align:left"><%=CommonUtil.getToday()%></td>
							</tr>
							<tr>
								<td colspan="4">
								<input type="button" onclick="goSave()" value="저장" class="btn" >
								<input type="button" onclick="history.back();" value="목록" class="btn">
								</td>
							</tr>

							</table>
					</fieldset>
				</form>
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
	
	
		<script>


		</script>
	
	</body>
</html>









    