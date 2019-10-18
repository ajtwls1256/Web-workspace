<%@page import="test.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%
    // 디비까지 가기 귀찮으니까 여기서 생성
    
    ArrayList<Member> list = new ArrayList<Member>();
    list.add(new Member("id1", "pass1", "이름1", 20));
    list.add(new Member("id2", "pass2", "이름2", 20));
    list.add(new Member("id3", "pass3", "이름3", 20));
    list.add(new Member("id4", "pass4", "이름4", 20));
    
    request.setAttribute("list", list);
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>회차(index)</th>
			<th>순번(count)</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<c:forEach items="${list }" var="member" varStatus="i" begin="2" end="3">
			<tr>
				<td><c:out value="${i.index }"/></td>	<!-- 2,3 -->
				<td><c:out value="${i.count }"/></td>	<!-- 1,2 -->
				<td><c:out value="${member.id }"/></td>
				<td><c:out value="${member.pw }"/></td>
				<td><c:out value="${member.name }"/></td>
				<td><c:out value="${member.age }"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>