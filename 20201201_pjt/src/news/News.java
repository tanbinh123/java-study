package news;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.setCharacterEncoding("utf-8");		
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun ="list";
		
		String viewPage="";
		
		if(gubun.equals("list")) {
			JaNewslist news = new JaNewslist();
			news.execute(request, response);
			viewPage="/news/news_list.jsp";
		} else if(gubun.equals("save")) {
			
		} else if(gubun.equals("update")) {
			
		} else if(gubun.equals("delete")) {
			
		} else if(gubun.equals("write")) {
			viewPage="/news/news_write.jsp";
		} else if(gubun.equals("view")) {
			JaNewsView news = new JaNewsView();
			news.execute(request, response);
			viewPage="/news/news_view.jsp";
		} else if(gubun.equals("updateForm")) {
			JaNewsUpdateForm news = new JaNewsUpdateForm();
			news.execute(request, response);
			viewPage="/news/news_update.jsp";
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
