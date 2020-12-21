package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CommandFreeboard.FreeboardDelete;
import CommandFreeboard.FreeboardList;
import CommandFreeboard.FreeboardSave;
import CommandFreeboard.FreeboardUpdate;
import CommandFreeboard.FreeboardView;

/**
 * Servlet implementation class freeboard
 */
@WebServlet("/Freeboard")
public class Freeboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Freeboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun = "list";
		
		String url = "";
		if (gubun.equals("list")) {
			FreeboardList free = new FreeboardList();
			free.execute(request, response); 
			url = "/freeboard/freeboard_list.jsp";
		}else if(gubun.equals("write")) {
			url = "/freeboard/freeboard_write.jsp";
		}else if(gubun.equals("save")) {
			FreeboardSave free = new FreeboardSave();
			free.execute(request, response); 
			url = "/common_alert_page.jsp";	
		}else if(gubun.equals("view")) {
			FreeboardView free = new FreeboardView();
			free.execute(request, response); 
			url = "/freeboard/freeboard_view.jsp";
		}else if(gubun.equals("updateForm")) {
			FreeboardView free = new FreeboardView();
			free.execute(request, response);
			url = "/freeboard/freeboard_update.jsp";
		}else if(gubun.equals("update")) {
			FreeboardUpdate free = new FreeboardUpdate();
			free.execute(request, response);
			url="/common_alert_page.jsp";	
		}else if(gubun.equals("delete")) {
			FreeboardDelete free = new FreeboardDelete();
			free.execute(request, response);
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
