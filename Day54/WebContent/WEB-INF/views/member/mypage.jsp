<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    Member member = (Member)request.getAttribute("member");	// include하는 header.jsp에 이미 m 이라는 변수명이 있으므로 피해서 member로 작성
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file ="/WEB-INF/views/common/header.jsp" %>
	<section>
		<form action="/update" method="post" style="width:800px; margin:0 auto; clolor:black;">
		<h1>회원 정보</h1>
		<table class="table">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="memberId" class="form-control" value="<%=member.getMemberId()%>" readonly>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="memberPw" class="form-control" value="<%=member.getMemberPw()%>">
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="memberName" class="form-control" value="<%=member.getMemberName()%>">
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="age" class="form-control" value="<%=member.getAge()%>">
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" class="form-control" value="<%=member.getEmail()%>">
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text" name="phone" class="form-control" value="<%=member.getPhone()%>">
			</tr>
			<tr>
				<th>가입일</th>
				<td><input type="text" name="enrollDate" class="form-control" value="<%=member.getEnrollDate()%>" readonly>
			</tr>
			<tr>
				<th colspan="2" style="text-align:center;">
					<button class="btn btn-outline-danger btn-lg" type="submit">수정하기</button>
					<%if(m.getMemberId().equals("admin")){ %>
						<button class="btn btn-outline-danger btn-lg" type="button" onclick="location.href='/adminPage'">회원관리</button>
					<%} else{ %>
						<button class="btn btn-outline-danger btn-lg" type="button" onclick="location.href='/delete?memberId=<%=member.getMemberId()%>'">회원탈퇴</button>
					<%} %>
				</th>
			</tr>
		</table>
		</form>
	</section>

</body>
</html>