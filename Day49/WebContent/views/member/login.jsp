<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="/css/member/login.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<section>
		<form action="/login" method="post" id="login-box">
			<h1>로그인</h1>
			<ul>
				<li><label for="memberId">아이디</label></li>
				<li><input type="text" name="memberId" id="memberId" class="form-control"></li>
				<li><label for="memberPw">비밀번호</label></li>
				<li><input type="password" name="memberPw" id="memberPw" class="form-control"></li><br>
				<li id="btn-wrapper">
					<br>	
					<button type="submit" class="btn btn-outline-danger btn-lg">로그인</button>
					<button type="reset" class="btn btn-outline-danger btn-lg">초기화</button>
					<br><br>
					<a href="/views/member/find.jsp">아이디/비밀번호 찾기</a>
				</li>
			</ul>
		</form>
	</section>
	
</body>
</html>