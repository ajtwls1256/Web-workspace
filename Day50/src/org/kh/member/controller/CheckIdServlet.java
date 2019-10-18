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
 * Servlet implementation class CheckIdServlet
 */
@WebServlet(name = "CheckId", urlPatterns = { "/checkId" })
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdServlet() {
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
	    String memberId = request.getParameter("checkId");
	    
	    
	    // 3. 비지니스 로직
	    MemberService service = new MemberService();
	    Member m = service.selectOne(memberId);
	    
	    // 4. 뷰
	    if(m == null){     // 아이디가 중복되지않아서 사용가능
	        request.setAttribute("result", true);
	    }else {            // 아이디 중복으로 사용 불가능
	        request.setAttribute("result", false);
	    }
	    request.setAttribute("checkId", memberId);
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/checkId.jsp");
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
