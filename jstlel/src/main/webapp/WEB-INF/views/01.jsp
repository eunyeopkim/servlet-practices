<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- if문 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> <!-- 함수처리 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> <!-- 형식화 -->
<!DOCTYPE html>
<%
	pageContext.setAttribute("newLine", "\n");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <h1>값 받아보기</h1>
		 ${ival} <br>
		 ${lval} <br>
		 ${fval} <br>
		 ${bval} <br>
		- ${obj }- <br>
		${vo.no } <br>
		${vo.name } <br>
		<p style='width:200px; height:150px; border:1px solid #0000ff'>
		${fn:replace(sval, newLine, "<br>") }
		</p>
	<h1>연산 해보기</h1>
	${ 3+10*20 } <br>
	${ ival+10 } <br>
	${ obj == null } <br>
	${ vo != null } <br>
	${ empty obj } <br>
	${not empty vo } <br>
	
	
	
	<h1>관계 연산 해보기</h1>
	${ ival==10 } <br>
	${ ival < 5 } <br>
	
	<h1> null 검사</h1>
	${ival==10 && lval <10000 } <br>
	${ival < 5 || lval - 10 ==0 } <br>
	
	
 	
	
	<h1>요청 파라미터 값 받아보기</h1>
	-${param.a }- <br>
	-${param.email }- <br>
	
	<h1>map 으로 값 받아보기</h1>
	${map.ival } <br>
	${map.lval } <br>
	${map.fval } <br>
	${map.bval } <br>
	
</html>