package org.kh.photo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.kh.photo.model.service.PhotoService;
import org.kh.photo.model.vo.Photo;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class InsertPhotoServlet
 */
@WebServlet(name = "InsertPhoto", urlPatterns = { "/insertPhoto" })
public class InsertPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPhotoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
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
            String saveDirectory = getServletContext().getRealPath("/upload/photo");
            // 2) 파일 최대 크기 지정
            int maxSize = 10*1024*1024;
	    // 3) request -> MultipartRequest
            MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
            
            String photoWriter = mRequest.getParameter("photoWriter");
            String photoContent = mRequest.getParameter("photoContent");
            String filename = mRequest.getOriginalFileName("filename");
            String filepath = mRequest.getFilesystemName("filename");
            
            Photo p = new Photo(0, photoWriter, photoContent, filename, filepath, null);
            
            
            
            // 3. 비지니스 로직
            PhotoService service = new PhotoService();
            int result = service.insertPhoto(p);
            
            
            // 4. 뷰
            if(result > 0) {
                request.setAttribute("msg", "사진 게시글 등록 성공");
            }else {
                request.setAttribute("msg", "사진 게시글 등록 실패");
            }
            
            request.setAttribute("loc", "/photoList");
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
