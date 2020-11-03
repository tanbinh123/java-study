package notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.Notice_dao;
import dto.Notice_dto;

/**
 * Servlet implementation class DBNoticeSave
 */
@WebServlet("/DBNoticeSave")
public class DBNoticeSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBNoticeSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Notice_dao dao = new Notice_dao();
		
		String no = dao.getNoticeNo();
		String title = request.getParameter("t_title");
		String content = request.getParameter("t_content");
		String reg_name = "관리자";
		String reg_date = CommonUtil.getToday();
		
		Notice_dto dto = new Notice_dto(no, title, content, "", reg_name, reg_date, 0);
		int result = dao.saveNotice(dto);
		if(result == 0) System.out.println("공지사항 등록 오류~~");
		else System.out.println("공지사항 등록 성공 ~~"); 
			
		response.sendRedirect("/NoticeList");
//		RequestDispatcher rd = request.getRequestDispatcher("");
//		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
