<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common_subpage_head.jsp"%>
<script type="text/javascript">
	function goJoin(){
		if(!checkEmpty(mem.t_id," ID 입력! ")) return;
		if(!checkEmpty(mem.t_name," 성명 입력! ")) return;

		if(mem.t_pw.value != mem.t_pw_confirm.value){
			alert("비밀번호 확인 오류~~");
			mem.t_pw_confirm.focus();
			return;
		}	
		mem.method="post";
		mem.action="db_member_join.jsp";
		mem.submit();
/*		
		if(mem.t_id.value==""){
			alert(" ID 입력! ");
			mem.t_id.focus();
			return;
		}
		if(mem.t_name.value ==""){
			alert("성명 입력! ");
			mem.t_name.focus();
			return;	
		}	
		if(mem.t_pw.value ==""){
			alert("비밀번호 입력! ");
			mem.t_pw.focus();
			return;	
		}	
		if(mem.t_pw_confirm.value ==""){
			alert("비밀번호확인 입력! ");
			mem.t_pw_confirm.focus();
			return;	
		}	
		if(mem.t_address.value ==""){
			alert("주소 입력! ");
			mem.t_address.focus();
			return;	
		}	
		if(mem.t_tel_1.value ==""){
			alert("첫번째 연락처 입력! ");
			mem.t_tel_1.focus();
			return;	
		}	
		if(mem.t_tel_2.value ==""){
			alert("두번째 연락처 입력! ");
			mem.t_tel_2.focus();
			return;	
		}	
		if(mem.t_tel_3.value ==""){
			alert("세번째 연락처 입력! ");
			mem.t_tel_3.focus();
			return;	
		}	
		if(mem.t_pw.value != mem.t_pw_confirm.value){
			alert("비밀번호 확인 오류~~");
			mem.t_pw_confirm.focus();
			return;
		}
*/		
	}
</script>	
		<div id="b_left">
			<P>MEMBER</P>
			<ul>
				<li><a href="member_login.jsp">LOGIN</a></li>
				<li><a href="">ID / PASSWORD</a></li>
				<li><a href="member_join.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span> CONTACT</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				MEMBER JOIN
			</p>
			<form name="mem">
			<table class="boardForm">
			  <colgroup>
				<col width="200" />
				<col width="500" />
			  </colgroup>
			  <tbody>
				<tr>
				  <th><label for="id">I D</label></th>
				  <td>
					<input name="t_id" type="text" size="10" id="id" title="id입력하세요">
					<input type="button" onclick="checkId()" value="ID중복검사" class="checkB">
				  </td>
				</tr>
				<tr>
				  <th><label for="nana">성 명</label></th>
				  <td><input name="t_name" type="text" size="8" id="nana"></td>
				</tr>
				<tr>
				  <th>비밀번호</th>
				  <td><input  name="t_pw" type="password" size="13"></td>
				</tr>
				<tr>
				  <th>비밀번호확인</th>
				  <td><input  name="t_pw_confirm" type="password" size="13"></td>
				</tr>
				<tr>
				  <th>지역</th>
				  <td>
					<select name="t_area">
						<option value="01">서울</option>
						<option value="02">대전</option>
						<option value="03">부산</option>
						<option value="04">대구</option>        
					</select>	  
				  </td>
				</tr>	
				
				<tr>
				  <th>주소</th>
				  <td><input  name="t_address" type="text" size="40"></td>
				</tr>
				<tr>
				  <th>연락처</th>
				  <td>
					<input name="t_tel_1" type="text" size="2"> -
					<input name="t_tel_2" type="text" size="3"> -
					<input name="t_tel_3" type="text" size="3">
				  </td>
				</tr>
				<tr>
				  <th>남여구분</th>
				  <td>
					  <input type="radio" value="f" checked name="t_mf" class="middleCheck" /> 여&nbsp;&nbsp;        
					  <input type="radio" value="m" name="t_mf" class="middleCheck" /> 남        
				  </td>
				</tr>
				<tr>
				  <th>취미</th>
				  <td>
					  <input type="checkbox" value="y" name="t_hobby_t" class="middleCheck" /> 여행&nbsp;&nbsp; 
					  <input type="checkbox" value="y" name="t_hobby_r" class="middleCheck" /> 독서&nbsp;&nbsp; 
					  <input type="checkbox" value="y" name="t_hobby_s" class="middleCheck" /> 운동
				  </td>
				</tr>
			  </tbody>
			</table>
			</form>
			<div class="buttonGroup_center">
				<a href="javascript:goJoin()" class="butt">JOIN</a>
			</div>	
		</div>	

<%@ include file="/common/common_subpage_bottom.jsp" %>	
	</div>	
</body>
</html>






