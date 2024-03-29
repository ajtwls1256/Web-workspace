<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    <%-- 
    <%@ page import="org.kh.member.model.vo.Member"  %> -->
    
    <%
    ArrayList<Member> list = (ArrayList<Member>)(request.getAttribute("members"));
    
    String type = (String)request.getAttribute("type");
    String keyword = (String)request.getAttribute("keyword");
   
    if(type == null){
        type = "";
    }
    %>
    
    --%>
    
    
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
					<c:if test="${empty type }">	<!-- null체크 -->
						<option value="memberId">아이디</option>
						<option value="memberName">이름</option>
					</c:if>
					<c:if test="${not empty type && type=='memberName'}">
						<option value="memberId">아이디</option>
						<option value="memberName" selected="selected">이름</option>
					</c:if>
					<c:if test="${not empty type && type=='memberId'}">
						<option value="memberId" selected="selected">아이디</option>
						<option value="memberName">이름</option>
					</c:if>
				</select>
				
				<input type="text" class="form-control" style="display:inline-block; width:200px; height:30px; font-size:0.8em;" name="keyword" value="${keyword}" >
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
				
				<c:forEach items="${members }" var="m" varStatus="i">
						<tr>
							<td>${m.memberId }</td>
							<td>${m.memberName }</td>
							<td>${m.age }</td>
							<td>${m.email }</td>
							<td>${m.phone }</td>
							<td><button class="btn btn-outline-info btn-sm" onclick="location.href='/dropOut?memberId=${m.memberId}'">탈퇴</button></td>
						</tr>
				</c:forEach>
			
			</table>
		</div>
	</section>

<%--	
	<script>
		window.onload = function(){
			
			<%if(keyword != null){%>
				form1.keyword.value = "<%=keyword%>";
			<%}%>
			
		}
	</script>
--%>
	 
</body>
</html>