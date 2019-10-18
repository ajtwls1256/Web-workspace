package org.kh.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.kh.ajax.model.User;

/**
 * Servlet implementation class AjaxTest7Servlet
 */
@WebServlet(name = "AjaxTest7", urlPatterns = { "/ajaxTest7.do" })
public class AjaxTest7Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest7Servlet() {
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
            String inputString = request.getParameter("userNum");
            
            // 결과를 담을 JSON객체배열
            JSONArray userArray = new JSONArray();
            
            StringTokenizer st = new StringTokenizer(inputString, ",");
            while(st.hasMoreTokens()) {
                int userNum = Integer.parseInt(st.nextToken()) - 1;
                User user = list.get(userNum);
                
                JSONObject userInfo = new JSONObject();
                userInfo.put("userNo", user.getUserNo());
                userInfo.put("userName", URLEncoder.encode(user.getUserName(), "UTF-8"));
                userInfo.put("userAddr", URLEncoder.encode(user.getUserAddr(), "UTF-8"));
                userArray.add(userInfo);
            }
            
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.print(userArray);
            out.flush();
            out.close();
            
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
