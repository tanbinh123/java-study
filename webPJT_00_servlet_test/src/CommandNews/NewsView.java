package CommandNews;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.CommonExecute;
import dao.News_dao;
import dto.News_dto;

public class NewsView implements CommonExecute {

  @Override
  public void execute (HttpServletRequest request, HttpServletResponse response) {
    // TODO Auto-generated method stub
    News_dao dao = new News_dao();
    String no = request.getParameter("t_no");
    dao.getNewshit(no);
    News_dto dto = dao.newsView(no);
    request.setAttribute("t_dto", dto);

  }

}
