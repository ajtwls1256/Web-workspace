<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<fieldset>
		<textarea id="messageWindow" rows="10" cols="50" readonly="true"></textarea>
		<br>
		<input id="inputMessage" type="text">
		<input type="submit" value="send" onclick="send()">
 	</fieldset>
 	
 	
 	
 	
 	<script type="text/javascript">
 	
 		// sciprt변수와 jquery변수는 다른 객체란 것 주의
 		
 		var textarea = document.getElementById("messageWindow");
 		var webSocket = new WebSocket('ws://localhost/server');
 		var inputMessage = document.getElementById('inputMessage');
 		
 		webSocket.onopen = function(event){
 			onOpen(event);
 		};
 		
 		webSocket.onerror = function(event){
 			onError(event);
 		};
 		
 		webSocket.onmessage = function(event){
 			onMessage(event);
 		};
 		
 		function onOpen(event){
 			textarea.value += "연결 성공\n";
 		}
 		
 		function onError(event){
 			alert("에러발생 = " + event.data);
 		}
 		
 		function onMessage(event){
 			textarea.value += "상대 : " + event.data + "\n";
 		}
 		
 		function send(){
 			textarea.value += "나 : " + inputMessage.value + "\n";
 			webSocket.send(inputMessage.value);
 			inputMessage.value = "";
 		}
 
 		
 		
 	</script>
</body>
</html>