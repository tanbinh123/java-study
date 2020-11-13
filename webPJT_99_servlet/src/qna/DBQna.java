package qna;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.Qna_dao;
import dto.Qna_dto;

/**
 * Servlet implementation class DBQna
 */
@WebServlet("/DBQna")
public class DBQna extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBQna() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Qna_dao dao = new Qna_dao();
		
		String pageGubun = request.getParameter("t_pageGubun");
		
		
		
		
		String title = request.getParameter("t_title");
		String content = request.getParameter("t_answer");
		String reg_name = "관리자";
		String reg_date = CommonUtil.getToday();
		int result = 0;
		
		if(pageGubun.equals("등록")) {
			String no = dao.getQnaNo();
			String groupno = dao.getGroupNo(); 
			Qna_dto dto = new Qna_dto(no, title, groupno, reg_date, reg_name, content, 0, 0, 0);
			result = dao.saveQna(dto);
			
		}else if(pageGubun.equals("삭제")) {
			String no = request.getParameter("t_no");
			result = dao.deleteQna(no);
			
		}/*else if(pageGubun.equals("수정")) {
			String no 		= request.getParameter("t_no");
			Qna_dto dto = 
					new Qna_dto(no,question,answer,reg_id,reg_date,sort,0);
			result = dao.updateQna(dto);
		}*/
		
			
			
			
			
			
			String msg="";
			if(result == 0) {
				msg = pageGubun+" 실패~";
			}else {
				msg = pageGubun+" 되었습니다.";
			}
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", "/QnaList");
			
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
