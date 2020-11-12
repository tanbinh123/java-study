package faq;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.Faq_dao;
import dto.Faq_dto;

/**
 * Servlet implementation class DBFaq
 */
@WebServlet("/DBFaq")
public class DBFaq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBFaq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Faq_dao dao = new Faq_dao();
		
		String pageGubun = request.getParameter("t_pageGubun");
		
		
		
		
		String question = request.getParameter("t_question");
		String answer = request.getParameter("t_answer");
		String sort = request.getParameter("t_sort");
		String reg_id = "관리자";
		String reg_date = CommonUtil.getToday();
		
		int result = 0;
		
		if(pageGubun.equals("등록")) {
			String no = dao.getFaqNo();
			Faq_dto dto = new Faq_dto(no,question,answer,reg_id,reg_date,sort,0);
			result = dao.saveFaq(dto);
			
		}else if(pageGubun.equals("삭제")) {
			String no = request.getParameter("t_no");
			result = dao.deleteFaq(no);
			
		}else if(pageGubun.equals("수정")) {
			String no 		= request.getParameter("t_no");
			Faq_dto dto = 
					new Faq_dto(no,question,answer,reg_id,reg_date,sort,0);
			result = dao.updateFaq(dto);
		}
		
			
			
			
			
			
			String msg="";
			if(result == 0) {
				msg = pageGubun+" 실패~";
			}else {
				msg = pageGubun+" 되었습니다.";
			}
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", "/FaqList");
			
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
