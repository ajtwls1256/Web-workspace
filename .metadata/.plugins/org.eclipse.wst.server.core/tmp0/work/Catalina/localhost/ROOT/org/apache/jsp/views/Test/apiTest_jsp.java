/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.46
 * Generated at: 2019-10-15 01:41:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.kh.member.model.vo.Member;

public final class apiTest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1570685940565L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.kh.member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<!-- 네이버 맵을 이용하기 위해 추가 -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=rwh7o3h6va&submodules=geocoder\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- 결제창을 이용하기 위해 추가 -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://cdn.iamport.kr/js/iamport.payment-1.1.5.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- 주소 찾기를 이용하기 위해 추가 -->\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");

    Member m = (Member)session.getAttribute("member");
    
    
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-3.3.1.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/header/style.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/header/responsive.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/bootstrap.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<header class=\"header_area\">\r\n");
      out.write("\t\t<nav class=\"navbar navbar-expand-lg navbar-light\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<a class=\"navbar-brand logo_h\" href=\"/\">\r\n");
      out.write("\t\t\t\t\t<img src=\"/img/logo.png\" width=\"165\" height=\"80\">\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t<button class=\"navbar-toggler\" type=\"button\" \r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" \r\n");
      out.write("\t\t\t\tdata-target=\"#navbarSupportedContent\"\r\n");
      out.write("\t\t\t\taria-controls = \"navbarSupportedContent\"\r\n");
      out.write("\t\t\t\taria-expand=\"false\"\r\n");
      out.write("\t\t\t\taria-label = \"Toggle navigation\" >\r\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t<div class=\"collapse navbar-collapse offset\" id=\"navbarSupportedContent\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-nav menu-nav ml-auto\">\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/noticeList\">공지사항</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/boardList\">자유게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/views/Test/ajaxTest.jsp\">AjaxTest</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/photoList\">사진게시판</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"/views/Test/apiTest.jsp\">APITest</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"right-button\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t");
if(m==null){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><button class=\"btn btn-danger\" onclick=\"location.href='/views/member/login.jsp'\">로그인</button></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><button class=\"btn btn-danger\" onclick=\"location.href='/views/member/join.jsp'\">회원가입</button></li>\r\n");
      out.write("\t\t\t\t\t\t");
}else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><button class=\"btn btn-danger\" onclick=\"location.href='/mypage?memberId=");
      out.print(m.getMemberId());
      out.write('\'');
      out.write('"');
      out.write('>');
      out.print(m.getMemberName());
      out.write("</button></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><button class=\"btn btn-danger\" onclick=\"location.href='/logout'\">로그아웃</button></li>\r\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t</header>");
      out.write("\r\n");
      out.write("\t<section>\r\n");
      out.write("\t\t<div class=\"container\" style=\"color:black;\">\r\n");
      out.write("\t\t\t<h2>1. 네이버 지도 API</h2>\r\n");
      out.write("\t\t\t<div id=\"map\" style=\"width:100%; height:500px;\"></div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<hr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<h2>2. 결제모듈 API</h2>\r\n");
      out.write("\t\t\t<div id=\"pay\">\r\n");
      out.write("\t\t\t\t<h4>\r\n");
      out.write("\t\t\t\t\t<label><input type=\"checkbox\" value=\"1000\">1000원</label>\r\n");
      out.write("\t\t\t\t\t<label><input type=\"checkbox\" value=\"5000\">5000원</label>\r\n");
      out.write("\t\t\t\t\t<label><input type=\"checkbox\" value=\"10000\">10000원</label>\r\n");
      out.write("\t\t\t\t\t<label><input type=\"checkbox\" value=\"50000\">50000원</label>\r\n");
      out.write("\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<h3>\r\n");
      out.write("\t\t\t\t총 결제 금액\r\n");
      out.write("\t\t\t\t\t<span style=\"display:inline-block; width:150px; text-align:right;\"></span>\r\n");
      out.write("\t\t\t\t\t원\r\n");
      out.write("\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-danger\">결제하기</button>\r\n");
      out.write("\t\t\t\t<p id=\"paymentResult\"></p>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<hr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<h2>3. 다음 주소 찾기 API 사용</h2>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<input id=\"postCode\" style=\"width:200px; display:inline-block\" type=\"text\" class=\"form-control\" readonly>\r\n");
      out.write("\t\t\t\t\t\t<button id=\"addrSearchBtn\" onclick=\"addrSearch();\" class=\"btn btn-primary\">주소 검색</button> \r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<input id=\"roadAddr\" style=\"width:200px; display:inline-block\" type=\"text\" class=\"form-control\" readonly>\r\n");
      out.write("\t\t\t\t\t\t<input id=\"jibunAddr\" style=\"width:200px; display:inline-block\" type=\"text\" class=\"form-control\" readonly>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<input id=\"detailAddr\" style=\"width:500px;display:inline-block\" type=\"text\" class=\"form-control\">\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 네이버맵 -->\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t// 1. 네이버 지도 api 사용\r\n");
      out.write("\t\twindow.onload=function(){\r\n");
      out.write("\t\t\tvar map = new naver.maps.Map('map', {\r\n");
      out.write("\t\t\t\tcenter : new naver.maps.LatLng(37.533807, 126.896772),\t// 위치 설정(기본은 서울시청)\r\n");
      out.write("\t\t\t\tzoom:12,\t\t\t\t\t\t\t\t\t\t\t\t// 확대정도 ( 0 ~ 15 )\r\n");
      out.write("\t\t\t\tzoomControl : true,\t\t\t\t\t\t\t\t\t\t// 줌 조절 툴바 on\r\n");
      out.write("\t\t\t\tzoomControlOptions:{\t\t\t\t\t\t\t\t// 줌 조절 툴바 설정\r\n");
      out.write("\t\t\t\t\tposition: naver.maps.Position.TOP_RIGHT,\t\t\t\t// 우측 상단\r\n");
      out.write("\t\t\t\t\tstyle : naver.maps.ZoomControlStyle.SMALL\t\t\t// 축소표시\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar marker = new naver.maps.Marker({\t\t\t\t// 지도에 위치 표시\r\n");
      out.write("\t\t\t\tposition : new naver.maps.LatLng(37.533807, 126.896772),\r\n");
      out.write("\t\t\t\tmap:map\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 클릭한 지점으로 마커 이동\r\n");
      out.write("\t\t\tnaver.maps.Event.addListener(map, 'click', function(e){\r\n");
      out.write("\t\t\t\tmarker.setPosition(e.coord);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 정보창이 떠있으면 정보창 닫기\r\n");
      out.write("\t\t\t\tif(infoWindow != null){\r\n");
      out.write("\t\t\t\t\tif(infoWindow.getMap()){\r\n");
      out.write("\t\t\t\t\t\tinfoWindow.close();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 위/경도를 이용하여 주소를 얻어오기 위해서는 reverseGeocode를 사용해야함\r\n");
      out.write("\t\t\t\t// 클라이언트 키 뒤에 &submodules=geocoder를 추가\r\n");
      out.write("\t\t\t\tnaver.maps.Service.reverseGeocode({\r\n");
      out.write("\t\t\t\t\tlocation : new naver.maps.LatLng(e.coord.lat(), e.coord.lng())\r\n");
      out.write("\t\t\t\t}, function(status, response){\r\n");
      out.write("\t\t\t\t\tif(status !== naver.maps.Service.Status.OK){\t// OK가 아니면(!== 는 자료형까지 비교)\r\n");
      out.write("\t\t\t\t\t\treturn alert(\"실패\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar result = response.result,\r\n");
      out.write("\t\t\t\t\t\titems = result.items;\t\t\t// JSON타입으로 응답을 받아서 변수에 저장\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\taddress = items[2].address;\t\t\t// 0 -> 지번주소, 1 -> 도로명, 2 -> 도로명?\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\tcontentString = [\r\n");
      out.write("\t\t\t\t\t\t'<div class=\"iw_inner\">',\r\n");
      out.write("\t\t\t\t\t\t'\t<h3>KH정보교육원</h3>',\r\n");
      out.write("\t\t\t\t\t\t'\t<p>'+address+'</p>',\r\n");
      out.write("\t\t\t\t\t\t'</div>'\r\n");
      out.write("\t\t\t\t\t].join('');\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t/* 마커에 대한 정보창 열기 */\r\n");
      out.write("\t\t\tvar contentString = [\r\n");
      out.write("\t\t\t\t'<div class=\"iw_inner\">',\r\n");
      out.write("\t\t\t\t'\t<h3>KH정보교육원</h3>',\r\n");
      out.write("\t\t\t\t'\t<p>서울특별시 영등포구 선유동2로 57 이레빌딩 19F, 20F</p>',\r\n");
      out.write("\t\t\t\t'</div>'\r\n");
      out.write("\t\t\t].join('');\r\n");
      out.write("\t\t\tvar infoWindow = new naver.maps.InfoWindow();\r\n");
      out.write("\t\t\tnaver.maps.Event.addListener(marker, 'click', function(e){\r\n");
      out.write("\t\t\t\tif(infoWindow.getMap()){\t// 정보창이 열려잇으면\r\n");
      out.write("\t\t\t\t\tinfoWindow.close();\t// 닫기\r\n");
      out.write("\t\t\t\t}else{\t\t\t\t\t\t// 안열려있으면 열기\r\n");
      out.write("\t\t\t\t\tinfoWindow = new naver.maps.InfoWindow({\r\n");
      out.write("\t\t\t\t\t\tcontent : contentString\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\tinfoWindow.open(map, marker);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 결제 -->\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 금액 클릭시 더해서 총액 표시\r\n");
      out.write("\t\t\tvar totalPay = 0;\r\n");
      out.write("\t\t\t$(\"#pay input\").change(function(){\r\n");
      out.write("\t\t\t\tif($(this).is(\":checked\")){\r\n");
      out.write("\t\t\t\t\ttotalPay += (Number)($(this).val());\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\ttotalPay -= (Number)($(this).val());\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#pay span\").html(totalPay);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 결제창 띄우기\r\n");
      out.write("\t\t\t$(\"#pay button\").click(function(){\r\n");
      out.write("\t\t\t\tvar price = $(\"#pay span\").html();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 상품명_현재시간\r\n");
      out.write("\t\t\t\tvar d = new Date();\r\n");
      out.write("\t\t\t\tvar date = d.getFullYear()+''+(d.getMonth()+1)+''+d.getDate()+''+d.getHours()+''+d.getMinutes()+''+d.getSeconds();\t// ''를 붙여 숫자계산이안되고 문자열 더하기로 되게 만듦\r\n");
      out.write("\t\t\t\tIMP.init('imp05211646');\t\t// 결제 API를 사용하기위한 코드(가맹점코드) 입력\r\n");
      out.write("\t\t\t\tIMP.request_pay({\t\t// 결제요청\r\n");
      out.write("\t\t\t\t\tmerchant_uid : '상품명_'+date,\t// 상점 거래 ID\r\n");
      out.write("\t\t\t\t\tname : '결제테스트',\t\t\t// 결제명\r\n");
      out.write("\t\t\t\t\tamount : price,\t\t\t\t\t// 결제 금액\r\n");
      out.write("\t\t\t\t\tbuyer_email : 'yhl509@naver.com',// 구매자 이메일\r\n");
      out.write("\t\t\t\t\tbuyer_name : '구매자,',\t\t\t// 구매자 이름\r\n");
      out.write("\t\t\t\t\tbuyer_tel : '010-1234-5678',\t\t// 구매자 전화번호\r\n");
      out.write("\t\t\t\t\tbuyer_addr : '서울특별시 영등포구',\t// 구매자 주소\r\n");
      out.write("\t\t\t\t\tbuyer_postcode : '123-456'\t\t// 구매자 우편번호\r\n");
      out.write("\t\t\t\t}, function(rsp){\t\t// 결과처리\r\n");
      out.write("\t\t\t\t\tif(rsp.success){\r\n");
      out.write("\t\t\t\t\t\tvar msg = '결제가 완료되었습니다.';\r\n");
      out.write("\t\t\t\t\t\tvar r1 = '고유 아이디 : ' + rsp.imp_uid;\r\n");
      out.write("\t\t\t\t\t\tvar r2 = '상점 거래 아이디 : ' +rsp.merchant_uid;\r\n");
      out.write("\t\t\t\t\t\tvar r3 = '결제 금액 : ' + rsp.paid_amount;\r\n");
      out.write("\t\t\t\t\t\tvar r4 = '카드 승인 번호 : ' + rsp.apply_num;\r\n");
      out.write("\t\t\t\t\t\talert(msg);\r\n");
      out.write("\t\t\t\t\t\t$(\"#paymentResult\").html(r1+\"<br>\"+r2+\"<br>\"+r3+\"<br>\"+r4);\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t$(\"#paymentResult\").html('결제실패<br>' + '에러내용 : ' +rsp.error_msg);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 주소검색 -->\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction addrSearch(){\r\n");
      out.write("\t\t\tnew daum.Postcode({\r\n");
      out.write("\t\t\t\toncomplete:function(data){\r\n");
      out.write("\t\t\t\t\t$(\"#postCode\").val(data.zonecode);\t\t// 우편번호\r\n");
      out.write("\t\t\t\t\t$(\"#roadAddr\").val(data.roadAddress);\t// 도로명주소\r\n");
      out.write("\t\t\t\t\t$(\"#jibunAddr\").val(data.jibunAddress);\t// 지번주소\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}).open();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}