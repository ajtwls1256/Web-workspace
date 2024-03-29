package test.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.model.vo.Member;

/**
 * Servlet implementation class ELServletTest4Servlet
 */
@WebServlet(name = "ELServletTest4", urlPatterns = { "/ELServletTest4" })
public class ELServletTest4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ELServletTest4Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ArrayList<Member> list = new ArrayList<>();
	    list.add(new Member("user01", "pass01", "이름1", 10));
	    list.add(new Member("user02", "pass02", "이름2", 20));
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/EL/jsp_EL_Test4.jsp");
            request.setAttribute("list", list);
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
