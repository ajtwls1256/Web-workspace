<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	int totalCount = (Integer)request.getAttribute("totalCount");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사진게시판</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<section>
		<div class="photo-container" style="width:80% margin:0 auto; text-align: center;">
			<h1>사진게시판</h1>
			<div id="photo-wrapper" style="padding: 100px;"></div>
			<div id="photo-btn-container">
				<!-- 지금까지 가져온개수, 전체개수, 현재값 , 노란줄은 존재하지않는 속성이라는 표시 -->
				<button class="btn btn-outline-info" currentCount="0" totalCount="<%=totalCount%>" value="" id="more-btn">더보기</button>
				<%if(m != null){ %>
					<button class="btn btn-outline-info" id="write-btn">글쓰기</button>
				<%} %>
				
				
			</div>
		</div>
	</section>
	
	<script>
		$("#write-btn").click(function(){
			location.href="/views/photo/writePhoto.jsp";
		});
		
		// 페이지 로드가 완료되면 시작값 1로 주고 fn_more함수를 호출하고 더보기 버튼 클릭이벤트를 설정
		$(document).ready(function(){
			fn_more(1);
			$("#more-btn").click(function(){
				fn_more($(this).val());
			});
		});
		
		
		function fn_more(start){
			var param = {start:start};
			$.ajax({
				url : "/photoMore", 
				data : param,
				type : "post",
				dataType : "json", 	// 리턴되는 데이터의타입 명시
				success : function(data){
					var html = "";
					
					for(var i in data){
						var p = data[i];
						
						html += "<div class='photo border border-dark' ";
						html += "style='width:800px;margin:0 auto; margin-bottom:10px;'>";
						html += "<img src='/upload/photo/" + p.filepath + "' width='100%'>";
						html += "<p class='caption'>" + p.photoContent + "</p></div>";

					}
					
					$("#photo-wrapper").append(html);
					
					
					
					/* 더보기 버튼 설정 */
					
					var totalCount = $("#more-btn").attr("totalCount");
					var currentCount = $("#more-btn").attr("currentCount");
					
					// value = 다음에 가져올 번호, currentCount = 내가 지금까지 가져온 게시물 수
					$("#more-btn").val(Number(start)+5);
					$("#more-btn").attr("currentCount",Number(currentCount) + data.length);
					
					currentCount = $("#more-btn").attr("currentCount");
					
					// 전체수와 내가불러온 수가 같다 -> 더이상 불러올 값이 없다	=> 더보기 버튼 비활성화 
					if(totalCount == currentCount){
						$("#more-btn").attr("disabled",true);
						$("#more-btn").css("cursor","not-allowed");
					}
				},
				error : function(){
					console.log("ajax 처리 실패");
				}
			});
		}
	</script>

</body>
</html>