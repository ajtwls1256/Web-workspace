package org.kh.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.board.model.service.BoardService;
import org.kh.board.model.vo.BoardPageData;

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
	    // 1. 인코딩
	    request.setCharacterEncoding("utf-8");
	    
	    // 2. 변수저장
	    int reqPage;
	    try {
	        reqPage = Integer.parseInt(request.getParameter("reqPage"));
	    }catch(NumberFormatException e) {
	        reqPage = 1;
	    }
	    
	    
	    // 3. 비지니스 로직
	    BoardService service = new BoardService();
	    BoardPageData bpd = service.selectList(reqPage);
	    
	    
	    // 4. view 처리
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/boardList.jsp");
	    request.setAttribute("bpd", bpd);
	    
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
