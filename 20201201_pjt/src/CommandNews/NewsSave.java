package CommandNews;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.News_dao;
import dto.News_dto;

public class NewsSave implements InterNews {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		News_dao dao = new News_dao();
		
		String no 		= dao.getNewsNo();
		String title 	= request.getParameter("t_title");
		String content 	= request.getParameter("t_content");
		String reg_name = "관리자";
		String reg_date = CommonUtil.getToday();
		News_dto dto = 
				new News_dto(no,title,content,reg_name,reg_date,0);
		int result = dao.getNewsSave(dto);

		String msg ="";
		if(result ==0) {
			msg =" 등록 실패 ~ ";	
		}else {
			msg =" 등록 되었습니다. ";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/NewsController");
		

	}

}






