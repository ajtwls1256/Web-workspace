package org.kh.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.board.model.service.BoardService;
import org.kh.board.model.vo.Board;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet(name = "BoardView", urlPatterns = { "/boardView" })
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int boardNo = Integer.parseInt(request.getParameter("boardNo"));
	    
	    BoardService service = new BoardService();
	    Board board = service.selectOne(boardNo);
	    
	    if(board != null) {
	        request.setAttribute("board", board);
	        
	    }else {
	        
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
