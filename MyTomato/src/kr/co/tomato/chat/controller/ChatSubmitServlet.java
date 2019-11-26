package kr.co.tomato.chat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tomato.chat.model.dao.ChatDao;
import kr.co.tomato.chat.model.service.ChatService;

/**
 * Servlet implementation class ChatSubmitServlet
 */
@WebServlet(name = "ChatSubmit", urlPatterns = { "/chatSubmit" })
public class ChatSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    
	    String chatName = request.getParameter("chatName");
	    String chatContent = request.getParameter("chatContent");

	    
	    response.setContentType("text/html);charset=UTF-8");
	    
	    if(chatName == null || chatName.equals("") || chatContent == null || chatContent.equals("")) {
	        response.getWriter().write("0");
	    }else {
	        response.getWriter().write(new ChatService().submit(chatName, chatContent) + "");  // 성공적으로 적용되면 1반환
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
