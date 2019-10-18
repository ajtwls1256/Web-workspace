<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<style>
		* { margin:0; padding:0; }
		ul,li { list-style:none; }
		a { text-decoration:none; color:#000; }
		.tab { border:1px solid #ddd; border-left:none; background:#fff; overflow:hidden; }
		.tab li { float:left; width:50%; border-left:1px solid #ddd; text-align:center; box-sizing:border-box; }
		.tab li { display:inline-block; padding:20px; cursor:pointer; }
		.tab li.on { background-color:#eee; color:#f00; }
		.tab_con { clear:both; margin-top:5px; border:1px solid #ddd; }
		.tab_con div { display:none; background:#fff; text-align:center; }
	</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<section>
		<div id="container" style="margin:0 auto; width:800px; color:black; text-align:center;">
			<ul class="tab" id="tab">
			    <li>아이디 찾기</li>
			    <li>비밀번호 찾기</li>
			</ul>
			
			<div class="tab_con" id="tab_con">
			    <div>
			    	<form action="/findId">
				    	<table class="table">
				    		<tr>
				    			<th><label for="IDmemberName">이름</label></th>
								<td><input type="text" name="memberName" id="IDmemberName" class="form-control"></td>
				    			<td colspan="2"></td>
				    		</tr>
				    		<tr>
								<th><label for="IDemail">이메일</label></th>
								<td><input type="text" name="email" id="IDemail" class="form-control"></td>
								<td colspan="2"></td>
							</tr>
							<tr>
								<th><label for="IDphone">연락처</label></th>
								<td><input type="text" name="phone" id="IDphone" class="form-control"></td>
								<td colspan="2"></td>
							</tr>
							<tr>
								<td colspan="4">
								<button type="submit" class="btn btn-success btn-lg">아이디 찾기</button>
								<button type="reset" class="btn btn-success btn-lg">초기화</button>
								</td>
							</tr>
				    	</table>
					</form>
			    </div>	
			    
			    <div>
			    	<form action="/findPw">
				    	<table class="table">
				    		<tr>
				    			<th><label for="PWmemberId">아이디</label></th>
								<td><input type="text" name="memberId" id="PWmemberId" class="form-control"></td>
				    		</tr>
				    		<tr>
								<th><label for="PWmemberName">이름</label></th>
								<td><input type="text" name="memberName" id="PWmemberName" class="form-control"></td>
								<td colspan="2"></td>
							</tr>
				    		<tr>
								<th><label for="PWemail">이메일</label></th>
								<td><input type="text" name="email" id="PWemail" class="form-control"></td>
								<td colspan="2"></td>
							</tr>
							<tr>
								<td colspan="4">
								<button type="submit" class="btn btn-success btn-lg">비밀번호 찾기</button>
								<button type="reset" class="btn btn-success btn-lg">초기화</button>
								</td>
							</tr>
				    	</table>
			    	</form>
			    </div>	
			</div>
		</div>
	</section>
</body>

<script>
	$(function () {	
		tab('#tab',0);	
	});
	
	function tab(e, num){
	    var num = num || 0;
	    var menu = $(e).children();
	    var con = $(e+'_con').children();
	    var select = $(menu).eq(num);
	    var i = num;
	
	    select.addClass('on');
	    con.eq(num).show();
	
	    menu.click(function(){
	        if(select!==null){
	            select.removeClass("on");
	            con.eq(i).hide();
	        }
	
	        select = $(this);	
	        i = $(this).index();
	
	        select.addClass('on');
	        con.eq(i).show();
	    });
	}
</script>
</html>