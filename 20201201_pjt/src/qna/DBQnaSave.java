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
 * Servlet implementation class DBQnaSave
 */
@WebServlet("/DBQnaSave")
public class DBQnaSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBQnaSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Qanda_dao dao = new Qanda_dao();
		String no 		= dao.getQandaNo();
		String title 	= request.getParameter("t_title");
		String content  = request.getParameter("t_content");
		String reg_id   = request.getParameter("t_reg_id");
		String reg_date = CommonUtil.getToday();
		
		Qanda_dto dto = new Qanda_dto(no,title,content,reg_id,reg_date);
		int result = dao.saveQuestion(dto);
		
		String msg="";
		if(result == 1) msg ="등록 되었습니다";
		else msg =" 질문 등록 실패~";
		
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
