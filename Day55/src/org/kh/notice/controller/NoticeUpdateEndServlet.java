package org.kh.notice.controller;

import java.io.File;
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
 * Servlet implementation class NoticeUpdateEndServlet
 */
@WebServlet(name = "NoticeUpdateEnd", urlPatterns = { "/noticeUpdateEnd" })
public class NoticeUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateEndServlet() {
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
            int maxSize = 10*1024*0124;                        // 10 -> kb -> mb
            // 3) request -> MultipartRequest
            // MultipartRequest(request, 저장경로, 최대사이즈, 인코딩, 파일명이 동일할 시 뒤에 넘버링 넣어주는거 추가)
            // 이 아랫줄쓰는 순간 파일 업로드는 이미 완료됨
            MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
            
            
	    int noticeNo = Integer.parseInt(mRequest.getParameter("noticeNo"));
	    String noticeTitle = mRequest.getParameter("noticeTitle");
	    String filename = mRequest.getOriginalFileName("filename");
	    String filepath = mRequest.getFilesystemName("filename");	            
	    String noticeContent = mRequest.getParameter("noticeContent");
	    

	    // 기존 파일 삭제 여부 확인
	    String status = mRequest.getParameter("status");
	    String oldFilename = mRequest.getParameter("oldFilename");
	    String oldFilepath = mRequest.getParameter("oldFilepath");
	    
	    if(filename != null) { // 새 첨부파일이 있는 경우
	        if(oldFilename != null) {      // 기존 첨부파일이 있는 경우
	            // 기존 파일 삭제로직
	            File delFile = new File(saveDirectory+"/"+oldFilepath);
	            System.out.println(delFile.delete()?"삭제성공":"삭제실패");
	        }
	    }else {                    // 새 첨부파일이 없는 경우
	        if(status.equals("stay")) {    // old파일 상태 그대로 유지
	            filename = oldFilename;
	            filepath = oldFilepath;
	        }else if(status.equals("delete")){     // old파일을 삭제
	            File delFile = new File(saveDirectory+"/"+oldFilepath);
	            System.out.println(delFile.delete()?"삭제성공":"삭제실패");
	        }
	    }
	    
	    Notice n = new Notice(0, noticeNo, noticeTitle, noticeContent, null, null, 0, filename, filepath);
	    
	    
	    
	    
	    // 3. 비지니스 로직
	    NoticeService service = new NoticeService();
	    int result = service.updateNotice(n);
	    
	    
	    // 4. 뷰
	    if(result > 0) {
	        request.setAttribute("msg", "공지사항 수정 성공");
	    }else {
	        request.setAttribute("msg", "공지사항 수정 실패");
	    }
	    request.setAttribute("loc", "/noticeView?noticeNo="+noticeNo);
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
