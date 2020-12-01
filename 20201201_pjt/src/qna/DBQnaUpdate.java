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
import dto.Qanda_dto;

/**
 * Servlet implementation class DBQnaUpdate
 */
@WebServlet("/DBQnaUpdate")
public class DBQnaUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBQnaUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Qanda_dao dao = new Qanda_dao();
		String no 		= request.getParameter("t_no");
		String title 	= request.getParameter("t_title");
		String content 	= request.getParameter("t_content");
		Qanda_dto dto = new Qanda_dto(no,title,content,"",CommonUtil.getToday());
		int result = dao.updateQuestion(dto);
		String msg="";
		if(result == 1) msg="질문 수정 되었습니다.";
		else msg="질문 수정 실패~";
		
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








