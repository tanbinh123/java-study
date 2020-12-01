package EL_JSTL;

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
 * Servlet implementation class El_Test
 */
@WebServlet("/El_Test")
public class El_Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public El_Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name ="홍길동";
		request.setAttribute("t_name", name);
		request.setAttribute("t_age", 25);
		request.setAttribute("t_score", 75);
		String area = null;
		request.setAttribute("t_area", area);
		
		ArrayList<String> arr = new ArrayList<>();
		arr.add("가나다");
		arr.add("abc");
		request.setAttribute("t_arr", arr);
		
		News_dto dto1 = new News_dto("N001","제목1","내용1","등록자1","20-09-05",10);
		News_dto dto2 = new News_dto("N002","제목2","내용2","등록자2","20-10-15",20);
		News_dto dto3 = new News_dto("N003","제목3","내용3","등록자3","20-11-25",30);
		ArrayList<News_dto> dtos = new ArrayList<>();
		dtos.add(dto1);
		dtos.add(dto2);
		dtos.add(dto3);
		
		request.setAttribute("t_dtos", dtos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/eltest/test.jsp");
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










