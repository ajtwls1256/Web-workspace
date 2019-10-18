package org.kh.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.notice.model.service.NoticeService;
import org.kh.notice.model.vo.NoticeComment;

/**
 * Servlet implementation class NoticeCommentInsertServlet
 */
@WebServlet(name = "NoticeCommentInsert", urlPatterns = { "/noticeCommentInsert" })
public class NoticeCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    request.setCharacterEncoding("utf-8");
	    
	    
	    String noticeCommentWriter = request.getParameter("noticeCommentWriter");
	    int noticeRef = Integer.parseInt(request.getParameter("noticeRef"));
	    int noticeCommentLevel = Integer.parseInt(request.getParameter("noticeCommentLevel"));
	    int noticeCommentRef = Integer.parseInt(request.getParameter("noticeCommentRef"));
	    String noticeCommentContent = request.getParameter("noticeCommentContent");
	    
	    System.out.println(noticeCommentWriter);
	    System.out.println(noticeRef);
	    System.out.println(noticeCommentLevel);
	    System.out.println(noticeCommentRef);
	    System.out.println(noticeCommentContent);
	    
	    
	    NoticeComment nc = new NoticeComment(0, noticeCommentLevel, noticeCommentWriter, noticeCommentContent, noticeRef, noticeCommentRef, null);
	    
	    NoticeService service = new NoticeService();
	    int result = service.insertNoticeComment(nc);
	    
	    if(result > 0) {
	        request.setAttribute("msg", "댓글 등록 성공");
	    }else {
	        request.setAttribute("msg", "댓글 등록 실패");
	    }
	    request.setAttribute("loc", "/noticeView?noticeNo="+noticeRef);
	    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
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
