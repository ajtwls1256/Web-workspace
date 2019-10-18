package org.kh.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.notice.model.service.NoticeService;
import org.kh.notice.model.vo.Notice;
import org.kh.notice.model.vo.PageData;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet(name = "NoticeList", urlPatterns = { "/noticeList" })
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 1. 인코딩
	    request.setCharacterEncoding("utf-8");
	    
	    // 2. 변수저장
	    int reqPage;
	    
	    // 예외처리를 이용해서 넘겨준 값이 없을때를 처리 
	    try {
	        reqPage = Integer.parseInt(request.getParameter("reqPage"));
	    }catch(NumberFormatException e) {
	        // 넘겨준 값이  없으면 null이 넘어와 오류가 발생하므로 여기로 넘어옴
	        reqPage = 1;
	    }
	    
	    
	    // 3. 비지니스 로직
	    NoticeService service = new NoticeService();
	    PageData pd = service.selectList(reqPage);
	    
	    // 4. view 처리
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/notice/noticeList.jsp");
	    request.setAttribute("pd", pd);
	    
	    
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
