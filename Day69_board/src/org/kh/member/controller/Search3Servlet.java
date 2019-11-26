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
 * Servlet implementation class Search3Servlet
 */
@WebServlet(name = "Search3", urlPatterns = { "/search3" })
public class Search3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    
	    // 체크박스는 중복체크가 가능하므로 getParameterValues로받아줌
	    String[] addr = request.getParameterValues("addr");
	    
	    MemberService service = new MemberService();
	    ArrayList<Member> list = service.search3Member(addr);
	    
	    
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
