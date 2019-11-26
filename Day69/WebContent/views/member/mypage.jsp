<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>마이페이지</h2>
	<hr>
	<form action="/update" method="post">
		<p><input type="text" name="memberId" value="${sessionScope.member.memberId}" readonly></p>
		<p><input type="password" name="memberPw" value="${sessionScope.member.memberPw}"></p>
		<p><input type="text" name="memberName" value="${sessionScope.member.memberName}"></p>
		<p><input type="text" name="memberAddr" value="${sessionScope.member.memberAddr}"></p>
		<p><input type="text" name="regDate" value="${sessionScope.member.regDate}" readonly></p>
		<p><input type="submit" value="정보 변경">   <button type="reset">취소</button></p>
	</form>
</body>
</html>