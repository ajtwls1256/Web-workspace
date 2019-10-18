<%@page import="org.kh.notice.model.vo.PageData"%>
<%@page import="org.kh.notice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%-- 
    <%
    	PageData pd = (PageData)request.getAttribute("pd");
		ArrayList<Notice> list = pd.getList();
		String pageNavi = pd.getPageNavi();
    
    	//ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
    %>
    --%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
		#pageNavi{
			text-align : center;
			width : 80%;
			margin : 0 auto;
		}
		#pageNavi>*{
			margin : 10px;
		}
		.selectPage{
			font-size : 18px;
			color : blue;
		}
	</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<section>
		<div class="table-wrapper" style="text-align: center; width:80%; margin:0 auto;">
			<table class="table table-striped">
				<tr>
					<th colspan="5" style="font-size:20px; font-weight:bold">
						공지사항
					</th>
				</tr>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>

				<c:forEach items="${pd.list }" var="n">
				<tr>
					<td>${n.rnum }</td>
					<td>
						<a href="/noticeView?noticeNo=${n.noticeNo}">${n.noticeTitle }</a>
					</td>
					<td>${n.noticeWriter } </td>
					<td>${n.noticeDate } </td>
					<td>${n.readcount } </td>
				</tr>
				</c:forEach>
			</table>
			<div id="pageNavi">${pd.pageNavi }</div>
			<div style="text-align:right;">
				<c:if test="${not empty sessionScope.member.memberId && sessionScope.member.memberId=='admin'}">
					<a class="btn btn-outline-primary btn-sm" href="/noticeWrite">글쓰기</a>	
				</c:if>
				
		
			</div>
		</div>
	</section>
	
</body>
</html>