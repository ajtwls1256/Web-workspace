package org.kh.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.kh.ajax.model.User;

/**
 * Servlet implementation class AjaxTest5Servlet
 */
@WebServlet(name = "AjaxTest5", urlPatterns = { "/ajaxTest5" })
public class AjaxTest5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest5Servlet() {
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
	    
	    
	    // 값 받아옴
	    int userNum = Integer.parseInt(request.getParameter("userNum"));
	    User user = list.get(userNum-1);   // 인덱스 맞춤
	    
	    JSONObject result = new JSONObject();
	    result.put("userNo", user.getUserNo());
	    // 한글이 들어있는 값들은 인코딩해서 넣어줘야함
	    result.put("userName", URLEncoder.encode(user.getUserName(), "utf-8"));
	    result.put("userAddr", URLEncoder.encode(user.getUserAddr(), "utf-8"));
	    
	   
	    response.setContentType("application/json"); // json을 넘긴다고 세팅
	    PrintWriter out = response.getWriter();
	    out.print(result);
	    out.flush();        // 버퍼링되어 아직 기록되지 않은 데이터를 출력스트림에 모두 출력
	    out.close();        // 출력되지 않은 데이터가있으면 먼저 출력하고 스트림을 닫음
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
