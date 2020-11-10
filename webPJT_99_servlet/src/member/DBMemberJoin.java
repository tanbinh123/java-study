package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.Member_dao;
import dto.Member_dto;

/**
 * Servlet implementation class DBMemberJoin
 */
@WebServlet("/DBMemberJoin")
public class DBMemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBMemberJoin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Member_dao dao = new dao.Member_dao();
		
		String id 		= request.getParameter("t_id");
		String name		= request.getParameter("t_name");
		String pw		= request.getParameter("t_pw");
		String area		= request.getParameter("t_area");
		String address	= request.getParameter("t_address");
		String tel_1	= request.getParameter("t_tel_1");
		String tel_2	= request.getParameter("t_tel_2");
		String tel_3	= request.getParameter("t_tel_3");
		String mf		= request.getParameter("t_mf");
		String hobby_t	= request.getParameter("t_hobby_t");
		String hobby_r	= request.getParameter("t_hobby_r");
		String hobby_s	= request.getParameter("t_hobby_s");
		if(hobby_t == null) hobby_t ="n";
		if(hobby_r == null) hobby_r ="n";
		if(hobby_s == null) hobby_s ="n";
		String reg_date = CommonUtil.getToday();
		
		Member_dto dto = new Member_dto(id, name, pw, area, address, tel_1, tel_2, tel_3, mf, hobby_t, hobby_r, hobby_s, reg_date);
		int result = dao.saveMember(dto);
		String msg = "";
		if (result == 1) {
			msg = name + "님 환영합니다";
		}
		if (result == 0 ) {
			msg = "회원가입 오류~";
		}
		
		 request.setAttribute("t_msg", msg);
		 request.setAttribute("t_url", "/index.jsp");
		 
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
