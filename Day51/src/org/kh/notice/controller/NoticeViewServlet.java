package org.kh.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.notice.model.service.NoticeService;
import org.kh.notice.model.vo.Notice;
import org.kh.notice.model.vo.NoticeViewData;

/**
 * Servlet implementation class NoticeViewServlet
 */
@WebServlet(name = "NoticeView", urlPatterns = { "/noticeView" })
public class NoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    
	    int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
	    NoticeService service = new NoticeService();
	    NoticeViewData nvd = service.selectOne(noticeNo);
	    
	    if(nvd.getN() != null) {
	        request.setAttribute("notice", nvd.getN());
	        request.setAttribute("comments", nvd.getList());
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/notice/noticeView.jsp");
	        rd.forward(request, response);
	    }else {
	        request.setAttribute("msg", "해당 게시글이 존재하지않습니다.");
	        request.setAttribute("loc", "/noticeList");
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
	        rd.forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
