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
			        		<!-- 수정시 나타나는 input 칸 -->
			        		<input type="text" class="form-control" name="noticeCommentContent" value="<%=nc.getNoticeCommentContent() %>" style="display:none;">
			        	</li>
			        	<li style="width:10%">
			        		<span><%=nc.getNoticeCommentDate() %></span>
			        	</li>
			        		<%if(m != null){ //로그인 되어있는 경우 버튼 활성화%>	
			        		<li style="width:20%">
			        			<a href="javascript:void(0)" onclick="insertComment(this, '<%=nc.getNoticeCommentNo() %>');">댓글달기</a>
			        	
			        		<%if(m.getMemberId().equals(nc.getNoticeCommentWriter())){ %>
			        			<a href="javascript:void(0)" onclick="modifyComment(this,'<%=nc.getNoticeCommentNo() %>');">수정</a>
			        			<a href="javascript:void(0)" onclick="deleteComment(this,'<%=nc.getNoticeCommentNo()%>')">삭제</a>
			        		<%} %>
			        	</li>
			        	<%} %>
			        </ul>
			    <% }// 댓글 if문 종료%>
			    
			    <!-- 대댓글 작성 위치 -->
			    <%
			    for(NoticeComment ncr : list){ 
			    	if(ncr.getNoticeCommentLevel() == 2 && (ncr.getNoticeCommentRef() == nc.getNoticeCommentNo()) ){
			    %>
			    	<ul class="commentList">
			    		<li style="width:5%"><span>└─></span></li>
			    		<li style="width:5%"><span><%=ncr.getNoticeCommentWriter() %></span></li>
			    		<li style="width:60%; text-align:left; padding-left:30px;">
			    			<span><%=ncr.getNoticeCommentContent() %></span>
			    			<!-- 수정시 나타나는 input 칸 -->
			        		<input type="text" class="form-control" name="noticeCommentContent" value="<%=ncr.getNoticeCommentContent() %>" style="display:none;">
			    		</li>
			    		<li style="width:10%"><span><%=ncr.getNoticeCommentDate() %></span></li>
			    		<li style="width:20%">
			    			<%if(m!=null && m.getMemberId().equals(ncr.getNoticeCommentWriter())){ %>
			    				<a></a>	<!-- <-이 비어있는 a태그는 위에 댓글보다 버튼한개가 없어서 계층구조를 맞춰주기 위함 -->
			    				<a href="javascript:void(0)" onclick="modifyComment(this,'<%=ncr.getNoticeCommentNo() %>');">수정</a>
			    				<a href="javascript:void(0)" onclick="deleteComment(this,'<%=ncr.getNoticeCommentNo()%>')">삭제</a>
			    			<%} %>
						</li>
			    	</ul>
			    	<%} %>
			    <%} // 대댓글 for문 끝%>
			    
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
			li3.append($("<button type='button' class='btn btn-link btn-sm' onclick='insertCommentCancle(this)'>취소</button>"));
			
			ul.append(li1).append(li2).append(li3);
			form.append(ul);
			
			// append는 자식으로 after는 형제로 삽입
			$(obj).parent().parent().after(form);
		}
		
		
		// 댓글,대댓글 등록 취소
		function insertCommentCancle(obj){
			// 대댓글 다려는 댓글의 댓글달기 버튼을 보이게하고
			$(obj).parents('form').prev().children().last().show();
			// 대댓글 입력창을 없앤다.
			$(obj).parents('form').remove();
		}
		
		
		// 댓글,대댓글 수정
		function modifyComment(obj, commentNo){
			$(obj).prev().hide();	// 댓글 달기 버튼
			$(obj).html('수정완료');	// 수정 버튼
			$(obj).attr('onclick','modifyComplete(this,"'+commentNo+'")');	// 기존 onclick이벤트에 걸려있는 함수를 변경
			$(obj).next().html('취소');	// 삭제 버튼
			$(obj).next().attr('onclick','modifyCancle(this, "'+commentNo+'")');
			$(obj).parent().parent().find('input').show();	// 숨어있는 input태그를 보여주고
			$(obj).parent().parent().find('input').prev().hide();	// 원래있던 span태그를 숨겨줌
		}
		
		// 댓글, 대댓글 수정 취소
		function modifyCancle(obj, commentNo){
			$(obj).prev().prev().show();
			$(obj).prev().html('수정');
			$(obj).prev().attr('onclick', 'modifyComment(this, "'+commentNo+'")');
			$(obj).html('삭제');
			$(obj).attr('onclick', 'deleteComment(this, "'+commentNo+'")');
			$(obj).parent().parent().find('input').hide();
			$(obj).parent().parent().find('input').prev().show();
		}
		
		// 댓글, 대댓글 수정완료
		function modifyComplete(obj, commentNo){
			// form안에 게시글번호,댓글번호,댓글내용을 담아서 넘김
			var form = $("<form action='/noticeCommentUpdate' method='post'></form>");
			form.append("<input type='text' name='noticeCommentNo' value='"+commentNo+"'>");
			form.append("<input type='text' name='noticeNo' value='"+<%=n.getNoticeNo()%>+"'>");
			form.append($(obj).parent().parent().find('input'));
			$('body').append(form);
			form.submit();
		}
		
		function deleteComment(obj, commentNo){
			location.href="/noticeCommentDelete?noticeCommentNo="+commentNo+"&noticeNo="+<%=n.getNoticeNo()%>;
		}
	</script>
	
	
</body>
</html>