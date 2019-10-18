package org.kh.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TestFilter
 */
@WebFilter("/TestFilter")
public class TestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {        
	    // 객체 없앨때 자동으로 호출
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {	

	    
	    // request를 가로채서 로직을 처리하는 코드
	    System.out.println("Servlet 도착 전 필터 출력");
	    String id = request.getParameter("memberId");
	    System.out.println(id+"님이 로그인 시도");
	    
	    
	    chain.doFilter(request, response); // 이 메소드 기준 위는 서버로직 처리 전 , 아래는 후
	    
	    
	    // response를 가로채서 로직을 처리하는 코드
	    System.out.println("Servlet 작업 수행 후 필터 출력");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {       
	    // 객체 생성할 때 자동으로 호출
	}

}
