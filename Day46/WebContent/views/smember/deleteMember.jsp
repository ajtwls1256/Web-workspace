<%@page import="org.kh.member.model.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
 	String id = request.getParameter("id");
    MemberDao dao = new MemberDao();
    boolean result = dao.delete(id);
    if(result){
        session.invalidate();
    }
 
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>회원 탈퇴 결과 페이지</h2>
	<%if(result){ %>
		<p>회원 탈퇴 성공</p>
		<a href="/index.html">메인으로 돌아가기</a>
	<%} else{%>
		<p>회원 탈퇴 실패</p>
		<a href="/index.html">메인으로 돌아가기</a>
	<%} %>
</body>
</html>