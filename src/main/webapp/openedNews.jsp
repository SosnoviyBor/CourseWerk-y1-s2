<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Новина, що ми заслужили</title>
</head>
    <body>
        <a href="index.jsp"><h1 align="center">Новини, що ми заслужили</h1></a>

        <h4><c:out default="" value="${News.getName()}"/></h4>
        <p><c:out default="" value="${News.getDescription()}"/></p>
        <i><c:out default="" value="${News.getDate()}"/></i>
    </body>
</html>
