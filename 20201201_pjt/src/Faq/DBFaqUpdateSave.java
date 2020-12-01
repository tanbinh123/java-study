package Faq;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.Faq_dao;
import dto.Faq_dto;

/**
 * Servlet implementation class DBFaqUpdateSave
 */
@WebServlet("/DBFaqUpdateSave")
public class DBFaqUpdateSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBFaqUpdateSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Faq_dao dao = new Faq_dao();
		
		String no 		= request.getParameter("t_no");
		String question = request.getParameter("t_question");
		String answer 	= request.getParameter("t_answer");
		String reg_id 	= request.getParameter("t_reg_id");
		String reg_date = request.getParameter("t_reg_date");
		String sort 	= request.getParameter("t_sort");
		
		System.out.println(no);
		
		Faq_dto dto = new Faq_dto(no, question, answer, reg_id, reg_date, sort, 0);
		int result = dao.updateFaq(dto);
		String msg = "";
		if(result == 1) {
			msg = "수정 성공";
		}
		else {
			msg = "수정 실패";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/FaqList");
		
		RequestDispatcher rd = request.getRequestDispatcher("/common_alert_page.jsp");
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
