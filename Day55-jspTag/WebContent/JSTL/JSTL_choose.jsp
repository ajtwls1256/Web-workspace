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
	<c:choose>
		<c:when test="${param.value2 == 1 }">
			1이야
		</c:when>
		<c:when test="${param.value2 == 2 }">
			2야
		</c:when>
		<c:when test="${param.value2 == 3 }">
			3이야
		</c:when>
		<c:otherwise>
			입력값이 잘못됐어
		</c:otherwise>
	</c:choose>
</body>
</html>