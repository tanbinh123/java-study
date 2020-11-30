package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commandNews.InterNews;
import commandNews.NewsList;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

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
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String gubun = "";
		String viewPage = "";
		
		if(gubun.equals("list")) {
			InterNews news = new NewsList();
			news.execute(request, response);
			viewPage="/news/news_list.jsp";
		}
		if(gubun.equals("write")) {
			
		}
		if(gubun.equals("save")) {
			
		}
		if(gubun.equals("save")) {
			
		}
		if(gubun.equals("view")) {
			
		}
		if(gubun.equals("")) {
			
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
