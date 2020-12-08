package CommandNews;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonExecute;
import dao.News_dao;

public class NewsDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		News_dao dao = new News_dao();
		String no = request.getParameter("t_no");
		int result = dao.getNewsDelete(no);
		String msg="";
		if(result == 1) msg ="삭제 되었습니다.";
		else msg ="뉴스 삭제 실패~";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/News");
	}

}



