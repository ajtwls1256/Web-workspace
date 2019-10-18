package org.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.service.MemberService;
import org.kh.member.model.vo.Member;

/**
 * Servlet implementation class SearchKeywordServlet
 */
@WebServlet(name = "SearchKeyword", urlPatterns = { "/searchKeyword" })
public class SearchKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchKeywordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    request.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		
		MemberService service = new MemberService();
		ArrayList<Member> list = service.searchKeyword(type,keyword);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/adminPage.jsp");
		
		request.setAttribute("type", type);
		request.setAttribute("keyword", keyword);
    		request.setAttribute("members", list);
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
