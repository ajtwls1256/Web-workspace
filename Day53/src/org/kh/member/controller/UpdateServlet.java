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
import org.kh.member.model.vo.Member;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet(name = "Update", urlPatterns = { "/update" })
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
	    String memberPw = request.getParameter("memberPw");
	    String memberName = request.getParameter("memberName");
	    int age = Integer.parseInt(request.getParameter("age"));
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    Member m = new Member(memberId, memberPw, memberName, age, email, phone, null);
	    
	    
	    // 3. 비지니스 로직
	    MemberService service = new MemberService();
	    int result = service.update(m);
	    
	    // 4. 뷰
	    if(result > 0) {
	        // 수정한 값 DB에서 가져오고
	        m = service.selectOne(memberId);
	        
	        // 세션 바꿔주고
	        HttpSession session = request.getSession();
	        session.setAttribute("member", m);
	        
	        // mypage.jsp로 값과 함께 넘겨서 이동
//	        request.setAttribute("member", m);
//	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp");
//	        rd.forward(request, response);
	        
	        // 위의 3줄과 동일한게 아래 한줄
	        response.sendRedirect("/mypage?memberId="+memberId);
	    }else {
	        request.setAttribute("msg", "수정 실패");
	        request.setAttribute("loc", "/mypage?memberId="+memberId);
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
