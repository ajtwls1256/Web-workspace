package org.kh.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.member.model.vo.Member;

/**
 * Servlet implementation class NoticeWriteServlet
 */
@WebServlet(name = "NoticeWrite", urlPatterns = { "/noticeWrite" })
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    
	    
	    HttpSession session = request.getSession();
	    if(session != null) {
	        String memberId = ((Member)session.getAttribute("member")).getMemberId();
	        
	     // 관리자계정인지 아닌지 한번 더 체크
	        if(memberId.equals("admin")) {
	            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/notice/noticeWrite.jsp");
	            rd.forward(request, response);
	        }else {
	                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
	                request.setAttribute("msg", "NAGA");
	                request.setAttribute("loc", "/");
	                rd.forward(request, response);
	        }
	    }else {
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
                request.setAttribute("msg", "로그인해주세요");
                request.setAttribute("loc", "/noticeList");
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
