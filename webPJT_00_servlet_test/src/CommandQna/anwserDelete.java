package CommandQna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonExecute;
import dao.Qanda_dao;

public class anwserDelete implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Qanda_dao dao = new Qanda_dao();
		
		String no 		= request.getParameter("t_no");
		
		int result = dao.deleteAnswer(no);
		String msg="";
		if(result == 1) msg =" 답변 삭제 되었습니다. ";
		else msg=" 답변 삭제 실패~ ";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/Qna");
	}

}
