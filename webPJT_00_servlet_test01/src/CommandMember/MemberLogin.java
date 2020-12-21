package CommandMember;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import dao.Member_dao;

public class MemberLogin implements CommonExecute{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Member_dao dao = new Member_dao();
		String id = request.getParameter("t_id");
		String pw = request.getParameter("t_pw");
		String name = dao.getLoginName(id, pw);
		String msg ="";
		String url ="";
		if(name == null){
			msg =" ID나 비밀번호가 맞지 않습니다. ";
			url ="/Member?t_gubun=loginForm";
		} else {
			msg = name +"님 환영합니다. ";
			url ="/Index";
			HttpSession session = request.getSession();
			session.setAttribute("session_name",name);
			session.setAttribute("session_id",id);
			if(id.equals("manager")) {
				session.setAttribute("session_level","top");
			}
			session.setMaxInactiveInterval(60*60*1);
		}
		request.setAttribute("t_msg",msg);
		request.setAttribute("t_url",url);
	}
}













