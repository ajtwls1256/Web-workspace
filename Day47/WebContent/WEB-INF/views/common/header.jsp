<%@page import="org.kh.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    Member m = (Member)session.getAttribute("member");
    
    
    %>
    
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/header/style.css">
<link rel="stylesheet" href="/css/header/responsive.css">
<script type="text/javascript" src="/js/bootstrap.js"></script>

<header class="header_area">
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container">
				<a class="navbar-brand logo_h" href="/">
					<img src="/img/logo.png" width="165" height="80">
				</a>
				<button class="navbar-toggler" type="button" 
				data-toggle="collapse" 
				data-target="#navbarSupportedContent"
				aria-controls = "navbarSupportedContent"
				aria-expand="false"
				aria-label = "Toggle navigation" >
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
					<ul class="nav navbar-nav menu-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="#">메뉴1</a></li>
						<li class="nav-item"><a class="nav-link" href="#">메뉴2</a></li>
						<li class="nav-item"><a class="nav-link" href="#">메뉴3</a></li>
						<li class="nav-item"><a class="nav-link" href="#">메뉴4</a></li>
					</ul>
				</div>
				<div class="right-button">
					<ul>
						<%if(m==null){ %>
						<li class="nav-item"><button class="btn btn-danger" onclick="location.href='/views/member/login.jsp'">로그인</button></li>
						<li class="nav-item"><button class="btn btn-danger" onclick="location.href='/views/member/login.jsp'">회원가입</button></li>
						<%}else { %>
						<li class="nav-item"><button class="btn btn-danger" onclick="location.href='/mypage?memberId=<%=m.getMemberId()%>'"><%=m.getMemberName()%></button></li>
						<li class="nav-item"><button class="btn btn-danger" onclick="location.href='/logout'">로그아웃</button></li>
						<%} %>
					</ul>
				</div>
			</div>
		</nav>
	</header>