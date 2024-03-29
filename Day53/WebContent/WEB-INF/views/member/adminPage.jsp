<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="org.kh.member.model.vo.Member"  %>
    
    <%
    ArrayList<Member> list = (ArrayList<Member>)(request.getAttribute("members"));
    
    String type = (String)request.getAttribute("type");
    String keyword = (String)request.getAttribute("keyword");
   
    if(type == null){
        type = "";
    }
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<section>
	
		<div style="margin:0 auto; width:500px; text-align:center;">
			<form action="/searchKeyword" name="form1">
				<select name="type" class="form-control" style="display:inline-block; width:100px; height:30px; font-size:0.8em;">
					<option value="memberId" <%if(type.equals("memberId")){ %> selected="selected" <%} %>>아이디</option>
					<option value="memberName" <%if(type.equals("memberName")){ %> selected="selected" <%} %>>이름</option>
				</select>
				<input type="text" class="form-control" style="display:inline-block; width:200px; height:30px; font-size:0.8em;" name="keyword" >
				<button type="submit" class="btn btn-outline-secondary btn-sm">조회</button>
			</form>
		</div>
		
		<br>
	
	
		<div id="container" style="margin:0 auto; width:800px; color:black; text-align:center;">
			<table class="table table-hover">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>나이</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>탈퇴</th>
				</tr>
				

				<%for(Member member : list){ %>
					<%if(!member.getMemberId().equals("admin")){ %>
						<tr>
							<td><%=member.getMemberId() %></td>
							<td><%=member.getMemberName() %></td>
							<td><%=member.getAge() %></td>
							<td><%=member.getEmail() %></td>
							<td><%=member.getPhone() %></td>
							<td><button class="btn btn-outline-info btn-sm" onclick="location.href='/dropOut?memberId=<%=member.getMemberId()%>'">탈퇴</button></td>
						</tr>
					<%} %>
				<%} %>
			
			</table>
		</div>
	</section>
	
	<script>
		window.onload = function(){
			
			<%if(keyword != null){%>
				form1.keyword.value = "<%=keyword%>";
			<%}%>
			
		}
	</script>
	
</body>
</html>