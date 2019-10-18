<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import = "kh.member.model.vo.Member" %>
    <%@ page import = "kh.member.model.dao.MemberDao" %>
    
    <%
    MemberDao dao = new MemberDao();
    ArrayList<Member> ml = dao.selectAll();
    
    Member m = (Member)session.getAttribute("member");
    int level = m.getMemberLevel();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>관리자 페이지</h2>
	
	<% if(ml.isEmpty()){ %>
		<p>존재하는 회원이 없습니다.</p>
		<a href="/index.html">메인으로 돌아가기</a>
	<%} else {%>
	
	<table border=1>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>등급</th>
			<%if(level == 2){ %>
			<th>등급변경</th>
			<%} %>
		</tr>
		
		<%for(int i=0; i<ml.size(); i++){ %>
			<tr>
				<td><%=ml.get(i).getMemberId() %></td>
				<td><%=ml.get(i).getMemberPw() %></td>
				<td><%=ml.get(i).getMemberName() %></td>
				<td><%=ml.get(i).getMemberPhone() %></td>
				
				
				<%if(level == 2){ %>
				<form action="/views/adminPageChange.jsp" method="post">
					<td>
						<select name="level">
							<option value="0" <%if(ml.get(i).getMemberLevel()==0){ %> selected="selected" <%} %>>일반회원
							<option value="1" <%if(ml.get(i).getMemberLevel()==1){ %> selected="selected" <%} %>>매니저
							<option value="2" <%if(ml.get(i).getMemberLevel()==2){ %> selected="selected" <%} %>>관리자
						</select>
					</td>
					
					<input type="hidden" name="id" value="<%=ml.get(i).getMemberId()%>">
					<td>
						<button type="submit">등급변경</button>
					</td>
				</form>
				<%} else{%>
				<td><%=ml.get(i).getMemberLevel() %></td>
				<%} %>
				
			</tr>
		<%} %>
	</table>
	<br>
	<a href="/views/memberInfo.jsp">마이페이지</a>
	<%} %>
</body>
</html>