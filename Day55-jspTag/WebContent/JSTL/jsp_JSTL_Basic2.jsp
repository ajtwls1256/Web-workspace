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
	<c:set var="num" value="100" scope="request"/>
	<c:set var="num" value="200" scope="session"/>
	request 값 : ${requestScope.num }<br>
	session 값 : ${sessionScope.num }<br>
	그냥 출력 : ${num }
	
</body>
</html>