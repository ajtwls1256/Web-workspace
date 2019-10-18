package org.kh.ajax.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.ajax.model.User;

import com.google.gson.Gson;

/**
 * Servlet implementation class AjaxTest11Servlet
 */
@WebServlet(name = "AjaxTest11", urlPatterns = { "/ajaxTest11.do" })
public class AjaxTest11Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest11Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
            User user1 = new User(1, "이윤수1", "서울1");
            User user2 = new User(2, "이윤수2", "서울2");
            User user3 = new User(3, "이윤수3", "서울3");
            User user4 = new User(4, "이윤수4", "서울4");
            User user5 = new User(5, "이윤수5", "서울5");
            
            HashMap<String, User> map = new HashMap<>();
            map.put(user1.getUserName(), user1);
            map.put(user2.getUserName(), user2);
            map.put(user3.getUserName(), user3);
            map.put(user4.getUserName(), user4);
            map.put(user5.getUserName(), user5);
            
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
	
            Gson gson = new Gson();
            gson.toJson(map, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
