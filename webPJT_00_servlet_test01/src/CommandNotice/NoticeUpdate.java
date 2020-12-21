package CommandNotice;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import common.Common;
import dao.Notice_dao;
import dto.Notice_dto;

/**
 * Servlet implementation class NoticeUpdate
 */
@WebServlet("/NoticeUpdate")
public class NoticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Notice_dao dao = new Notice_dao();
		
		//String file_dir ="C:/Users/JSLHRD/Desktop/jsl43_홍길동/eclipse_source/webPJT_00_homepage4/WebContent/file_room/notice/";
		String file_dir = Common.file_dir_notice;
		int sizeLimit = 1024 * 1024 * 10;
		MultipartRequest mpr = new MultipartRequest(request,file_dir,sizeLimit,"utf-8");
		
		String no 		= mpr.getParameter("t_no"); 
		String title 	= mpr.getParameter("t_title"); 
		String content 	= mpr.getParameter("t_content"); 
		String reg_name = mpr.getParameter("t_reg_name"); 
		String reg_date = mpr.getParameter("t_reg_date"); 	

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
		
		String msg="";
		Notice_dto dto = new Notice_dto(no,title,content,dbAttachName,reg_name,reg_date,0);				
		int result = dao.updateNotice(dto);
		if(result == 1) msg =" 수정 되었습니다. ";
		else msg=" 수정 실패~ ";	

		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "/Notice");
		request.setAttribute("t_gubun", "view");
		request.setAttribute("t_no", no);
		
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
