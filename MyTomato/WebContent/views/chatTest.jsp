<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel ="stylesheet" href="/chat/css/bootstrap.css">
	<link rel ="stylesheet" href="/chat/css/custom.css">
	<title>실시간 익명 채팅 사이트</title>
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="/chat/js/bootstrap.js"></script>
	
	
</head>
<body class="d-chat">
	<div class="container">
		<div class="container bootstrap snippet">
			<div class="col-xs-12">
				<div class="portlet portlet-default">
					<div class="portlet-heading">
						<div class="portlet-title">
							<h4><i class="fa fa-circle text-green"></i>실시간 채팅방</h4>
						</div>
						<div class="clearfix"></div>
					</div>
					<div id="chat" class="panel-collapse collapse in">
						<div class="portlet-body chat-widget" style="overflow-y: auto; width: auto; height: 300px;">
							<div class="row">
								<div class="col-lg-12">
									<p class="text-center text-muted small">2019년 10월 21일</p> 
								</div>
							</div>
							
							<!-- 채팅 작성 부분 -->
							<div class="row">
								<div class="col-lg-12">
									<div class="media">
										<a class="pull-left" href="#">
											<img class="media-object img-circle" src="/chat/img/icon.png">
										</a>
										
										<div class="media-body">
											<h4 class="media-heading">홍길동
												<span class="small pull-right">오전 3시</span>
											</h4>
										</div>
										<p>안녕하세요. 접니다</p>
									</div>
								</div>
							</div>
							
							<hr>
							
							<!-- 채팅 작성 부분 -->
							<div class="row">
								<div class="col-lg-12">
									<div class="media">
										<a class="pull-left" href="#">
											<img class="media-object img-circle" src="/chat/img/icon.png">
										</a>
										
										<div class="media-body">
											<h4 class="media-heading">고길동
												<span class="small pull-right">오전 3시</span>
											</h4>
										</div>
										<p>반가워요. 접니다</p>
									</div>
								</div>
							</div>
						</div>

						<!-- 이름 입력 -->
						<div class="portlet-footer">
							<div class="row">
								<div class="form-group col-xs-4">
									<input style="height: 40px" type="text" id="chatName" class="form-control" placeholder="이름" maxlength="20">
								</div>
							</div>
						
						
							<!-- 메시지 입력 -->
							<div class="row" style="height: 90px">
								<div class="form-group col-xs-10">
									<textarea style="height: 80px" id="chatContent" class="form-control" placeholder="메시지를 입력하세요." maxlength="100"></textarea>
								</div>
								<div class="form-group col-xs-2">
									<button type="button" class="btn btn-default pull-right" onclick="submitFunction();">전송</button>
									<div class="clearfix"></div>
								</div> 
							</div>
						
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="alert alert-success" id="successMessage" style="display:none;">
		<strong>메시지 전송에 성공하였습니다.</strong>
	</div>
	
	<div class="alert alert-danger" id="dangerMessage" style="display:none;">
		<strong>이름과 내용을 모두 입력해주세요,</strong>
	</div>
	
		<div class="alert alert-warning" id="warningMessage" style="display:none;">
		<strong>데이터베이스 오류가 발생했습니다.</strong>
	</div>
	
	
	
	
	<script>
	
		function submitFunction(){
			var chatName = $("#chatName").val();
			var chatContent = $("#chatContent").val();
		
			$.ajax({
				type : "POST",
				url : "/chatSubmit",
				data : {chatName: chatName, chatContent: chatContent},
				success: function(result){
					if(result == 1){
						autoClosingAlert('#successMessage', 2000);
					} else if(result == 0){
						autoClosingAlert('#dangerMessage', 2000);
					}else{
						autoClosingAlert('#warningMessage', 2000);
					}
				}
			
			});
			
			// 채팅입력창 초기화
			$("#chatContent").val('');
		}
		
		
		// 전송버튼 클릭에 대한 alert반응을 자동으로 꺼지게 하기위함
		function autoClosingAlert(selector, delay){
			var alert = $(selector).alert();
			alert.show();
			window.setTimeout(function(){alert.hide()}, delay);
		}
	</script>
	
</body>
</html>