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
	<h1>JSTL Core Tags 실습</h1>
	<c:set var="num1" value="100" scope="request"/>
	<c:set var="num1" value="200" scope="session"/>
	<h3>생성 후 출력</h3>
	request : ${requestScope.num1 }<br>
	session : ${sessionScope.num1 }<br>
	
	<c:remove var="num1" scope="session"/>
	<h3>session 삭제 후 출력</h3>
	request : ${requestScope.num1 }<br>
	session : ${sessionScope.num1 }<br>
	
</body>
</html>