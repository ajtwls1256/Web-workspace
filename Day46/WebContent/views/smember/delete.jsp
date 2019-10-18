<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.kh.member.model.vo.Member" %>
    <%@ page import="org.kh.member.model.dao.MemberDao" %>
    
    <%
    request.setCharacterEncoding("utf-8");
    
    String id = request.getParameter("id");
    
    MemberDao dao = new MemberDao();
    boolean result = dao.delete(id);
    
    %>
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 회원 삭제 결과 </h2>
	<%if(result == false) {%>
		<p>회원삭제에 실패했습니다.</p>
		<a href="/index.html">메인으로 돌아가기</a>
	<%} else{%>
		<p>회원삭제 성공</p>
		<a href="/index.html">메인으로 돌아가기</a>
		<a href="./selectAll.jsp">전체회원 정보 조회</a>
	<%} %>
</body>
</html>