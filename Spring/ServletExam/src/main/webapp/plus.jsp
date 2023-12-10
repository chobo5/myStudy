<%--
  Created by IntelliJ IDEA.
  User: wonjun-yeon
  Date: 2023/12/09
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>plus.jsp</title>
</head>
<body>
<%
    out.write(request.getAttribute("x").toString());
    out.write(" + ");
    out.write(request.getAttribute("y").toString());
    out.write(" = ");
    out.write(request.getAttribute("value").toString());
%>
<%--Servlet을 사용하는것과 별반 다르지 않다.--%>
<%--그래서 다음과 같이 작성할 수 있다.--%>
<%--el표기법--%>
<h1>${x} + ${y} = ${value}</h1>
</body>
</html>
