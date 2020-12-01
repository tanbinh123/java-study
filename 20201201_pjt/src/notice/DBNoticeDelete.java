package notice;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.Notice_dao;

/**
 * Servlet implementation class DBNoticeDelete
 */
@WebServlet("/DBNoticeDelete")
public class DBNoticeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBNoticeDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Notice_dao dao = new Notice_dao();
		String no = request.getParameter("t_no");
		String delFile = request.getParameter("t_attach");
		int result = dao.deleteNotice(no);
		
		if(!delFile.equals("")) {
			File df = new File(CommonUtil.file_dir_notice,delFile);
			df.delete();
		}
		String msg ="";
		if(result ==0) msg =" 삭제 실패 ~ ";	
		else msg =" 삭제 되었습니다. ";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/NoticeList");

		RequestDispatcher rd =
				request.getRequestDispatcher("/common_alert_page.jsp");
		rd.forward(request, response);	
//		response.sendRedirect("/NoticeList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
