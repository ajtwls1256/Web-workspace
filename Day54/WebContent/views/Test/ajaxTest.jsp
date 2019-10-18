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
		<div class="container" style="color:black;">
			<h3>1. Ajax 서버에 전송값 보내기</h3>
			<input type="text" class="form-control" id="msg1">
			<button class="btn btn-primary" onclick="jsFunction();">JS로 보내기</button>
			<button id="jQ1" class="btn btn-primary">jQuery로 보내기</button>
			
			<hr>
			
			<h3>2. 버튼클릭 시 서버에서 보낸 값 사용자가 수신</h3>
			<button id="jQ2" class="btn btn-primary">서버에서 보낸 값 사용자가 수신</button>
			<p id ="p2" class="border border-danger"></p>
			
			<hr>
			
			<h3>3. 서버로 기본형 전송값을 보내고, 결과로 문자열을 받아서 처리</h3>
			<p>두개의 숫자값을 보내고 더한값을 받아옴</p>
			첫번째 숫자 : <input type="text" id="firstNum"><br>
			두번째 숫자 : <input type="text" id="secondNum"><br>
			<button class="btn btn-primary" id="jQ3">실행</button>
			<p id="p3" class="border border-danger"></p>
			
			<hr>
			
			<h3>4. 서버로 Object형 전송값 보내기</h3>
			이름 : <input type="text" id="name"><br>
			나이 : <input type="text" id="age"><br>
			주소 : <input type="text" id="addr"><br>
			<button class="btn btn-primary" id="jQ4">실행</button>
			
			<hr>
			
			<h3>5. 서버로 기본형 데이터를 보내고, 결과로 객체를 받아서 처리</h3>
			<p>JSON을 사용</p>
			유저 번호 입력 : <input type="text" id="userNum"><br>
			<button class="btn btn-primary" id="jQ5">실행</button>
			<p id="p5" class="border border-danger"></p>
			
			<hr>
			
			<h3>6. 서버로 기본형 전송값을 보내고, 결과로 리스트객체를 받아서 처리</h3>
			<p>JSON객체이용</p>
			<p>유저번호를 보내서 해당 유저정보 가져오기 -> 없는 경우에는 전체 리스트 가져오기</p>
			유저번호 입력(번호):<input type="text" id="userNum2"><br>
			<button class="btn btn-primary" id="jQ6">실행</button>
			<p id="p6" class="border border-danger"></p>
			
			<hr>
			
			<h3>7. 여러 전송값을 보내고, 결과로 리스트를 받아서 처리</h3>
			유저번호입력(번호,번호,번호) : <input type="text" id="userNum3"><br>
			<button class="btn btn-primary" id="jQ7">실행</button>
			<p id="p7" class="border border-danger"></p>
			
			<h3>8. 여러 전송값을 보내고, 결과로 맵객체를 받아서 처리</h3>
			유저번호입력(번호,번호,번호) : <input type="text" id="userNum4"><br>
			<button class="btn btn-primary" id="jQ8">실행</button>
			<p id="p8" class="border border-danger"></p>
			
			
			<h3>9. 서버 유저 정보 테이블로 표현하기</h3>
			<button class="btn btn-primary" id="jQ9">실행</button>
			<table id="userTbl" class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>주소</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			
			
			<hr>
			
			<h3>10. GSON을 이용한 LIST반환</h3>
			<p>GSON 사용</p>
			<button class="btn btn-primary" id="jQ10">실행</button>
			<select id="select10">
			</select>
			
			<hr>
			
			<h3>11. GSON을 이용한 MAP반환</h3>
			<p>GSON 사용</p>
			<button class="btn btn-primary" id="jQ11">실행</button>
			<select id="select11">
			</select>
			
		</div>
	</section>
	
	
	<script>
		/* JS 방식 */
		function jsFunction(){
			// 1. XMLHttpRequest 객체 생성
			var xhttp = new XMLHttpRequest();
			var msg = document.getElementById("msg1").value;
			
			// 2. 요청정보 설정
			xhttp.open("GET","/ajaxTest1?msg="+msg,true);
			
			// 3. 데이터 처리에 따라 작동할 함수 설정
			xhttp.onreadystatechange = function(){
				if(this.readyState==4 && this.status == 200){	// 정상 처리된 경우
					console.log("서버 전송 성공");
				}else if(this.readyState == 4 && this.status == 404){
					console.log("서버 전송 실패");
				}
			}
			
			// 서버에게 요청
			xhttp.send();
		}
		
		
		
		/* jQuery 방식 */
		
		$("#jQ1").click(function(){
			var message = $("#msg1").val();
			$.ajax({
				// 2. 요청 정보 설정
				url : "/ajaxTest1",		// 넘겨질 주소
				data : {msg:message},	// 객체타입 - 키(msg) 값 (message)
				type : "get",			// 방식
				
				// 3. 데이터 처리에 따라 작동할 함수 설정 
				success : function(){
					console.log("서버 전송 성공!");
				},
				error : function(){
					console.log("서버 전송 실패");
				},
				complete : function(){		// complete : 성공하던 실패하던 무조건 호출
					console.log("무조건 호출");
				}
			});
		});
		
		
		$("#jQ2").click(function(){
			// 보낼 테이터가 없으므로 따로 data를 넣어서 넘겨주지않는다.
			$.ajax({
				url : "/ajaxTest2",
				type : "get",
				// 매개변수를 통해 값을 가져온다.
				success : function(data){
					$("#p2").html(data);
				},
				error : function(data){
					console.log("실패");
				}
			});
		});
		
		
		// 값 주고 계산된값 받기
		$("#jQ3").click(function(){
			 var firstNum = $("#firstNum").val();
			 var secondNum = $("#secondNum").val();
			
			$.ajax({
				
				// 값 설정해서 넘겨주기
				url : "/ajaxTest3",
				type : "get",
				data : {firstNum:firstNum,secondNum:secondNum},
				
				// 결과에 따라 값 받아오기
				success : function(data){
					// 받아오는 data는 string으로 넘어온다
					$("#p3").html(data + 1);
				},
				error : function(){
					console.log("실패");
				}
			});
		});
		
		
		// 서버로 Object 객체 보내기
		$("#jQ4").click(function(){
			var name = $("#name").val();
			var age = $("#age").val();
			var addr = $("#addr").val();
			var student = {name:name, age:age, addr:addr};
		
		
			$.ajax({
				url : "/ajaxTest4",
				type : "get",
				data : student,		// 넘겨주는 값이 객체타입이므로 그냥 넘겨주면된다.
				success : function(){
					console.log("성공");
				}
			});
		});
		
		
		// 서버로 기본형 데이터를 보내고 객체를 받아오기 (json사용)
		$('#jQ5').click(function(){
			var userNum = $("#userNum").val();
			
			$.ajax({
				url : "/ajaxTest5",
				type : "get",
				data : {userNum:userNum},
				success : function(data){
					var userNo = data.userNo;
					// 인코딩되서 넘어왔기때문에 디코딩
					var userName = decodeURIComponent(data.userName);	
					var userAddr = decodeURIComponent(data.userAddr);
					$("#p5").html('유저번호 : ' + userNo + "<br>" + 
								'유저이름 : ' + userName + "<br>" + 
								"주소 : "+ userAddr);
				}
			});
		});
		
		
		// 서버로 기본형 데이터를 보내고 결과로 리스트객체로 받아서처리
		$("#jQ6").click(function(){
			var userNum = $("#userNum2").val();
			
			$.ajax({
				url : "/ajaxTest6",
				type : "get",
				data : {userNum:userNum},
				success : function(data){
					var resultText = "";
					
					for(var i=0;i<data.length;i++){
						var userNo = data[i].userNo;
						// 인코딩되서 넘어왔기때문에 디코딩
						var userName = decodeURIComponent(data[i].userName);	
						var userAddr = decodeURIComponent(data[i].userAddr);
						resultText += "유저 번호 : " +userNo+ "/유저 이름 : " +userName+ "/주소 : " +userAddr+"<br>";
					}
					
					$("#p6").html(resultText);
				}
			});
		});
		
		
		$("#jQ7").click(function(){
			var userNum = $("#userNum3").val();
			$.ajax({
				url : "/ajaxTest7.do",
				type:"get",
				data:{userNum:userNum},
				success:function(data){
					var resultText = "";
					
					for(var i=0;i<data.length;i++){
						var userNo = data[i].userNo;
						// 인코딩되서 넘어왔기때문에 디코딩
						var userName = decodeURIComponent(data[i].userName);	
						var userAddr = decodeURIComponent(data[i].userAddr);
						resultText += "유저 번호 : " +userNo+ "/유저 이름 : " +userName+ "/주소 : " +userAddr+"<br>";
					}
					
					$("#p7").html(resultText);
				}
			});
		});
		
		
		// 여러 전송값을 보내고, 결과로 맵객체를 받아서 처리
		$("#jQ8").click(function(){
			var userNum = $("#userNum4").val();
			$.ajax({
				url : "/ajaxTest8.do",
				type:"get",
				data:{userNum:userNum},
				success:function(data){
					
					var resultText = "";
					var keys = Object.keys(data); // 키값만 한번에 추출
					
					for(var i=0; i<keys.length;i++){
						var userNo = data[keys[i]].userNo;
						var userName = decodeURIComponent(data[keys[i]].userName);	
						var userAddr = decodeURIComponent(data[keys[i]].userAddr);
						resultText += "유저 번호 : " +userNo+ "/유저 이름 : " +userName+ "/주소 : " +userAddr+"<br>";
					}
					
					$("#p8").html(resultText);
				}
			});
		});
		
		
		// 서버 유저 정보 테이블로 표현하기
		$("#jQ9").click(function(){

			$.ajax({
				url : "/ajaxTest9.do",
				type:"get",
				success:function(data){
					var tbody = $("#userTbl tbody");
					for(var i=0; i<data.length; i++){
						var tr = $("<tr>");	// 닫는태그안하면 자동으로 닫아줌
						var noTd = $("<td>").html(data[i].userNo);
						var nameTd = $("<td>").html(decodeURIComponent(data[i].userName));
						var addrTd = $("<td>").html(decodeURIComponent(data[i].userAddr));
					
						tr.append(noTd).append(nameTd).append(addrTd);
						tbody.append(tr);
					}
				
				}
			});
		});
		
		
		
		// GSON 사용해서 List반환
		$("#jQ10").click(function(){
			
			$.ajax({
				url : "/ajaxTest10.do",
				type : "get",
				success : function(data){
					var select = $("#select10");
					
					for(var index in data){	// Java의 foreach문과 동일
						var option = $("<option>");
						option.html(data[index].userName);
						select.append(option);
					}
				}
			});
		});
		
		
		// GSON 사용해서 Map반환
		$("#jQ11").click(function(){
			
			$.ajax({
				url : "/ajaxTest11.do",
				type : "get",
				success : function(data){
					var select = $("#select11");
					
					for(var key in data){	// for in 문으로 map의 key값을 순서대로 가져와서 사용
						var option = $("<option>");
						option.html(data[key].userName);
						select.append(option);
					}
				}
			});
		});
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>