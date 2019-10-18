package org.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.dao.MemberDao;
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
	    // 1. 문자인코딩
	    request.setCharacterEncoding("utf-8");
	    
	    // 2. 변수저장
	    String id = request.getParameter("id");
	    String pw = request.getParameter("pw");
	    
	    // 3. 비지니스 로직
	    MemberDao dao = new MemberDao();
	    Member m = dao.login(id, pw);
	    
	    // 4. 결과 내보내기
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println("<html><head><title>로그인 결과 페이지</title></head>");
	    out.println("<body>");
	    
	    if(m != null) 
            {
                // 로그인 성공한 경우
	        out.println("<h2>로그인 성공</h2><hr>");
	        out.println("<p>" + m.getMemberName() + "님 환영합니다.");
	        out.println("<a href='/index.html'>메인으로 돌아가기</a>");
	        out.println("<a href='/selectAll'>전체회원조회</a>");
            }
            else 
            { 
                // 로그인 실패한 경우
                out.println("<h2>로그인 실패</h2><hr>");
                out.println("<a href='/views/smember/login.html'>로그인 화면으로 가기</a>");
            }
	    
	    out.println("</body></html>");
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
