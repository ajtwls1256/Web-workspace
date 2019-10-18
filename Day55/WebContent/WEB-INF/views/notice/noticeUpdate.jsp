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
		<div class="table-wrapper" style="text-align:center; width:80%; margin:0 auto;">
			<form action="/noticeUpdateEnd" method="post" enctype="multipart/form-data">
				<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo() %>">
				<table class="table table-bordered">
					<tr>
						<th colspan="2" style="font-size:20px; font-weight:bold">공지사항</th>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" class="form-control" name="noticeTitle" value="<%=n.getNoticeTitle()%>"></td>
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
						<!-- 파일이 있으면 삭제버튼만 있고, 기존 파일을 삭제하면 새로 입력받을 수 있게 하려고 -->
							<input type="hidden" id="status" name="status" value="stay">	<!-- 파일이 삭제되었는지 아닌지 체크해서 넘겨주기위해 -->
						<%if(n.getFilename() != null){ %>
							<img class="delFile" src="/img/file.png" width="16px">
							<span class="delFile"><%=n.getFilename() %></span>
							<button type="button" id="fileDelBtn" class="btn btn-primary btn-sm delFile">삭제</button>
							<input type="file" name="filename" id="file" style="display:none;">
							
						<!-- 삭제를 누르면 파일삭제를 해야하므로 넘겨주는 값들 -->
							<input type="hidden" name="oldFilename" value="<%=n.getFilename() %>">
							<input type="hidden" name="oldFilepath" value="<%=n.getFilepath() %>">
						<%} else{%>
							<input type="file" name="filename">
						<%} %>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea name="noticeContent" class="form-control" rows="3" cols="40"><%=n.getNoticeContent() %></textarea>
						</td>
					</tr>
					<tr>
						<th colspan="2" style="text-align:center">
							<button type="submit" class="btn btn-outline-primary">수정하기</button>
							<a class="btn btn-outline-primary" href="/noticeList">목록으로 가기</a>
						</th>
					</tr>
				</table>
			</form>
		</div>
	</section>
	<script>
		$(document).ready(function(){
			$("#fileDelBtn").click(function(){
				if(confirm("첨부파일을 삭제하시겠습니까?")){
					$(".delFile").hide();
					$("#file").show();
					$("#status").val("delete");
				}
			});
		});
	</script>
</body>
</html>

