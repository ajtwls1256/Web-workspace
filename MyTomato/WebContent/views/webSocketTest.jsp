<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	<p id="output">웹소켓</p>
	
	
	<script>
	
		$(function(){
			
			
			$("#output").click(function(){
				WebSocketTest();
			})
			
			
			function WebSocketTest(){
			
			
				if("WebSocket" in window){
					alert("Websocket이 지원되는 브라우저네");
					
					// 아래 url부분이 틀려 jsp에 맞는 버전으로 다시 작성하자
					var ws = new WebSocket("ws://localhost/WebContent/views/chatTest.jsp");
					
					ws.onopen = function(){
						ws.send("Message to send");
						alert("Message is sent..");
					};
					
					ws.onmessage = function(evt){
						var received_msg = evt.data;
						alert("Message is received..");
					};
					
					ws.onerror = function(evt){
						alert("에러발생");
					}
					
					ws.onclose = function(){
						alert("Connection is closed");
					};
					
				}else{
					
					alert("Websocket이 지원 안되는 브라우저네");
				}
				
			}
			
		});
	
	
	</script>
</body>
</html>