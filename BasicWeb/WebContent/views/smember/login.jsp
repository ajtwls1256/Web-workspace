<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="org.kh.member.model.vo.Member" %>
    <%@ page import ="org.kh.member.model.dao.MemberDao" %>
    <%
    	// 자바 소스 작성 구간
    	
    	// 1. 인코딩
    	request.setCharacterEncoding("utf-8");
    
    	// 2. 변수저장
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	
    	// 3. 비지니스 로직
    	MemberDao dao = new MemberDao();
    	Member m = dao.login(id, pw);
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 로그인 페이지 </h1>
	<%if(m != null) {%>
		<p><%=m.getMemberName() %>님 환영합니다</p>
		<a href="/index.html">메인으로 돌아가기</a>
		<a href="./selectAll.jsp">전체회원 정보 조회</a>
	<%} else{%>
		<p>로그인 실패</p>
		
		<script>
			alert("아이디 또는 비밀번호를 확인하세요.");
		</script>
		
		<p>아이디 또는 비밀번호를 확인하세요</p>
		<a href="/index.html">메인으로돌아가기</a>
	<%} %>
	
	
</body>
</html>