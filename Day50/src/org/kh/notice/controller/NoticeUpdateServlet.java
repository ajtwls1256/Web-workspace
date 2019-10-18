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

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet(name = "NoticeUpdate", urlPatterns = { "/noticeUpdate" })
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 1. 인코딩
	    request.setCharacterEncoding("utf-8");
	    
	    // 2. 변수 저장
	    int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
	    
	    // 3. 비지니스 로직
	    NoticeService service = new NoticeService();
	    Notice n = service.selectOne(noticeNo);
	    if(n != null) {
	        request.setAttribute("notice", n);
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/notice/noticeUpdate.jsp");
	        rd.forward(request, response);
	    }else {
	        // 따로 작성하렴
	    }
	    
	    // 4. 뷰
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
