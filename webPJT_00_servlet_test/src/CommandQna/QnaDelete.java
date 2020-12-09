package CommandQna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonExecute;
import dao.Qanda_dao;

public class QnaDelete implements CommonExecute{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Qanda_dao dao = new Qanda_dao();
		String no 		= request.getParameter("t_no");
		
		int result = dao.deleteQuestion(no);
		String msg="";
		if(result == 1) msg =" 질문 삭제 되었습니다. ";
		else msg=" 질문 삭제 실패~ ";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/Qna");
	}
}
