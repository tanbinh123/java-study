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
import dto.Notice_dto;

/**
 * Servlet implementation class DBNews
 */
@WebServlet("/DBNews")
public class DBNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		News_dao dao = new News_dao();
		
		String pageGubun = request.getParameter("t_pageGubun");
		
		
		
		
		String title = request.getParameter("t_title");
		String content = request.getParameter("t_content");
		String reg_name = "관리자";
		String reg_date = CommonUtil.getToday();
		
		int result = 0;
		
		if(pageGubun.equals("등록")) {
			String no = dao.getNewsNo();
			News_dto dto = new News_dto(no, title, content, reg_name, reg_date, 0);
			result = dao.saveNews(dto);
			
		}else if(pageGubun.equals("삭제")) {
			String no = request.getParameter("t_no");
			result = dao.deleteNews(no);
			
		}else if(pageGubun.equals("수정")) {
			String no 		= request.getParameter("t_no");
			News_dto dto = 
					new News_dto(no,title,content,reg_name,reg_date,0);
			result = dao.updateNews(dto);
		}
		
			
			
			
			
			
			String msg="";
			if(result == 0) {
				msg = pageGubun+" 실패~";
			}else {
				msg = pageGubun+" 되었습니다.";
			}
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", "/NewsList");
			
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
