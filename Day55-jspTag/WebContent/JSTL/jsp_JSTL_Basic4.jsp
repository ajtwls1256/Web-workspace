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
	출력 : <c:out value="100"/> <br>
	default 값 : <c:out value="${data }" default="변수 없음"/><br>		<!-- 값을 출력하면서 바로 값이없을때 default값 설정가능 -->
	기본 출력문 : 글씨를 진하게 하려면 Bold태그인 <b>1</b>를 쓰면 됨<br>
	기본 출력문 : <c:out value="글씨를 진하게 하려면 Bold태그인 <b>1</b>를 쓰면 됨" escapeXml="false"/><br>
	기본 출력문 : <c:out value="글씨를 진하게 하려면 Bold태그인 <b>1</b>를 쓰면 됨" escapeXml="true"/> <br>
	< -> &lt;	<br>
	> -> &gt;	<br>
	& -> &amp;	<br>

	
</body>
</html>