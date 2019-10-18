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
		<div class="table-wrapper" style="text-align: center; width:80%; margin: 0 auto;">
			<form action="/insertPhoto" method="post" enctype="multipart/form-data">
				<table class="table table-bordered" style="text-align: center">
					<tr>
						<th colspan="2" style="font-size:20px; font-weight:bold">사진게시판 작성</th>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<%=m.getMemberId() %>
							<input type="hidden" name="photoWriter" value="<%=m.getMemberId() %>">
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td>
							<input type="file" name="filename" onchange="loadImg(this)">
						</td>
					</tr>
					<tr>
						<!-- 파일이 선택되었을 때 이미지를 띄움 -->
						<th>이미지 보기</th>
						<td>
							<div id="img-viewer">
								<img id="img-view" width="350px;">
							</div>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea name="photoContent" rows="3" cols="40" class="form-control"></textarea>
						</td>
					</tr>
					<tr style="text-align: center">
						<th colspan="2">
							<button type="submit" class="btn btn-primary">등록하기</button>
						</th> 
					</tr>
				</table>
			</form>
		</div>
	</section>
	
	<script>
		function loadImg(f){
			console.log(f.files);	// 인풋태그에 선택된 파일을 배열로 가져옴
			if(f.files.length!=0 && f.files[0]!=0){	// 파일이 한개라도 선택되었는지 && 존재하는 파일이 정상적인 파일인지
				var reader = new FileReader();	// pc에있는 파일과 브라우저를 연결하기위함
				reader.readAsDataURL(f.files[0]);	// 매개변수로 지정한 파일의 경로를 가져옴
				reader.onload = function(e){
					$("#img-view").attr("src",e.target.result);	// img태그의 src속성을 가져온 경로(e.target.result로 꺼내옴)로 지정
				}
			}else{
				$("#img-view").attr('src','');
			}
		}
	</script>
</body>
</html>