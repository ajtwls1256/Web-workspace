<%@page import="org.kh.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.kh.board.model.vo.BoardPageData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    BoardPageData bpd = (BoardPageData)request.getAttribute("bpd");
    ArrayList<Board> list = bpd.getList();
    String pageNavi = bpd.getPageNavi();
    
    %>
    
    
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
						자유게시판
					</th>
				</tr>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<%for(Board b : list) {%>
					<tr>
						<td><%=b.getRnum() %></td>
						<td>
							<a href="/boardView?boardNo=<%=b.getBoardNo() %>">
							<%=b.getBoardTitle() %>
							</a>
						</td>
						<td><%=b.getBoardWriter() %></td>
						<td><%=b.getBoardDate() %></td>
						<td><%=b.getReadcount() %></td>
					</tr>
				<%} %>
			</table>
			<div id="pageNavi"><%=pageNavi %></div>
			<div style="text-align:right;">
				<%if(m!=null) {%>
				<a class="btn btn-outline-primary btn-sm" href="/boardWrite">글쓰기</a>
				<%} %>
			</div>
		</div>
	</section>
</body>
</html>