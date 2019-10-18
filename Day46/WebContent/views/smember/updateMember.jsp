<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="org.kh.member.model.vo.Member" %>
    <%@ page import ="org.kh.member.model.dao.MemberDao" %>
    
    <%
    request.setCharacterEncoding("utf-8");
    
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    int age = Integer.parseInt(request.getParameter("age"));
    String addr = request.getParameter("addr");
    String gender = request.getParameter("gender");
    
    Member m = new Member(id,pw,name,email,age,addr,gender,null);
    
    MemberDao dao = new MemberDao();
    boolean result = dao.update(m);
    
    /*
    어차피 미리 작성해놓은 login메소드가 db에 저장된 값을 가져오는것이기 때문에 이용해서 변경한 값을 가져오고,
	 session은 map이라 put과 동일한 기능인 setAttribute를 통해 변경해준다
    */
    
    if(result){
        m = dao.login(id, pw);
        session.setAttribute("member",m);
    }
    %>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>정보변경결과 페이지</h2>
	
	<%if(result){%>
		<p>정보변경 성공</p>
		<a href="/index.html">메인으로 돌아가기</a>
	<%} else{%>
		<p>정보변경 실패</p>
		<a href="/index.html">메인으로 돌아가기</a>
	<%} %>


</body>
</html>