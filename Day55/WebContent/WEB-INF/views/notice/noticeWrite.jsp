<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<!-- 파일 업로드 양식이란걸 알려주기 위해  method="post" enctype="multipart/form-data" 는 반드시 해야함-->
			<form action="/insertNotice" method="post" enctype="multipart/form-data">
				<table class="table table-bordered" style="text-align: left;">
					<tr>
						<th colspan="2" style="font-size:20px; font-weight:bold">공지사항 작성</th>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" class="form-control" name="noticeTitle"></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
						<%=m.getMemberId() %>
						<input type="hidden" name="noticeWriter" value="<%=m.getMemberId() %>">
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><input type="file" name="filename"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<!-- 여러줄 입력(엔터입력)을 위한 textarea -->
							<textarea rows="3" cols="40" name="noticeContent" class="form-control"></textarea>
						</td>
					</tr>
					<tr style="text-align: center;">
						<td colspan="2">
							<button type="submit" class="btn btn-outline-primary">등록하기</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</section>
</body>
</html>