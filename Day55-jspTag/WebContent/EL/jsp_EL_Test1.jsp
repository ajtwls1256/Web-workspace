<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- requestScope로 꺼내올 값이 존재하는 영역을 선택해 값을 꺼내올 수 있음 -->
	<!-- 영역설정을 반드시 해야하지만 default가 request이기때문에 명시를 안해줄 시 request로 자동으로 설정 -->
	아이디 : ${requestScope.member.id }<br>
	비밀번호 : ${requestScope.member.pw }<br>
	이름 : ${member.name }<br>
	나이 : ${member.age }<br>
</body>
</html>