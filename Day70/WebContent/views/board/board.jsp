<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
	body *{
		margin : 0 auto;
	}
</style>

</head>
<body>
	<h2>자유게시판</h2>
	<table border="1px">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	
		<c:if test="${not empty list }">
		<c:forEach items="${list}" var="board">
		<tr>
			<td>
				0
			</td>
			<td>
				<p>${board.boardTitle }</p>
			</td>
			<td>
				<p>${board.boardWriter }</p>
			</td>
			<td>
				<p>${board.boardDate }</p>
			</td>
		</tr>
		</c:forEach>
		</c:if>

	</table>
	
	
</body>
</html>