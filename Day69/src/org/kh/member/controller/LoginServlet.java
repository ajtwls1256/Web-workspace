package org.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값 읽어오기
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		Member m = new Member();//하나하나 전달하는 것 보다 객체타입으로 전달하는 게 훨씬 편함
		m.setMemberId(memberId);
		m.setMemberPw(memberPw);
		//3. 비지니스 로직 수행
		MemberService service = new MemberService();
		Member member = service.loginMember(m);
		//4. 결과처리
		if(member != null) {
		    HttpSession session = request.getSession();
		    session.setAttribute("member", member);
		    RequestDispatcher rd = request.getRequestDispatcher("views/member/mypage.jsp");
		    rd.forward(request, response);
		}else {
		    response.sendRedirect("/");
		}
		
		
		
		/*
		response.setContentType("text/html; charset=UTF-8");//페이지를 따로 만들 게 아니라서 response도 인코딩
		PrintWriter out = response.getWriter();
		if(member != null) {
			out.println("로그인 성공");
		}else{
			out.println("로그인 실패");
		}
		*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
