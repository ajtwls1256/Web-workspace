<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    // 결과값, 조회한 id값 넘어옴
    
    // object 타입이기때문에 wrapper클래스로 형변환하고 오토언박싱을 처리
    boolean result = (Boolean)request.getAttribute("result"); 	
    
    String checkId = (String)request.getAttribute("checkId");
    
    %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
		#checked-container{
			text-align : center;
			padding-top : 50px;
		}
		
		#checked{
			color : red;
			font-weight : bold;
		}
	</style>
</head>
<body>
	<div id="checked-container">
		<%if(result){ %>
			[<span><%=checkId %></span>]는 사용이 가능합니다.
			<br><br>
			<button type="button" onclick="setMemberId('<%=checkId %>')">닫기</button>
		<%}else{ %>
			[<span id="checked"><%=checkId %></span>]는 이미 사용중입니다.
			<br><br>
			<form action="/checkId" method="post">
				<input type="text" name="checkId" placeholder="아이디를 입력하세요"><br>
				<button type="submit">중복검사</button>
			</form>
		<%} %>
	</div>
	
	
	<script>
	
	// 입력한 ID가 중복값이 아니라면 회원가입창 ID란에 입력받은 ID를 넘겨주고 아래 PW입력란으로 focus이동
		function setMemberId(memberId){
			// opener -> 현재창을 연 창
			var id = opener.document.getElementById("memberId");
			var pw = opener.document.getElementById("memberPw");
			id.value = memberId;	// 부모창 ID input에 값 세팅
			pw.focus();		// 비밀번호 입력창으로 focus 이동
			self.close();	// 현재 열린 popup창 종료
		}
	</script>

</body>
</html>