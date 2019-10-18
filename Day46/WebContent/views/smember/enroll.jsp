<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="org.kh.member.model.vo.Member" %>
    <%@ page import="org.kh.member.model.dao.MemberDao" %>
    
    <%
    
    request.setCharacterEncoding("utf-8");
    
    Member m = new Member();
    m.setMemberId(request.getParameter("id"));
    m.setMemberPw(request.getParameter("pw"));
    m.setMemberName(request.getParameter("name"));
    m.setEmail(request.getParameter("email"));
    m.setAge(Integer.parseInt(request.getParameter("age")));
    m.setAddr(request.getParameter("addr"));
    m.setGender(request.getParameter("gender"));
    
    MemberDao dao = new MemberDao();
    boolean result = dao.enroll(m);
    
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원 가입 결과 </h1>
	<%if(result == false) {%>
		<p>회원가입에 실패했습니다.</p>
		<a href="./enroll.html">회원가입페이지로 돌아가기</a><br>
		<a href="/index.html">메인으로 돌아가기</a>
	<%} else{%>
		<p>회원가입 성공</p>
		<a href="/index.html">메인으로 돌아가기</a>
	<%} %>
</body>
</html>