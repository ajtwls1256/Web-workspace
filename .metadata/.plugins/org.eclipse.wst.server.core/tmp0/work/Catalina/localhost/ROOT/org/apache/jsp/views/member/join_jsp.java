/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.46
 * Generated at: 2019-10-08 07:51:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.kh.member.model.vo.Member;

public final class join_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1570499038762L));
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
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">메뉴4</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">메뉴5</a></li>\r\n");
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
      out.write("\t\t<div id=\"container\" style=\"margin:0 auto; width:800px; color:black; text-align:center;\">\r\n");
      out.write("\t\t\t<form action=\"/join\" method=\"post\" id=\"memberJoin\">\r\n");
      out.write("\t\t\t\t<h1>회원가입</h1>\r\n");
      out.write("\t\t\t\t<table class=\"table\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th><label for=\"memberId\">아이디</label></th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"memberId\" id=\"memberId\" class=\"form-control\"></td>\r\n");
      out.write("\t\t\t\t\t\t<!-- <td style=\"width:150px;\"><button type=\"button\" onclick=\"checkId();\" class=\"btn btn-primary\">중복체크</button></td> -->\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width:150px\"><span id=\"chkMsg\"></span></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th><label for=\"memberPw\">비밀번호</label></th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"password\" name=\"memberPw\" id=\"memberPw\" class=\"form-control\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th><label for=\"pwChk\">비밀번호확인</label></th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"password\" id=\"pwChk\" class=\"form-control\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th><label for=\"memberName\">이름</label></th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"memberName\" id=\"memberName\" class=\"form-control\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th><label for=\"age\">나이</label></th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"age\" id=\"age\" class=\"form-control\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th><label for=\"email\">이메일</label></th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"email\" id=\"email\" class=\"form-control\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th><label for=\"phone\">연락처</label></th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"phone\" id=\"phone\" class=\"form-control\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<hr>\r\n");
      out.write("\t\t\t\t<div id=\"btn-box\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-success btn-lg\">회원가입</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"reset\" class=\"btn btn-success btn-lg\">초기화</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<form name=\"checkIdFrm\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"checkId\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\r\n");
      out.write("\t\t$(\"#memberId\").keyup(function(){\r\n");
      out.write("\t\t\tvar memberId = $(\"#memberId\").val();\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"/ajaxCheckId.do\",\r\n");
      out.write("\t\t\t\ttype : \"get\",\r\n");
      out.write("\t\t\t\tdata : {memberId:memberId},\r\n");
      out.write("\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar msg = $(\"#chkMsg\");\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif(data == '1'){\r\n");
      out.write("\t\t\t\t\t\tmsg.html(\"사용가능\");\r\n");
      out.write("\t\t\t\t\t\tmsg.css(\"color\",\"green\");\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\tmsg.html(\"사용중\");\r\n");
      out.write("\t\t\t\t\t\tmsg.css(\"color\",\"red\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror:function(){\r\n");
      out.write("\t\t\t\t\tconsole.log(\"아이디 중복체크 실패\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction checkId(){\r\n");
      out.write("\t\t\tvar memberId = document.getElementById(\"memberId\").value;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(memberId == \"\"){\r\n");
      out.write("\t\t\t\talert(\"아이디를 입력해주세요.\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar title = \"checkId\";\t\r\n");
      out.write("\t\t\tvar status = \"left=500px, top=100px, width=300px, height=200px, menubar=no, status=no, scrollbar=yes\";\t// 새 창의 속성\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// open(새 창에 보여줄 주소(비우면 빈창(about:blank)), 새창의 이름, 새 창의 속성)\r\n");
      out.write("\t\t\t// 두번째 요소 title속성이 form에 target에 들어가는 속성과 같다.\r\n");
      out.write("\t\t\tvar popup = window.open(\"\", title, status);\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// name만 있는 form태그에 hidden 속성값 설정\r\n");
      out.write("\t\t\tcheckIdFrm.checkId.value = memberId;\t// input hidden에 값 설정\r\n");
      out.write("\t\t\tcheckIdFrm.target = title;\t\t\t// popup 창과 form 태그를 연결\r\n");
      out.write("\t\t\t// action, method 설정 후 form태그 submit실행\r\n");
      out.write("\t\t\tcheckIdFrm.action = \"/checkId\"; // 요청할 서블릿 url\r\n");
      out.write("\t\t\tcheckIdFrm.method=\"post\";\r\n");
      out.write("\t\t\tcheckIdFrm.submit();\r\n");
      out.write("\t\t\t\r\n");
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