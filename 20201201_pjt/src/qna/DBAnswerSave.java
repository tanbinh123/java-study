package qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.Qanda_dao;

/**
 * Servlet implementation class DBAnswerSave
 */
@WebServlet("/DBAnswerSave")
public class DBAnswerSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBAnswerSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Qanda_dao dao = new Qanda_dao();
		String gubun  = request.getParameter("t_work_gubun");
		String no 	  = request.getParameter("t_no");
		String answer = request.getParameter("t_answer");
		String reg_id = request.getParameter("t_reg_id");
		int result = dao.saveAnswer(no, answer, reg_id, CommonUtil.getToday());
		
		String msg="";
		if(result == 1) msg ="답변 "+gubun+" 되었습니다";
		else msg =" 답변 "+gubun+" 실패~";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/QnaList");
		
		RequestDispatcher rd = 
					request.getRequestDispatcher("/common_alert_page.jsp");
		rd.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



