<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="kh.member.model.vo.Member" %>
    <%@ page import ="kh.member.model.dao.MemberDao" %>
    
    <%
	 request.setCharacterEncoding("utf-8");
    
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String name = request.getParameter("name");
    String phone = request.getParameter("phone");
    int level = Integer.parseInt(request.getParameter("level"));
    
    Member m = new Member(id, pw, name, phone, level);
    
    MemberDao dao = new MemberDao();
    boolean result = dao.update(m);
    
    
    if(result){
        m = dao.login(id, pw);
        session.setAttribute("member", m);
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
			alert("정보수정 성공");
			location.href="/views/memberInfo.jsp";
		</script>
	<%    
	}else{
	%>
		<script>
			alert("정보수정 실패");
			location.href="/views/memberInfo.jsp";
		</script>
	<%   
	}
	%>


</body>
</html>