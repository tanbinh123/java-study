package qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Qanda_dao;

/**
 * Servlet implementation class DBQnaDelete
 */
@WebServlet("/DBQnaDelete")
public class DBQnaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBQnaDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Qanda_dao dao = new Qanda_dao();
		String no = request.getParameter("t_no");
		int result = dao.deleteQuestion(no);
		String msg="";
		if(result == 1) msg="질문 삭제 되었습니다.";
		else msg="질문 삭제 실패~";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/QnaList");
		
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





