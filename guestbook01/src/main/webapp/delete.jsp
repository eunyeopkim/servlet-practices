<%@page import="com.douzone.guestbook.dao.GuestbookDao"%>
<%@page import="com.douzone.guestbook.vo.GuestbookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String password = request.getParameter("password");
	String no = request.getParameter("no");
	GuestbookVo vo = new GuestbookVo();
	vo.setNo(Long.parseLong(no));
	vo.setPassword(password);
	new GuestbookDao().delete(vo);
	
	response.sendRedirect("/guestbook01");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>