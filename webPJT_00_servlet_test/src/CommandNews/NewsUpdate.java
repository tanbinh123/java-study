package CommandNews;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonExecute;
import dao.News_dao;
import dto.News_dto;

public class NewsUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		News_dao dao = new News_dao();
		String no 		= request.getParameter("t_no");
		String title 	= request.getParameter("t_title");
		String content 	= request.getParameter("t_content");
		String reg_name = request.getParameter("t_reg_name");
		String reg_date = request.getParameter("t_reg_date");
		
		News_dto dto = new News_dto(no,title,content,reg_name,reg_date);
		int result = dao.getNewsUpdate(dto);
		String msg="";
		if(result == 1) msg ="수정 되었습니다.";
		else msg ="뉴스 수정 실패~";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/News");		

	}

}



