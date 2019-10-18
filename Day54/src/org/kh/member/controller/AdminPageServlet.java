package org.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class AdminPageServlet
 */
@WebServlet(name = "AdminPage", urlPatterns = { "/adminPage" })
public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    // 관리자가 아닐때 들어오는 만약의 상황을 대비해 현재 session의 id값으로 확인
	    HttpSession session = request.getSession(false);
	    String memberId = ((Member)session.getAttribute("member")).getMemberId();
	    if(memberId.equals("admin")) {
	        MemberService service = new MemberService();
	        ArrayList<Member> list = service.selectList();
	        
	        if(list.isEmpty()) {
	            
	        }else {
	            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/member/adminPage.jsp");
	            request.setAttribute("members", list);
	            rd.forward(request, response);
	        }
	        
	    }else {
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
	        request.setAttribute("msg", "NAGA");
	        request.setAttribute("loc", "/");
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
