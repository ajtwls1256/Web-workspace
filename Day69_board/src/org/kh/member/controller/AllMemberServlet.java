package org.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.service.MemberService;
import org.kh.member.model.vo.Member;

/**
 * Servlet implementation class AllMemberServlet
 */
@WebServlet(name = "AllMember", urlPatterns = { "/allMember" })
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		//2. 변수 저장
		//3. 비지니스 로직
		MemberService service = new MemberService();
		ArrayList<Member> list = service.selectAllMember();
		//4. 결과처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(!list.isEmpty()) {
			for(Member m : list) {
				out.println(m.getMemberName()+"<br>");
			}
		}else {
			out.println("읽어오기 실패");
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
