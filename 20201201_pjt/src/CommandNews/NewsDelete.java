package CommandNews;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.News_dao;

public class NewsDelete implements InterNews {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		News_dao dao = new News_dao();
		String no = request.getParameter("t_no");
		int result = dao.getNewsDelete(no);
		String msg ="";
		
		if(result ==0) msg =" 삭제 실패 ~ ";	
		else msg =" 삭제 되었습니다. ";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/NewsController");


	}

}




