/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.46
 * Generated at: 2019-10-18 05:44:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.co.tomato.search.model.service.testService;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1571288323912L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("kr.co.tomato.search.model.service.testService");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\t\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/index.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/header/header.css\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.3.1.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$(\"#navFunc\").hover(function(){\r\n");
      out.write("\t\t\t$(\"#cate\").slideToggle();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#cate\").mouseover(function(){\r\n");
      out.write("\t\t\t$(\"#cate\").show;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\t<header>\r\n");
      out.write("\t\t<div class=\"header1\">\r\n");
      out.write("\t\t\t<div class=\"con\">\r\n");
      out.write("\t\t\t\t<a href=\"https://apps.apple.com/app/id395672275\"><img id=\"download\" src=\"/img/download.png\"><span>앱다운로드</span></a>\r\n");
      out.write("\t\t\t\t<span id=\"head1\">\r\n");
      out.write("\t\t\t\t<a href=\"#\">마이페이지</a>\r\n");
      out.write("\t\t\t\t<a href=\"#\">알림 <img id=\"arrow\" src=\"/img/arrow.png\"></a>\r\n");
      out.write("\t\t\t\t<a href=\"#\" id=\"logout\">로그아웃</a>\r\n");
      out.write("\t\t\t\t</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"header2\"> \r\n");
      out.write("\t\t\t<div class=\"con\">\r\n");
      out.write("\t\t\t\t<a href=\"#\"><img id=\"logo\" src=\"/img/tomatoLogo.png\"></a>\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"searchBox\" placeholder=\"지역, 상품, 업체 등을 검색하세요\" >\r\n");
      out.write("\t\t\t\t<!-- <div id=\"searchIcon\"></div> --> \r\n");
      out.write("\t\t\t\t<div class=\"my-menu\">\r\n");
      out.write("\t\t\t\t\t<span><a href=\"#\"><img src=\"/img/money.png\" id=\"money\">판매하기</a></span>\r\n");
      out.write("\t\t\t\t\t<span><a href=\"#\"><img src=\"/img/myMarket.png\" id=\"myMarket\">내 상점</a></span>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<!-- 일단 요기를 통해 검색페이지 이동 -->\r\n");
      out.write("\t\t\t\t\t<span><a href=\"/searchPage\"><img src=\"/img/talk.png\" id=\"talk\">토마톡</a></span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<nav>\r\n");
      out.write("\t\t<div class=\"navbar\">\r\n");
      out.write("\t\t\t<span id=\"navFunc\">\r\n");
      out.write("\t\t\t\t<img src=\"/img/menu.png\">\r\n");
      out.write("\t\t\t\t<span id=\"cate-span\">카테고리 선택 > </span>\r\n");
      out.write("\t\t\t</span>\r\n");
      out.write("\t\t\t<div class=\"sort\"><!-- http://blog.naver.com/PostView.nhn?blogId=nonamed0000&logNo=220861656041 -->\r\n");
      out.write("\t\t\t\t\t<span>인기검색어</span>\r\n");
      out.write("\t\t\t\t\t<div id=\"searchCount\">\r\n");
      out.write("\t\t\t\t\t\t<span></span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"cate\">  \r\n");
      out.write("\t\t\t<ul class=\"cate1-ul\">\r\n");
      out.write("\t\t\t\t<li class=\"cate1-li\"><a href=\"#\">여성의류</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate1-li\"><a href=\"#\">남성의류</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate1-li\"><a href=\"#\">뷰티/미용</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate1-li\"><a href=\"#\">디지털/가전</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate1-li\"><a href=\"#\">도서/티켓</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate1-li\"><a href=\"#\">스타굿즈</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate1-li\"><a href=\"#\">생활/가구</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate1-li\"><a href=\"#\">기타</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"cate2-ul\" id=\"cate2-ul1\">\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">상의</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">하의</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">원피스</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">스포츠</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">아우터</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">신발</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"cate2-ul\">\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">상의</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">하의</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">스포츠</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">아우터</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">신발</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"cate2-ul\">\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">색조화장품</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">기초화장품</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">남성화장품</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">식품</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"cate2-ul\">\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">PC/노트북</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">카메라</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">가전제품</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">게임</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"cate2-ul\">\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">상품권</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">도서</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">티켓</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">기프티콘</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"cate2-ul\">\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">보이그룹</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">걸그룹</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">기타</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"cate2-ul\">\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">생활용품</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">주방용품</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">가구</a></li>\r\n");
      out.write("\t\t\t\t<li class=\"cate2-li\"><a href=\"#\">식품</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<div class=\"nav-border\"></div>");
      out.write("  \r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/jquery/jquery.bxslider.css\"/>\r\n");
      out.write("<script src=\"/js/jquery.bxslider.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t    $('.bxslider').bxSlider({ \r\n");
      out.write("\t    \tpager: false,\r\n");
      out.write("\t    \tauto: true, \r\n");
      out.write("\t    \tspeed: 500, \r\n");
      out.write("\t    \tpause: 2000, \r\n");
      out.write("\t    \tmode:'fade',\r\n");
      out.write("\t    \tautoControls: false,\r\n");
      out.write("\t    \ttickerHover: false\r\n");
      out.write("\t    \t});\r\n");
      out.write("\t    \r\n");
      out.write("\t    init();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('.next').on('click',moveSlider);\r\n");
      out.write("\t\t$('.prev').on('click',moveSlider);\t\r\n");
      out.write("\t});\r\n");
      out.write("</script>    \r\n");
      out.write("\t<section>\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"bxslider\">\r\n");
      out.write("\t    \t\t\t<div><img src=\"/img/slider/slider1.png\"></div>\r\n");
      out.write("\t    \t\t\t<div><img src=\"/img/slider/slider2.png\"></div>\r\n");
      out.write("\t    \t\t\t<div><img src=\"/img/slider/slider3.png\"></div>\r\n");
      out.write("\t    \t\t\t<div><img src=\"/img/slider/slider4.png\"></div>\r\n");
      out.write("\t  \t\t</div>\r\n");
      out.write("\t  \t\t<div class=\"con1\">\r\n");
      out.write("\t  \t\t\t<span><h3>우리동네 인기매물</h3></span>\r\n");
      out.write("\t  \t\t\t<div class=\"item-slider1\">\r\n");
      out.write("\t  \t\t\t\t<div class=\"item item1\"></div>\r\n");
      out.write("\t  \t\t\t\t<div class=\"item item2\"></div>\r\n");
      out.write("\t  \t\t\t\t<div class=\"item item3\"></div>\r\n");
      out.write("\t  \t\t\t\t<div class=\"item item4\"></div>\r\n");
      out.write("\t  \t\t\t\t<div class=\"item item5\"></div>\r\n");
      out.write("\t  \t\t\t\t<div class=\"item item6\"></div>\r\n");
      out.write("\t  \t\t\t\t<div class=\"item item7\"></div>\r\n");
      out.write("\t  \t\t\t\t<div class=\"item item8\"></div>\r\n");
      out.write("\t  \t\t\t\t<div class=\"item item9\"></div>\r\n");
      out.write("\t  \t\t\t\t<div class=\"item item10\"></div>\r\n");
      out.write("\t  \t\t\t</div>\r\n");
      out.write("\t  \t\t\r\n");
      out.write("\t\t  \t\t<div class=\"btn\">\r\n");
      out.write("\t\t  \t\t\t<button class=\"prev\" data-btn=\"0\">이전</button>\r\n");
      out.write("\t\t  \t\t\t<button class=\"next\" data-btn=\"1\">다음</button>\t  \t\t\t\r\n");
      out.write("\t\t  \t\t</div>\t\r\n");
      out.write("\t  \t\t</div>\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tvar $con1 = 800;\r\n");
      out.write("\t\tvar $display = 5;\r\n");
      out.write("\t\tvar $item = $con1/$display;\r\n");
      out.write("\t\tvar $count = $('.item').length;\r\n");
      out.write("\t\tvar $slidebox = $item*count;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tconsole.log($con1);\r\n");
      out.write("\t\tconsole.log($display);\r\n");
      out.write("\t\tconsole.log($item);\r\n");
      out.write("\t\tconsole.log($count);\r\n");
      out.write("\t\tconsole.log($slidebox);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction init(){\r\n");
      out.write("\t\t\tconsole.log('init함수 시작');\r\n");
      out.write("\t\t\t$('.con1').css('width',$con1);\r\n");
      out.write("\t\t\t$('.item-slider1').css('width',$slidebox);\r\n");
      out.write("\t\t\t$('.item').css('width',$item);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction moveSlider(){\r\n");
      out.write("\t\t\tvar check = $(this).attr('data-btn');\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(check == 0){\r\n");
      out.write("\t\t\t\t$('.slider').animate({left:'+='+$item+\"px\"},300,slideEnd)\r\n");
      out.write("\t\t\t}else if(check==1){\r\n");
      out.write("\t\t\t\t$('.slider').animate({left: '-='+$item+'px'},300,slideEnd)\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction slideEnd(){\r\n");
      out.write("\t\t\tvar nowLeft = $('.slider').position().left;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar end = -($slidebox-$con1);\r\n");
      out.write("\t\t\tconsole.log(nowLeft);\r\n");
      out.write("\t\t\tconsole.log(end);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(nowLeft<=end){\r\n");
      out.write("\t\t\t\t$('.slider').animate({left:end});\r\n");
      out.write("\t\t\t}else if(nowLeft>0){\r\n");
      out.write("\t\t\t\t$('.slider').animate({left:0});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
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
