<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="kh.member.model.vo.Member" %>
    <%@ page import="kh.member.model.dao.MemberDao" %>
    
    <%
    
    Member m = (Member)session.getAttribute("member");
    
    if(m == null)
    {
        
	   request.setCharacterEncoding("utf-8");
	  
	   String id = request.getParameter("id");
	   String pw = request.getParameter("pw");
	   
	   MemberDao dao = new MemberDao();
	   m = dao.login(id, pw);
	   
		
	   if(m != null){
	       session.setAttribute("member", m);
	   }
    }
    
    %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(m == null){%>
		<script >
			alert("일치하는 회원 정보가 없습니다!");
			location.href = "/index.html";
		</script>
	<%}
	else{
	%>

	<h2>회원 정보</h2>
	<h3>
	<%
	int mLevel = m.getMemberLevel();
	
	
	if(mLevel == 0){
	%>
	(일반회원)
	<%
	}
	else if(mLevel == 1){
	%>
	(매니저)
	<%
	}
	else if(mLevel == 2){
	%>
	(관리자)
	<%
	}
	%>
	</h3>
	
	
	
	<div>
		<form action="./update.jsp">
			<div>
				<span>아이디</span><br>
				<input type="text" name="id" value="<%=m.getMemberId()%>" readonly>
			</div>
			<div>
				<span>비밀번호</span><br>
				<input type="password" name="pw" value="<%=m.getMemberPw()%>">
			</div>
			<div>
				<span>이름</span><br>
				<input type="text" name="name" value="<%=m.getMemberName()%>">
			</div>
			<div>
				<span>전화번호</span><br>
				<input type="text" name="phone" value="<%=m.getMemberPhone()%>">		
			</div>
			<input type="hidden" name="level" value="<%=m.getMemberLevel()%>">
			<div>
				<button type="submit">정보 수정</button>
			</div>
		</form>	
		
		
		<div>
			<a href="/views/logout.jsp">로그아웃</a>
			/
			<a href="/views/delete.jsp">회원탈퇴</a>
			
			<%
			if(mLevel != 0){%>
				/ <a href="/views/adminPage.jsp">관리자 페이지</a>
			<%    
			}
			%>
		</div>
	</div>
		
	
	
	
	<%} %>
</body>
</html>