<%@page import="org.kh.notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Notice n = (Notice)request.getAttribute("notice");
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
		<div class="table-wrapper" style="text-align: center; width:80%; margin:0 auto;">
			<table class="table table-bordered">
				<tr>
					<th colspan="2" style="font-size:20px; font-weight:bold">공지사항</th>
				</tr>
				<tr>
					<th>제목</th>
					<td><%=n.getNoticeTitle() %></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=n.getNoticeWriter() %></td>
				</tr>
				<tr>
					<th>작성일</th>
					<td><%=n.getNoticeDate() %></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<%if(n.getFilepath() != null) {%>
						<img src="/img/file.png" width="16px">
						<%=n.getFilename() %>
						<%} %>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><%=n.getNoticeContent() %></td>
				</tr>
				<tr>
					<th colspan="2">
						<%if(m!=null && m.getMemberId().equals(n.getNoticeWriter())) { %>
							<a class="btn btn-outline-primary btn-sm" href="#">수정하기</a>
							<a class="btn btn-outline-primary btn-sm" href="#">삭제하기</a>
						<%} %>
						<a class="btn btn-outline-primary btn-sm" href="/noticeList">목록으로</a>
					</th>
				</tr>
			</table>
		</div>
	</section>
</body>
</html>