<%@page import="com.douzone.guestbook.dao.GuestbookDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.douzone.guestbook.vo.GuestbookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
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
	response.sendRedirect("/guestbook01");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1> 성공 ! </h1>
</body>
</html>