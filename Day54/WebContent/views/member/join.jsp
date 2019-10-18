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
		<div id="container" style="margin:0 auto; width:800px; color:black; text-align:center;">
			<form action="/join" method="post" id="memberJoin">
				<h1>회원가입</h1>
				<table class="table">
					<tr>
						<th><label for="memberId">아이디</label></th>
						<td><input type="text" name="memberId" id="memberId" class="form-control"></td>
						<!-- <td style="width:150px;"><button type="button" onclick="checkId();" class="btn btn-primary">중복체크</button></td> -->
						<td style="width:150px"><span id="chkMsg"></span></td>
					</tr>
					<tr>
						<th><label for="memberPw">비밀번호</label></th>
						<td><input type="password" name="memberPw" id="memberPw" class="form-control"></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<th><label for="pwChk">비밀번호확인</label></th>
						<td><input type="password" id="pwChk" class="form-control"></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<th><label for="memberName">이름</label></th>
						<td><input type="text" name="memberName" id="memberName" class="form-control"></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<th><label for="age">나이</label></th>
						<td><input type="text" name="age" id="age" class="form-control"></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<th><label for="email">이메일</label></th>
						<td><input type="text" name="email" id="email" class="form-control"></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<th><label for="phone">연락처</label></th>
						<td><input type="text" name="phone" id="phone" class="form-control"></td>
						<td colspan="2"></td>
					</tr>
				</table>
				<hr>
				<div id="btn-box">
					<button type="submit" class="btn btn-success btn-lg">회원가입</button>
					<button type="reset" class="btn btn-success btn-lg">초기화</button>
				</div>
			</form>
			
			<form name="checkIdFrm">
				<input type="hidden" name="checkId">
			</form>
		</div>
	</section>
	
	<script>

		$("#memberId").keyup(function(){
			var memberId = $("#memberId").val();
			$.ajax({
				url : "/ajaxCheckId.do",
				type : "get",
				data : {memberId:memberId},
				success:function(data){
					
					var msg = $("#chkMsg");
					
					if(data == '1'){
						msg.html("사용가능");
						msg.css("color","green");
					}else{
						msg.html("사용중");
						msg.css("color","red");
					}
						
				},
				error:function(){
					console.log("아이디 중복체크 실패");
				}
			});
		});
	

	
		function checkId(){
			var memberId = document.getElementById("memberId").value;
			
			if(memberId == ""){
				alert("아이디를 입력해주세요.");
				return;
			}
			
			
			var title = "checkId";	
			var status = "left=500px, top=100px, width=300px, height=200px, menubar=no, status=no, scrollbar=yes";	// 새 창의 속성
			
			// open(새 창에 보여줄 주소(비우면 빈창(about:blank)), 새창의 이름, 새 창의 속성)
			// 두번째 요소 title속성이 form에 target에 들어가는 속성과 같다.
			var popup = window.open("", title, status);	
			
			
			// name만 있는 form태그에 hidden 속성값 설정
			checkIdFrm.checkId.value = memberId;	// input hidden에 값 설정
			checkIdFrm.target = title;			// popup 창과 form 태그를 연결
			// action, method 설정 후 form태그 submit실행
			checkIdFrm.action = "/checkId"; // 요청할 서블릿 url
			checkIdFrm.method="post";
			checkIdFrm.submit();
			
		}
	</script>
	
</body>
</html>