package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandNews.NewsDelete;
import CommandNews.NewsSave;
import CommandNews.NewsUpdate;
import CommandNews.NewsView;
import CommandQna.QnaDelete;
import CommandQna.QnaList;
import CommandQna.QnaSave;
import CommandQna.QnaUpdate;
import CommandQna.QnaView;
import CommandQna.answerSave;
import CommandQna.anwserDelete;
import common.CommonExecute;

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
		
		if (gubun.equals("list")){
			CommonExecute qna = new QnaList();
			qna.execute(request, response);
			url = "/qanda/qanda_list.jsp";
		} else if(gubun.equals("view")){
			CommonExecute qna = new QnaView();
			qna.execute(request, response);
			url = "/qanda/qanda_view.jsp";
		} else if(gubun.equals("write")) {
			url = "/qanda/qanda_write.jsp";
		} else if(gubun.equals("save")) {
			CommonExecute qna = new QnaSave();
			qna.execute(request, response);
			url="/common_alert_page.jsp";
		} else if(gubun.equals("qnaUpdateForm")) {
			CommonExecute qna = new QnaView();
			qna.execute(request, response);			
			url = "/qanda/qanda_update.jsp";			
		} else if(gubun.equals("qnaUpdate")){
			CommonExecute qna = new QnaUpdate();
			qna.execute(request, response);
			url="/common_alert_page.jsp";		
		} else if(gubun.equals("qnaDelete")) {
			CommonExecute qna = new QnaDelete();
			qna.execute(request, response);
			url="/common_alert_page.jsp";				
		} else if(gubun.equals("answer")) {
			url = "/qanda/answer_write.jsp";
		} else if(gubun.equals("answerSave")) {
			CommonExecute qna = new answerSave();
			qna.execute(request, response);
			url="/common_alert_page.jsp";
		} else if(gubun.equals("answerUpdateForm")) {
			CommonExecute qna = new QnaView();
			qna.execute(request, response);			
			url = "/qanda/answer_update.jsp";	
		} else if(gubun.equals("answerDelete")) {
			CommonExecute qna = new anwserDelete();
			qna.execute(request, response);
			url="/common_alert_page.jsp";
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
