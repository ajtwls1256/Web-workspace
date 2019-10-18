package org.kh.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.dao.MemberDao;
import org.kh.member.model.vo.Member;

/**
 * Servlet implementation class SelectAll
 */
@WebServlet("/selectAll")
public class SelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	        //
	        request.setCharacterEncoding("utf-8");
		
		//
		MemberDao dao = new MemberDao();
		ArrayList<Member> ml = dao.selectAll();
		
		
		
		//
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>전체회원조회 페이지</title></head>");
		out.println("<body>");
		
		if(ml.isEmpty()) 
		{
		    out.println("<h2>존재하는 회원이 없습니다.</h2>");
		    out.println("<a href='/views/smember/login.html'>로그인 화면으로 가기</a>");
		}
		else
		{
		    out.println("<table border=1>");
		    out.println("<tr>");
		    out.println("<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>나이</th><th>주소</th><th>성별</th><th>가입일</th>");
		    out.println("</tr>");
		    for(int i =0; i<ml.size();i++) {
		        out.println("<tr>");
		        out.println("<td>"+ml.get(i).getMemberName()+"</td>"+"<td>"+ml.get(i).getMemberPw()+"</td>"+"<td>"+ml.get(i).getMemberName()+"</td>"+"<td>"+ml.get(i).getEmail()+"</td>"+"<td>"+ml.get(i).getAge()+"</td>"+"<td>"+ml.get(i).getAddr()+"</td>"+"<td>"+ml.get(i).getGender()+"</td>"+"<td>"+ml.get(i).getEnrollDate()+"</td>");
		        out.println("</tr>");
		    }
		    
		    out.println("</table>");
		    out.println("<a href='/index.html'>메인으로 돌아가기</a>");
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
