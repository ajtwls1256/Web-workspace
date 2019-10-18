<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="org.kh.member.model.vo.Member" %>
    <%@ page import ="org.kh.member.model.dao.MemberDao" %>
    <%
    	// 자바 소스 작성 구간
    	
    	// 세션에 저장된 값을 key값으로 읽어들임
    	Member m = (Member)session.getAttribute("member");

    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  map은 없는 key값 요구하면 null을 반환 --> 
	<%if(m==null){ %>
		<hr>
		<form action="./login.jsp" method="post">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pw"><br>
		<input type="submit" value="로그인">
		</form>
	
		<a href="./enroll.html">회원 가입</a>
		<a href="./delete.html">회원 삭제</a>
	
	<%} else{ %>
	<h2>[<%=m.getMemberName() %>님] 환영합니다.</h2>
	<p><a href="/views/smember/logout.jsp">로그아웃</a></p>
	<p><a href="/views/smember/mypage.jsp">마이페이지</a></p>
	<%} %>

	
</body>
</html>