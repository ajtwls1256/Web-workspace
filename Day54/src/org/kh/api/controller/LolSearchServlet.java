package org.kh.api.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class LolSearchServlet
 */
@WebServlet(name = "LolSearch", urlPatterns = { "/lolSearch" })
public class LolSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LolSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    
	    // 소환사명 받아오기
	    String summoners = request.getParameter("summoners");
	
	    
	    /* 소환사명으로 id 정보 뽑기 */
	    
	    // 요청 url (lol)
            String url = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+summoners+"?api_key=RGAPI-89e46468-04cf-46e8-a581-5e7710af793e";

            String result = Jsoup.connect(url)        // 매개변수 url 요청
                            .userAgent("Mozilla")      // 브라우저로 인식하게만들기
                            .ignoreContentType(true)   // 스트링뭐? 무시?뭐?
                            .execute().body();         // 실행, 바디로 가져오면 스트링값으로 가져온데
            
            
            System.out.println(result);
            
            /* 결과로 받은 String값을 Json으로 변환하여 사용 */
            // String 타입 데이터를 반환하기 위한 변환용 객체 생성
            JsonParser parser = new JsonParser();                 // google꺼 사용
            // result를 변환하여 JsonObject객체에 저장
            JsonObject resultInfo = (JsonObject)parser.parse(result);
            // 키 값이 id인 값을 저장
            String id = resultInfo.get("id").toString().replaceAll("\"", "");
            System.out.println(id);
            
            
            
            /* 추출한 id로 매치 결과 뽑기 */
            String url2 = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/"+id+"?api_key=RGAPI-89e46468-04cf-46e8-a581-5e7710af793e";
            
            String result2 = Jsoup.connect(url2)        // 매개변수 url 요청
                    .userAgent("Mozilla")      // 브라우저로 인식하게만들기
                    .ignoreContentType(true)   // 스트링뭐? 무시?뭐?
                    .execute().body();         // 실행, 바디로 가져오면 스트링값으로 가져온데
            
            
            System.out.println(result2);
            
            /* 결과로 받은 String값을 Json으로 변환하여 사용 */
            // result를 변환하여 JsonArray 로 랭크 정보를 저장 -> 원본 데이터에 배열로 저장되어있기때문
            JsonArray resultInfo2 = (JsonArray)parser.parse(result2);
            
            System.out.println(resultInfo2);
            
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            new Gson().toJson(resultInfo2, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
