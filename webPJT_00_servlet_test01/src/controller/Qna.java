package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandQna.QnaAnswerSave;
import CommandQna.QnaAnswerUpdate;
import CommandQna.QnaList;
import CommandQna.QnaQueUpdate;
import CommandQna.QnaSave;
import CommandQna.QnaView;
import CommandQna.Qnadelete;
import common.CommonExecute;
import dao.Qanda_dao;

/**
 * Servlet implementation class Qna
 */
@WebServlet("/Qna")
public class Qna extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Qna() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun ="list";
		String url ="";
		if(gubun.equals("list")){
			CommonExecute Qanda = new QnaList();
			Qanda.execute(request, response);
			url = "/qanda/qanda_list.jsp";
		}else if(gubun.equals("write")){
			url="/qanda/qanda_write.jsp";
		}else if(gubun.equals("save")){
			CommonExecute Qanda = new QnaSave();
			Qanda.execute(request, response);
			url = "/common_alert_page.jsp";
		}else if(gubun.equals("view")){
			CommonExecute Qanda = new QnaView();
			Qanda.execute(request, response);
			url = "/qanda/qanda_view.jsp";
		}else if(gubun.equals("queupdateForm")){
			CommonExecute Qanda = new QnaView();
			Qanda.execute(request, response);
			url = "/qanda/qanda_update.jsp";
		}else if(gubun.equals("QueUpdate")){
			CommonExecute Qanda = new QnaQueUpdate();
			Qanda.execute(request, response);
			url = "/common_alert_page.jsp";
		}else if(gubun.equals("queDelete")){
			CommonExecute Qanda = new Qnadelete();
			Qanda.execute(request, response);
			url = "/common_alert_page.jsp";
		}else if(gubun.equals("answerForm")){
			CommonExecute Qanda = new QnaView();
			Qanda.execute(request, response);
			url = "/qanda/answer_write.jsp";
		}else if(gubun.equals("answerSave")){
			CommonExecute Qanda = new QnaAnswerSave();
			Qanda.execute(request, response);
			url = "/common_alert_page.jsp";
		}else if(gubun.equals("ansUpdateForm")){
			CommonExecute Qanda = new QnaView();
			Qanda.execute(request, response);
			url = "/qanda/answer_update.jsp";
		}else if(gubun.equals("answerUpdate")){
			CommonExecute Qanda = new QnaAnswerUpdate();
			Qanda.execute(request, response);
			url = "/common_alert_page.jsp";
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
