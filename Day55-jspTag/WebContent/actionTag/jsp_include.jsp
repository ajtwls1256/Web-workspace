<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- context root 가 /jsp이지만 브라우저가 읽는 것이 아닌 자바가(컨테이너)가 읽는 경우에는 WebConent를 /로 생각하고 경로를 설정해준다. -->
	<%-- 액션태그 내부에 값이 없는 경우 다음처럼 표기할 수도 있음 <jsp:include page="/actionTag/header.jsp" /> --%>
	<%-- <%@ page file="/actionTag/header.jsp" %> 와 아랫줄은 동일하다. --%>
	<jsp:include page="/actionTag/header.jsp"></jsp:include>
</body>
</html>