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
		String content 	= request.getParameter("t_content"); 
		String reg_id   = request.getParameter("t_reg_id"); 
		String reg_date = CommonUtil.getToday(); 
		
		Qanda_dto dto = new Qanda_dto(no,title,content,reg_id,reg_date);
		int result = dao.saveQuestion(dto);
		String msg="";
		if(result == 1) msg =" 등록 되었습니다. ";
		else msg=" 등록 실패~ ";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/Qna");
	}

}
