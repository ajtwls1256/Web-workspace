<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="kh.member.model.vo.Member" %>
    <%@ page import="kh.member.model.dao.MemberDao" %>
    
    
    <%
    
    request.setCharacterEncoding("utf-8");
    
    Member m = new Member();
    m.setMemberId(request.getParameter("id"));
    m.setMemberName(request.getParameter("name"));
    m.setMemberPhone(request.getParameter("phone"));

    MemberDao dao = new MemberDao();
    String result = dao.findPw(m);
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	if(result.equals("")){%>
		<script>
			alert("일치하는 회원 정보가 없습니다!");
			location.href="/views/findPw.jsp";
		</script>    
	<%    
	}else{ %>
		<script>
			alert("회원님의 비밀번호는 " + <%=result%> + "입니다.");
			location.href="/index.html";
		</script>    
	<%    
	}%>

</body>
</html>