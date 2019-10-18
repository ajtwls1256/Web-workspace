<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.tomato.search.model.service.testService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	testService service = new testService();
	ArrayList<String> list = service.allTest();

	for(String s : list){
	    System.out.println(s);
	}
	%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>  
	
	<section>
		
	</section>
</body>
</html>