<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="kh.member.model.vo.Member" %>
    <%@ page import="kh.member.model.dao.MemberDao" %>
    
    <%
    request.setCharacterEncoding("utf-8");
    
    Member m = (Member)session.getAttribute("member");
    
    MemberDao dao = new MemberDao();
    boolean result = dao.delete(m.getMemberId());
    
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


	<%
	if(result){%>
		<script>
			alert("회원탈퇴 성공");
			location.href="/index.html";
		</script>    
	<%    
	}else{ %>
		<script>
			alert("회원탈퇴 실패");
			location.href="/views/memberInfo.jsp";
		</script>    
	<%    
	}%>
	
</body>
</html>