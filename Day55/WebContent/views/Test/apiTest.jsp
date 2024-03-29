<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 네이버 맵을 이용하기 위해 추가 -->
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=rwh7o3h6va&submodules=geocoder"></script>

<!-- 결제창을 이용하기 위해 추가 -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<!-- 주소 찾기를 이용하기 위해 추가 -->
<script type="text/javascript" src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="container" style="color:black;">
			<h2>1. 네이버 지도 API</h2>
			<div id="map" style="width:100%; height:500px;"></div>
			
			<hr>
			
			<h2>2. 결제모듈 API</h2>
			<div id="pay">
				<h4>
					<label><input type="checkbox" value="1000">1000원</label>
					<label><input type="checkbox" value="5000">5000원</label>
					<label><input type="checkbox" value="10000">10000원</label>
					<label><input type="checkbox" value="50000">50000원</label>
				</h4>
				
				<h3>
				총 결제 금액
					<span style="display:inline-block; width:150px; text-align:right;"></span>
					원
				</h3>
				<button class="btn btn-danger">결제하기</button>
				<p id="paymentResult"></p>
				
				<hr>
				
				<h2>3. 다음 주소 찾기 API 사용</h2>
				<ul>
					<li>
						<input id="postCode" style="width:200px; display:inline-block" type="text" class="form-control" readonly>
						<button id="addrSearchBtn" onclick="addrSearch();" class="btn btn-primary">주소 검색</button> 
					</li>
					<li>
						<input id="roadAddr" style="width:200px; display:inline-block" type="text" class="form-control" readonly>
						<input id="jibunAddr" style="width:200px; display:inline-block" type="text" class="form-control" readonly>
					</li>
					<li>
						<input id="detailAddr" style="width:500px;display:inline-block" type="text" class="form-control">
					</li>
				</ul>
				
				<hr>
				
				<h2>4. 영화 박스오피스</h2>
				<button id="movieBtn" class="btn btn-primary">영화순위</button>
				<div id="movieResult"></div>
				
				<br><hr><br>
				
				<h2>5. LOL 전적검색 </h2>
				<input id="summoners" style="width:200px; display:inline-block;" type="text" class="form-control">
				<button id="lolSearch" class="btn btn-primary">전적 검색</button>
				<br>
				<div id="lolResult"></div> 
				
				<br><br><br>
			</div>
		</div>
	</section>
	
	
	<!-- 네이버맵 -->
	<script>
		// 1. 네이버 지도 api 사용
		window.onload=function(){
			var map = new naver.maps.Map('map', {
				center : new naver.maps.LatLng(37.533807, 126.896772),	// 위치 설정(기본은 서울시청)
				zoom:12,												// 확대정도 ( 0 ~ 15 )
				zoomControl : true,										// 줌 조절 툴바 on
				zoomControlOptions:{								// 줌 조절 툴바 설정
					position: naver.maps.Position.TOP_RIGHT,				// 우측 상단
					style : naver.maps.ZoomControlStyle.SMALL			// 축소표시
				}
			});
			
			var marker = new naver.maps.Marker({				// 지도에 위치 표시
				position : new naver.maps.LatLng(37.533807, 126.896772),
				map:map
			});
			
			// 클릭한 지점으로 마커 이동
			naver.maps.Event.addListener(map, 'click', function(e){
				marker.setPosition(e.coord);
				
				// 정보창이 떠있으면 정보창 닫기
				if(infoWindow != null){
					if(infoWindow.getMap()){
						infoWindow.close();
					}
				}
				
				// 위/경도를 이용하여 주소를 얻어오기 위해서는 reverseGeocode를 사용해야함
				// 클라이언트 키 뒤에 &submodules=geocoder를 추가
				naver.maps.Service.reverseGeocode({
					location : new naver.maps.LatLng(e.coord.lat(), e.coord.lng())
				}, function(status, response){
					if(status !== naver.maps.Service.Status.OK){	// OK가 아니면(!== 는 자료형까지 비교)
						return alert("실패");
					}
					
					var result = response.result,
						items = result.items;			// JSON타입으로 응답을 받아서 변수에 저장
						
						
					address = items[2].address;			// 0 -> 지번주소, 1 -> 도로명, 2 -> 도로명?
				
					contentString = [
						'<div class="iw_inner">',
						'	<h3>KH정보교육원</h3>',
						'	<p>'+address+'</p>',
						'</div>'
					].join('');
				});
				
			});
			
			/* 마커에 대한 정보창 열기 */
			var contentString = [
				'<div class="iw_inner">',
				'	<h3>KH정보교육원</h3>',
				'	<p>서울특별시 영등포구 선유동2로 57 이레빌딩 19F, 20F</p>',
				'</div>'
			].join('');
			var infoWindow = new naver.maps.InfoWindow();
			naver.maps.Event.addListener(marker, 'click', function(e){
				if(infoWindow.getMap()){	// 정보창이 열려잇으면
					infoWindow.close();	// 닫기
				}else{						// 안열려있으면 열기
					infoWindow = new naver.maps.InfoWindow({
						content : contentString
					});
				
				
					infoWindow.open(map, marker);
				}
			});

		}
	</script>
	
	
	<!-- 결제 -->
	<script>
		$(document).ready(function(){
			
			// 금액 클릭시 더해서 총액 표시
			var totalPay = 0;
			$("#pay input").change(function(){
				if($(this).is(":checked")){
					totalPay += (Number)($(this).val());
				}else{
					totalPay -= (Number)($(this).val());
				}
				
				$("#pay span").html(totalPay);
			});
			
			
			// 결제창 띄우기
			$("#pay button").click(function(){
				var price = $("#pay span").html();
				
				// 상품명_현재시간
				var d = new Date();
				var date = d.getFullYear()+''+(d.getMonth()+1)+''+d.getDate()+''+d.getHours()+''+d.getMinutes()+''+d.getSeconds();	// ''를 붙여 숫자계산이안되고 문자열 더하기로 되게 만듦
				IMP.init('imp05211646');		// 결제 API를 사용하기위한 코드(가맹점코드) 입력
				IMP.request_pay({		// 결제요청
					merchant_uid : '상품명_'+date,	// 상점 거래 ID
					name : '결제테스트',			// 결제명
					amount : price,					// 결제 금액
					buyer_email : 'yhl509@naver.com',// 구매자 이메일
					buyer_name : '구매자,',			// 구매자 이름
					buyer_tel : '010-1234-5678',		// 구매자 전화번호
					buyer_addr : '서울특별시 영등포구',	// 구매자 주소
					buyer_postcode : '123-456'		// 구매자 우편번호
				}, function(rsp){		// 결과처리
					if(rsp.success){
						var msg = '결제가 완료되었습니다.';
						var r1 = '고유 아이디 : ' + rsp.imp_uid;
						var r2 = '상점 거래 아이디 : ' +rsp.merchant_uid;
						var r3 = '결제 금액 : ' + rsp.paid_amount;
						var r4 = '카드 승인 번호 : ' + rsp.apply_num;
						alert(msg);
						$("#paymentResult").html(r1+"<br>"+r2+"<br>"+r3+"<br>"+r4);
					}else{
						$("#paymentResult").html('결제실패<br>' + '에러내용 : ' +rsp.error_msg);
					}
				});
			});
		});
	</script>
	
	
	<!-- 주소검색 -->
	<script>
		function addrSearch(){
			new daum.Postcode({
				oncomplete:function(data){
					$("#postCode").val(data.zonecode);		// 우편번호
					$("#roadAddr").val(data.roadAddress);	// 도로명주소
					$("#jibunAddr").val(data.jibunAddress);	// 지번주소
				}
			}).open();
		}
	</script>
	
	
	<!-- 박스오피스 순위 -->
	<script>
		$("#movieBtn").click(function(){
			/* 어제날짜 조회 */
			$.ajax({
				url : "/searchMovie",
				type : "get",
				success : function(data){
					for(var index in data){
						$("#movieResult").append("<hr>");
						$("#movieResult").append("순위 : " + data[index].rank + "<br>");
						$("#movieResult").append("영화제목 : " + data[index].movieNm + "<br>");
					}
				},
				error:function(){
					console.log("실패");
				}
			});
		});
	</script>
	
	<!-- LOL 전적검색 -->
	<script>
	
		$("#lolSearch").click(function(){
			
			$("#lolResult").empty();
			var summoners = $("#summoners").val();
			
			$.ajax({
				url : "/lolSearch",
				data : {summoners:summoners},
				type : "get",
				success : function(data){
					for(var index in data){
						$("#lolResult").append("<hr>");
						$("#lolResult").append("종류 : " + data[index].queueType + "<br>");
						$("#lolResult").append("등급 : " + data[index].tier + " " + data[index].rank + " " + data[index].leaguePoints + "점<br>");
						$("#lolResult").append("승 : " + data[index].wins + " / 패 : " + data[index].losses + "<br>");
					}
				},
				error:function(){
					console.log("실패");
				}
			});
		});
	</script>
	
</body>
</html>