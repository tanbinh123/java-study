package CommandNotice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonExecute;
import dao.Notice_dao;
import dto.Notice_dto;

public class NoticeView implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Notice_dao dao = new Notice_dao();
		String no = request.getParameter("t_no");
		dao.setHitCount(no);
		Notice_dto dto = dao.getNoticeView(no);
		request.setAttribute("t_dto", dto);
	}

}
