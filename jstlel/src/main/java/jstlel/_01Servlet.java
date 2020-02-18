package jstlel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/01")
public class _01Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iVal = 10;
		long lVal = 10;
		float fVal = 1.4f;
		boolean bVal = true;
		String sVal="가\n나\n다\n라\n마";
		
		// 객체 테스트
		Object obj = null;
		UserVo vo = new UserVo();
		vo.setNo(10L);
		vo.setName("김은엽");
		
		Map<String,Object> map = new HashMap<>();
		map.put("ival", iVal);
		map.put("lval", lVal);
		map.put("fval", fVal);
		map.put("bval", bVal);
		
		request.setAttribute("ival", iVal);
		request.setAttribute("lval", lVal);
		request.setAttribute("fval", fVal);
		request.setAttribute("bval", bVal);
		request.setAttribute("obj", obj);
		request.setAttribute("vo", vo);
		request.setAttribute("map", map);
		
		request.setAttribute("sval", sVal);
		
		request.getRequestDispatcher("/WEB-INF/views/01.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
