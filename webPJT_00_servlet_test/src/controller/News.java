package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import CommandNews.NewsList;
import CommandNews.NewsView;
import common.CommonExecute;

/**
 * Servlet implementation class News
 */
@WebServlet("/News")
public class News extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public News() {
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
	  
		String gubun = request.getParameter("t_gubun");
		if (gubun == null) gubun = "list";
		String url = "/news/news_list.jsp";
		
		if (gubun.equals("list")) {
		  CommonExecute news = new NewsList();
		  news.execute(request, response);
		  url = "/news/news_list.jsp";
		} else if (gubun.equals("view")) {
		  CommonExecute news = new NewsView();
		  news.execute(request, response);
		  url = "/news/news_view.jsp";
		} else if (gubun.equals("write")) {
          url = "/news/news_write.jsp";
        } else if (gubun.equals("save")) {
          
        }
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}



  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
