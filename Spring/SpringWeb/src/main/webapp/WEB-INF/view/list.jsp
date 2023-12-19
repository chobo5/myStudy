<%@ page import="com.example.springweb.domain.ToDo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Todo List</title>
</head>
<body>
    <h1>Todo List</h1>
<%--<%--%>
<%--    //Model에 담긴 값을 읽어온다.--%>
<%--    List<ToDo> toDoList = (List<ToDo>) request.getAttribute("todos");--%>
<%--    for(ToDo toDo : toDoList) {--%>
<%--        System.out.println(toDo.getTodo());--%>
<%--    }--%>
<%--%>--%>
    <c:forEach var="todo" items="${todos}" varStatus="status">
        <p>${status.count} : <c:out value="${todo}" /></p>
    </c:forEach>
    <br><br>

<%--    //http://localhost:8080/todos/list--%>
<form method="post" action="addToDo">
<%--    http://localhost:8080/todos/addToDo--%>
<%--    action="/addToDo" 이면 http://localhost:8080/addToDo가 된다.--%>
    할일 : <input type="text" name="todo">
    <input type="submit" value="추가">

</form>
</body>
</html>
