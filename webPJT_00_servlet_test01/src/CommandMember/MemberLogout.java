package CommandMember;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonExecute;

public class MemberLogout implements CommonExecute{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String logoutName = (String)session.getAttribute("session_name");
		
		session.invalidate();
		String msg = logoutName+"님 로그 아웃 되었습니다.";
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/Index");
	}
}
