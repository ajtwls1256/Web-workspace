package org.kh.ajax.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.ajax.model.User;

import com.google.gson.Gson;

/**
 * Servlet implementation class AjaxTest10Servlet
 */
@WebServlet(name = "AjaxTest10", urlPatterns = { "/ajaxTest10.do" })
public class AjaxTest10Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest10Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // 예시용으로 디비 대신 쓸 list 생성
            ArrayList<User> list = new ArrayList<>();
            
            User user1 = new User(1, "이윤수1", "서울1");
            User user2 = new User(2, "이윤수2", "서울2");
            User user3 = new User(3, "이윤수3", "서울3");
            User user4 = new User(4, "이윤수4", "서울4");
            User user5 = new User(5, "이윤수5", "서울5");
            
            list.add(user1);
            list.add(user2);
            list.add(user3);
            list.add(user4);
            list.add(user5);
            
            /* GSON으로 list 넘기는 작업 */
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");     // 인코딩 반드시
            
            // Gson gson = new Gson();
            // gson.toJson(list,response.getWriter()); 이 두줄과 아래 한 줄이 동일
            new Gson().toJson(list, response.getWriter());      // list가 JSON으로 바껴서 알아서 넘겨줌
            
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
