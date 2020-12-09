package CommandQna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonExecute;
import dao.Qanda_dao;
import dto.Qanda_dto;

public class QnaView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Qanda_dao dao = new Qanda_dao();
		String no = request.getParameter("t_no");
		dao.setHitCount(no);
		Qanda_dto dto = dao.getQandaView(no);
		request.setAttribute("t_dto", dto);
	}

}
