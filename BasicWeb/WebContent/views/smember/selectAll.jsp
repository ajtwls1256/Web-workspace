<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "org.kh.member.model.vo.Member" %>
    <%@ page import = "org.kh.member.model.dao.MemberDao" %>
    
    
    <%
    request.setCharacterEncoding("utf-8");
    
    MemberDao dao = new MemberDao();
    ArrayList<Member> ml = dao.selectAll();
    
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 전체 회원 조회</h1>
	
	<% if(ml.isEmpty()){ %>
		<p>존재하는 회원이 없습니다.</p>
		<a href="/index.html">메인으로 돌아가기</a>
	<%} else {%>
	<table border=1>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>나이</th>
			<th>주소</th>
			<th>성별</th>
			<th>가입일자</th>
		</tr>
		
		<%for(int i=0; i<ml.size(); i++){ %>
			<tr>
				<td><%=ml.get(i).getMemberId() %></td>
				<td><%=ml.get(i).getMemberPw() %></td>
				<td><%=ml.get(i).getMemberName() %></td>
				<td><%=ml.get(i).getEmail() %></td>
				<td><%=ml.get(i).getAge() %></td>
				<td><%=ml.get(i).getAddr() %></td>
				<td><%=ml.get(i).getGender() %></td>
				<td><%=ml.get(i).getEnrollDate() %></td>
			</tr>
		<%} %>
	</table>
	<a href="/index.html">메인으로 돌아가기</a>
	<%} %>
</body>
</html>