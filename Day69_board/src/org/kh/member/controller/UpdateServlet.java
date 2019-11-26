package org.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            
            // 2. 전달값 저장            
            String memberId = request.getParameter("memberId");
            String memberPw = request.getParameter("memberPw");
            String memberName = request.getParameter("memberName");
            String memberAddr = request.getParameter("memberAddr");
            Member m = new Member(0, memberId, memberPw, memberName, memberAddr, null);
            
            MemberService service = new MemberService();
            int result = service.updateMember(m);
            
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            if(result > 0) {
                out.print("성공");
            }else {
                out.print("실패");
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
