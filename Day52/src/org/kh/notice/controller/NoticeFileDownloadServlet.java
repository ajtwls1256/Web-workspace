package org.kh.notice.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeFileDownloadServlet
 */
@WebServlet(name = "NoticeFileDownload", urlPatterns = { "/noticeFileDownload" })
public class NoticeFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩( 그냥 있건없건 무조건 하자)
	    request.setCharacterEncoding("utf-8");
	    
	    // 2. 변수에 값 저장
	    String filename = request.getParameter("filename");
	    String filepath = request.getParameter("filepath");
	    
	    // 3. 비지니스 로직

	    // 1) 파일 저장 경로 생성
	    String saveDirectory = getServletContext().getRealPath("/upload/notice/");
	    // 파일을 읽어오기 위한 스트림 생성
	    FileInputStream fis = new FileInputStream(saveDirectory+filepath);         // 저장경로 + 실제저장된파일명 ,  감싸고있는 doGet메소드에서 IOException을 throws하고있어서 별도의 예외처리가 필요x
	    BufferedInputStream bis = new BufferedInputStream(fis);
	    // 파일을 내보내기 위한 스트림 생성
	    ServletOutputStream sos = response.getOutputStream();
	    BufferedOutputStream bos = new BufferedOutputStream(sos);          // 속도 개선을위한 보조스트림인 버퍼드스트림에 넘겨줌
	    
	    
	    
	    // 2) IE여부 판단
	    boolean bool = request.getHeader("user-agent").indexOf("MSIE") != -1 || request.getHeader("user-agent").indexOf("Trident") != -1;  // request에 브라우저 정보도 같이 넘어가는데 그게 저기 user-agent에 들어가있데
	    System.out.println("IE 여부 : " + bool);
	    
	    // 3) 다운로드 파일이름 설정
	    String resFilename = "";           // 사용자가 저장할 파일 이름
	    if(bool) { // IE인 경우
	        resFilename = URLEncoder.encode(filename, "UTF-8");
	        resFilename = resFilename.replaceAll("\\\\", "%20");           // \\\\가 붙어있다는데 %20 은 공백
	    }else {    // 그 외 다른 브라우저인 경우
	        resFilename = new String(filename.getBytes("UTF-8"),"ISO-8859-1");
	    }
	    
	    // 4) 파일 다운로드를 위한 HTTP Header 설정
	    response.setContentType("application/octet-stream");
	    response.setHeader("Content-Disposition", "attachment;filename="+resFilename);
	    
	    // 5) 파일 전송
	    int read = -1;
	    // 파일을 읽어올게 없을때까지 읽어와서 씀
	    while((read=bis.read()) != - 1) {
	        bos.write(read);
	    }
	    bos.close();
	    bis.close();
	    
	    
	    // 4. 뷰 처리
	    // 는 따로 없다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
