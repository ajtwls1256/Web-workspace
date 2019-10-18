<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- id는 변수명 같은 느낌, 경로는 전부 적어야함, scope는 사용할 범위(page는 현재 페이지) -->
	<jsp:useBean id="m" class="test.model.vo.Member" scope="page">
		<!-- setPropery에서의 name이 usebean선언에서의 id    id=name -->
		<jsp:setProperty name="m" property="id" value="idid"/>
		<jsp:setProperty name="m" property="pw" value="pwpw"/>
		<jsp:setProperty name="m" property="name" value="이름"/>
	</jsp:useBean>
	<h1>useBean 사용</h1>
	ID : <jsp:getProperty property="id" name="m"/><br>
	PW : <jsp:getProperty property="pw" name="m"/><br>
	이름 : <jsp:getProperty property="name" name="m"/><br>
</body>
</html>