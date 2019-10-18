package org.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.service.MemberService;
import org.kh.member.model.vo.Member;

/**
 * Servlet implementation class FindPwServlet
 */
@WebServlet(name = "FindPw", urlPatterns = { "/findPw" })
public class FindPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    request.setCharacterEncoding("utf-8");
            
            String memberId = request.getParameter("memberId");
            String memberName = request.getParameter("memberName");
            String email = request.getParameter("email");
            
            Member m = new Member();
            m.setMemberId(memberId);
            m.setMemberName(memberName);
            m.setEmail(email);
            
            
            MemberService service = new MemberService();
            String memberPw = service.findPw(m);
            
            if(memberId.length() > 0) {
                request.setAttribute("msg", "찾으시는 회원님의 PW는 [" + memberPw + "] 입니다.");
            }else {
                request.setAttribute("msg", "회원님의 정보와 일치하는 PW가 없습니다.");
            }
            request.setAttribute("loc", "/");
            
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
