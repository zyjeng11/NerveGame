package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class question1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>1</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"./nervegame.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <p>手碰到熱鍋子，立刻縮回來</p>\n");
      out.write("\n");
      out.write("        <div id=\"myDIV\">\n");
      out.write("            <span class=\"anser-zone\" data-ans=\"\"></span>\n");
      out.write("            <span class=\"anser-zone\" data-ans=\"\"></span>\n");
      out.write("            <span class=\"anser-zone\" data-ans=\"\"></span>\n");
      out.write("            <span class=\"anser-zone\" data-ans=\"\"></span>\n");
      out.write("            <span class=\"anser-zone\" data-ans=\"\"></span>\n");
      out.write("            <span class=\"anser-zone\" data-ans=\"\"></span>\n");
      out.write("            <span class=\"anser-zone\" data-ans=\"\"></span>\n");
      out.write("        </div> \n");
      out.write("\n");
      out.write("        <div id=\"buttons\">\n");
      out.write("            <span data-cho=\"A\">皮膚</span>\n");
      out.write("            <span data-cho=\"B\">鼻子</span>\n");
      out.write("            <span data-cho=\"C\">眼睛</span>\n");
      out.write("            <span data-cho=\"D\">耳朵</span>\n");
      out.write("            <span data-cho=\"E\">感覺神經元</span> \n");
      out.write("            <span data-cho=\"F\">脊髓</span>\n");
      out.write("            <span data-cho=\"G\">大腦</span>\n");
      out.write("            <span data-cho=\"H\">運動神經元</span>\n");
      out.write("            <span data-cho=\"I\">肌肉</span>\n");
      out.write("            <span data-cho=\"J\">唾腺</span>\n");
      out.write("            <span data-cho=\"K\">腦幹</span>\n");
      out.write("            <span data-cho=\"\"></span> \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"rightAns\">答對了</div>\n");
      out.write("        <div id=\"wrongAns\">答錯了，再試試看</div>\n");
      out.write("        <button id=\"bt\">對答案</button>\n");
      out.write("                \n");
      out.write("        <a href=\"question2.html\" id=\"next\">下一題</a>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(\"#next\").hide();\n");
      out.write("            $(\"#rightAns\").hide();\n");
      out.write("            $(\"#wrongAns\").hide();\n");
      out.write("            var answer = [\"A\", \"E\", \"F\", \"H\", \"I\", \"\", \"\"];\n");
      out.write("\n");
      out.write("//選取答案框\n");
      out.write("            $(\"#myDIV span\").click(function () {\n");
      out.write("                $(\"#myDIV span\").removeClass(\"selected\");\n");
      out.write("                $(this).addClass(\"selected\");\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            $(\"#buttons span\").click(function () {\n");
      out.write("                var but = $(this).html();\n");
      out.write("                var da = $(this).attr(\"data-cho\");\n");
      out.write("                $(\".selected\").html(but).attr(\"data-ans\", da);\n");
      out.write("                $(\".selected\").removeClass(\"selected\");\n");
      out.write("            });\n");
      out.write("\n");
      out.write("//對答案\n");
      out.write("            $(\"#bt\").click(function () {\n");
      out.write("                var myAns = [];\n");
      out.write("                for (var i = 0; i < 7; i++) {\n");
      out.write("                    myAns[i] = $(\".anser-zone\").eq(i).attr(\"data-ans\");\n");
      out.write("                }\n");
      out.write("                var result = check(myAns);\n");
      out.write("                console.log(myAns);\n");
      out.write("                if (result == true) {\n");
      out.write("                    $(\"#wrongAns\").hide();\n");
      out.write("                    $(\"#rightAns\").show();\n");
      out.write("                    $(\"#next\").show();\n");
      out.write("                    $(\"#bt\").hide();\n");
      out.write("                } else {\n");
      out.write("                    $(\"#rightAns\").hide();\n");
      out.write("                    $(\"#wrongAns\").show();\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("\n");
      out.write("//把答案內容轉成array\n");
      out.write("            function disp(divs) {\n");
      out.write("                var a = [];\n");
      out.write("                for (var i = 0; i < divs.length; i++) {\n");
      out.write("                    a.push(divs[i].innerHTML);\n");
      out.write("                }\n");
      out.write("                return a;\n");
      out.write("            }\n");
      out.write("            //答案判斷\n");
      out.write("            function check(myAns) {\n");
      out.write("                var isCorrect = true;\n");
      out.write("                for (var i = 0; i < myAns.length; i++) {\n");
      out.write("                    if (myAns[i] !== answer[i]) {\n");
      out.write("                        isCorrect = false;\n");
      out.write("                        break;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                return isCorrect;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
