package com.douzone.guestbook.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.guestbook.dao.GuestbookDao;
import com.douzone.guestbook.vo.GuestbookVo;


public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("a");
		if("add".equals(action)) {
			request.setCharacterEncoding("UTF-8");
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String message = request.getParameter("message");
			
			GuestbookVo vo = new GuestbookVo();
			Date date = new Date();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			vo.setName(name);
			vo.setPassword(password);
			vo.setContents(message);
			vo.setRegDate(sdf.format(date));
			
			new GuestbookDao().insert(vo);
			// insert 후 돌아가야하는 URI주소를 redirect해준다.
			response.sendRedirect(request.getContextPath()+"/gb");
		} else if("deleteform".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
		} else if("delete".equals(action)) {

			request.setCharacterEncoding("UTF-8");
			String password = request.getParameter("password");
			String no = request.getParameter("no");
			GuestbookVo vo = new GuestbookVo();
			vo.setNo(Long.parseLong(no));
			vo.setPassword(password);
			new GuestbookDao().delete(vo);

			response.sendRedirect(request.getContextPath()+"/gb");
		} else {
			// list(default) 처리
			List<GuestbookVo> list = new GuestbookDao().findAll();
			
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
