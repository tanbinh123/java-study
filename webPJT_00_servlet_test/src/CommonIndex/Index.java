package CommonIndex;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonExecute;
import dao.Notice_dao;
import dto.Notice_dto;

public class Index implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Notice_dao dao = new Notice_dao();
		ArrayList<Notice_dto> arr = dao.getIndexNotice();
		request.setAttribute("t_arr", arr);
	}

}
