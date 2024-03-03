<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
            <html lang='en'>
            <head>
              <meta charset='UTF-8'>
              <title>비트캠프 데브옵스 5기</title>
            </head>
            <body>
        <jsp:include page="/header.jsp"></jsp:include>

         <h1>로그인</h1>
                   <c:choose>
                   <c:when test="${not empty loginUser}">
                        <p>${loginUser.name}님 환영합니다.</p>
                        <meta http-equiv="Refresh" content="1;url=/index.html">
                    </c:when>
                    <c:otherwise>
                        <p>이메일 또는 암호가 맞지 않습니다.</p>
                        <meta http-equiv="Refresh" content="1;url=/app/auth/login">
                    </c:otherwise>
                    </c:choose>

        <jsp:include page="/footer.jsp"></jsp:include>

        </body>
        </html>