package org.kh.photo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.photo.model.service.PhotoService;
import org.kh.photo.model.vo.Photo;

import com.google.gson.Gson;

/**
 * Servlet implementation class PhotoMoreServlet
 */
@WebServlet(name = "PhotoMore", urlPatterns = { "/photoMore" })
public class PhotoMoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoMoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int start = Integer.parseInt(request.getParameter("start"));
	    
	    PhotoService service = new PhotoService();
	    ArrayList<Photo> list = service.morePhoto(start);
	    
	    response.setContentType("application/json; charset=utf-8");
	    new Gson().toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
