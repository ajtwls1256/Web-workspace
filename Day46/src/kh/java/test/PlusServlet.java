package kh.java.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.servicecontext.ServiceContextData;

/**
 * Servlet implementation class PlusServlet
 */
@WebServlet(name = "Plus", urlPatterns = { "/plus" })
public class PlusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
        // get 요청이 들어왔을 시 ( 지만 결국 다 여기서 처리된다.)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// 서블릿에서 데이터를 처리하는 4단계
		// 1. 전송값에 한글이 있을 경우를 처리하기 위한 인코딩
		request.setCharacterEncoding("utf-8");
		// 2. 웹에서 보내준 데이터를 꺼내서 변수에 저장
		int firstValue = Integer.parseInt(request.getParameter("firstValue")); 	// name 속성에 적은 값으로 가져옴, String 값으로 넘어오기 때문에 변수 형태 맞춰서 형변환
		int secondValue = Integer.parseInt(request.getParameter("secondValue"));
		// 3. 비지니스 로직처리 ( DB작업 )
		
		// 4. 처리결과 내보내기
		response.setContentType("text/html; charset=UTF-8");          // 결과창 한글 인코딩
		PrintWriter out = response.getWriter();
		out.println("<html><head><title> 결과 </title></head>");
		out.println("<body>");
		out.println("<h2>결과</h2><hr>");
		out.println(firstValue + " + " + secondValue + " = " + (firstValue+secondValue));
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	// post 요청이 들어왔을 시
	// 두개를 구분해서 작성하기 힘들기 때문에 doPost() 내부에서 doGet()을 호출하여 처리
	// 그러므로 doGet()만 작성하면 된다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
