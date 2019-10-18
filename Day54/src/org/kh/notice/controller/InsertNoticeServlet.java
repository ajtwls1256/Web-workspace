package org.kh.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.kh.notice.model.service.NoticeService;
import org.kh.notice.model.vo.Notice;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet(name = "InsertNotice", urlPatterns = { "/insertNotice" })
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    // 1. 인코딩
	    request.setCharacterEncoding("utf-8");
	    
	    // 2. 변수 저장
	    
	    // enctype 체크
	    // 파일업로드 요청이 아니면
	    if(!ServletFileUpload.isMultipartContent(request)) {
	        request.setAttribute("msg", "[enctype]을 확인하세요");
	        request.setAttribute("loc", "/");
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
	        rd.forward(request, response);
	        return;
	    }
	    
	    // 파일 업로드 준비
	    // 1) 파일 업로드 경로 지정
	    String root = getServletContext().getRealPath("/");        // "/" 의 절대경로 가져오기
	    String saveDirectory = root + "upload/notice";
	    // 2) 파일 최대크기 지정
	    // cos 라이브러리의 무료 최대 사이즈는 10MB
	    int maxSize = 10*1024*1024;                        // 10 -> kb -> mb
	    // 3) request -> MultipartRequest
	    // MultipartRequest(request, 저장경로, 최대사이즈, 인코딩, 파일명이 동일할 시 뒤에 넘버링 넣어주는거 추가)
	    // 이 아랫줄쓰는 순간 파일 업로드는 이미 완료됨
	    MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
	    
	    
	    String noticeTitle = mRequest.getParameter("noticeTitle");
	    String noticeContent = mRequest.getParameter("noticeContent");
	    String noticeWriter = mRequest.getParameter("noticeWriter");
	    String filename = mRequest.getOriginalFileName("filename");        // 실제로 올린 파일명
	    String filepath = mRequest.getFilesystemName("filename");          // 업로드된 파일이름(파일명이 같을시 넘버링되므로 달라질 수 있음)
	
	    System.out.println("filename :" + filename);
	    System.out.println("filepath :" + filepath);
	    
            Notice n = new Notice(0, 0, noticeTitle, noticeContent, noticeWriter, null, 0, filename, filepath);
	    
	    
	    // 3. 비지니스 로직
	    NoticeService service = new NoticeService();
	    int result = service.insertNotice(n);
	    
	    
	    // 4. 뷰
	    if(result > 0) {
	        request.setAttribute("msg", "공지사항 등록 성공");
	    }else {
	        request.setAttribute("msg", "공지사항 등록 실패");
	    }
	    request.setAttribute("loc", "/noticeList");
	    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
	    rd.forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
