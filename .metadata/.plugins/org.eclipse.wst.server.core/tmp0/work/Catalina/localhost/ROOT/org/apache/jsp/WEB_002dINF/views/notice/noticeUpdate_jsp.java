/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.46
 * Generated at: 2019-10-08 01:12:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.kh.notice.model.vo.Notice;
import org.kh.member.model.vo.Member;

public final class noticeUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1570423341169L));
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
    _jspx_imports_classes.add("org.kh.notice.model.vo.Notice");
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
      out.write("    \r\n");
      out.write("    ");

    Notice n = (Notice)request.getAttribute("notice");	
    
    
    
      out.write("\r\n");
      out.write("    \r\n");
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
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">메뉴3</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">메뉴4</a></li>\r\n");
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
      out.write("\t\r\n");
      out.write("\t<section>\r\n");
      out.write("\t\t<div class=\"table-wrapper\" style=\"text-align:center; width:80%; margin:0 auto;\">\r\n");
      out.write("\t\t\t<form action=\"/noticeUpdateEnd\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"noticeNo\" value=\"");
      out.print(n.getNoticeNo() );
      out.write("\">\r\n");
      out.write("\t\t\t\t<table class=\"table table-bordered\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"2\" style=\"font-size:20px; font-weight:bold\">공지사항</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>제목</th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" class=\"form-control\" name=\"noticeTitle\" value=\"");
      out.print(n.getNoticeTitle());
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>작성자</th>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(n.getNoticeWriter() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>작성일</th>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(n.getNoticeDate() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>첨부파일</th>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<!-- 파일이 있으면 삭제버튼만 있고, 기존 파일을 삭제하면 새로 입력받을 수 있게 하려고 -->\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" id=\"status\" name=\"status\" value=\"stay\">\t<!-- 파일이 삭제되었는지 아닌지 체크해서 넘겨주기위해 -->\r\n");
      out.write("\t\t\t\t\t\t");
if(n.getFilename() != null){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<img class=\"delFile\" src=\"/img/file.png\" width=\"16px\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"delFile\">");
      out.print(n.getFilename() );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"button\" id=\"fileDelBtn\" class=\"btn btn-primary btn-sm delFile\">삭제</button>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"file\" name=\"filename\" id=\"file\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<!-- 삭제를 누르면 파일삭제를 해야하므로 넘겨주는 값들 -->\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"oldFilename\" value=\"");
      out.print(n.getFilename() );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"oldFilepath\" value=\"");
      out.print(n.getFilepath() );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t");
} else{
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"file\" name=\"filename\">\r\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>내용</th>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<textarea name=\"noticeContent\" class=\"form-control\" rows=\"3\" cols=\"40\">");
      out.print(n.getNoticeContent() );
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=\"2\" style=\"text-align:center\">\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-outline-primary\">수정하기</button>\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"btn btn-outline-primary\" href=\"/noticeList\">목록으로 가기</a>\r\n");
      out.write("\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t$(\"#fileDelBtn\").click(function(){\r\n");
      out.write("\t\t\t\tif(confirm(\"첨부파일을 삭제하시겠습니까?\")){\r\n");
      out.write("\t\t\t\t\t$(\".delFile\").hide();\r\n");
      out.write("\t\t\t\t\t$(\"#file\").show();\r\n");
      out.write("\t\t\t\t\t$(\"#status\").val(\"delete\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
