package org.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.member.model.service.MemberService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(name = "Delete", urlPatterns = { "/delete" })
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
	    String memberId = request.getParameter("memberId");
	    
	    // 3. 비즈니스 로직
	    MemberService service = new MemberService();
	    int result = service.delete(memberId);
	    
	    // 4. 뷰
	    if(result > 0) {
	        // 세션 초기화
	        HttpSession session = request.getSession();
	        session.invalidate();
	        
	        request.setAttribute("msg", "회원 탈퇴 성공");
	        request.setAttribute("loc", "/");
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
	        rd.forward(request, response);
	        
	    }else {
	        request.setAttribute("msg", "회원 탈퇴 실패");
                request.setAttribute("loc", "/mypage?member_id="+memberId);
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
