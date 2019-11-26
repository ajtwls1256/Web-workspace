package org.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.board.model.service.BoardService;
import org.kh.board.model.vo.Board;
import org.kh.board.model.vo.BoardPage;
import org.kh.member.model.vo.Member;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet(name = "BoardList", urlPatterns = { "/boardList" })
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    
	    int reqPage;
	    
	    try {
	        reqPage = Integer.parseInt(request.getParameter("reqPage"));
	    }catch(Exception e) {
	        reqPage = 1;
	    }
	    
	    
	    
	    
	    BoardService service = new BoardService();
	    BoardPage bp = service.selectBoardList(reqPage);
	    
	    if(bp == null) {
	        System.out.println("리스트가 비어있음");
	    }else {
	        request.setAttribute("bp", bp);
	    }
	   
	    RequestDispatcher rd = request.getRequestDispatcher("/views/board/board.jsp");
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
