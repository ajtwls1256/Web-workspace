<%@page import="org.kh.notice.model.vo.NoticeComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.kh.notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Notice n = (Notice)request.getAttribute("notice");
    	ArrayList<NoticeComment> list = (ArrayList<NoticeComment>)request.getAttribute("comments");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.commentList{
		width:100%;
		clear:both;
		border:1px solid #ccc;
		border-radius : 5px;
		overflow : hidden;
	}
	
	.commentList>li{
		float:left;
		color:black;
		font-weight:bold;
	}
</style>
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
						<!-- href="javascript:void(0)" = href로 넘어가는 기능을 없앰, 대신 onclick이벤트를 이용, 인코딩을 위해 자바스크립트함수 사용(크롬은 필요없으나 IE는 필요)  -->
						<a href="javascript:void(0)" onclick="fileDownload('<%=n.getFilename()%>','<%=n.getFilepath()%>')">
						<%=n.getFilename() %>
						</a>
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
							<a class="btn btn-outline-primary btn-sm" href="/noticeUpdate?noticeNo=<%=n.getNoticeNo()%>">수정하기</a>
							<a class="btn btn-outline-primary btn-sm" href="javascript:void(0)" onclick="deleteNotice('<%=n.getNoticeNo()%>', '<%=n.getFilepath()%>')">삭제하기</a>
						<%} %>
						<a class="btn btn-outline-primary btn-sm" href="/noticeList">목록으로</a>
					</th>
				</tr>
			</table>
		</div>
		
		<!-- 댓글 작성 위치 -->
		<%if(m!=null){ // 댓글 작성 시작%>	
		<div class="comment-write" style="text-align: center; width:80%; margin:0 auto;">
			<form action="/noticeCommentInsert" method="post">
				<input type="hidden" name="noticeCommentWriter" value="<%=m.getMemberId() %>">
				<input type="hidden" name="noticeRef" value="<%=n.getNoticeNo() %>">
				<input type="hidden" name="noticeCommentLevel" value="1">
				<input type="hidden" name="noticeCommentRef" value="0">
				<table class="table">
					<tr>
						<td width="85%">
							<textarea rows="1" class="form-control" name="noticeCommentContent"></textarea>
						</td>
						<td width="15%">
							<button type="submit" class="btn btn-primary">등록</button>
						</td>
					</tr>
				</table>
			</form>
		</div>			
		<%} // 댓글 작성 끝%>
		<div class="comment-wrapper" style="text-align: center; width:80%; margin:0 auto;">
			<%
			for(NoticeComment nc : list){
			    if(nc.getNoticeCommentLevel() == 1){%>
			        <ul class="commentList">
			        	<li style="width:5%">
			        		<span><%=nc.getNoticeCommentWriter() %></span>
			        	</li>
			        	<li style="width:65%">
			        		<span><%=nc.getNoticeCommentContent() %></span>
			        	</li>
			        	<li style="width:10%">
			        		<span><%=nc.getNoticeCommentDate() %></span>
			        	</li>
			        		<%if(m != null){ //로그인 되어있는 경우 버튼 활성화%>	
			        		<li style="width:20%">
			        			<a href="javascript:void(0)" onclick="insertComment(this, '<%=nc.getNoticeCommentNo() %>');">댓글달기</a>
			        	
			        		<%if(m.getMemberId().equals(nc.getNoticeCommentWriter())){ %>
			        			<a href="javascript:void(0)" onclick="modifyComment(this,'<%=nc.getNoticeCommentNo() %>');">수정</a>
			        			<a href="javascript:void(0)" onclick="deleteComment(this,'<%=nc.getNoticeCommentNo() %>');">삭제</a>
			        		<%} %>
			        	</li>
			        	<%} %>
			        </ul>
			    <% }// 댓글 if문 종료%>
			<%}// 전체 댓글 for문 종료
			%>
		</div>
	</section>
	<script>
		function fileDownload(filename, filepath){
			// 넘겨줄 서블릿 경로
			var url = "/noticeFileDownload";
			// encodeURIComponent(filename) = 한글일 경우 인코딩 해주는 함수
			var encFilename = encodeURIComponent(filename);
			var encFilepath = encodeURIComponent(filepath);
			// ?는 파라미터 시작, 파라미터 사이 구분은 &
			location.href = url + '?filename='+encFilename+"&filepath="+encFilepath;
		}
		
		function deleteNotice(noticeNo, filepath){
			var url = "/noticeDelete";
			var encFilepath = encodeURIComponent(filepath);
			location.href = url + "?noticeNo=" + noticeNo + "&filepath=" + encFilepath;
		}
		
		function insertComment(obj, commentNo){
			$(obj).parent().hide();		// 댓글달기 버튼 눌렀을때 댓글달기버튼이 안보이게 하려고
			var form = $("<form action='/noticeCommentInsert' method='post'></form>");
			
			// form 태그 미리 hidden으로 만들어두고 사용해도되는데, 아래와같이 스크립트에서 작성하는 방법도있다는걸 보여주기 위해 스크립트로 작성
			var ul = $("<ul class='commentList'></ul>")
			form.append($("<input type='hidden' name='noticeCommentWriter' value='<%=m.getMemberId()%>'>"));
			form.append($("<input type='hidden' name='noticeRef' value='<%=n.getNoticeNo()%>'>"));
			form.append($("<input type='hidden' name='noticeCommentLevel' value='2'>"));
			form.append($("<input type='hidden' name='noticeCommentRef' value='"+commentNo+"'>"));
			
			var li1 = $("<li style='width:5%'>└─></li>");
			var li2 = $("<li style='width:75%'></li>");
			li2.append($("<input type='text' name='noticeCommentContent' class='form-control' style='height:100%;'>"));
			var li3 = $("<li style='width:20%'></li>");
			li3.append($("<button type='submit' class='btn btn-link btn-sm'>등록</button>"));
			
			ul.append(li1).append(li2).append(li3);
			form.append(ul);
			
			// append는 자식으로 after는 형제로 삽입
			$(obj).parent().parent().after(form);
		}
		
	</script>
	
	
</body>
</html>