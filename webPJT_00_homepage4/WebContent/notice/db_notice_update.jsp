<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*,common.*" %>
<%@ page import="com.oreilly.servlet.*,java.io.*"%>
<%
	request.setCharacterEncoding("utf-8");
	int sizeLimit = 1024 * 1024 * 100 ; 
	String file_dir =CommonUtil.attach_dir_notice;	
	MultipartRequest ctl = new MultipartRequest(request,file_dir,sizeLimit,"UTF-8");
	Notice_dao dao = new Notice_dao();
/*	
	String no 		= dao.getNoticeNo();
	String title 	= request.getParameter("t_title"); 
	String content 	= request.getParameter("t_content"); 
	String attach 	= request.getParameter("t_attach"); 
	String reg_name = request.getParameter("t_reg_name"); 
	String reg_date = request.getParameter("t_reg_date"); 
*/
	String delFile 	    = ctl.getParameter("checkBox_del_attach");
String dbAttachName  = "";
	
	//if(!delFile.equals("")){
	if(delFile != null){
		File dFa = new File(file_dir, delFile);
		dFa.delete();
	} else {
		dbAttachName = ctl.getParameter("ori_attach");
	}

	String no 		= ctl.getParameter("t_no");
	String title 	= ctl.getParameter("t_title"); 
	String content 	= ctl.getParameter("t_content"); 
	String reg_name = ctl.getParameter("t_reg_name"); 
	String reg_date = ctl.getParameter("t_reg_date"); 
//	String attach 	= ctl.getParameter("t_attach");
	String attach   = ctl.getFilesystemName("t_attach");	

	if(attach != null){
		String del_fileName_file =  ctl.getParameter("ori_attach");
		if(!del_fileName_file.equals("")){
			File dFa = new File(file_dir, del_fileName_file);
			dFa.delete();
		}		
		
		File oldFile = new File(file_dir,attach);
		File newFile = new File(file_dir,no+"-"+attach);
		oldFile.renameTo(newFile);
		dbAttachName = newFile.getName();
	} 	
	
	
	
	Notice_dto dto = new Notice_dto(no,title,content,dbAttachName,reg_name,reg_date,0);
	int result = dao.updateNotice(dto);
	String msg="";
	if(result == 1) msg =" 수정 되었습니다. ";
	else msg=" 수정 실패~ ";
%>    
    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="notice_list.jsp";
</script>
</head>
<body>

</body>
</html>