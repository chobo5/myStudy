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

</body>
</html>
