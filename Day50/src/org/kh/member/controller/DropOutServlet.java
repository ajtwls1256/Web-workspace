package org.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.service.MemberService;

/**
 * Servlet implementation class DropOutServlet
 */
@WebServlet(name = "DropOut", urlPatterns = { "/dropOut" })
public class DropOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropOutServlet() {
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
	    String memberId = request.getParameter("memberId");
	    System.out.println(memberId);
	    
	    // 3. 비지니스 처리
	    MemberService service = new MemberService();
	    int result = service.delete(memberId);
	    
	    // 4. 뷰
	    if(result > 0) {
	        request.setAttribute("msg", "탈퇴 성공");
	    }else {
	        request.setAttribute("msg", "탈퇴 실패");
	    }
	    
	    request.setAttribute("loc", "/adminPage");
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
