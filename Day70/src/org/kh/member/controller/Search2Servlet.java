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
import org.kh.member.model.vo.Search;
import org.kh.member.model.vo.Search2;

/**
 * Servlet implementation class Search2Servlet
 */
@WebServlet(name = "Search2", urlPatterns = { "/search2" })
public class Search2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    
	    String memberName = request.getParameter("memberName");
	    String memberAddr = request.getParameter("memberAddr");
	    Search2 search = new Search2(memberName, memberAddr);
	    
	    MemberService service = new MemberService();
	    ArrayList<Member> list = service.searchMember2(search);
	    
	    response.setContentType("text/html; charset=utf-8");
	    PrintWriter out = response.getWriter();
            if(!list.isEmpty()) {
                for(Member m : list) {
                    out.println("ID : " + m.getMemberId() + "<br>");
                    out.println("NAME : " + m.getMemberName() + "<br>");
                    out.println("ADDR : " + m.getMemberAddr() + "<br>");
                    out.println("<hr>");
                }
            }else {
                out.println("실패");
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
