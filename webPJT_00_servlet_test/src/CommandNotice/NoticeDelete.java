package CommandNotice;

import java.io.File;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Common;
import common.CommonExecute;
import dao.Notice_dao;

public class NoticeDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Notice_dao dao 		= new Notice_dao();
		String no 			= request.getParameter("t_no");
		String del_attach 	= request.getParameter("t_attach");
		if(!del_attach.equals("")){
			File delFile = new File(Common.file_dir_notice,del_attach);
			delFile.delete();
		}
		int result = dao.deleteNotice(no);
		String msg="";
		if(result == 1) msg =" 삭제 되었습니다. ";
		else msg=" 삭제 실패~ ";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/Notice");
	}

}
