package commandNews;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.News_dao;
import dto.News_dto;

public class NewsList implements InterNews {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		News_dao dao = new News_dao();
		String select = request.getParameter("t_select");
		String search = request.getParameter("t_search");
		if(select == null) {
			select = "title";
			search ="";
		}
		
		ArrayList<News_dto> dtos = dao.getNewsList(select, search);
		
		//*************page 시작**************/
		int	list_setup_count = 5;			// 한페이지에 출력될 List 수 

		String r_page = request.getParameter("r_page");
		if(r_page==null) r_page= "";
		int			current_page;					// 현재페이지 번호
		int			total_page;						// 총페이지 수
		int			total_count;					// 총레코드 수
		int			for_count;						
		int			p_no;
		int			v_count;
		int			a_count;
		String		url				= null;	

		// 조회된 건수 구하기  total_count : 설정
		if(dtos == null) total_count =0;
		else total_count = dtos.size(); 


		// 페이지번호가 없으면 1페이지로 간주
		if(r_page.equals("")) current_page = 1;
		else current_page = Integer.parseInt(r_page);
			
		for_count		= list_setup_count;
		p_no			= list_setup_count;				// 페이지수가 10
		total_page = total_count / list_setup_count;		// 전체페이지수 계산 (if 23개 게시물이면 2)
	   
		if(current_page == 1) {
			v_count		= 0;
			a_count		= list_setup_count;
			for_count	= 0;
		} else{
			v_count		= 0;
			a_count		= p_no * current_page;
			for_count	= a_count - list_setup_count;
		}
		if(total_page * list_setup_count != total_count)   total_page = total_page +1;

		request.setAttribute("v_count", v_count);
		request.setAttribute("for_count", for_count);
		request.setAttribute("a_count", a_count);
		request.setAttribute("current_page", current_page);
		request.setAttribute("total_page", total_page);
		
		
	//*************page 끝**************/			
				
		request.setAttribute("t_dtos", dtos);
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);

	}

}
