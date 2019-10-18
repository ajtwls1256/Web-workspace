package org.kh.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeCommentUpdateServlet
 */
@WebServlet(name = "NoticeCommentUpdate", urlPatterns = { "/noticeCommentUpdate" })
public class NoticeCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    
	    int noticeCommentNo = Integer.parseInt(request.getParameter("noticeCommentNo"));
	    int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
	    String noticeCommentContent = request.getParameter("noticeCommentContent");
	    
	    NoticeService service = new NoticeService();
	    int result = service.updateNoticeComment(noticeCommentNo, noticeCommentContent);
	    
	    if(result >0) {
	        request.setAttribute("msg", "댓글 수정 성공");
	    }else {
	        request.setAttribute("msg", "댓글 수정 실패");
	    }
	    request.setAttribute("loc", "/noticeView?noticeNo="+noticeNo);
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
