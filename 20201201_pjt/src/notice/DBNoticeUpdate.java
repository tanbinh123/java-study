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
 * Servlet implementation class DBNoticeUpdate
 */
@WebServlet("/DBNoticeUpdate")
public class DBNoticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBNoticeUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Notice_dao dao = new Notice_dao();
		
		String file_dir = CommonUtil.file_dir_notice;
		int sizeLimit = 1024 * 1024 * 10;
		MultipartRequest mpr = new MultipartRequest(request,file_dir,sizeLimit,"utf-8");

		String no 		= mpr.getParameter("t_no");		
/* 첨부파일 */		
		String del_attach = mpr.getParameter("t_del_attach");
		String dbAttachName =""; 
		boolean delYN = true;
		if(del_attach != null){
			File delFile = new File(file_dir,del_attach);
			delFile.delete();
			delYN = false;
		} else {
			dbAttachName = mpr.getParameter("t_ori_attach");
		}

		String attach 	= mpr.getFilesystemName("t_attach"); // aaa.hwp
		if(attach != null){
			String df = mpr.getParameter("t_ori_attach");
			if(!df.equals("") && delYN==true){
				File delFile = new File(file_dir,df);
				delFile.delete();	
			}
			File oldFile = new File(file_dir,attach);
			File newFile = new File(file_dir, no+"-"+attach); //N025-aaa.hwp
			oldFile.renameTo(newFile);
			dbAttachName = newFile.getName();
		}			
/* 첨부파일 */		
		
		String title 	= mpr.getParameter("t_title");
		String content 	= mpr.getParameter("t_content");
		String reg_name = "관리자";
		String reg_date = CommonUtil.getToday();
		Notice_dto dto = 
				new Notice_dto(no,title,content,dbAttachName,reg_name,reg_date,0);
		int result = dao.updateNotice(dto);
		
		String msg ="";
		if(result ==0) msg =" 수정 실패 ~ ";	
		else msg =" 수정 되었습니다. ";
		
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
