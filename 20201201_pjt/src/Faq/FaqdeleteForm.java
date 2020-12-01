package Faq;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Faq_dao;

/**
 * Servlet implementation class FaqdeleteForm
 */
@WebServlet("/FaqdeleteForm")
public class FaqdeleteForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqdeleteForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Faq_dao dao = new Faq_dao();
		String no = request.getParameter("t_no");	
		int result = dao.deleteFaq(no);
		
		String msg = "";
		if(result == 1) msg ="삭제 성공";
		else msg = "삭제 실패";
		
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
