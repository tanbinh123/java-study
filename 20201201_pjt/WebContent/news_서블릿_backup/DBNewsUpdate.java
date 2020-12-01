package news;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.News_dao;
import dto.News_dto;

/**
 * Servlet implementation class DBNoticeUpdate
 */
@WebServlet("/DBNewsUpdate")
public class DBNewsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBNewsUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		News_dao dao = new News_dao();
		String no 		= request.getParameter("t_no");
		String title 	= request.getParameter("t_title");
		String content 	= request.getParameter("t_content");
		String reg_name = "관리자";
		String reg_date = CommonUtil.getToday();
		News_dto dto = 
				new News_dto(no,title,content,reg_name,reg_date,0);
		int result = dao.getNewsUpdate(dto);
		
		String msg ="";
		if(result ==0) msg =" 수정 실패 ~ ";	
		else msg =" 수정 되었습니다. ";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/NewsList");

		RequestDispatcher rd =
				request.getRequestDispatcher("/common_alert_page.jsp");
		rd.forward(request, response);

//		response.sendRedirect("/NewsList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
