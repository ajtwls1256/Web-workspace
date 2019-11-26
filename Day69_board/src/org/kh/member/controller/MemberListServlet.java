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
import org.kh.member.model.vo.Check;
import org.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet(name = "MemberList", urlPatterns = { "/memberList" })
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    
	    String ckId = request.getParameter("ckId");
	    System.out.println(ckId);  // checkBox가 값을 넘길때 value값안주면 체크안되면 null, 체크되면 on값이 넘어옴
	    String ckPw = request.getParameter("ckPw");
	    String ckName = request.getParameter("ckName");
	    String ckAddr = request.getParameter("ckAddr");
	    
	    Check ck = new Check(ckId, ckPw, ckName, ckAddr);
	    
	    MemberService service = new MemberService();
	    ArrayList<Member> list = service.checkMemberList(ck);
	    
	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    if(!list.isEmpty()) {
	        for(Member m : list) {
	            out.println("No : " + m.getMemberNo() + "<br>");
	            if(m.getMemberId() != null) {
	                out.println("ID : " + m.getMemberId() + "<br>");
	            }

                    if(m.getMemberPw() != null) {
                        out.println("Pw : " + m.getMemberPw() + "<br>");
                    }
                    
                    if(m.getMemberName() != null) {
                        out.println("NAME : " + m.getMemberName() + "<br>");
                    }
                    
                    if(m.getMemberAddr() != null) {
                        out.println("ADDR : " + m.getMemberAddr() + "<br>");
                    }
	            
	            out.println("RegDate : " + m.getRegDate() + "<br>");
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
