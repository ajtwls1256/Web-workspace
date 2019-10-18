<%@page import="org.kh.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Member m = (Member)session.getAttribute("member");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1><hr>
	<form action="/views/smember/updateMember.jsp">
	<h3>아이디 : <input type="text" name="id" value="<%=m.getMemberId() %>" readonly></h3>	<!-- 읽기 전용 -->
	<h3>비밀번호 : <input type="text" name="pw" value="<%=m.getMemberPw() %>"></h3>
	<h3>이름 : <input type="text" name="name" value="<%=m.getMemberName() %>"></h3>
	<h3>이메일 : <input type="text" name="email" value="<%=m.getEmail() %>"></h3>
	<h3>나이 : <input type="text" name="age" value="<%=m.getAge() %>"></h3>
	<h3>주소 : <input type="text" name="addr" value="<%=m.getAddr() %>"></h3>
	
	<h3>성별 : 
	
		<!-- value 속성에 꼭 값을 넣어야 값이 넘어간다. 옆에 text는 text일뿐이라서 -->
		<!-- name 속성에 같은 값을 넣어야 하나만 체크됨 -->
		<input type="radio" name="gender" value="여" <%if(m.getGender().equals("여")){ %> checked="checked" <%} %>>여자 
        <input type="radio" name="gender" value="남" <%if(m.getGender().equals("남")){ %> checked="checked" <%} %>>남자
        
        <br>
        
        <select name="gender">
        	<option value="남" <%if(m.getGender().equals("남")){ %> selected="selected" <%} %>>남자
        	<option value="여" <%if(m.getGender().equals("여")){ %> selected="selected" <%} %>>여자
        </select>
    </h3>
    
    <button type="submit">정보변경</button>
    <!-- button태그는 form내부에서 dafault로 submit으로 되기때문에 submit이 아니라면 꼭 button을 명시 -->
    
    <!-- 탈퇴 방법 1) 버튼을 이용한 get 방식의 탈퇴 -->
    <button type="button" onclick="return deleteMember('<%=m.getMemberId()%>');">회원탈퇴</button>	
    
    <!-- 탈퇴 방법 2) a태그를 이용한 get 방식의 탈퇴 -->
    <a href="/views/smember/deleteMember.jsp?id=<%=m.getMemberId()%>">회원탈퇴</a>
	</form>
	
	<!-- 탈퇴 방법 3) form을 이용한 post, hidden 방식 탈퇴 -->
	<form action="/views/smember/deleteMember.jsp" method="post">
		<input type="hidden" name="id" value="<%=m.getMemberId()%>">
		<button type="submit">탈퇴하기</button>
	</form>
	
	<script>
		function deleteMember(id){
			if(confirm("정말 탈퇴하시겠습니까?")){
				location.href = "/views/smember/deleteMember.jsp?id="+id;
			}
			
		}
	</script>
	
</body>
</html>