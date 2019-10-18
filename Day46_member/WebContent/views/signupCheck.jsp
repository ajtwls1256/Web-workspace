<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="kh.member.model.vo.Member" %>
    <%@ page import="kh.member.model.dao.MemberDao" %>
    
    
    <%
    
    request.setCharacterEncoding("utf-8");
    
    Member m = new Member();
    m.setMemberId(request.getParameter("id"));
    m.setMemberPw(request.getParameter("pw"));
    m.setMemberName(request.getParameter("name"));
    m.setMemberPhone(request.getParameter("phone"));
    m.setMemberLevel(Integer.parseInt(request.getParameter("level")));

    MemberDao dao = new MemberDao();
    boolean result = dao.signUp(m);
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	if(result){%>
		<script>
			alert("회원가입 성공");
			location.href="/index.html";
		</script>    
	<%    
	}else{ %>
		<script>
			alert("회원가입 실패");
			location.href="/views/signup.jsp";
		</script>    
	<%    
	}%>

</body>
</html>