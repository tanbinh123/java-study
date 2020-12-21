<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/session_manager_check.jsp" %> 
<%@ include file="/common/common_subpage_head.jsp"%>  
<%@ page import="common.*"%>
<%
	Common common = new Common();
%>    

<script type="text/javascript">
	function goSave(){
//		if(!checkEmpty(noti.t_title," 제목 입력! ")) return;
//		if(!fnChkByte(noti.t_title, 10)) return;
//		if(!inputCheck_empty_length(noti.t_title,"제목입력!" ,10)) return;
		
		if(noti.t_title.value==""){
			alert(" 제목 입력! ");
			noti.t_title.focus();
			return;
		}	
		if(noti.t_content.value==""){
			alert(" 내용 입력! ");
			noti.t_content.focus();
			return;
		}	
	
		if(noti.t_reg_date.value==""){
			alert(" 등록일 입력! ");
			noti.t_reg_date.focus();
			return;
		}	
	
/*		첨부파일 용량, 확장자 검사 */	
		var maxSize  = 1024 * 1024 * 1;  // 첨부 용량 설정 2MB
//		var maxSize  = 100; // 첨부 용량 설정 2MB
		var msg =" 첨부파일 사이즈는 1MB 이내로 등록 가능합니다.";
		
		var fileName = noti.t_attach.value;
		if(fileName != ""){
			var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
			var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
			//파일명.확장자
			
			if(extension != "jpg" && extension != "gif" && extension != "png"){
				alert(extension +" 형식 파일은 업로드 안됩니다.이미지 파일만 가능!");
				return;
			}		
		}
		
		//첨부 용량 체크		
		var file = noti.t_attach;
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
		
		
		noti.method="post";
//		noti.action="db_notice_save.jsp";
//		noti.action="db_notice.jsp";
		noti.action="/NoticeSave";
		noti.submit();
	}
</script>	
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/Notice"><span class="fnt"><i class="fas fa-apple-alt"></i></span> NOTICE</a></li>
				<li><a href="/News"> News</a></li>
				<li><a href="/Qna">Q & A</a></li>
				<li><a href="/Freeboard">Free Board</a></li>
				<li><a href="/Etc">Etc</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			<form name="noti" enctype="multipart/form-data">
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
						<td colspan="3"><input type="text" name="t_title" class="input600"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250"></textarea></td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3"><input type="file" name="t_attach" class="input600"></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=session_name%>
							<input type="hidden" name="t_reg_name" value="<%=session_name%>" class="input100">
						</td>
						<th>RegDate</th>
						<td><input type="date" name="t_reg_date" value="<%=CommonUtil.getToday()%>" class="input130"></td>
					</tr>	
				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="/Notice" class="butt">List</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>	
	</div>	
</body>
</html>






