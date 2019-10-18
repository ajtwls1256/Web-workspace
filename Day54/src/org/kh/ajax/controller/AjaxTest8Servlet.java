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
 * Servlet implementation class AjaxTest8Servlet
 */
@WebServlet(name = "AjaxTest8", urlPatterns = { "/ajaxTest8.do" })
public class AjaxTest8Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest8Servlet() {
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
           ArrayList<Integer> userNum = new ArrayList<>();
           StringTokenizer st = new StringTokenizer(inputString, ",");
           
           while(st.hasMoreTokens()) {
               userNum.add(Integer.parseInt(st.nextToken()) - 1);
           }
           

           // JSON은 키:value 형식을 가지고 있기때문에 value에 JSON객체를 넣으면 MAP형태가 완성!
           JSONObject map = new JSONObject();
           int index = 0;
           while(index < userNum.size()) {
       
               User user = list.get(userNum.get(index));
               JSONObject userInfo = new JSONObject();
               
               userInfo.put("userNo", user.getUserNo());
               userInfo.put("userName", URLEncoder.encode(user.getUserName(), "UTF-8"));
               userInfo.put("userAddr", URLEncoder.encode(user.getUserAddr(), "UTF-8"));
               
               map.put(user.getUserName(), userInfo);
               
               index++;
           }
           
           response.setContentType("application/json");
           PrintWriter out = response.getWriter();
           out.print(map);
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
