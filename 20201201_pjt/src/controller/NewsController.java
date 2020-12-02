package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandNews.InterNews;
import CommandNews.NewsDelete;
import CommandNews.NewsList;
import CommandNews.NewsSave;
import CommandNews.NewsUpdate;
import CommandNews.NewsUpdateForm;
import CommandNews.NewsView;

/**
 * Servlet implementation class NewsController
 */
@WebServlet("/NewsController")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun ="list";
		
		String viewPage="";
		
		if(gubun.equals("list")) {
			InterNews news = new NewsList();
			news.execute(request, response);
//			viewPage="/news/news_list.jsp";
			viewPage="/news/news_list_jstl.jsp";
		} else if(gubun.equals("write")) {
			viewPage="/news/news_write.jsp";
		} else if(gubun.equals("save")) {
			InterNews news = new NewsSave();
			news.execute(request, response);
			viewPage ="/common_alert_page.jsp";
		} else if(gubun.equals("view")) {
			InterNews news = new NewsView();
			news.execute(request, response);
			//viewPage ="/news/news_view.jsp";
			viewPage ="/news/news_view_jstl.jsp";
		} else if(gubun.equals("updateForm")) {
			InterNews news = new NewsUpdateForm();
			news.execute(request, response);
			//viewPage ="/news/news_update.jsp";	
			viewPage ="/news/news_update_jstl.jsp";	
		} else if(gubun.equals("update")) {
			InterNews news = new NewsUpdate();
			news.execute(request, response);
			viewPage ="common_alert_page.jsp";
		} else if(gubun.equals("delete")) {
			InterNews news = new NewsDelete();
			news.execute(request, response);
			viewPage ="common_alert_page.jsp";
		}	
		
		RequestDispatcher rd = 
				request.getRequestDispatcher(viewPage);
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







