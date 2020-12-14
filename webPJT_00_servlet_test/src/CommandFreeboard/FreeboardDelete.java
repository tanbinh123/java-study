package CommandFreeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonExecute;
import dao.Freeboard_dao;

public class FreeboardDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Freeboard_dao dao = new Freeboard_dao();
		String no = request.getParameter("t_no");
		int result = dao.getFreeboardDelete(no);
		String msg="";
		if(result == 1) msg ="삭제 되었습니다.";
		else msg ="뉴스 삭제 실패~";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/Freeboard");
	}

}



