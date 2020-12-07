package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import CommandNews.NewsSave;
import CommandNotice.NoticeList;
import CommandNotice.NoticeSave;
import CommandNotice.NoticeView;
import common.CommonExecute;

/**
 * Servlet implementation class Notice
 */
@WebServlet("/Notice")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String gubun = request.getParameter("t_gubun");
        if (gubun == null) gubun = "list";
        String url = "/news/news_list.jsp"; 
        
        if (gubun.equals("list")) {
          CommonExecute notice = new NoticeList();
          notice.execute(request, response);
          url = "/notice/notice_list.jsp";
        } else if (gubun.equals("view")) {
          CommonExecute notice = new NoticeView();
          notice.execute(request, response);
          url = "/notice/notice_view.jsp";
        }  else if (gubun.equals("write")) {
          url = "/notice/notice_write.jsp";
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
