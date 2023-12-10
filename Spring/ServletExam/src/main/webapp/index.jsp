<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response--%>
<%--final javax.servlet.jsp.PageContext pageContext;--%>
<%--javax.servlet.http.HttpSession session = null;--%>
<%--final javax.servlet.ServletContext application;--%>
<%--final javax.servlet.ServletConfig config;--%>
<%--javax.servlet.jsp.JspWriter out = null;--%>
<%--final java.lang.Object page = this;--%>
<%--javax.servlet.jsp.JspWriter _jspx_out = null;--%>
<%--javax.servlet.jsp.PageContext _jspx_page_context = null;--%>
<%--_jspService()메서드에 위와 같은 변수들이 있고 아래의 html 태그들을--%>
<%--out.write("<!DOCTYPE html>")와 같이 감싸서 내보낸다.--%>
<%--그리고 <% %>안의 코드가 그대로 들어간다.--%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>Plus</h1>
<br/>
<%--<img src="Java_Logo.png">--%>
<form method="get" action="/plus">
    x: <input type="text" name="x"> <br>
    y: <input type="text" name="y"> <br>
    <input type="submit" value="plus">
</form>


</body>
</html>