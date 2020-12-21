package CommandFreeboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonExecute;
import dao.Freeboard_dao;
import dto.Freeboard_dto;

public class FreeboardView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Freeboard_dao dao = new Freeboard_dao();
		String no = request.getParameter("t_no");
		dao.getfreehit(no);
		Freeboard_dto dto = dao.freeView(no);
		request.setAttribute("t_dto", dto);
	}

}
