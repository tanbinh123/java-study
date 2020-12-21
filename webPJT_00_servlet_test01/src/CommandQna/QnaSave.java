package CommandQna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonExecute;
import common.CommonUtil;
import dao.Qanda_dao;
import dto.Qanda_dto;

public class QnaSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Qanda_dao dao = new Qanda_dao();
		
		String no 		= dao.getQandaNo();
		String title 	= request.getParameter("t_title");
		String content	= request.getParameter("t_content");
		String q_reg_id 	= request.getParameter("t_reg_id");
		String q_reg_date = CommonUtil.getToday();
		
		Qanda_dto dto = new Qanda_dto(no, title, content, q_reg_id, q_reg_date);
		int result = dao.saveQuestion(dto);
		String msg = "";
		if(result == 1) msg="등록 성공하였습니다.";
		else msg="등록 실패하였습니다.";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/Qna");
		
	}

}
