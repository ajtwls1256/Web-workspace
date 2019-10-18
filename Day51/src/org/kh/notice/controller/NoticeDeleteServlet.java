package org.kh.notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.notice.model.service.NoticeService;



/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet(name = "NoticeDelete", urlPatterns = { "/noticeDelete" })
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	    request.setCharacterEncoding("utf-8");
	    
	    int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
	    String filepath = request.getParameter("filepath");
	    
	    NoticeService service = new NoticeService();
	    int result = service.deleteNotice(noticeNo);
	    
	    if(result > 0) {
	        
	        /* 파일 삭제 */
	        if(filepath != null) {
	            String saveDirectory = getServletContext().getRealPath("/upload/notice/");
	            File delFile = new File(saveDirectory+filepath);
	            
	            // 파일이 존재하면
	            if(delFile.exists()) {
	                delFile.delete();
	            }
	        }
	        

	        request.setAttribute("msg", "공지사항 삭제 성공");
	        request.setAttribute("loc", "/noticeList");

	    }else {
	        request.setAttribute("msg", "공지사항 삭제 실패");
                request.setAttribute("loc", "/noticeView?noticeNo="+noticeNo);
	    }
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
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
