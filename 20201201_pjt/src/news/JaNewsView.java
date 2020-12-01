package news;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.News_dao;
import dto.News_dto;

public class JaNewsView {
	public void execute(HttpServletRequest request, HttpServletResponse response) {	
		News_dao dao = new News_dao();
		String no = request.getParameter("t_no");
		dao.setHitCount(no);
		News_dto dto = dao.newsView(no);
		request.setAttribute("t_dto", dto);		
	}	
}







