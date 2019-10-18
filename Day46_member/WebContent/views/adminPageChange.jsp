<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
    <%@ page import="kh.member.model.vo.Member" %>
    <%@ page import="kh.member.model.dao.MemberDao" %>
    
    <%
    request.setCharacterEncoding("utf-8");
    
    String id = request.getParameter("id");
    int level = Integer.parseInt(request.getParameter("level"));
    
    MemberDao dao = new MemberDao();
    boolean result = dao.change(id, level);
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
			alert("회원 등급 변경 성공");
			location.href="/views/adminPage .jsp";
		</script>    
	<%    
	}else{ %>
		<script>
			alert("회원 등급 변경 실패");
			location.href="/views/adminPage.jsp";
		</script>    
	<%    
	}%>
</body>
</html>