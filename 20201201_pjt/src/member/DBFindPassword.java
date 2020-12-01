package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.MailContentSend;
import dao.Member_dao;

/**
 * Servlet implementation class DBFindPassword
 */
@WebServlet("/DBFindPassword")
public class DBFindPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBFindPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member_dao dao = new Member_dao();
		String id 	  = request.getParameter("t_id");
		String tel_1  = request.getParameter("t_tel_1");
		String tel_2  = request.getParameter("t_tel_2");
		String tel_3  = request.getParameter("t_tel_3");
		String mail_1 = request.getParameter("t_mail_1");
		String mail_2 = request.getParameter("t_mail_input");
		
		String pw = dao.idMemberCheck(id,tel_1,tel_2,tel_3);
		String msg ="";
		
		if(!pw.equals("")) { // 비밀번호 메일발송
			MailContentSend mailSend = new MailContentSend();
			String mailHost ="smtp.naver.com";
			String mailUser ="sshj0803";
			String mailPassword="kyhkhs0088";
			mailSend.setMail(mailHost, mailUser, mailPassword);
			
			String fromMail ="sshj0803@naver.com";
			String toMail=mail_1+"@"+mail_2;
			String title ="비밀번호 안내";
			String attachImg ="C:\\pw_jam_400_200.jpg";
			String content =
				"<table width='400' height='200' border='0' background='cid:image'>"+
				"<tr>"+
				"	<td colspan='2' align='center'>고객님의 비밀 번호 안내</td>"+
				"</tr>"+	
				"<tr>"+
				"	<td width='100' align='center'>비밀번호</td>"+
				"	<td align='center'><font size='15' color='blue'>"+pw+"</font></td>"+
				"</tr>"+	
				"</table>";					
			
			boolean tf = true;
			try {
				mailSend.sendMail(fromMail, toMail, title, content, attachImg);
			} catch (Exception e) {
				e.printStackTrace();
				tf =false;
			}
			if(tf) msg =" 요청하신 이메일 주소로 비밀번호가 발송되었습니다.";
			else msg =" 이메일 발송 오류~~";
			
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", "/Login");
		} else {
			msg = "아이디 또는 전화번호가 틀립니다. 확인후 다시 시도하십시요~";
			request.setAttribute("t_msg", msg);
			request.setAttribute("t_url", "/MemberPwFind");
		}
		RequestDispatcher rd = 
				request.getRequestDispatcher("/common_alert_page.jsp");
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
