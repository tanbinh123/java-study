package notice;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import common.CommonUtil;
import dao.Notice_dao;
import dto.Notice_dto;

/**
 * Servlet implementation class DBNoticeSave
 */
@WebServlet("/DBNoticeSave")
public class DBNoticeSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBNoticeSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Notice_dao dao = new Notice_dao();
		
		String no 		= dao.getNoticeNo();
		
		String file_dir = CommonUtil.file_dir_notice;
		int sizeLimit = 1024 * 1024 * 10;
		MultipartRequest mpr = new MultipartRequest(request,file_dir,sizeLimit,"utf-8");
		
		String attach 	= mpr.getFilesystemName("t_attach"); //aa.hwp
		String dbAttachName = "";
		
		if (attach != null){ //파일 저장 이름 변경
			File oldFile = new File(file_dir,attach);
			File newFile = new File(file_dir,no+"-"+attach);//N025-aaaa.hwp
			oldFile.renameTo(newFile);
			dbAttachName = newFile.getName();
		}
		
		String title 	= mpr.getParameter("t_title");
		String content 	= mpr.getParameter("t_content");
		String reg_name = "관리자";
		String reg_date = CommonUtil.getToday();
		Notice_dto dto = 
				new Notice_dto(no,title,content,dbAttachName,reg_name,reg_date,0);
		int result = dao.saveNotice(dto);

		String msg ="";
		if(result ==0) {
			msg =" 등록 실패 ~ ";	
		}else {
			msg =" 등록 되었습니다. ";
		}
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/NoticeList");

		RequestDispatcher rd =
				request.getRequestDispatcher("/common_alert_page.jsp");
		rd.forward(request, response);
//		response.sendRedirect("/NoticeList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
