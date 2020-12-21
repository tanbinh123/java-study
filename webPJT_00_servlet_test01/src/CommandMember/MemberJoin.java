package CommandMember;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonExecute;
import common.CommonUtil;
import dao.Member_dao;
import dto.Member_dto;

public class MemberJoin implements CommonExecute{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Member_dao dao = new Member_dao();
		
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
		

		String msg="";
		String url="/Index";

		Member_dto dto = new Member_dto(id,name,pw,area,address,
										tel_1,tel_2,tel_3,mf,
										hobby_t,hobby_r,hobby_s,
									reg_date);
		int result = dao.saveMember(dto);
		if(result == 1) {
			msg = name +"님 회원 가입 되었습니다. ";
		} else {
			msg = " 회원 가입  실패~ ";
			url ="/Member?t_gubun=contact";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);			
	}
}






