package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.News_dto;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("t_name", "홍길동");
		request.setAttribute("t_age", 34);
		request.setAttribute("t_score", 75);
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(100);
		arr.add(700);
		arr.add(400);
		
		request.setAttribute("arr", arr);
		
		ArrayList<News_dto> newsarr = new ArrayList<>();
		News_dto dto = new News_dto("1", "제목1", "내용1", "홍길동1", "2020-12-01", 43);
		News_dto dto1 = new News_dto("2", "제목2", "내용2", "홍길동2", "2020-12-01", 45);
		News_dto dto2 = new News_dto("3", "제목3", "내용3", "홍길동3", "2020-12-01", 42);
		newsarr.add(dto);
		newsarr.add(dto1);
		newsarr.add(dto2);
		
		request.setAttribute("newsarr", newsarr);
		
		RequestDispatcher rd = request.getRequestDispatcher("/test.jsp");
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
