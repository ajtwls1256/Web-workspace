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
 * Servlet implementation class SearchMovieServlet
 */
@WebServlet(name = "SearchMovie", urlPatterns = { "/searchMovie" })
public class SearchMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    
	    // 요청 url (박스오피스)
	    String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
	    // key값에 들어갈 발급받은 키값
	    String key = "2d1960a325f72e312330c46c40440bb2";
	    // targetDt에 들어갈 날짜포맷 생성
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    // 어제날짜로
	    String yesterday = sdf.format(System.currentTimeMillis()-86400000);        // 86400000 하루치 밀리세컨드 -> 지금(오늘) - 하루치 = 어제
	    
	    String result = Jsoup.connect(url)        // 매개변수 url 요청
	                    .data("key",key)           // key=
	                    .data("targetDt",yesterday)        // targetDt=
	                    .userAgent("Mozilla")      // 브라우저로 인식하게만들기
	                    .ignoreContentType(true)   // 스트링뭐? 무시?뭐?
	                    .execute().body();         // 실행, 바디로 가져오면 스트링값으로 가져온데
	    
	    System.out.println(result);
	    
	    
	    /* 결과로 받은 String값을 Json으로 변환하여 사용 */
	    // String 타입 데이터를 반환하기 위한 변환용 객체 생성
	    JsonParser parser = new JsonParser();                 // google꺼 사용
	    // result를 변환하여 JsonObject객체에 저장
	    JsonObject resultInfo = (JsonObject)parser.parse(result);
	    // 키 값이 boxOfficeResult인 값을 저장
	    JsonObject detail1 = resultInfo.getAsJsonObject("boxOfficeResult");
	    System.out.println(detail1);
	    
	    // JsonArray 로 박스오피스 순위를 저장 -> 원본 데이터에 배열로 저장되어있기때문
	    JsonArray rank = detail1.getAsJsonArray("dailyBoxOfficeList");
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    new Gson().toJson(rank, response.getWriter());
	    
	}                
	                    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
