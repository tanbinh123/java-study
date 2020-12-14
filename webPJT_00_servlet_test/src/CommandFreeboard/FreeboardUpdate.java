package CommandFreeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonExecute;
import dao.Freeboard_dao;
import dto.Freeboard_dto;

public class FreeboardUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Freeboard_dao dao = new Freeboard_dao();
		String no 		= request.getParameter("t_no");
		String title 	= request.getParameter("t_title");
		String content 	= request.getParameter("t_content");
		String reg_name = request.getParameter("t_reg_name");
		String reg_id = request.getParameter("t_reg_id");
		String reg_date = request.getParameter("t_reg_date");
		
		Freeboard_dto dto = new Freeboard_dto(no,title,content,reg_name,reg_date,reg_id);
		int result = dao.getFreeboardUpdate(dto);
		String msg="";
		if(result == 1) msg ="수정 되었습니다.";
		else msg ="수정 실패~";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/Freeboard");		

	}

}



