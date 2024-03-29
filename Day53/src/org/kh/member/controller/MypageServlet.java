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
 * Servlet implementation class MypageServlet
 */
@WebServlet(name = "Mypage", urlPatterns = { "/mypage" })
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
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
//	    System.out.println(memberId);
	    
	    // 3. 비지니스 로직
	    MemberService service = new MemberService();
	    Member m = service.selectOne(memberId);
	    
	    
	    // 4. 뷰
	    if(m != null) {
	        request.setAttribute("member", m);
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp");
	        rd.forward(request, response);                 // 넘겨줄 값이 있으므로 requestDispatcher를 이용해 이동
	    }else {
	        response.sendRedirect("/");                    // 같이 넘겨줄 값이 없기때문에 response로 페이지이동
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
