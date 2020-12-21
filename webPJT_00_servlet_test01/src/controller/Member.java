package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandMember.MemberJoin;
import CommandMember.MemberLogin;
import CommandMember.MemberLogout;
import common.CommonExecute;

/**
 * Servlet implementation class Member
 */
@WebServlet("/Member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Member() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		String url="/common_alert_page.jsp";
		
		if(gubun.equals("loginForm")){
			url ="/member/member_login.jsp";
		} else if(gubun.equals("login")){
			CommonExecute mem = new MemberLogin();
			mem.execute(request, response);
		} else if(gubun.equals("logout")){
			CommonExecute mem = new MemberLogout();
			mem.execute(request, response);
		} else if(gubun.equals("contact")){
			url ="/member/member_join.jsp";
		} else if(gubun.equals("join")){
			CommonExecute mem = new MemberJoin();
			mem.execute(request, response);
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
