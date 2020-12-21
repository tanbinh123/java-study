package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandNotice.NoticeDelete;
import CommandNotice.NoticeList;
import CommandNotice.NoticeView;
import common.CommonExecute;

/**
 * Servlet implementation class Notice
 */
@WebServlet("/Notice")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notice() {
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
			CommonExecute noti = new NoticeList();
			noti.execute(request, response);
			url = "/notice/notice_list.jsp";
		}else if(gubun.equals("view")){
			CommonExecute noti = new NoticeView();
			noti.execute(request, response);
			url = "/notice/notice_view.jsp";			
		}else if(gubun.equals("write")){
			url = "/notice/notice_write.jsp";
		}else if(gubun.equals("updateForm")){
			CommonExecute noti = new NoticeView();
			noti.execute(request, response);
			url = "/notice/notice_update.jsp";			
		}else if(gubun.equals("delete")){
			CommonExecute noti = new NoticeDelete();
			noti.execute(request, response);
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
