<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL 제어문</h1>
	<h3> c:if </h3>
	<form action="/jsp/JSTL/JSTL_if.jsp">
		숫자 입력 : <input type="text" name="value1">
		<input type="submit" value="전송">
	</form>
	
	<hr>
	
	<h3> c:chose </h3>
	<form action="/jsp/JSTL/JSTL_choose.jsp">
		1~3 중에서 입력 : <input type="text" name="value2"><br>
		<input type="submit" value="전송">
	</form>
	
	<hr>
	
	<h3> c:forEach </h3>
	<a href="/jsp/JSTL/JSTL_forEach.jsp">forEach문 이동</a>
	
	<hr>
	
	<form action="/jsp/JSTL/JSTL_forToken.jsp">
		당신의 취미를 적어보세요(여러개인 경우 , 로 구분) : <input type="text" name="hobby" >
		<input type="submit" value="전송">
	</form>
</body>
</html>