<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>비밀번호 찾기</h2>
	
	<div>
		<form action="./findPwCheck.jsp">
			<div>
				<span>아이디</span><br>
				<input type="text" name="id">
			</div>
			<div>
				<span>이름</span><br>
				<input type="text" name="name">
			</div>
			<div>
				<span>전화번호</span><br>
				<input type="text" name="phone" placeholder="010-0000-0000">		
			</div>
			<div>
				<button type="submit">검색</button>
			</div>
		</form>	
			<div>
				<a href="/index.html">메인으로 돌아가기</a>
			</div>
	</div>
</body>
</html>