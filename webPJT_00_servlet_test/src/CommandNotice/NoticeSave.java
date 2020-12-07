package CommandNotice;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import common.Common;
import common.CommonExecute;
import dao.Notice_dao;
import dto.Notice_dto;

public class NoticeSave implements CommonExecute {

  @Override
  public void execute(HttpServletRequest request, HttpServletResponse response) {
      try {
        request.setCharacterEncoding("utf-8");

    Notice_dao dao = new Notice_dao();
    
//  String file_dir ="C:/Users/JSLHRD/Desktop/jsl43_홍길동/eclipse_source/webPJT_00_homepage4/WebContent/file_room/notice/";
    String file_dir = Common.file_dir_notice;
    int sizeLimit = 1024 * 1024 * 10;
    MultipartRequest mpr;

        mpr = new MultipartRequest(request,file_dir,sizeLimit,"utf-8");
        String no       = dao.getNoticeNo();
        String title    = mpr.getParameter("t_title"); 
        String content  = mpr.getParameter("t_content"); 
        String reg_name = mpr.getParameter("t_reg_name"); 
        String reg_date = mpr.getParameter("t_reg_date"); 
        String attach   = mpr.getFilesystemName("t_attach"); // aaa.hwp
        String dbAttachName ="";
        if(attach != null){
            File oldFile = new File(file_dir,attach);
            File newFile = new File(file_dir, no+"-"+attach); //N025-aaa.hwp
            oldFile.renameTo(newFile);
            dbAttachName = newFile.getName();
        }
        /*  
        String no       = dao.getNoticeNo();
        String title    = request.getParameter("t_title"); 
        String content  = request.getParameter("t_content"); 
        String attach   = request.getParameter("t_attach"); 
        String reg_name = request.getParameter("t_reg_name"); 
        String reg_date = request.getParameter("t_reg_date"); 
    */
        Notice_dto dto = new Notice_dto(no,title,content,dbAttachName,reg_name,reg_date,0);
        int result = dao.saveNotice(dto);
        System.out.println(result);
        String msg="";
        if(result == 1) msg =" 등록 되었습니다. ";
        else msg= " 등록 실패~ ";
        
        
        request.setAttribute("t_msg", msg);
        request.setAttribute("t_url", "/Notice");
        
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
     
      
 
      
    
    
    
  }
  

}
