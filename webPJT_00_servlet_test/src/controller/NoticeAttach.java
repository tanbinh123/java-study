package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import CommandNotice.NoticeSave;
import common.CommonExecute;

/**
 * Servlet implementation class NoticeAttach
 */
@WebServlet("/NoticeAttach")
public class NoticeAttach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeAttach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	  
	  request.setCharacterEncoding("utf-8");
	  String url = "/news/news_list.jsp";
	  MultipartRequest mpr;
	  mpr = new MultipartRequest(request,"utf-8");
      String gubun = mpr.getParameter("t_gubun");
      
      
      if (gubun.equals("save")) {
        CommonExecute notice = new NoticeSave();
        notice.execute(request, response);
        url = "/common_alert_page.jsp";
      }
      
      RequestDispatcher rd = request.getRequestDispatcher(url);
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
