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
	    System.out.println("로그인 Servlet 시작");
	    
	    // 1. 인코딩
	    request.setCharacterEncoding("utf-8");
	    
	    // 2. 변수 저장
	    String memberId = request.getParameter("memberId");
	    String memberPw = request.getParameter("memberPw");
	    
	    // 3. 비지니스 로직
	    MemberService service = new MemberService();
	    Member m = service.login(memberId, memberPw);
	    

	    
	    // 4. view 처리
	    if(m != null) {
	        // servlet에선 session이 내장객체가 아니므로 생성하여 값을 넣어줘야함.
	        HttpSession session = request.getSession();
	        session.setAttribute("member", m);
	        request.setAttribute("msg", "로그인 성공");
	    }else {
	        request.setAttribute("msg", "로그인 실패");
	    }
	    
	    request.setAttribute("loc", "/");          // 메시지 처리가 끝나고 이동할 페이지
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp"); // 메시지 처리를 위해 이동할 페이지 
	    rd.forward(request, response);             // request와 response 를 들고 페이지 이동, response는 큰 의미는 모르겠는데 매개변수로 반드시 있어야함
	    // 주소창에서도 msg.jsp가 나오지않고 requestDispatcher 를 호출한 이곳의 주소만 나온다.
	    // WEB-INF 아래에 작성한 페이지들은 일반적인 방법(url을 통해)으로는 접근할 수 없고 requestDispatcher나 include를 통해서만 가능하다.
	    // 보안성을 위해 접근하지못하게 자동으로 설정되어있다.
	    
	    System.out.println("로그인 Servlet 끝");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
