package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Member_dao;

/**
 * Servlet implementation class DBMemberLogin
 */
@WebServlet("/DBMemberLogin")
public class DBMemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBMemberLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member_dao dao = new Member_dao();
		String id = request.getParameter("t_id");
		String pw = request.getParameter("t_pw");
		
		String name = dao.getLoginName(id, pw);
		String msg="";
		String url="";
		if(name == null) {
			msg =" ID 나 비밀번호가 맞지않습니다. ";
			url ="/Login";
		} else {
			msg =name+"님 환영합니다.";
			url ="/index.jsp";
			HttpSession session = request.getSession(true);
			session.setAttribute("session_name",name);
			session.setAttribute("session_id",id);
			if(id.equals("manager")) {
				session.setAttribute("session_level","top");
			}
			session.setMaxInactiveInterval(60*60*1);			
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
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
