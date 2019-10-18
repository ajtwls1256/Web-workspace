<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ArrayList 처리</h1>
	
	
	
	<h2>첫번째 회원</h2>
	아이디 : ${list[0].id }<br>
	비밀번호 : ${list[0].pw }<br>
	이름 : ${list[0].name }<br>
	나이 : ${list[0].age + 100}<br>
	
	<!-- EL에서 test라 표시하면 변수 test로 직접접근하여 값을 가져오는 것이 아닌 getter메소드로 이동하여 가져오기때문에 실제 변수가 없어도 getter메소드가 있으면 그 메소드를 실행시킨다. -->
	${list[0].test }
	
	<h2>두번째 회원</h2>
	아이디 : ${list[1].id }<br>
	비밀번호 : ${list[1].pw }<br>
	이름 : ${list[1].name }<br>
	나이 : ${list[1].age < 40}<br>
	${list[1].test }
</body>
</html>