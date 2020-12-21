package CommandQna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonExecute;
import common.CommonUtil;
import dao.Qanda_dao;

public class QnaAnswerUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Qanda_dao dao = new Qanda_dao();
		
		String no 		= request.getParameter("t_no");
		String answer	= request.getParameter("t_answer");
		String reg_id 	= request.getParameter("t_reg_id");
		String reg_date = CommonUtil.getToday();
		String work		= request.getParameter("t_work_gubun");
		
		int result = dao.saveAnswer(no, answer, reg_id, reg_date);
		String msg = "";
		if(result == 1) msg = "답변 수정 되었습니다.";
		else msg = "답변 수정 실패했습니다.";

		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/Qna");
	}

}
